package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController
public class GroupOfStudentController {
    @Autowired
    private DaoGroupOfStudentImpl daoGroupOfStudent;
    @RequestMapping("/api/groupOfStudent")
    public List<GroupOfStudent> groupOfStudentList(){
        return daoGroupOfStudent.readAll();
    }
}