package com.mastery.data.base;

public interface ISoftDelete {
    public static final String FIELD_DELETED = "deleted";
    
    Boolean getDeleted();
    void setDeleted(Boolean deleted);
}
