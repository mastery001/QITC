/**
 * 
 */
package com.mastery.dao.sql.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.mastery.dao.sql.SqlTypeEnum;
import com.mastery.dao.sql.part.ISqlPart;
import com.mastery.dao.sql.part.limit.LimitPart;
import com.mastery.dao.sql.part.order.AbstractOrderByPart;
import com.mastery.dao.sql.part.order.AscOrderByPart;
import com.mastery.dao.sql.part.order.DescOrderByPart;
import com.mastery.dao.sql.part.select.AbstractSelectPart;
import com.mastery.dao.sql.part.select.AllColumnSelectPart;
import com.mastery.dao.sql.part.select.ColumnSelectPart;
import com.mastery.dao.sql.part.select.CountSelectPart;
import com.mastery.dao.sql.part.update.ColumUpdatePart;
import com.mastery.dao.sql.part.where.AbstractWherePart;
import com.mastery.dao.sql.part.where.AndPart;
import com.mastery.dao.sql.part.where.BetweenAndWherePart;
import com.mastery.dao.sql.part.where.EqualWherePart;
import com.mastery.dao.sql.part.where.GreaterWherePart;
import com.mastery.dao.sql.part.where.InWherePart;
import com.mastery.dao.sql.part.where.IsNotNullWherePart;
import com.mastery.dao.sql.part.where.IsNullWherePart;
import com.mastery.dao.sql.part.where.LessWherePart;
import com.mastery.dao.sql.part.where.LikeWherePart;
import com.mastery.dao.sql.part.where.NotEqualWherePart;
import com.mastery.dao.sql.part.where.NotLikeWherePart;
import com.mastery.dao.sql.part.where.OrPart;

/**
 * sql的构造器
 * 
 * @author zhumingyuan
 * @date 2015年2月10日 上午11:53:01
 */
public class SqlBuilder {
    
    private final Logger logger = LoggerFactory.getLogger(SqlBuilder.class);
    
    // sql对象
    private ISql sqlObject;

    // select 片段
    private StringBuilder selectParts = new StringBuilder();
    // where 片段
    private StringBuilder whereParts = new StringBuilder();
    // orderby 片段
    private StringBuilder orderParts = new StringBuilder();
    // limit 片段
    private String limitPart;
    // update set 片段
    private StringBuilder updateParts = new StringBuilder();
    // update set 片段
    private String tableName = "";
    
    /**
     * sql语句的类型
     */
    private SqlTypeEnum type;

    public SqlBuilder(SqlTypeEnum type) {
        this.type = type;
    }
    
    public void setType(SqlTypeEnum type) {
        this.type = type;
    }
    
    public SqlBuilder append(ISqlPart sqlPart) {
        if (sqlPart != null) {
            if (sqlPart instanceof AbstractSelectPart) {
                appendPart(selectParts, sqlPart);
            } else if (sqlPart instanceof AbstractWherePart) {
                appendPart(whereParts, sqlPart);
            } else if (sqlPart instanceof AbstractOrderByPart) {
                appendPart(orderParts, sqlPart);
            } else if (sqlPart instanceof LimitPart) {
                limitPart = sqlPart.getPart();
            } else if (sqlPart instanceof ColumUpdatePart) {
                appendPart(updateParts, sqlPart);
            }
        }
        return this;
    }
    
    /**
     * 拼接sql part
     *
     * @author zhumingyuan
     * @date 2015年2月10日 下午2:32:46 
     * @param sqlParts
     * @return
     */
    public SqlBuilder append(ISqlPart ...sqlParts) {
        for (ISqlPart sqlPart : sqlParts) {
            this.append(sqlPart);
        }
        return this;
    }

    
    /**
     * 拼接part
     * @param sb
     * @param part
     */
    private void appendPart(StringBuilder sb, ISqlPart part) {
        if (sb.length() > 0) {
            sb.append(part.getConnector());
        }
        sb.append(part.getPart());
    }

    /**
     * 取得SelectObjectSql
     */
    public ISql build() {
        if (type == SqlTypeEnum.SELECT) {
            String selectCondition = selectParts.toString();
            String whereCondition = whereParts.toString();
            String orderByCondition = orderParts.toString();
            String limitCondition = limitPart;
            // 没有查询条件默认为查询全字段
            if (!StringUtils.hasLength(selectCondition)) {
                selectCondition = new AllColumnSelectPart().getPart();
            }
            sqlObject =
                            new SelectSql(selectCondition, whereCondition, orderByCondition,
                                            limitCondition, tableName);
            logger.debug(sqlObject.toString());
        } else if (type == SqlTypeEnum.UPDATE) {
            String whereCondition = whereParts.toString();
            String setCondition = updateParts.toString();
            sqlObject = new UpdateSql(whereCondition, setCondition, tableName);
            logger.debug(sqlObject.toString());
        } else if (type == SqlTypeEnum.INSERT) {
            sqlObject = new InsertSql(tableName);
            logger.debug(sqlObject.toString());
        }
        return sqlObject;
    }
    
    /**
     * 拼接查询字段条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:22:23 
     * @param columns
     * @return
     */
    public SqlBuilder appendSomeColumn(String... columns) {
        this.append(new ColumnSelectPart(columns));
        return this;
    }
    /**
     * 拼接查询全表条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:22:23 
     * @param columns
     * @return
     */
    public SqlBuilder appendAllColumn() {
        if (selectParts.length() > 0) {
            selectParts.setLength(0);
        }
        this.append(new AllColumnSelectPart());
        return this;
    }
    /**
     * 拼接查询数量条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:22:23 
     * @param columns
     * @return
     */
    public SqlBuilder appendCountColumn() {
        if (selectParts.length() > 0) {
            selectParts.setLength(0);
        }
        this.append(new CountSelectPart());
        return this;
    }
    
