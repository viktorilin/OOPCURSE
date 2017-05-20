package vik.oop.services.Lesson.impls;

import org.springframework.stereotype.Service;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.model.Lesson.Lesson;
import vik.oop.services.Lesson.interfaces.ILessonService;

import java.util.List;

/**
 * Created by Asus on 09.04.2017.
 */
public class LessonServiceImpl implements ILessonService
{
    ILessonService iLessonService;

    public LessonServiceImpl(DaoLessonImpl daoLesson) {
    }

    public List<Lesson> getAll() {
        return iLessonService.getAll();
    }

    public Lesson getLesson(int id) {
        return iLessonService.getLesson(id);
    }

    public void createLesson(Lesson lesson) {
        iLessonService.createLesson(lesson);
    }

    public void updateLesson(Lesson lesson) {
        iLessonService.updateLesson(lesson);
    }

    public void deleteLesson(int id) {
        iLessonService.deleteLesson(id);
    }

    public void showAll() {
        iLessonService.showAll();
    }

}
