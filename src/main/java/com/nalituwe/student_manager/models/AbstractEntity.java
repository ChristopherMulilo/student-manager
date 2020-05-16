package com.nalituwe.student_manager.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass //this annotation means the fields in this class must be pushed down to sub-classes TABLES
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;

    public int getId(){
        return id;
    }

    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() !=o.getClass()) return false;
        AbstractEntity abstractEntity =(AbstractEntity) o;
        return id == abstractEntity.id;

    }

    public int hashCode(){
        return Objects.hash(id);
    }

}