    /**
     * 拼接升序条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:26:43 
     * @param columns
     * @return
     */
    public SqlBuilder appendAscOrder(String... columns) {
        this.append(new AscOrderByPart(columns));
        return this;
    }
    
    /**
     * 拼接降序条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:26:55 
     * @param columns
     * @return
     */
    public SqlBuilder appendDescOrder(String... columns) {
        this.append(new DescOrderByPart(columns));
        return this;
    }
    /**
     * 拼接分页条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:26:55 
     * @param columns
     * @return
     */
    public SqlBuilder appendLimit(int begin, int offSet) {
        this.append(new LimitPart(begin, offSet));
        return this;
    }
    
    
    /**
     * 拼接between条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:02:19 
     * @param column 列 
     * @param leftValue 左值
     * @param rightValue 右值
     * @return
     */
    public SqlBuilder appendBetweenAnd(String column, Object leftValue, Object rightValue) {
        this.append(new BetweenAndWherePart(column, leftValue, rightValue));
        return this;
    }
    
    /**
     * 拼接等于的where条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:04:19 
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendEqual(String column, Object value) {
        this.append(new EqualWherePart(column, value));
        return this;
    }

    /**
     * 拼接in的where条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:05:31 
     * @param column
     * @param values
     * @return
     */
    public SqlBuilder appendIn(String column, Object[] values) {
        this.append(new InWherePart(column, values));
        return this;
    }
    
    /**
     * 拼接is not null条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:06:31 
     * @param column
     * @return
     */
    public SqlBuilder appendIsNotNull(String column) {
        this.append(new IsNotNullWherePart(column));
        return this;
    }
    
    /**
     * 拼接is null条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:08:13 
     * @param column
     * @return
     */
    public SqlBuilder appendIsNull(String column) {
        this.append(new IsNullWherePart(column));
        return this;
    }
    
    /**
     * 拼接like条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:09:15 
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendLike(String column, String value) {
        this.append(new LikeWherePart(column, value));
        return this;
    }
    
    /**
     * 拼接 not like条件
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendNotLike(String column, String value) {
        this.append(new NotLikeWherePart(column, value));
        return this;
    }
    
    /**
     * 拼接不等于条件
     *
     * @author zhumingyuan
     * @date 2015年2月10日 上午11:18:40 
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendNotEqual(String column, Object value) {
        this.append(new NotEqualWherePart(column, value));
        return this;
    }
    
    /**
     * 拼接大于条件
     *
     * @author zhumingyuan
     * @date Mar 13, 2015 4:02:09 PM 
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendGreater(String column, Object value) {
        this.append(new GreaterWherePart(column, value));
        return this;
    }
    
    /**
     * 拼接小于条件
     *
     * @author zhumingyuan
     * @date Mar 13, 2015 4:02:06 PM 
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendLess(String column, Object value) {
        this.append(new LessWherePart(column, value));
        return this;
    }
    
    /**
     * 拼接or条件    会把子的wherepart 用or连接符拼接
     *
     * @author zhumingyuan
     * @date Apr 3, 2015 2:41:12 PM 
     * @return
     */
    public SqlBuilder appendOR(AbstractWherePart...whereParts) {
        this.append(new OrPart(whereParts));
        return this;
    }
    
    /**
     * 拼接or条件    会把子的wherepart 用or连接符拼接
     *
     * @author zhumingyuan
     * @date Apr 3, 2015 2:41:12 PM 
     * @return
     */
    public SqlBuilder appendAND(AbstractWherePart...whereParts) {
        this.append(new AndPart(whereParts));
        return this;
    }
    
    /**
     * 拼接update的set条件
     *
     * @author zhumingyuan
     * @date 2015年2月28日 下午4:43:59 
     * @param column
     * @param value
     * @return
     */
    public SqlBuilder appendSet(String column, Object value) {
        this.append(new  ColumUpdatePart(column, value));
        return this;
    }

    public ISql getSqlObject() {
        return sqlObject;
    }

    public void setSqlObject(ISql sqlObject) {
        this.sqlObject = sqlObject;
    }

    public StringBuilder getSelectParts() {
        return selectParts;
    }

    public void setSelectParts(StringBuilder selectParts) {
        this.selectParts = selectParts;
    }

    public StringBuilder getWhereParts() {
        return whereParts;
    }

    public void setWhereParts(StringBuilder whereParts) {
        this.whereParts = whereParts;
    }

    public StringBuilder getOrderParts() {
        return orderParts;
    }

    public void setOrderParts(StringBuilder orderParts) {
        this.orderParts = orderParts;
    }

    public String getLimitPart() {
        return limitPart;
    }

    public void setLimitPart(String limitPart) {
        this.limitPart = limitPart;
    }

    public StringBuilder getUpdateParts() {
        return updateParts;
    }

    public void setUpdateParts(StringBuilder updateParts) {
        this.updateParts = updateParts;
    }
    
    public void appendTable(String tableName) {
        this.tableName = tableName;
    }

    public SqlTypeEnum getType() {
        return type;
    }
    
    
}
