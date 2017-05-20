package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.model.Lesson.Lesson;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController
@RequestMapping("/api/lesson")
public class LessonController
{
    @Autowired
    private DaoLessonImpl daoLesson;
    @RequestMapping
    public List<Lesson> lessonsList(){
        return daoLesson.readAll();
    }

}