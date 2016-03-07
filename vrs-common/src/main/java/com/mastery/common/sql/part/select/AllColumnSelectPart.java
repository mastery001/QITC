/**
 * 
 */
package com.mastery.common.sql.part.select;

import com.mastery.common.sql.SqlConstant;

/**
 * 全字段查询片段
 * @author zhumingyuan
 *
 */
public class AllColumnSelectPart extends AbstractSelectPart {
    
    public AllColumnSelectPart(){
    }

    /* (non-Javadoc)
     * @see com.letv.mms.common.sql.part.ISqlPart#getPart()
     */
    @Override
    public String getPart() {
        return SqlConstant.ALL_COLUMN;
    }

}
