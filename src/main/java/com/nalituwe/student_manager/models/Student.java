package com.nalituwe.student_manager.models;


import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
@Service
@Entity
public class Student extends AbstractEntity {

    @NotBlank
    @Size(min=2, max=25, message="Name should be more than 3 characters but less than 25")
    private String firstName;
    @NotBlank
    @Size(min=2, max=25, message="Name should be more than 3 characters but less than 25\"" )
    private String lastName;

    @Email(message="Invalid Email, Email format is xxxx@xxx.x")
    private String email;

    @NotBlank(message="Gender is required")
    private String gender;

    @NotBlank
    private String grade;

    @ManyToOne
    @NotNull(message="Category is required")
    private StudentCategory studentCategory;


    public Student(){ }


    public Student(String firstName, String lastName, String gender, String email, String grade, StudentCategory studentCategory){
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.email=email;
        this.grade=grade;
        this.studentCategory = studentCategory;

    }



    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }

    public void setGender(String gender){
     this.gender=gender;
    }

    public String getGender(){
        return gender;
    }

    public void setGrade(String grade){
        this.grade=grade;
    }

    public String getGrade(){
        return grade;
    }


    public StudentCategory getStudentCategory() {
        return studentCategory;
    }

    public void setStudentCategory(StudentCategory studentCategory) {
        this.studentCategory=studentCategory;
    }

    public String toString(){
        return firstName;
    }



}
