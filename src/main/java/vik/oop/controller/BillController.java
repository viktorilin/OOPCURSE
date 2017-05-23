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

}
