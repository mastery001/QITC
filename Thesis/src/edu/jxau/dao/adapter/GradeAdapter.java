package edu.jxau.dao.adapter;

import java.util.List;

import org.web.exception.VoProcessorException;
import org.web.service.VoProcessor;

import edu.jxau.po.Grade;
import edu.jxau.util.FetchFirstChineseLetterUtil;

public class GradeAdapter extends VoProcessor {

	@Override
	protected List<Object> convert(List<Object> vos)
			throws VoProcessorException {
		for (Object vo : vos) {
			Grade c = (Grade) vo;
			if (c.getC_id() == null) {
				c.setC_id(FetchFirstChineseLetterUtil.getFirstLetter(c
						.getC_name()));
			}
		}
		return vos;
	}

	@Override
	protected List<Object> reverseConvert(List<Object> vos)
			throws VoProcessorException {
		/*list = new ArrayList<Object>();
		// 先用第一个进行比较
		Grade c = (Grade) vos.get(0);
		// 班级人数
		int number = 1;
		for (int i = 1; i < vos.size(); i++) {
			Grade temp = (Grade) vos.get(i);
			if (temp.getC_id().equals(c.getC_id())) {
				// 如果是老师将其设置为老师
				if (temp.getStatus() == 1) {
					c.setU_name(temp.getU_name());
				}
				number++;
				if (i != vos.size() - 1) {
					continue;
				}
			}
			c.setNumber(number);
			number = 0;
			list.add(c);
			c = temp;
		}*/
		return null;
	}

}
