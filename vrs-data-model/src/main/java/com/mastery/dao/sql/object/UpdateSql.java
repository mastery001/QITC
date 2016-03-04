/**
 * 
 */
package com.mastery.dao.sql.object;

/**
 *
 *
 * @author zhumingyuan
 * @date 2015年2月28日 下午4:25:27 
 */
public class UpdateSql implements ISql {

    // where条件
    private String whereCondition;
    // set条件
    private String setCondition;
    // table
    private String tableName;

    /**
     * @param selectCondition
     * @param whereCondition
     * @param orderByCondition
     * @param limitCondition
     */
    public UpdateSql(String whereCondition, String setCondition, String tableName) {
        super();
        this.whereCondition = whereCondition;
        this.setCondition = setCondition;
        this.tableName = tableName;
    }

    public String getSetCondition() {
        return setCondition;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "SelectObjectSql \r\n setCondition : " + setCondition + "\r\n tableName : "
                        + tableName + "\r\n whereCondition : " + whereCondition;
    }
}
