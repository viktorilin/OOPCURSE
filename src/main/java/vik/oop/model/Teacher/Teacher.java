package vik.oop.model.Teacher;

/**
 * Created by Asus on 27.03.2017.
 */
public class Teacher
{
    private int id;
    private String fullName;
    private String numberOfPhone;
    private int timeOfWork;
    private int salary;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", numberOfPhone='" + numberOfPhone + '\'' +
                ", timeOfWork=" + timeOfWork +
                ", salary=" + salary +
                '}';
    }

    public Teacher() {
    }

    public Teacher(int id, String fullName, String numberOfPhone, int timeOfWork, int salary) {
        this.id = id;
        this.fullName = fullName;
        this.numberOfPhone = numberOfPhone;
        this.timeOfWork = timeOfWork;
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNumberOfPhone() {
        return numberOfPhone;
    }

    public void setNumberOfPhone(String numberOfPhone) {
        this.numberOfPhone = numberOfPhone;
    }

    public int getTimeOfWork() {
        return timeOfWork;
    }

    public void setTimeOfWork(int timeOfWork) {
        this.timeOfWork = timeOfWork;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
