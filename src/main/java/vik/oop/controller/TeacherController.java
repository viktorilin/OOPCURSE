package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Teacher.Teacher;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController
public class TeacherController {
    @Autowired
    private DaoTeacher daoTeacher;
    @RequestMapping("api/teacher")
    public List<Teacher> teacherList(){return daoTeacher.readAll();}

    @RequestMapping("/teachers")
    public String teachers(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Teacher table</title>\n" +
                "    <link rel=\"stylesheet\" href=\"/css/table.css\">\n" +
                "</head>\n" +
                "<body ng-app=\"laba3\">\n" +
                "<div class=\"container\" style=\"margin-top: 50px\" ng-controller=\"TeacherController\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"panel panel-default\">\n" +
                "                <h2 align=\\\"center\\\"> Information about Teachers </h2>\n" +
                "                <table class=\"table table-striped\">\n" +
                "                    <thead>\n" +
                "                    <tr>\n" +
                "                        <th><mrg>Id</mrg></th>\n" +
                "                        <th><mrg>Full name</mrg></th>\n" +
                "                        <th><mrg>Number of phone</mrg></th>\n" +
                "                        <th><mrg>Time of work</mrg></th>\n" +
                "                        <th><mrg>Salary</mrg></th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>\n" +
                "                    <tr ng-repeat=\"item in teachers\" >\n" +
                "                        <td><mrg>{{item.id}}</mrg></td>\n" +
                "                        <td><mrg>{{item.fullName}}</mrg></td>\n" +
                "                        <td><mrg>{{item.numberOfPhone}}</mrg></td>\n" +
                "                        <td><mrg>{{item.timeOfWork}}</mrg></td>\n" +
                "                        <td><mrg>{{item.salary}}</mrg></td>\n" +
                "                    </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"js/angular.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"js/teacher.js\"></script>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }
}
