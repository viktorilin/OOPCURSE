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

public class LessonController
{
    @Qualifier("daoLessonImpl")
    @Autowired
    private DaoLessonImpl daoLesson;
    @RequestMapping("/api/lesson")
    public List<Lesson> lessonsList(){
        return daoLesson.readAll();
    }

    @RequestMapping("/lessons")
    public String lessons(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Lesson table</title>\n" +
                "    <link rel=\"stylesheet\" href=\"/css/table.css\">\n" +
                "</head>\n" +
                "<body ng-app=\"laba3\">\n" +
                "<div class=\"container\" style=\"margin-top: 50px\" ng-controller=\"LessonController\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"panel panel-default\">\n" +
                "                <h2 align=\\\"center\\\"> Information about Lessons </h2>\n" +
                "                <table class=\"table table-striped\">\n" +
                "                    <thead>\n" +
                "                    <tr>\n" +
                "                        <th><mrg>Id</mrg></th>\n" +
                "                        <th><mrg>Time of Lesson</mrg></th>\n" +
                "                        <th><mrg>Number of class room</mrg></th>\n" +
                "                        <th><mrg>Name of lesson</mrg></th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>\n" +
                "                    <tr ng-repeat=\"item in lessons\" >\n" +
                "                        <td><mrg>{{item.id}}</mrg></td>\n" +
                "                        <td><mrg>{{item.timeOfLesson}}</mrg></td>\n" +
                "                        <td><mrg>{{item.numberOfClassRoom}}</mrg></td>\n" +
                "                        <td><mrg>{{item.nameOfLesson}}</mrg></td>\n" +
                "                    </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"js/angular.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"js/lesson.js\"></script>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

}
