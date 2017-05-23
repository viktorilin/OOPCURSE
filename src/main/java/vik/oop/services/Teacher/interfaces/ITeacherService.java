package vik.oop.services.Teacher.interfaces;

import vik.oop.model.Teacher.Teacher;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public interface ITeacherService
{
    List<Teacher> getAll();
    Teacher getTeacher(int id);
    void createTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(int id);
    void showAll();
    String nameOfTheBestTeacher(List<Teacher> teachers);
    String numberOfPhoneOfTheBestTeacher(List<Teacher>teachers);
    int getPaymentForTeacher(Teacher teacher);
    int getMaximumPaymentForTeacher(List<Teacher> teachers);
    int getMinimumPaymentForTeacher(List<Teacher> teachers);
}
