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

	MatchResult matches(String desPath) throws IOException;
	
}
