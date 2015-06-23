package edu.jxau.service.match.support;

import java.util.Map;

import edu.jxau.service.match.Rules;

/**
 * @ClassName: HeadingCheckRule
 * @Description: 根据论文中规定大标题对应内容进行匹配
 * @author mastery
 * @date 2015-6-18 下午5:08:03
 * 
 */
public class HeadingCheckRule implements Rules {

	private static final int JUMP_STR_LENGTH = 10;

	/*
	 * 
	 */
	private static final String[] matchContextKey = new String[] {
			DocumentInformation.THESIS_KEY[0],
			DocumentInformation.THESIS_KEY[1],
			DocumentInformation.THESIS_KEY[3],
			DocumentInformation.THESIS_CONTEXT };

	@Override
	public MatchResult checkDuplicate(DocumentInformation srcDocInfo,
			DocumentInformation desDocInfo) {
		/**
		 * 先通过匹配论文的中文摘要和英文摘要、总结， 然后进行论文的正文投点匹配 通过匹配正文的部分内容来进行概率统计
		 */
		double rate = 0;
		Map<String, String> srcMap = srcDocInfo.getSectionContext();
		Map<String, String> desMap = desDocInfo.getSectionContext();
		for (String key : matchContextKey) {
			//System.out.println("key is " + key);
			rate += getDuplicateRate(srcMap.get(key), desMap.get(key));
		}
		MatchResult mr = new MatchResult();
		mr.setRate(rate / matchContextKey.length);
		return mr;
	}

	private double getDuplicateRate(String srcStr, String desStr) {
		/*System.out.println(srcStr);
		System.out.println(desStr);*/
		if (srcStr == null || desStr == null) {
			return 0;
		}
		char[] srcChars = srcStr.toCharArray();
		char[] desChars = desStr.toCharArray();
		// 计算出可以分割出多少个大小为10的的字符
		int index = 0;
		String currentStr = null;
		StringBuilder duplicateStr = new StringBuilder();
		while (index < srcChars.length) {
			// 得到当前的10个字符串
			currentStr = this.getBeginToEndStr(srcChars, index, index
					+ JUMP_STR_LENGTH);
			if (index >= desChars.length) {
				break;
			}
			// 取得比较的字符串的对应位置的前30个字符
			for (int i = index; i < index + JUMP_STR_LENGTH * 2; i++) {
				if (index == desChars.length + 1) {
					break;
				}
				String str = this.getBeginToEndStr(desChars, i, i
						+ JUMP_STR_LENGTH);
				if (currentStr.equalsIgnoreCase(str)) {
					duplicateStr.append(currentStr);
					break;
				}
			}
			index += JUMP_STR_LENGTH;
		}
		return duplicateStr.length() / srcChars.length;
	}

	private String getBeginToEndStr(char[] strs, int begin, int end) {
		StringBuilder sb = new StringBuilder();
		if (end > strs.length) {
			end = strs.length;
		}
		for (int i = begin; i < end; i++) {
			sb.append(strs[i]);
		}
		return sb.toString();
	}

}
