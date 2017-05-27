package vik.oop.dao.Lesson.impls;

import com.google.gson.Gson;
import org.junit.Test;
import vik.oop.model.Lesson.Lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Asus on 23.05.2017.
 */
public class DaoLessonImplTest {

    @Test
    public void getAll() throws Exception {
        DaoLessonImpl dao = new DaoLessonImpl();
        int count = dao.readAll().size();
        assertEquals(dao.getAll().size(), count);
    }

    @Test
    public void getLessons() throws Exception {
        DaoLessonImpl dao = new DaoLessonImpl();
        Lesson result = null;
        for (Lesson lesson : dao.readAll()) {
            if (lesson.getId() == 2) {
                result = new Lesson();
            }
        }
        Gson gson = new Gson();
        String str1 = gson.toJson(result);
        String str2 = gson.toJson(dao.getLesson(2));
        assertEquals(str1,str2);
    }

    @Test
    public void createLesson() throws Exception {
        ArrayList<Lesson> lessons = new ArrayList<>();
        ArrayList<Lesson> lessons1 = new ArrayList<>();
        Lesson lesson = new Lesson();
        Lesson lesson1 = new Lesson();
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        lessons=daoLesson.readAll();
        lessons.add(lesson);

        daoLesson.createLesson(lesson1);
        daoLesson.getAll();
        lessons1= (ArrayList<Lesson>) daoLesson.getAll();

        lessons.add(lesson);

        daoLesson.createLesson(lesson1);
        assertEquals(lessons1.size(),lessons.size());
    }


    @Test
    public void deleteLesson() throws Exception {
        ArrayList<Lesson> lessons = new ArrayList<>();
        ArrayList<Lesson> lessons1 = new ArrayList<>();
        Lesson lesson = new Lesson();
        Lesson lesson1 = new Lesson();
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        lessons=daoLesson.readAll();
        lessons.remove(daoLesson.readAll().size()-1);

        lessons1= (ArrayList<Lesson>) daoLesson.getAll();
        daoLesson.deleteLesson(lessons1.size());


        lessons.add(lesson);

        daoLesson.createLesson(lesson1);
        assertEquals(lessons1.size(),lessons.size());
    }

    @Test
    public void readAll() throws Exception {
        ArrayList<Lesson> lessons = new ArrayList<>();
        Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
        Statement statement = co.createStatement();
        String query =  " SELECT * FROM Lesson";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()){
            int id = rs.getInt("id");
            String timeOfLesson = rs.getString("timeOfLesson");
            int numberOfClassRoom = rs.getInt("numberOfClassRoom");
            String nameOfLesson = rs.getString("nameOfLesson");
            Lesson lesson = new Lesson(id,timeOfLesson,numberOfClassRoom,nameOfLesson);
            lessons.add(lesson);
        }
        DaoLessonImpl daoLesson = new DaoLessonImpl();
        Gson gson = new Gson();
        String str1=gson.toJson(lessons);
        String str2=gson.toJson(daoLesson.readAll());

        assertEquals(str1,str2);
    }


}