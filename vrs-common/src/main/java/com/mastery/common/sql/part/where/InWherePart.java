/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;
import com.mastery.common.sql.SqlTools;

/**
 * in的条件
 * 
 * @author zouziwen
 * 
 */
public class InWherePart extends AbstractWherePart {

    private String column = "";

    private Object[] values;

    /**
     * @param column
     * @param value
     */
    public InWherePart(String column, Object[] values) {
        Assert.notNull(column, "in condition column can not be null.");
        Assert.notEmpty(values, "in condition value can not be null.");
        Assert.noNullElements(values, "in condition value can not contain null.");
        this.column = column;
        this.values = values;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.part.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder(column);
        sb.append(SqlConstant.IN).append(SqlConstant.LEFT_BRACKET);
        // spilt by comma
        SqlTools.appendArraySplitByComma(sb, values);
        sb.append(SqlConstant.RIGHT_BRACKET);
        return sb.toString();
    }

}
