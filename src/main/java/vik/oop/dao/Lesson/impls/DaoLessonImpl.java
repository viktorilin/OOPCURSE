package vik.oop.dao.Lesson.impls;

import org.springframework.stereotype.Service;
import vik.oop.dao.Lesson.interfaces.IDaoLesson;
import vik.oop.model.Lesson.Lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 03.04.2017.
 */
@Service
public class DaoLessonImpl implements IDaoLesson
{
    public List<Lesson> lessons = new ArrayList<Lesson>();

    public DaoLessonImpl() {
        try {
            Connection co = DriverManager.getConnection("jdbc:sqlite:laba3.db");
            Statement statement = co.createStatement();
            String query = "SELECT * FROM Lesson";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String timeOfLesson = rs.getString("timeOfLesson");
                int numberOfClassRoom = rs.getInt("numberOfClassRoom");
                String nameOfLesson = rs.getString("nameOfLesson");
                Lesson lesson = new Lesson(id,timeOfLesson,numberOfClassRoom,nameOfLesson);
                this.lessons.add(lesson);
            }
            co.close();
            statement.close();
        } catch (Exception e) {
            //  System.out.println(e.getMessage());
        }
    }

    public DaoLessonImpl(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public ArrayList<Lesson> readAll() {
        return (ArrayList<Lesson>) this.lessons;

    }

    public List<Lesson> getAll() {
        return lessons;
    }

    public Lesson getLesson(int id) {
        Lesson result = null;
        for (Lesson lesson:lessons)
        {
            if((lesson.getId())==id)
            {
                result = new Lesson();
            }

        }
        return result;
    }

    public void createLesson(Lesson lesson)
    {
        lessons.add(lesson);
    }

    public void updateLesson(Lesson lesson)
    {
        Lesson updateLesson = null;
        for (Lesson lesson1:lessons)
        {
            if(lesson1.getId()==lesson.getId())
            {
                updateLesson = lesson1;
                break;
            }
        }
        updateLesson = lesson;
    }

    public void deleteLesson(int id)
    {
        int i =0;
        boolean is=false;
        for (Lesson lesson:lessons)
        {
            if (lesson.getId()==id)
            {
                is = true;
                break;
            }
            i++;
        }
        if (is) lessons.remove(i);

    }

    public void showAll()
    {
        for (Lesson lesson:lessons)
        {
            System.out.println(lesson.toString());
        }
    }
}
