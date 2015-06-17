package edu.jxau.service.match;

import java.io.IOException;

import edu.jxau.service.match.support.DocumentInformation;
import edu.jxau.service.match.support.MatchResult;


/** 
* @ClassName: ThesisMatcher 
* @Description: 论文匹配步骤
* 					1.文档解析，
* 					2.相似度匹配算法
* 						2.1  匹配规则
* 						2.2 匹配优先级
* 					3.匹配结果
* @author mastery
* @date 2015-6-16 下午12:49:50 
*  
*/ 
public class ThesisMatcher implements Matcher{

	public final ParseDocument pd = new ParseDocument();
	
	private DocumentInformation originDocInfo;
	
	public ThesisMatcher(String originPath) throws IOException {
		originDocInfo = pd.parse(originPath);
	}
	
	@Override
	public MatchResult matches(String desPath) throws IOException{
		// 解析目标文档
		DocumentInformation desDocInfo = pd.parse(desPath);
		
		return null;
	}

}
