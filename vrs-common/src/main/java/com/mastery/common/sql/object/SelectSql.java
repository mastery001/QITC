/**
 * 
 */
package com.mastery.common.sql.object;

/**
 * 查询对象的sql 不可变对象
 * 
 * @author zhumingyuan
 * 
 */
public class SelectSql implements ISql {

    // select语句
    private String selectCondition;
    // where条件
    private String whereCondition;
    // 排序条件
    private String orderByCondition;
    // 分页条件
    private String limitCondition;
    // 表名
    private String tableName;

    /**
     * @param selectCondition
     * @param whereCondition
     * @param orderByCondition
     * @param limitCondition
     */
    public SelectSql(String selectCondition, String whereCondition, String orderByCondition,
                    String limitCondition, String tableName) {
        super();
        this.selectCondition = selectCondition;
        this.whereCondition = whereCondition;
        this.orderByCondition = orderByCondition;
        this.limitCondition = limitCondition;
        this.tableName = tableName;
    }

    public String getSelectCondition() {
        return selectCondition;
    }

    public String getWhereCondition() {
        return whereCondition;
    }

    public String getOrderByCondition() {
        return orderByCondition;
    }

    public String getLimitCondition() {
        return limitCondition;
    }


    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "SelectObjectSql \r\n selectCondition : " + selectCondition + " \r\n tableName : "
                        + tableName + "\r\n whereCondition : " + whereCondition
                        + "\r\n orderByCondition : " + orderByCondition + "\r\n limitCondition : "
                        + limitCondition;
    }

}
