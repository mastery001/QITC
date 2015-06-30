package edu.jxau.service;

import java.io.IOException;

import org.web.exception.DBException;

import edu.jxau.dao.DocumentsDao;
import edu.jxau.service.match.Matcher;
import edu.jxau.service.match.ThesisMatcher;
import edu.jxau.service.match.support.MatchResult;

public class CheckThesisService {

	private static String servicePath;
	
	private static MatchResult matchResult;
	
	private DocumentsDao dao;

	public CheckThesisService(String servicePath) {
		dao = new DocumentsDao();
		CheckThesisService.servicePath = servicePath + "/";
	}

	public void check(String document){
		try {
			// 实例化论文查重对象
			Matcher m = new ThesisMatcher(servicePath + document);
			// 得到非当前用户的其他人的文档
			String[] paths = dao.getAllThesisPath();
			// 启动线程进行论文查重
			new Thread(new Check(m, paths)).start();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
	}
	
	public static MatchResult result() {
		if(matchResult == null && Check.isOver) {
			Check.isOver = false;
			matchResult = new MatchResult();
		}
		return matchResult;
	}
	
	/** 
	* @Title: interruptCheck 
	* @Description: 中断查重 
	* @param    
	* @return void    返回类型 
	* @throws 
	*/ 
	public void interruptCheck() {
		Check.on_off = false;
	}

	static class Check implements Runnable {

		static boolean on_off;
		
		static boolean isOver;

		private Matcher m;

		private String[] paths;

		public Check(Matcher m, String[] paths) {
			this.m = m;
			this.paths = paths;
			on_off = true;
		}

		@Override
		public void run() {
			MatchResult lastMr = null;
			for (String path : paths) {
				if (on_off) {
					MatchResult mr = null;
					try {
						mr = m.matches(servicePath + path);
					} catch (IOException e) {
						e.printStackTrace();
					}catch(Exception e) {
						e.printStackTrace();
						continue;
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
			isOver = true;
		}
	}
}
