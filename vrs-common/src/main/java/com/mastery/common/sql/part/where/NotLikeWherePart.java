/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * not like
 * @author zouziwen
 *
 */
public class NotLikeWherePart extends AbstractWherePart {

    private String column = "";

    private String value = null;

    /**
     * @param column
     * @param value
     */
    public NotLikeWherePart(String column, String value) {
        Assert.notNull(column, "not like condition column can not be null.");
        Assert.notNull(value, "not like condition value can not be null.");
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
        sb.append(SqlConstant.NOT_LIKE).append(SqlConstant.SINGLE_QUOTES).append(SqlConstant.PERCENT)
                        .append(value).append(SqlConstant.PERCENT)
                        .append(SqlConstant.SINGLE_QUOTES);
        return sb.toString();
    }

}
