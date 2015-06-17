package edu.jxau.service.match.support;

import java.util.HashMap;
import java.util.Map;

public class DocumentInformation {

	public static final String CHINESE_SUMMARY = "摘要";
	
	
	private String name; 	// 文档名称
	
	private int numParagraphs;	// 文档有多少个段落
	
	private String text;	// 文档所有内容

	private String[] ParagraphTexts;
	
	private Map<String , String> sectionContext = new HashMap<String , String>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumParagraphs() {
		return numParagraphs;
	}

	public void setNumParagraphs(int numParagraphs) {
		this.numParagraphs = numParagraphs;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String[] getParagraphTexts() {
		return ParagraphTexts;
	}

	public void setParagraphTexts(String[] paragraphTexts) {
		ParagraphTexts = paragraphTexts;
	}

	public Map<String, String> getSectionContext() {
		return sectionContext;
	}

	public void setSectionContext(Map<String, String> sectionContext) {
		this.sectionContext = sectionContext;
	}
	
	
}
