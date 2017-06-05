package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.GroupOfStudent.impls.DaoGroupOfStudentImpl;
import vik.oop.model.GroupOfStudent.GroupOfStudent;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController
public class GroupOfStudentController {
    @Autowired
    private DaoGroupOfStudentImpl daoGroupOfStudent;
    @RequestMapping("/api/groupOfStudent")
    public List<GroupOfStudent> groupOfStudentList(){
        return daoGroupOfStudent.readAll();
    }

    @RequestMapping("/groupOfStudents")
    public String groupOfStudents(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Group of student table</title>\n" +
                "    <link rel=\"stylesheet\" href=\"/css/table.css\">\n" +
                "</head>\n" +
                "<body ng-app=\"laba3\">\n" +
                "<div class=\"container\" style=\"margin-top: 50px\" ng-controller=\"GroupOfStudentController\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"panel panel-default\">\n" +
                "                <h2 align=\\\"center\\\"> Information about Group of students </h2>\n" +
                "                <table class=\"table table-striped\">\n" +
                "                    <thead>\n" +
                "                    <tr>\n" +
                "                        <th><mrg>Id</mrg></th>\n" +
                "                        <th><mrg>Number of group</mrg></th>\n" +
                "                        <th><mrg>Specialty</mrg></th>\n" +
                "                        <th><mrg>Department</mrg></th>\n" +
                "                        <th><mrg>Number of students</mrg></th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>\n" +
                "                    <tr ng-repeat=\"item in groupOfStudents\" >\n" +
                "                        <td><mrg>{{item.id}}</mrg></td>\n" +
                "                        <td><mrg>{{item.numberOfGroup}}</mrg></td>\n" +
                "                        <td><mrg>{{item.specialty}}</mrg></td>\n" +
                "                        <td><mrg>{{item.department}}</mrg></td>\n" +
                "                        <td><mrg>{{item.numberOfStudents}}</mrg></td>\n" +
                "                    </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"js/angular.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"js/groupOfStudent.js\"></script>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }
}
