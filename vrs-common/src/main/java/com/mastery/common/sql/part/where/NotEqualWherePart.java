/**
 * 
 */
package com.mastery.common.sql.part.where;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;

/**
 * 不等于的条件
 * 
 * @author zouziwen
 * 
 */
public class NotEqualWherePart extends AbstractWherePart {

    private String column = "";

    private Object value = null;

    /**
     * @param column
     * @param value
     */
    public NotEqualWherePart(String column, Object value) {
        Assert.notNull(column, "notEqual condition column can not be null.");
        Assert.notNull(value, "notEqual condition value can not be null.");
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
        sb.append(SqlConstant.NOT_EQUAL).append(getValueInWhereString(value));
        return sb.toString();
    }

    public static void main(String[] args) {
        AbstractWherePart part1 = new NotEqualWherePart("id", 1);
        AbstractWherePart part2 = new NotEqualWherePart("column_cn", "aaa");
        System.out.println(part1.getPart());
        System.out.println(part2.getPart());
    }


}
