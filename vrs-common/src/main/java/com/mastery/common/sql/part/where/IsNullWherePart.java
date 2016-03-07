/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * 为空条件
 * 
 * @author zouziwen
 * 
 */
public class IsNullWherePart extends AbstractWherePart {

    private String column = "";

    /**
     * @param column
     * @param value
     */
    public IsNullWherePart(String column) {
        Assert.notNull(column, "isNull condition column can not be null.");
        this.column = column;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.part.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder(column);
        sb.append(SqlConstant.IS_NULL);
        return sb.toString();
    }

}
