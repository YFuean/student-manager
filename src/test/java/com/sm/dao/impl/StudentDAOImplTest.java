package com.sm.dao.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.CClass;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOImplTest {
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();
//    @Test
//    public void selectByClassId() {
//        List<Student> studentList = null;
//        try {
//            studentList = studentDAO.selectByClassId(1);
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        studentList.forEach(student -> System.out.println(student));
//    }
//
//    @Test
//    public void deleteById(){
//        try {
//            studentDAO.deleteById(20);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Test
//    public void getStudentByName() {
//        List<Student> studentList = null;
//        try {
//            studentList = studentDAO.getStudentByName("王一");
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//        studentList.forEach(student -> System.out.println(student));
//    }
//
//    @Test
//    public void insertStudent() {
//        Student student = new Student();
//        student.setClassId(14);
//        student.setStudentName("yf测试");
//        try {
//            studentDAO.insertStudent(student);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void selectAll() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectAll();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByDepartmentId() {
        List<StudentVO> studentList = null;
        try{
            studentList = studentDAO.selectByDepartmentId(15);
        }catch (SQLException e){
            e.printStackTrace();
        }
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByClassId() {
        List<StudentVO> studentList = null;
        try{
            studentList = studentDAO.selectByClassId(2);
        }catch (SQLException e){
            e.printStackTrace();
        }
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void selectByKeywords() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByKeywords("江苏");
        }catch (SQLException e){
            e.printStackTrace();
        }
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void updateStudent() throws SQLException{
        Student student = new Student();
        student.setId("12");
        student.setAddress("浙江杭州");
        student.setPhone("11111111");
        studentDAO.updateStudent(student);
    }

    @Test
    public void deleteStuById() {
        try {
            studentDAO.deleteStuById("9");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertStudent() throws SQLException{
        Student student = new Student();
        student.setId("1111111111");
        student.setClassId(6);
        student.setStudentName("yue");
        student.setAvatar("111.jpg");
        student.setBirthday(new Date());
        student.setGender("男");
        student.setAvatar("纽约");
        student.setPhone("8888888");
        studentDAO.insertStudent(student);
    }

    @Test
    public void countByDepartmentId() {
        int number = 0;
        try {
            number = studentDAO.countByDepartmentId(12);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }

    @Test
    public void countByClassId() {
        int count = 0;
        try {
            count = studentDAO.countByClassId(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }
}