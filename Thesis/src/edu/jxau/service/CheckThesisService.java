package edu.jxau.service;

import java.io.IOException;

import org.web.exception.DBException;

import edu.jxau.dao.ThesisesDao;
import edu.jxau.service.match.Matcher;
import edu.jxau.service.match.ThesisMatcher;
import edu.jxau.service.match.support.MatchResult;

public class CheckThesisService {

	private static String servicePath;
	
	private static MatchResult matchResult;
	
	public static boolean isExe = false;
	
	private ThesisesDao dao;

	public CheckThesisService(String servicePath) {
		dao = new ThesisesDao();
		CheckThesisService.servicePath = servicePath + "/";
	}

	public void check(String document) {
		try {
			Matcher m = new ThesisMatcher(servicePath + document);
			String[] paths = dao.getAllThesisPath();
			new Thread(new Check(m, paths)).start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static MatchResult result() {
		return matchResult;
	}
	
	public void interruptCheck() {
		Check.on_off = false;
	}

	static class Check implements Runnable {

		static boolean on_off;

		private Matcher m;

		private String[] paths;

		public Check(Matcher m, String[] paths) {
			this.m = m;
			this.paths = paths;
			on_off = true;
		}

		@Override
		public void run() {
			isExe = true;
			MatchResult lastMr = null;
			for (String path : paths) {
				if (on_off) {
					MatchResult mr = null;
					try {
						mr = m.matches(servicePath + path);
					} catch (IOException e) {
						e.printStackTrace();
					}
					if (lastMr == null) {
						lastMr = mr;
					} else {
						if (lastMr.getRate() < mr.getRate()) {
							lastMr = mr;
						}
					}
				}
			}
			matchResult = lastMr;
		}
	}
}
