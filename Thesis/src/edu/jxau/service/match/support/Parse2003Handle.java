package edu.jxau.service.match.support;

import java.io.IOException;
import java.io.InputStream;

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
		String[] paragraphTexts = new String[length];
		DocumentInformation di = new DocumentInformation();
		// 段落长度
		di.setNumParagraphs(length);
		for (int i = 0; i < length; i++) {
			Paragraph p = range.getParagraph(i);
			String text = p.text();
			if(text.trim().equals("")) {
				continue;
			}
			paragraphTexts[i] = text + "----" + p.getLvl();
		}
		di.setParagraphTexts(paragraphTexts);
		di.setText(range.text());
		return di;
	}
	
	private void parse11(InputStream is) throws IOException {
		// WordExtractor extractor = new WordExtractor(is);
				// 这个构造函数从InputStream中加载Word文档。
				HWPFDocument doc = new HWPFDocument(is);
				// 这个类为HWPF对象模型,对文档范围段操作
				Range range = doc.getRange();
				int length = range.numParagraphs();
				String[] paragraphTexts = new String[length];
				DocumentInformation di = new DocumentInformation();
				// 段落长度
				di.setNumParagraphs(length);
				for (int i = 0; i < length; i++) {
					paragraphTexts[i] =  range.getParagraph(i).text();
				}
				di.setParagraphTexts(paragraphTexts);
				di.setText(range.text());
	}

}
