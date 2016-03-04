package com.mastery.dao;

public interface ISoftDelete {
    public static final String FIELD_DELETED = "deleted";
    
    Boolean getDeleted();
    void setDeleted(Boolean deleted);
}
