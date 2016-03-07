/**
 * 
 */
package com.mastery.common.sql.part.order;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;
import com.mastery.common.sql.part.ISqlPart;

/**
 * 排序对象的接口
 * 
 * @author zhumingyuan
 * 
 */
public abstract class AbstractOrderByPart implements ISqlPart {

    protected String[] columns;

    public AbstractOrderByPart(String... columns) {
        Assert.notEmpty(columns, "order condition can not be null.");
        Assert.noNullElements(columns, "order condition can not contains null.");
        this.columns = columns;
    }
    

    /**
     * order条件的连接符为,
     */
    @Override
    public String getConnector() {
        return SqlConstant.COMMA;
    }
}
