/**
 * 
 */
package com.mastery.dao.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.dao.sql.SqlConstant;

/**
 * @author zouziwen
 *
 */
public class IsNotNullWherePart extends AbstractWherePart {

    private String column = "";

    /**
     * @param column
     * @param value
     */
    public IsNotNullWherePart(String column) {
        Assert.notNull(column, "isNtNull condition column can not be null.");
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
        sb.append(SqlConstant.IS_NOT_NULL);
        return sb.toString();
    }

}
