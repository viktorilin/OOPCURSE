package vik.oop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vik.oop.dao.Bill.impls.DaoBillImpl;
import vik.oop.model.Bill.Bill;
import vik.oop.model.Bills.Bills;

import java.util.List;

/**
 * Created by Asus on 20.05.2017.
 */
@RestController
public class BillController {
    @Autowired
    private DaoBillImpl daoBill;
    @RequestMapping("/api/bill")
    public List<Bill> billList(){
        return daoBill.readAll();
    }

    @RequestMapping("/bills")
    public String bills(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Bills</title>\n" +
                "    <link rel=\"stylesheet\" href=\"/css/table.css\">\n" +
                "</head>\n" +
                "<body ng-app=\"laba3\">\n" +
                "<div class=\"container\" style=\"margin-top: 50px\" ng-controller=\"BillController\">\n" +
                "    <div class=\"row\">\n" +
                "        <div class=\"col-md-12\">\n" +
                "            <div class=\"panel panel-default\">\n" +
                "                <h2 align=\\\"center\\\"> Information about Bill </h2>\n" +
                "                <table class=\"table table-striped\">\n" +
                "                    <thead>\n" +
                "                    <tr>\n" +
                "                        <th><mrg>Id</mrg></th>\n" +
                "                        <th><mrg>Teacher</mrg></th>\n" +
                "                        <th><mrg>Lesson</mrg></th>\n" +
                "                        <th><mrg>Group Of Student</mrg></th>\n" +
                "                    </tr>\n" +
                "                    </thead>\n" +
                "                    <tbody>\n" +
                "                    <tr ng-repeat=\"item in bills\" >\n" +
                "                        <td><mrg>{{item.id}}</mrg></td>\n" +
                "                        <td><mrg>{{item.teacher.fullName}}</mrg></td>\n" +
                "                        <td><mrg>{{item.lesson.nameOfLesson}}</mrg></td>\n" +
                "                        <td><mrg>{{item.groupOfStudent.numberOfGroup}}</mrg></td>\n" +
                "                    </tr>\n" +
                "                    </tbody>\n" +
                "                </table>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "\n" +
                "    <script type=\"text/javascript\" src=\"js/angular.min.js\"></script>\n" +
                "    <script type=\"text/javascript\" src=\"js/bill.js\"></script>\n" +
                "\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";
    }

}
