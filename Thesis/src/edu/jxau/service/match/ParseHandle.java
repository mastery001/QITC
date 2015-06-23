package edu.jxau.service.match;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import tool.mastery.core.ToolKit;
import edu.jxau.service.match.support.DocumentInformation;

public abstract class ParseHandle {

	private ParseHandle nextParseHandle;

	public DocumentInformation parse(String document) throws IOException {
		if (document.contains(getFormat())) {
			InputStream is = new FileInputStream(document);
			DocumentInformation di = null;
			try {
				di = this.parse0(is);
			} catch (IOException e) {
				throw e;
			} finally {
				ToolKit.close(is);
			}
			return di;
		} else {
			if (this.nextParseHandle != null) {
				return this.nextParseHandle.parse(document);
			} else {
				throw new IOException("该文档无法解析，请配置合适的转换器");
			}

		}
	}

	public void setNextHandle(ParseHandle nextParseHandle) {
		this.nextParseHandle = nextParseHandle;
	}

	public abstract String getFormat();

	/** 
	* @Title: parse0 
	* @Description: 解析word文档 
	* @param @param is
	* @param @return
	* @param @throws IOException   
	* @return DocumentInformation    返回类型 
	* @throws 
	*/ 
	public abstract DocumentInformation parse0(InputStream is)
			throws IOException;
}
