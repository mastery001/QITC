/**
 * 
 */
package com.mastery.dao.sql.part.select;

import com.mastery.dao.sql.SqlConstant;
import com.mastery.dao.sql.part.ISqlPart;

/**
 * select的抽象类
 * @author zhumingyuan
 *
 */
public abstract class AbstractSelectPart implements ISqlPart{

    /**
     * select条件的连接符为,
     */
    @Override
    public String getConnector() {
        return SqlConstant.COMMA;
    }
}
