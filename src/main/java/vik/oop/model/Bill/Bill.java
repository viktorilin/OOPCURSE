package vik.oop.model.Bill;

import vik.oop.model.GroupOfStudent.GroupOfStudent;
import vik.oop.model.Lesson.Lesson;
import vik.oop.model.Teacher.Teacher;

/**
 * Created by Asus on 27.03.2017.
 */
public class Bill
{
    int id;
    Teacher teacher;
    Lesson lesson;
    GroupOfStudent groupOfStudent;

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", teacher=" + teacher +
                ", lesson=" + lesson +
                ", groupOfStudent=" + groupOfStudent +
                '}';
    }

    public Bill() {
    }

    public Bill(int id, Teacher teacher, Lesson lesson, GroupOfStudent groupOfStudent) {
        this.id = id;
        this.teacher = teacher;
        this.lesson = lesson;
        this.groupOfStudent = groupOfStudent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public GroupOfStudent getGroupOfStudent() {
        return groupOfStudent;
    }

    public void setGroupOfStudent(GroupOfStudent groupOfStudent) {
        this.groupOfStudent = groupOfStudent;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
