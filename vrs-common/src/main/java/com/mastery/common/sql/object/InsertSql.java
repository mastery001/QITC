/**
 * 
 */
package com.mastery.common.sql.object;

/**
 *
 *
 * @author zhumingyuan
 * @date Mar 12, 2015 4:16:00 PM 
 */
public class InsertSql implements ISql {

    // table
    private String tableName;
    
    public InsertSql(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "InsertSql [tableName=" + tableName + "]";
    }
    
}
