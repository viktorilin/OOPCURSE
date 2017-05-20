package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Teacher.Teacher;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController
public class TeacherController {
    @Autowired
    private DaoTeacher daoTeacher;
    @RequestMapping("api/teacher")
    public List<Teacher> teacherList(){return daoTeacher.readAll();}
}
