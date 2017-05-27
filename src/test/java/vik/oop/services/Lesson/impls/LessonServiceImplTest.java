package vik.oop.services.Lesson.impls;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.model.Lesson.Lesson;

import java.util.Objects;

import static org.junit.Assert.*;

/**
 * Created by Asus on 27.05.2017.
 */
public class LessonServiceImplTest {
    @Test
    public void isInThisClassRoomLesson() throws Exception {
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl(daoLesson);
        int numberOfClassroom = daoLesson.getLesson(1).getNumberOfClassRoom();
        boolean result = false;

        for (Lesson lesson:daoLesson.readAll()) {
            if (lesson.getNumberOfClassRoom()== daoLesson.getLesson(1).getNumberOfClassRoom()){
                result = true;
                break;
            }
            else result = false;

        }
        assertEquals(result,lessonService.isInThisClassRoomLesson(daoLesson.readAll(),numberOfClassroom));
    }

    @Test
    public void getNumberOfLesson() throws Exception {
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl(daoLesson);
        int result = 0;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "8:20"))
            result = 1;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "9:50"))
            result = 2;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "11:30"))
            result = 3;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "13:00"))
            result = 4;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "14:40"))
            result = 5;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "16:10"))
            result = 6;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "17:50"))
            result = 7;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "18:20"))
            result = 8;
        assertEquals(result,lessonService.getNumberOfLesson(daoLesson.getLesson(1)));
    }

    @Test
    public void getNumberOfFloorOfCurrentClassRoomOfCurrentLesson() throws Exception {
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl(daoLesson);
        System.out.println(daoLesson.getLesson(1).getNumberOfClassRoom());
        int result;
        result = (daoLesson.getLesson(1).getNumberOfClassRoom())/100;
        assertEquals(result,lessonService.getNumberOfFloorOfCurrentClassRoomOfCurrentLesson(daoLesson.getLesson(1)));
    }

    @Test
    public void getMaxNumberOfClassRoom() throws Exception {
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl(daoLesson);
        int result = daoLesson.readAll().get(0).getNumberOfClassRoom();
        for (int i = 0; i < daoLesson.readAll().size()-1 ; i++) {
            if (daoLesson.readAll().get(i).getNumberOfClassRoom()>daoLesson.readAll().get(i+1).getNumberOfClassRoom())
                result = daoLesson.readAll().get(i).getNumberOfClassRoom();
        }
        assertEquals(result,lessonService.getMaxNumberOfClassRoom(daoLesson.readAll()));
    }

    @Test
    public void getRentOfClassRoom() throws Exception {
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl(daoLesson);
        int result2;
        result2 = (daoLesson.getLesson(1).getNumberOfClassRoom())/100;
        int result;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "8:20"))
        {
            result =1;
        }
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "9:50"))
            result = 2;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "11:30"))
            result = 3;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "13:00"))
            result = 4;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "14:40"))
            result = 5;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "16:10"))
            result = 6;
        if (Objects.equals(daoLesson.getLesson(1).getTimeOfLesson(), "17:50"))
            result = 7;
        else
            result = 8;
        double resultd;
        resultd = 1000/result/result2;
        double delta = 0;
        assertEquals(resultd,lessonService.getRentOfClassRoom(daoLesson.getLesson(1)), delta);

    }

}