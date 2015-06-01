package edu.jxau.dao.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.web.access.factory.DaoAdviceFactory;
import org.web.exception.DBException;
import org.web.exception.VoProcessorException;
import org.web.service.VoProcessor;

import tool.mastery.log.Logger;
import edu.jxau.vo.Thesises;

public class ThesisesAdapter extends VoProcessor {

	@Override
	protected List<Object> convert(List<Object> vos)
			throws VoProcessorException {
		for (int i = 0; i < vos.size(); i++) {
			Thesises thesis = (Thesises) vos.get(i);
			if (thesis.getT_id() == null) {
				thesis.setT_id(this.getTid(thesis.getU_id()));
			}
		}
		return null;
	}

	@Override
	protected List<Object> reverseConvert(List<Object> vos)
			throws VoProcessorException {
		return null;
	}

	private String getTid(String u_id) {
		if (!map.containsKey(u_id)) {
			Thesises t = new Thesises();
			t.setU_id(u_id);
			try {
				List<Object> list = DaoAdviceFactory.getDao("Thesises").query(
						t.getClass(), t, null, false);
				if (list.size() == 0) {
					map.put(u_id, -1);
				} else {
					t = (Thesises) list.get(list.size() - 1);
					String serial = t.getT_id().substring(u_id.length());
					map.put(u_id, Integer.parseInt(serial));
				}
			} catch (DBException e) {
				Logger.getLogger(this.getClass()).debug(e.getMessage(), e);
			}
		}
		Integer serial = map.get(u_id) + 1;
		String serialNumber = "";
		if (String.valueOf(serial).length() != 4) {
			for (int i = 0; i < 4 - String.valueOf(serial).length(); i++) {
				serialNumber += "0";
			}
			serialNumber += String.valueOf(serial);
		} else {
			serialNumber = String.valueOf(serial);
		}
		return u_id + serialNumber;
	}

	private static final Map<String, Integer> map = new HashMap<String, Integer>();
}
