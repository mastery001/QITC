/**
 * 
 */
package com.mastery.common.sql.part;

/**
 * sql的某个子部分的条件
 * 
 * @author zhumingyuan
 * 
 */
public interface ISqlPart {

    /**
     * 返回sql片段
     * 
     * @return
     */
    public String getPart();
    
    /**
     * 返回某一类sql片段的连接符
     * @return
     */
    public String getConnector();

}
