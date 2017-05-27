package vik.oop.services.GroupOfStudent.impls;

import org.junit.Test;
import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Asus on 27.05.2017.
 */
public class GroupOfStudentServiceImplTest {
    @Test
    public void getNumberOfStudentsOnCurrentDepartment() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        GroupOfStudentServiceImpl groupOfStudentService = new GroupOfStudentServiceImpl(daoGroupOfStudent);
        String department = daoGroupOfStudent.getGroupOfStudent(1).getDepartment();
        int result = 0;
        for (GroupOfStudent groupOfStudent:daoGroupOfStudent.readAll()) {
            if (Objects.equals(groupOfStudent.getDepartment(), department)) {
                result+=groupOfStudent.getNumberOfStudents();
            }
        }
        assertEquals(result,groupOfStudentService.getNumberOfStudentsOnCurrentDepartment(daoGroupOfStudent.readAll(),department));

    }

    @Test
    public void getNumberOfCourseOfCurrentGroup() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        GroupOfStudentServiceImpl groupOfStudentService = new GroupOfStudentServiceImpl(daoGroupOfStudent);
        int result = 0;
        result = daoGroupOfStudent.getGroupOfStudent(1).getNumberOfGroup()/100;
        assertEquals(result,groupOfStudentService.getNumberOfCourseOfCurrentGroup(daoGroupOfStudent.getGroupOfStudent(1)));
    }

    @Test
    public void getSpecialtiesOnCurrentDepartment() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        GroupOfStudentServiceImpl groupOfStudentService = new GroupOfStudentServiceImpl(daoGroupOfStudent);
        String department =daoGroupOfStudent.getGroupOfStudent(1).getDepartment();
        String result = "";
        for (GroupOfStudent groupOfStudent:daoGroupOfStudent.readAll()) {
            if (Objects.equals(department, groupOfStudent.getDepartment()))
            {
                result+=groupOfStudent.getSpecialty() + " , ";
            }
        }
        assertEquals(result,groupOfStudentService.getSpecialtiesOnCurrentDepartment(daoGroupOfStudent.readAll(),department));
    }

    @Test
    public void getNumberOfStudentsOnCurrentSpecialty() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        GroupOfStudentServiceImpl groupOfStudentService = new GroupOfStudentServiceImpl(daoGroupOfStudent);
        String specialty = daoGroupOfStudent.getGroupOfStudent(1).getSpecialty();
        int result = 0;
        for (GroupOfStudent groupOfStudent:daoGroupOfStudent.readAll()) {
            if (Objects.equals(groupOfStudent.getSpecialty(), specialty)) {
                result+=groupOfStudent.getNumberOfStudents();
            }
        }
        assertEquals(result,groupOfStudentService.getNumberOfStudentsOnCurrentSpecialty(daoGroupOfStudent.readAll(),specialty));
    }

    @Test
    public void getNumberOfStudentsOnCurrentCourse() throws Exception {
        DaoGroupOfStudentImpl daoGroupOfStudent = new DaoGroupOfStudentImpl();
        GroupOfStudentServiceImpl groupOfStudentService = new GroupOfStudentServiceImpl(daoGroupOfStudent);
        int result = 0;
        int numberOfCourse = groupOfStudentService.getNumberOfCourseOfCurrentGroup(daoGroupOfStudent.getGroupOfStudent(1));
        for (GroupOfStudent groupOfStudent:daoGroupOfStudent.readAll()) {
            if (groupOfStudentService.getNumberOfCourseOfCurrentGroup(groupOfStudent)==numberOfCourse) {
                result+=groupOfStudent.getNumberOfStudents();
            }
        }
       assertEquals(result,groupOfStudentService.getNumberOfStudentsOnCurrentCourse(daoGroupOfStudent.readAll(),numberOfCourse));
    }

}