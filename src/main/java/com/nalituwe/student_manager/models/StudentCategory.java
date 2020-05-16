package com.nalituwe.student_manager.models;

import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
public class StudentCategory extends AbstractEntity {
    private String sCategoryName;

    public StudentCategory(){}

    public StudentCategory(@Size(min=3, message="Name must be more than 3 Characters") String sCategoryName) {
        this.sCategoryName = sCategoryName;
    }

        public void setSCategoryName(String sCategoryName){
            this.sCategoryName=sCategoryName;
        }

        public String getSCategoryName(){
        return sCategoryName;
        }
        @Override
        public String toString(){
          return sCategoryName;
        }



}
