package edu.jxau.service.match.support;

import java.util.Map;

public class DocumentInformation {

	public static final String THESIS_INTRODUCTION = "封面";
	
	public static final String THESIS_CONTEXT = "正文";
	
	public static final String[] THESIS_KEY = new String[] { "摘要", "Abstract",
		 "致谢","总结", "参考文献" };

	private String name; // 文档名称

	private String text; // 文档所有内容

	private Map<String, String> sectionContext;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<String, String> getSectionContext() {
		return sectionContext;
	}

	public void setSectionContext(Map<String, String> sectionContext) {
		this.sectionContext = sectionContext;
	}

	@Override
	public String toString() {
		return "DocumentInformation [name=" + name + ", sectionContext="
				+ sectionContext + "]";
	}

}