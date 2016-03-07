/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * 等于的where条件
 * 
 * @author zouziwen
 * 
 */
public class EqualWherePart extends AbstractWherePart {

    private String column = "";

    private Object value = null;

    /**
     * @param column
     * @param value
     */
    public EqualWherePart(String column, Object value) {
        Assert.notNull(column, "equal condition column can not be null.");
        Assert.notNull(value, "equal condition value can not be null.");
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
        sb.append(SqlConstant.EQUAL).append(getValueInWhereString(value));
        return sb.toString();
    }

}
