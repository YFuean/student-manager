package com.sm.service.impl;

import com.sm.entity.PunishVO;
import com.sm.entity.RewardVO;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.ServiceFactory;
import com.sm.service.StudentService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentServiceImplTest {
    private StudentService studentService = ServiceFactory.getStudentServiceInstance();

    @Test
    public void selectAll() {
        List<StudentVO> studentList = studentService.selectAll();
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void getStuByDepartmentId() {
        List<StudentVO> studentList = studentService.getStuByDepartmentId(15);
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void getStuByClassId() {
        List<StudentVO> studentList = studentService.getStuByClassId(2);
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void getStuByKeywords() {
        List<StudentVO> studentList = studentService.getStuByKeywords("江苏");
        studentList.forEach(studentVO -> System.out.println(studentVO));
    }

    @Test
    public void updateStudent() {
        Student student = new Student();
        student.setId("12");
        student.setAddress("北京");
        student.setPhone("22222");
        studentService.updateStudent(student);
    }

    @Test
    public void deleteStuById() {
        studentService.deleteStuById("8");
    }

    @Test
    public void insertStu() {
        Student student = new Student();
        student.setId("112222221");
        student.setClassId(6);
        student.setStudentName("yue");
        student.setAvatar("111.jpg");
        student.setBirthday(new Date());
        student.setGender("男");
        student.setAvatar("纽约");
        student.setPhone("999999");
        studentService.insertStu(student);
    }

    @Test
    public void countByDepartmentId() {
        int count = studentService.countByDepartmentId(12);
        System.out.println(count);
    }

    @Test
    public void countByClassId() {
        int count = studentService.countByClassId(6);
        System.out.println(count);
    }

    @Test
    public void selectAllReward() {
        List<RewardVO> rewardVOList = studentService.selectAllReward();
        rewardVOList.forEach(rewardVO -> System.out.println(rewardVO));
    }

    @Test
    public void selectByStuId() {
        List<RewardVO> rewardVOList = studentService.selectByStuId("1802736893");
        rewardVOList.forEach(rewardVO -> System.out.println(rewardVO));
    }

    @Test
    public void selectRewByKeywords() {
        List<RewardVO> rewardVOList = studentService.selectRewByKeywords("李");
        rewardVOList.forEach(rewardVO -> System.out.println(rewardVO));
    }

    @Test
    public void delRewById() {
        studentService.delRewById(16);
    }

    @Test
    public void upRew() {
        RewardVO rewardVO = new RewardVO();
        rewardVO.setId(14);
        rewardVO.setReward("国家奖学金");
        studentService.upRew(rewardVO);
    }

    @Test
    public void inRew() {
        RewardVO rewardVO = new RewardVO();
        rewardVO.setStudentId("21");
        rewardVO.setReward("三好学生");
        rewardVO.setRewardDate(new Date());
        studentService.inRew(rewardVO);
    }

    @Test
    public void selectAllPunish() {
        List<PunishVO> punishVOList = studentService.selectAllPunish();
        punishVOList.forEach(punishVO -> System.out.println(punishVO));
    }

    @Test
    public void selectPunByKeywords() {
        List<PunishVO> punishVOList = studentService.selectPunByKeywords("李");
        punishVOList.forEach(punishVO -> System.out.println(punishVO));
    }

    @Test
    public void delPunById() {
        studentService.delPunById(17);
    }

    @Test
    public void upPun() {
        PunishVO punishVO = new PunishVO();
        punishVO.setId(15);
        punishVO.setPunish("处分");
        studentService.upPun(punishVO);
    }

    @Test
    public void inPun() {
        PunishVO punishVO = new PunishVO();
        punishVO.setStudentId("33333");
        punishVO.setPunish("处分");
        punishVO.setPunishDate(new Date());
        studentService.inPun(punishVO);
    }
}