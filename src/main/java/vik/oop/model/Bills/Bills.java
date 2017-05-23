package vik.oop.model.Bills;

import vik.oop.model.Bill.Bill;
import vik.oop.model.GroupOfStudent.GroupOfStudent;
import vik.oop.model.Lesson.Lesson;
import vik.oop.model.Teacher.Teacher;

import java.util.ArrayList;

/**
 * Created by Asus on 27.03.2017.
 */
public class  Bills
{
    Integer id;
    Integer teacher_id;
    Integer groupOfStudent_id;
    Integer lesson_id;

    public Bills(Integer id, Integer teacher_id, Integer groupOfStudent_id, Integer lesson_id) {
        this.id = id;
        this.teacher_id = teacher_id;
        this.groupOfStudent_id = groupOfStudent_id;
        this.lesson_id = lesson_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Integer getGroupOfStudent_id() {
        return groupOfStudent_id;
    }

    public void setGroupOfStudent_id(Integer groupOfStudent_id) {
        this.groupOfStudent_id = groupOfStudent_id;
    }

    public Integer getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Integer lesson_id) {
        this.lesson_id = lesson_id;
    }
}
