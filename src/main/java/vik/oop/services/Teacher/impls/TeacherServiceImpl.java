package vik.oop.services.Teacher.impls;

import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Lesson.Lesson;
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

    public TeacherServiceImpl() {

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

    public String nameOfTheBestTeacher(List<Teacher> teachers){
        String result = teachers.get(0).getFullName();
        for (int i = 0; i < teachers.size()-1 ; i++) {
            if (teachers.get(i).getTimeOfWork()>teachers.get(i+1).getTimeOfWork())
                result = teachers.get(i).getFullName();
        }
        return result;

    }

    public String numberOfPhoneOfTheBestTeacher(List<Teacher>teachers){
        String result = teachers.get(0).getNumberOfPhone();
        for (int i = 0; i < teachers.size()-1 ; i++) {
            if (teachers.get(i).getTimeOfWork()>teachers.get(i+1).getTimeOfWork())
                result = teachers.get(i).getNumberOfPhone();
        }
        return result;

    }

    public int getPaymentForTeacher(Teacher teacher){
        return teacher.getTimeOfWork()*teacher.getSalary();
    }

    public int getMaximumPaymentForTeacher(List<Teacher> teachers) {
        int result = 0;
        for (int i = 0; i < teachers.size()-1 ; i++) {
            if (teachers.get(i).getTimeOfWork()*teachers.get(i).getSalary() > teachers.get(i+1).getTimeOfWork()*teachers.get(i+1).getSalary())
                result = teachers.get(i).getTimeOfWork()*teachers.get(i).getSalary();
        }
        return result;
    }

    public int getMinimumPaymentForTeacher(List<Teacher> teachers){
        int result = 10000000;
        for (int i = 0; i < teachers.size()-1 ; i++) {
            if (teachers.get(i).getTimeOfWork()*teachers.get(i).getSalary() < teachers.get(i+1).getTimeOfWork()*teachers.get(i+1).getSalary())
                result = teachers.get(i).getTimeOfWork()*teachers.get(i).getSalary();
        }
        return result;
    }


}
