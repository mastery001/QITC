package edu.jxau.service.match;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.junit.Test;

import edu.jxau.service.match.support.DocumentInformation;

public class ParseDocumentTest {

	@Test
	public void testParse() throws IOException {
		ParseDocument pd = new ParseDocument();
		DocumentInformation di = pd.parse("伍嘉宇 20111415 毕业论文二稿-修改意见.doc");
		for (Iterator<String> it = di.getSectionContext().keySet().iterator(); it
				.hasNext();) {
			String key = it.next();
			System.out.println(key + "--------");
			System.out.println(di.getSectionContext().get(key));
			System.out.println();
		}
	}

	@SuppressWarnings("unused")
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
		for (int i = 0; i < length; i++) {
			paragraphTexts[i] = range.getParagraph(i).text();
		}
		di.setText(range.text());
	}

}
