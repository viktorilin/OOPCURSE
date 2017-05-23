package vik.oop.services.Lesson.impls;

import org.springframework.stereotype.Service;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.model.Lesson.Lesson;
import vik.oop.services.Lesson.interfaces.ILessonService;

import java.util.List;
import java.util.Objects;

/**
 * Created by Asus on 09.04.2017.
 */
@Service
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

    public boolean isInThisClassRoomLesson(List<Lesson> lessons, int numberOfClassRoom){
        for (Lesson lesson:lessons) {
            if (lesson.getNumberOfClassRoom()== numberOfClassRoom)
                return true;
        }
        return false;
    }

    public int getNumberOfLesson(Lesson lesson) {
        if (Objects.equals(lesson.getTimeOfLesson(), "8:20"))
            return 1;
        if (Objects.equals(lesson.getTimeOfLesson(), "9:50"))
            return 2;
        if (Objects.equals(lesson.getTimeOfLesson(), "11:30"))
            return 3;
        if (Objects.equals(lesson.getTimeOfLesson(), "13:00"))
            return 4;
        if (Objects.equals(lesson.getTimeOfLesson(), "14:40"))
            return 5;
        if (Objects.equals(lesson.getTimeOfLesson(), "16:10"))
            return 6;
        if (Objects.equals(lesson.getTimeOfLesson(), "17:50"))
            return 7;
        return 8;
    }

    public int getNumberOfFloorOfCurrentClassRoomOfCurrentLesson(Lesson lesson){
        return lesson.getNumberOfClassRoom()/100;
    }

    public int getMaxNumberOfClassRoom(List<Lesson> lessons){
        int result = lessons.get(0).getNumberOfClassRoom();
        for (int i = 0; i < lessons.size()-1 ; i++) {
            if (lessons.get(i).getNumberOfClassRoom()>lessons.get(i+1).getNumberOfClassRoom())
                result = lessons.get(i).getNumberOfClassRoom();
        }
        return result;
    }

    public double getRentOfClassRoom(Lesson lesson){
        return 1000/iLessonService.getNumberOfLesson(lesson)/iLessonService.getNumberOfFloorOfCurrentClassRoomOfCurrentLesson(lesson);
}




}
