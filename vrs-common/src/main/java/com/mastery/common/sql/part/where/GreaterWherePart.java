/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 *
 *
 * @author zouziwen
 * @date Mar 13, 2015 3:58:00 PM 
 */
public class GreaterWherePart extends AbstractWherePart {

    private String column = "";

    private Object value = null;

    /**
     * @param column
     * @param value
     */
    public GreaterWherePart(String column, Object value) {
        Assert.notNull(column, "> condition column can not be null.");
        Assert.notNull(value, "> condition value can not be null.");
        this.column = column;
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.part.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder(column);
        sb.append(SqlConstant.GREATER).append(getValueInWhereString(value));
        return sb.toString();
    }

}
