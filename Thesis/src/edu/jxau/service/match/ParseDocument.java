package edu.jxau.service.match;

import java.io.IOException;

import edu.jxau.service.match.support.DocumentInformation;
import edu.jxau.service.match.support.Parse2003Handle;
import edu.jxau.service.match.support.Parse2007Handle;

public class ParseDocument {

	private ParseHandle parseHandle;

	public ParseDocument() {
		parseHandle = new Parse2007Handle();
		ParseHandle p2003h = new Parse2003Handle();
		parseHandle.setNextHandle(p2003h);
	}

	public DocumentInformation parse(String document) throws IOException {
		if(document == null || document.equals("")) {
			throw new NullPointerException("document参数不能为空，或不能为空串");
		}
		return parseHandle.parse(document);
	}
}
