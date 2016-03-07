/**
 * 
 */
package com.mastery.common.sql.part.where;

import com.mastery.common.sql.SqlConstant;
import com.mastery.common.sql.SqlTools;
import com.mastery.common.sql.part.ISqlPart;

/**
 * where条件部分
 * 
 * @author zouziwen
 * 
 */
public abstract class AbstractWherePart implements ISqlPart {

    /**
     * 取得运算符右侧的条件
     * 
     * @param value
     * @return
     */
    protected String getValueInWhereString(Object value) {
        // 数值型直接返回
        return SqlTools.getDBStringValue(value);
    }

    /**
     * where条件的连接符为and
     */
    @Override
    public String getConnector() {
        return SqlConstant.AND;
    }
    
    

}
