/**
 * 
 */
package com.mastery.dao.sql.part.limit;

import com.mastery.dao.sql.SqlConstant;
import com.mastery.dao.sql.part.ISqlPart;

/**
 * 分页的条件
 * 
 * @author zouziwen
 * 
 */
public class LimitPart implements ISqlPart {

    private int begin = 0;

    private int offset = 0;

    public LimitPart(int begin, int offset) {
        if (begin < 0) {
            throw new IllegalArgumentException("limit condition begin can not be less than 0.");
        }
        if (offset < 0) {
            throw new IllegalArgumentException("limit condition end can not be less than 0.");
        }
        this.begin = begin;
        this.offset = offset;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder();
        sb.append(begin).append(SqlConstant.COMMA).append(offset);
        return sb.toString();
    }
    
    /**
     * limit只有一个条件的
     */
    @Override
    public String getConnector() {
        return null;
    }

}
