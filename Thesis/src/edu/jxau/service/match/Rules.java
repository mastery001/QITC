package edu.jxau.service.match;

import edu.jxau.service.match.support.DocumentInformation;
import edu.jxau.service.match.support.MatchResult;

/**
 * @ClassName: Rules
 * @Description: 匹配时候对应的规则
 * @author mastery
 * @date 2015-6-18 下午5:05:08
 * 
 */
public interface Rules {

	/** 
	* @Title: checkDuplicate 
	* @Description: 通过源文件和待匹配文件进行比较，返回匹配结果 
	* @param @param srcDocInfo
	* @param @param descDocInfo   
	* @return void    返回类型 
	* @throws 
	*/ 
	MatchResult checkDuplicate(DocumentInformation srcDocInfo,
			DocumentInformation desDocInfo);
}
