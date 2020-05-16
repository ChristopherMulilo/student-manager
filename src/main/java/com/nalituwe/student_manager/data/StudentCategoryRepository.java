package com.nalituwe.student_manager.data;

import com.nalituwe.student_manager.models.StudentCategory;
import org.springframework.data.repository.CrudRepository;

public interface StudentCategoryRepository extends CrudRepository<StudentCategory, Integer> {

}
