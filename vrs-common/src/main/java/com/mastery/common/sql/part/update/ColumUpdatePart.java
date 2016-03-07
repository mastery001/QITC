/**
 * 
 */
package com.mastery.common.sql.part.update;

import org.springframework.util.Assert;

import com.mastery.common.sql.SqlConstant;
import com.mastery.common.sql.SqlTools;
import com.mastery.common.sql.part.ISqlPart;

/**
 * 
 * 
 * @author zouziwen
 * @date 2015年2月28日 下午4:17:47
 */
public class ColumUpdatePart implements ISqlPart {



    private String column = "";

    private Object value = null;

    /**
     * @param column
     * @param value
     */
    public ColumUpdatePart(String column, Object value) {
        Assert.notNull(column, "equal condition column can not be null.");
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
        sb.append(SqlConstant.EQUAL).append(SqlTools.getDBStringValue(value));
        return sb.toString();
    }

    @Override
    public String getConnector() {
        return SqlConstant.COMMA;
    }
    
}
