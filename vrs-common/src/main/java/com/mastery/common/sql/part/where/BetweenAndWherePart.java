/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * between条件语句
 * 
 * @author zouziwen
 * 
 */
public class BetweenAndWherePart extends AbstractWherePart {

    private String column = "";

    private Object leftValue = null;

    private Object rightValue = null;

    /**
     * @param column
     * @param value
     */
    public BetweenAndWherePart(String column, Object leftValue, Object rightValue) {
        Assert.notNull(column, "betweenAnd condition column can not be null.");
        Assert.notNull(leftValue, "betweenAnd condition left value can not be null.");
        Assert.notNull(rightValue, "betweenAnd condition right value can not be null.");
        this.column = column;
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.part.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder(column);
        sb.append(SqlConstant.BETWEEN).append(getValueInWhereString(leftValue)).append(SqlConstant.AND)
                        .append(getValueInWhereString(rightValue));
        return sb.toString();
    }


}
