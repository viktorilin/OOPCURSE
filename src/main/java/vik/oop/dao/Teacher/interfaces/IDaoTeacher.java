package vik.oop.dao.Teacher.interfaces;

import vik.oop.model.Teacher.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public interface IDaoTeacher {
    public ArrayList<Teacher> readAll();
    List<Teacher> getAll();
    Teacher getTeacher(int id);
    void createTeacher (Teacher teacher);
    void updateTeacher (Teacher teacher);
    void deleteTeacher (int id);
    void showAll();
}
