package vik.oop.services.GroupOfStudent.impls;

import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.model.GroupOfStudent.GroupOfStudent;
import vik.oop.services.GroupOfStudent.interfaces.IGroupOfStudentService;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public class GroupOfStudentServiceImpl implements IGroupOfStudentService
{
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
}
