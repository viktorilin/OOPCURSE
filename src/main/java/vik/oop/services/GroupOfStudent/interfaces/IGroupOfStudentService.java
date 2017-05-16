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
}
