package edu.jxau.service.match;

import java.io.IOException;

import edu.jxau.service.match.support.MatchResult;


/** 
* @ClassName: Macther 
* @Description: TODO
* @author mastery
* @date 2015-6-16 下午12:48:38 
*  
*/ 
public interface Matcher {

	/** 
	* @Title: matches 
	* @Description: 用当前文档和待匹配文档进行匹配，采用默认的匹配规则 
	* @param @param desPath
	* @param @return
	* @param @throws IOException   
	* @return MatchResult    返回类型 
	* @throws 
	*/ 
	MatchResult matches(String desPath) throws IOException;
	
	
	/** 
	* @Title: matches 
	* @Description: 用当前文档和待匹配文档进行匹配，通过传递的匹配规则 
	* @param @param desPath
	* @param @param rules		匹配规则类
	* @param @return
	* @param @throws IOException   
	* @return MatchResult    返回类型 
	* @throws 
	*/ 
	MatchResult matches(String desPath , Rules rules) throws IOException;
	
}
