package vik.oop.services.Teacher.impls;

import org.junit.Test;
import vik.oop.dao.Lesson.impls.DaoLessonImpl;
import vik.oop.dao.Teacher.impls.DaoTeacher;
import vik.oop.model.Teacher.Teacher;
import vik.oop.services.Lesson.impls.LessonServiceImpl;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Asus on 27.05.2017.
 */
public class TeacherServiceImplTest {
    @Test
    public void nameOfTheBestTeacher() throws Exception {
        DaoTeacher daoTeacher = new DaoTeacher();
        TeacherServiceImpl teacherService = new TeacherServiceImpl(daoTeacher);
        String result = daoTeacher.readAll().get(0).getFullName();
        for (int i = 0; i < daoTeacher.readAll().size() - 1; i++) {
            if (daoTeacher.readAll().get(i).getTimeOfWork() > daoTeacher.readAll().get(i + 1).getTimeOfWork())
                result = daoTeacher.readAll().get(i).getFullName();
        }
        assertEquals(result, teacherService.nameOfTheBestTeacher(daoTeacher.readAll()));
    }

    @Test
    public void numberOfPhoneOfTheBestTeacher() throws Exception {
        DaoTeacher daoTeacher = new DaoTeacher();
        TeacherServiceImpl teacherService = new TeacherServiceImpl(daoTeacher);
        String result = daoTeacher.readAll().get(0).getNumberOfPhone();
        for (int i = 0; i < daoTeacher.readAll().size() - 1; i++) {
            if (daoTeacher.readAll().get(i).getTimeOfWork() > daoTeacher.readAll().get(i + 1).getTimeOfWork())
                result = daoTeacher.readAll().get(i).getNumberOfPhone();
        }
        assertEquals(result, teacherService.numberOfPhoneOfTheBestTeacher(daoTeacher.readAll()));

    }

    @Test
    public void getPaymentForTeacher() throws Exception {
        DaoTeacher daoTeacher = new DaoTeacher();
        TeacherServiceImpl teacherService = new TeacherServiceImpl(daoTeacher);
        int result = daoTeacher.getTeacher(1).getTimeOfWork() * daoTeacher.getTeacher(1).getSalary();
        assertEquals(result, teacherService.getPaymentForTeacher(daoTeacher.getTeacher(1)));
    }

    @Test
    public void getMaximumPaymentForTeacher() throws Exception {
        DaoTeacher daoTeacher = new DaoTeacher();
        TeacherServiceImpl teacherService = new TeacherServiceImpl(daoTeacher);
        int result = 0;
        for (int i = 0; i < daoTeacher.readAll().size() - 1; i++) {
            if (teacherService.getPaymentForTeacher(daoTeacher.readAll().get(i)) > teacherService.getPaymentForTeacher(daoTeacher.readAll().get(i + 1)))
                result = teacherService.getPaymentForTeacher(daoTeacher.readAll().get(i));
        }
        assertEquals(result, teacherService.getMaximumPaymentForTeacher(daoTeacher.readAll()));
    }

    @Test
    public void getMinimumPaymentForTeacher() throws Exception {
        DaoTeacher daoTeacher = new DaoTeacher();
        TeacherServiceImpl teacherService = new TeacherServiceImpl(daoTeacher);
        int result = 1000000;
        for (int i = 0; i < daoTeacher.readAll().size() - 1; i++) {
            if (teacherService.getPaymentForTeacher(daoTeacher.readAll().get(i)) < teacherService.getPaymentForTeacher(daoTeacher.readAll().get(i + 1)))
                result = teacherService.getPaymentForTeacher(daoTeacher.readAll().get(i));
        }
        assertEquals(result, teacherService.getMinimumPaymentForTeacher(daoTeacher.readAll()));
}
    }