/**
 * 
 */
package com.mastery.common.sql.part.select;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * distinct的select
 * @author zouziwen
 * 
 */
public class DistinctSelectPart extends AbstractSelectPart {

    protected String column;

    public DistinctSelectPart(String column) {
        Assert.notNull(column, "select distinct column can not be null.");
        this.column = column;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder();
        sb.append(SqlConstant.DISTINCT).append(SqlConstant.LEFT_BRACKET).append(column)
                        .append(SqlConstant.RIGHT_BRACKET);
        return sb.toString();
    }

}
