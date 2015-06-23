package edu.jxau.service.match.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;

import edu.jxau.service.match.ParseHandle;

public class Parse2003Handle extends ParseHandle {

	@Override
	public String getFormat() {
		return "doc";
	}

	@Override
	public DocumentInformation parse0(InputStream is) throws IOException {
		// WordExtractor extractor = new WordExtractor(is);
		// 这个构造函数从InputStream中加载Word文档。
		HWPFDocument doc = new HWPFDocument(is);
		// 这个类为HWPF对象模型,对文档范围段操作
		Range range = doc.getRange();
		int length = range.numParagraphs();
		DocumentInformation di = new DocumentInformation();
		StringBuffer contextBuffer = new StringBuffer();
		Map<String, String> sectionContext = new HashMap<String, String>();
		// 初始为封面的内容
		String key = DocumentInformation.THESIS_INTRODUCTION;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length - 1; i++) {
			Paragraph p = range.getParagraph(i);
			String text = p.text().trim();
			if (text.equals("")) {
				continue;
			}
			// 当为标题1时得到其对应下面的正文
			if (p.getLvl() == 0) {
				if (isNotContext(key)) {
					// 将内容填充到map中
					sectionContext.put(key, sb.toString());
				} else {
					contextBuffer.append(sb.toString());
				}
				key = getCorrespondTitle(text);
				sb = new StringBuffer();
			} else if (p.getLvl() == 9) {
				// 当且仅当不为标题时加入到正文中
				sb.append(text);
			}
		}
		sectionContext.put(key, sb.toString());
		sectionContext.put(DocumentInformation.THESIS_CONTEXT,
				contextBuffer.toString());
		/*
		 * Map<String, String> sectionContext1 = new HashMap<String, String>();
		 * sb = new StringBuffer(); for (Iterator<String> it =
		 * sectionContext.keySet().iterator(); it .hasNext();) { String pk =
		 * it.next(); if (!isDocumentFormat(pk)) {
		 * sb.append(sectionContext.get(pk)); }else { sectionContext1.put(pk,
		 * sectionContext.get(pk)); } }
		 * sectionContext1.put(DocumentInformation.THESIS_CONTEXT,
		 * sb.toString());
		 */
		di.setSectionContext(sectionContext);
		di.setText(range.text());
		return di;
	}

	/**
	 * @Title: getCorrespondTitle
	 * @Description: 获取对应的标题
	 * @param @param title
	 * @param @return
	 * @return String 返回类型
	 * @throws
	 */
	private String getCorrespondTitle(String title) {
		char[] charTitles = title.toCharArray();
		int count = 0;
		for (String key : DocumentInformation.THESIS_KEY) {
			for (char charTitle : charTitles) {
				if (key.contains(String.valueOf(charTitle))) {
					count++;
				}
			}
			if (count == key.length()) {
				return key;
			}
			count = 0;
		}
		return title;
	}

	/** 
	* @Title: isNotContext 
	* @Description: 不是论文中属于正文的内容标题 
	* @param @param title
	* @param @return   
	* @return boolean    返回类型 
	* @throws 
	*/ 
	private boolean isNotContext(String title) {
		if (title.equals(DocumentInformation.THESIS_INTRODUCTION)) {
			return true;
		}
		for (String key : DocumentInformation.THESIS_KEY) {
			if (key.equals(title)) {
				return true;
			}
		}
		return false;
	}

}
