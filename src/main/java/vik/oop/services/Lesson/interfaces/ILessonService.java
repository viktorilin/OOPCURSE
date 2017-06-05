package vik.oop.services.Lesson.interfaces;

import vik.oop.model.Lesson.Lesson;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public interface ILessonService {
    List<Lesson> getAll();
    Lesson getLesson(int id);
    void createLesson(Lesson lesson);
    void updateLesson(Lesson lesson);
    void deleteLesson(int id);
    void showAll();
    boolean isInThisClassRoomLesson(List<Lesson> lessons, int numberOfClassRoom);
    int getNumberOfLesson(Lesson lesson);
    int getNumberOfFloorOfCurrentClassRoomOfCurrentLesson(Lesson lesson);
    int getMaxNumberOfClassRoom(List<Lesson> lessons);
    double getRentOfClassRoom(Lesson lesson);
 }
