/**
 * 
 */
package com.mastery.common.sql.part.where;

import com.mastery.common.sql.SqlConstant;

/**
 * or 连接符
 *
 * @author zouziwen
 * @date Apr 3, 2015 2:43:40 PM 
 */
public class OrPart extends AbstractWherePart{
    
    private AbstractWherePart[] whereParts;
    
    public OrPart(AbstractWherePart... whereParts) {
        this.whereParts = whereParts;
    }

    @Override
    public String getPart() {
        StringBuilder sb = new StringBuilder(SqlConstant.LEFT_BRACKET);
        int i = 0;
        for (AbstractWherePart wherePart : whereParts) {
            sb.append(wherePart.getPart());
            if (i++ != whereParts.length - 1) {
                sb.append(SqlConstant.OR);                
            }
        }
        sb.append(SqlConstant.RIGHT_BRACKET);
        return sb.toString();
    }

}
