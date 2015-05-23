package edu.jxau.dao.adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.web.exception.VoProcessorException;
import org.web.service.VoProcessor;

import edu.jxau.vo.Thesises;

public class ThesisesAdapter extends VoProcessor{

	@Override
	protected List<Object> convert(List<Object> vos)
			throws VoProcessorException {
		for(int i = 0 ; i < vos.size() ; i ++) {
			Thesises thesis = (Thesises)vos.get(i);
			if(thesis.getT_id() == null) {
				thesis.setT_id(this.getAid(thesis.getU_id()));
			}
		}
		return null;
	}

	@Override
	protected List<Object> reverseConvert(List<Object> vos)
			throws VoProcessorException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String getAid(String u_id) {
		if(!map.containsKey(u_id)) {
			map.put(u_id, 0);
		}
		String serialNumber = "";
		if(map.get(u_id).toString().length() != 4) {
			for(int i = 0 ; i < 4 - map.get(u_id).toString().length() ; i++){
				serialNumber += "0";
			}
			serialNumber += map.get(u_id).toString();
		}else {
			serialNumber = map.get(u_id).toString();
		}
		return u_id + serialNumber;
 	}
	
	private static final Map<String , Integer> map = new HashMap<String , Integer>();
}
