package com.sm.dao.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.*;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentDAOImplTest {
    private StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

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

    @Test
    public void selectAllReward() {
        List<RewardVO> rewardVOList = null;
        try {
            rewardVOList = studentDAO.selectAllReward();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        rewardVOList.forEach(rewardVO -> System.out.println(rewardVO));
    }

    @Test
    public void selectByStuId() {
        List<RewardVO> rewardVOList = null;
        try {
            rewardVOList = studentDAO.selectByStuId("1802426679");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rewardVOList.forEach(rewardVO -> System.out.println(rewardVO));
    }

    @Test
    public void selectRedByKeywords() {
        List<RewardVO> rewardVOList = null;
        try {
            rewardVOList = studentDAO.selectRewByKeywords("商务");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rewardVOList.forEach(rewardVO -> System.out.println(rewardVO));
    }

    @Test
    public void deleteRewById() {
        try {
            studentDAO.deleteRewById(15);
        } catch (SQLException e) {
        }
    }

    @Test
    public void updateRew() throws SQLException {
        RewardVO rewardVO = new RewardVO();
        rewardVO.setReward("guojia奖学金");
        rewardVO.setId(14);
        studentDAO.updateRew(rewardVO);
    }

    @Test
    public void insertRew() throws SQLException{
        RewardVO rewardVO = new RewardVO();
        rewardVO.setStudentId("35436363");
        rewardVO.setReward("黄炎培奖学金");
        rewardVO.setRewardDate(new Date());
        studentDAO.insertRew(rewardVO);
    }

    @Test
    public void selectAllPunish() {
        List<PunishVO> punishVOList = null;
        try {
            punishVOList = studentDAO.selectAllPunish();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        punishVOList.forEach(punishVO -> System.out.println(punishVO));
    }

    @Test
    public void selectPunByKeywords() {
        List<PunishVO> punishVOList = null;
        try {
            punishVOList = studentDAO.selectPunByKeywords("机械");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        punishVOList.forEach(punishVO -> System.out.println(punishVO));
    }

    @Test
    public void deletePunById() {
        try {
            studentDAO.deletePunById(16);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updatePun() throws SQLException {
        PunishVO punishVO = new PunishVO();
        punishVO.setPunish("真香警告");
        punishVO.setId(15);
        studentDAO.updatePun(punishVO);
    }

    @Test
    public void insertPun() throws SQLException{
        PunishVO punishVO = new PunishVO();
        punishVO.setStudentId("35436363");
        punishVO.setPunish("真香警告");
        punishVO.setPunishDate(new Date());
        studentDAO.insertPun(punishVO);
    }
}