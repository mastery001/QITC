package edu.jxau.service.match.support;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.POIXMLProperties.CoreProperties;

import edu.jxau.service.match.ParseHandle;

public class Parse2007Handle extends ParseHandle {

	@Override
	public String getFormat() {
		return "docx";
	}

	@Override
	public DocumentInformation parse0(InputStream is) throws IOException {
		return null;
		/*XWPFDocument doc = new XWPFDocument(is);
		XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
		DocumentInformation di = new DocumentInformation();
		List<XWPFParagraph> list = doc.getParagraphs();
		String[] paragraphTexts = new String[list.size()];
		for(int i = 0 ; i < list.size() ; i++) {
			paragraphTexts[i] = list.get(i).getParagraphText();
		}
		di.setNumParagraphs(list.size());
		String text = extractor.getText();
		di.setText(text);
		CoreProperties coreProps = extractor.getCoreProperties();
		di.setName(coreProps.getTitle());
		return di;*/
	}

	/**
	 * 输出CoreProperties信息
	 * 
	 * @param coreProps
	 */
	@SuppressWarnings("unused")
	private void printCoreProperties(CoreProperties coreProps) {
		System.out.println(coreProps.getCategory()); // 分类
		System.out.println(coreProps.getCreator()); // 创建者
		System.out.println(coreProps.getCreated()); // 创建时间
		System.out.println(coreProps.getTitle()); // 标题
	}

}
