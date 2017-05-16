package vik.oop.services.Teacher.impls;

import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Teacher.Teacher;
import vik.oop.services.Teacher.interfaces.ITeacherService;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public class TeacherServiceImpl implements ITeacherService
{
    ITeacherService iTeacherService;

    public TeacherServiceImpl(DaoTeacher daoTeacher) {
    }

    public List<Teacher> getAll() {
        return iTeacherService.getAll();
    }

    public Teacher getTeacher(int id) {
        return iTeacherService.getTeacher(id);
    }

    public void createTeacher(Teacher teacher) {
        iTeacherService.createTeacher(teacher);
    }

    public void updateTeacher(Teacher teacher) {
        iTeacherService.updateTeacher(teacher);
    }

    public void deleteTeacher(int id) {
        iTeacherService.deleteTeacher(id);
    }

    public void showAll() {
        iTeacherService.showAll();
    }

}
