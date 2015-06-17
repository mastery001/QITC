package edu.jxau.service.match;

import java.io.IOException;

import org.junit.Test;

import edu.jxau.service.match.support.DocumentInformation;

public class ParseDocumentTest {

	@Test
	public void testParse() throws IOException {
		 ParseDocument pd = new ParseDocument();
		 DocumentInformation di = pd.parse("计算机专业毕业论文范文.doc");
		 String paragraphTexts[] = di.getParagraphTexts();
		 System.out.println(paragraphTexts.length);
		 for(String paragraphText : paragraphTexts) {
			 System.out.println(paragraphText);
		 }
	}

}
