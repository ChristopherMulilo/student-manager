package com.nalituwe.student_manager.controllers;

import com.nalituwe.student_manager.data.StudentCategoryRepository;
import com.nalituwe.student_manager.data.StudentRepository;
import com.nalituwe.student_manager.models.StudentCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.nalituwe.student_manager.models.Student;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("students")
public class studentController {

@Autowired
StudentCategoryRepository studentCategoryRepository;

@Autowired
Student updateStudent;

@Autowired
private StudentRepository studentRepository;

@GetMapping
public String fetchStudents(Model model){
        model.addAttribute("students", studentRepository.findAll());

        return"students/index";
    }

    @GetMapping("create")
    public String displayCreateStudentForm(Model model){
        model.addAttribute("title", "Add Student");
        model.addAttribute(new Student());
        model.addAttribute("categories",studentCategoryRepository.findAll());

        return"students/create"; //this returns a create form which is in a subdirectory students
    }

    @PostMapping("create")
    public String processCreateStudent(@ModelAttribute @Valid Student newStudent, Errors errors, Model model){
       if(errors.hasErrors()){
           model.addAttribute("title", "Add Student");
           return"students/create";
       }

        studentRepository.save(newStudent);
        return "redirect:";//this takes you to the root

    }
     @GetMapping("delete")
    public String displayDeleteStudentsForm(Model model){
        model.addAttribute("title", "Delete Students");
        model.addAttribute("students", studentRepository.findAll());

        return"students/delete";
    }
    @PostMapping("delete")
    public String processDeleteStudentsForm(@RequestParam(required = false) int [] studentIds){
       if(studentIds !=null){
        for(int id : studentIds) {
            studentRepository.deleteById(id);
        }
        }
        return"redirect:";
}

@PostMapping("update")
    public String updateProcessStudentForm(@RequestParam(required = false) int id,@ModelAttribute @Valid Student updateStudent ,Model model){
     model.addAttribute("Title", "Update Student Info");
     model.addAttribute("sUpdate",studentRepository.findById(id));
if(studentRepository.findById(id)!= null){
    studentRepository.save(updateStudent);

}
    return "redirect:";

}


}
