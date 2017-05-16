package vik.oop.dao.Lesson.interfaces;

import vik.oop.model.Lesson.Lesson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.04.2017.
 */
public interface IDaoLesson
{
    public ArrayList<Lesson> readAll();
    List<Lesson> getAll();
    Lesson getLesson(int id);
    void createLesson (Lesson lesson);
    void updateLesson (Lesson lesson);
    void deleteLesson (int id);
    void showAll();

}
