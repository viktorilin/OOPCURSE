package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.model.Lesson.Lesson;
import vik.oop.services.Lesson.impls.LessonServiceImpl;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController

public class LessonController
{
    @Qualifier("daoLessonImpl")
    @Autowired
    private DaoLessonImpl daoLesson;
    @RequestMapping("/api/lesson")
    public List<Lesson> lessonsList(){
        return daoLesson.readAll();
    }

}
