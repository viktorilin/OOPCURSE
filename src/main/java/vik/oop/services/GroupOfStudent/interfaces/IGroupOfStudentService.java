package vik.oop.services.GroupOfStudent.interfaces;

import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public interface IGroupOfStudentService
{
    List<GroupOfStudent> getAll();
    GroupOfStudent getGroupOfStudent(int id);
    void createGroupOfStudent(GroupOfStudent groupOfStudent);
    void updateGroupOfStudent(GroupOfStudent groupOfStudent);
    void deleteGroupOfStudent(int id);
    void showAll();
    int getNumberOfStudentsOnCurrentDepartment(List<GroupOfStudent> groupOfStudents,String department);
    int getNumberOfCourseOfCurrentGroup(GroupOfStudent groupOfStudent);
    String getSpecialtiesOnCurrentDepartment(List<GroupOfStudent> groupOfStudents,String department);
    int getNumberOfStudentsOnCurrentSpecialty(List<GroupOfStudent> groupOfStudents, String specialty);
    int getNumberOfStudentsOnCurrentCourse(List<GroupOfStudent> groupOfStudents, int numberOfCourse);
}