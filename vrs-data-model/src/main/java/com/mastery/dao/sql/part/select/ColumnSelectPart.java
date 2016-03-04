/**
 * 
 */
package com.mastery.dao.sql.part.select;

import org.springframework.util.Assert;

import com.mastery.dao.sql.SqlTools;

/**
 * select部分语句
 * 
 * @author zhumingyuan
 * 
 */
public class ColumnSelectPart extends AbstractSelectPart {

    protected String[] columns;

    public ColumnSelectPart(String... columns) {
        Assert.notEmpty(columns, "select columns can not be null.");
        Assert.noNullElements(columns, "select columns can not contains null.");
        this.columns = columns;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder();
        // split by comma
        SqlTools.appendArraySplitByComma(sb, columns);
        return sb.toString();
    }

}
