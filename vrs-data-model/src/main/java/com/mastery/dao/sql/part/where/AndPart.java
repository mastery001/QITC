/**
 * 
 */
package com.mastery.dao.sql.part.where;

import com.mastery.dao.sql.SqlConstant;

/**
 * and连接条件
 *
 * @author zouziwen
 * @date Apr 3, 2015 3:01:06 PM 
 */
public class AndPart extends AbstractWherePart {
    
    private AbstractWherePart[] whereParts;
    
    public AndPart(AbstractWherePart... whereParts) {
        this.whereParts = whereParts;
    }

    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder(SqlConstant.LEFT_BRACKET);
        int i = 0;
        for (AbstractWherePart wherePart : whereParts) {
            sb.append(wherePart.getPart());
            if (i++ != whereParts.length - 1) {
                sb.append(SqlConstant.AND);                
            }
        }
        sb.append(SqlConstant.RIGHT_BRACKET);
        return sb.toString();
    }

}
