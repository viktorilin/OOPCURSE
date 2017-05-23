package vik.oop.services.GroupOfStudent.impls;

import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.model.GroupOfStudent.GroupOfStudent;
import vik.oop.services.GroupOfStudent.interfaces.IGroupOfStudentService;

import java.util.List;
import java.util.Objects;

/**
 * Created by Asus on 09.04.2017.
 */
public class GroupOfStudentServiceImpl implements IGroupOfStudentService {
    IGroupOfStudentService iGroupOfStudentService;

    public GroupOfStudentServiceImpl(DaoGroupOfStudentImpl daoGroupOfStudent) {
    }

    public List<GroupOfStudent> getAll() {
        return iGroupOfStudentService.getAll();
    }

    public GroupOfStudent getGroupOfStudent(int id) {
        return iGroupOfStudentService.getGroupOfStudent(id);
    }

    public void createGroupOfStudent(GroupOfStudent groupOfStudent) {
        iGroupOfStudentService.createGroupOfStudent(groupOfStudent);
    }

    public void updateGroupOfStudent(GroupOfStudent groupOfStudent) {
        iGroupOfStudentService.updateGroupOfStudent(groupOfStudent);
    }

    public void deleteGroupOfStudent(int id) {
        iGroupOfStudentService.deleteGroupOfStudent(id);
    }

    public void showAll() {
        iGroupOfStudentService.showAll();
    }

    public int getNumberOfStudentsOnCurrentDepartment(List<GroupOfStudent> groupOfStudents,String department) {
        int result = 0;
        for (GroupOfStudent groupOfStudent:groupOfStudents) {
            if (Objects.equals(groupOfStudent.getDepartment(), department)) {
                result+=groupOfStudent.getNumberOfStudents();
            }
        }
        return result;

    }

    public int getNumberOfCourseOfCurrentGroup(GroupOfStudent groupOfStudent){
        return groupOfStudent.getNumberOfGroup()/100;
    }

    public String getSpecialtiesOnCurrentDepartment(List<GroupOfStudent> groupOfStudents,String department){
        String result = "";
        for (GroupOfStudent groupOfStudent:groupOfStudents) {
            if (Objects.equals(department, groupOfStudent.getDepartment()))
            {
                result+=groupOfStudent.getSpecialty() + " , ";
            }
        }

        return result;
    }

    public int getNumberOfStudentsOnCurrentSpecialty(List<GroupOfStudent> groupOfStudents, String specialty){
        int result = 0;
        for (GroupOfStudent groupOfStudent:groupOfStudents) {
            if (Objects.equals(groupOfStudent.getSpecialty(), specialty)) {
                result+=groupOfStudent.getNumberOfStudents();
            }
        }
        return result;

    }

    public int getNumberOfStudentsOnCurrentCourse(List<GroupOfStudent> groupOfStudents, int numberOfCourse){
        int result = 0;
        for (GroupOfStudent groupOfStudent:groupOfStudents) {
            if (iGroupOfStudentService.getNumberOfCourseOfCurrentGroup(groupOfStudent)==numberOfCourse) {
                result+=groupOfStudent.getNumberOfStudents();
            }
        }
        return result;
    }
}
