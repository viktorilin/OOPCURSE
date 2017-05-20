package vik.oop.model.Lesson;

import org.springframework.stereotype.Service;

/**
 * Created by Asus on 27.03.2017.
 */
 public class Lesson
{
    private int id;
    private String timeOfLesson;
    private int numberOfClassRoom;
    private String nameOfLesson;

    public Lesson() {
    }

    public Lesson(int id, String timeOfLesson, int numberOfClassRoom, String nameOfLesson) {
        this.id = id;
        this.timeOfLesson = timeOfLesson;
        this.numberOfClassRoom = numberOfClassRoom;
        this.nameOfLesson = nameOfLesson;
    }

    public String getNameOfLesson() {
        return nameOfLesson;
    }

    public void setNameOfLesson(String nameOfLesson) {
        this.nameOfLesson = nameOfLesson;
    }

    public String getTimeOfLesson() {
        return timeOfLesson;
    }

    public void setTimeOfLesson(String timeOfLesson) {
        this.timeOfLesson = timeOfLesson;
    }

    public int getNumberOfClassRoom() {
        return numberOfClassRoom;
    }

    public void setNumberOfClassRoom(int numberOfClassRoom) {
        this.numberOfClassRoom = numberOfClassRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
