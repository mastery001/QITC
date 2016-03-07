/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * like条件
 * 
 * @author zouziwen
 * 
 */
public class LikeWherePart extends AbstractWherePart {

    private String column = "";

    private String value = null;

    /**
     * @param column
     * @param value
     */
    public LikeWherePart(String column, String value) {
        Assert.notNull(column, "like condition column can not be null.");
        Assert.notNull(value, "like condition value can not be null.");
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
        sb.append(SqlConstant.LIKE).append(SqlConstant.SINGLE_QUOTES).append(SqlConstant.PERCENT)
                        .append(value).append(SqlConstant.PERCENT)
                        .append(SqlConstant.SINGLE_QUOTES);
        return sb.toString();
    }

}
