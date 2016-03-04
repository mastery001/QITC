/**
 * 
 */
package com.mastery.dao.sql.part.select;

import com.mastery.dao.sql.SqlConstant;

/**
 * 查询数量的片单
 * @author zouziwen
 *
 */
public class CountSelectPart extends AbstractSelectPart {

    public CountSelectPart() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.letv.mms.core.mybatis.builder.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        return SqlConstant.COUNT;
    }

}
