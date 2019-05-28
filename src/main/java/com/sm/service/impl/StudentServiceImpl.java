package com.sm.service.impl;

import com.sm.dao.StudentDAO;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;
import com.sm.factory.DAOFactory;
import com.sm.service.StudentService;
import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    StudentDAO studentDAO = DAOFactory.getStudentDAOInstance();

    @Override
    public List<StudentVO> selectAll() {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<StudentVO> getStuByDepartmentId(int departmentId) {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<StudentVO> getStuByClassId(int classId) {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public List<StudentVO> getStuByKeywords(String keywords) {
        List<StudentVO> studentList = null;
        try {
            studentList = studentDAO.selectByKeywords(keywords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public int updateStudent(Student student) {
        int n = 0;
        try {
            n = studentDAO.updateStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int deleteStuById(String id) {
        int n = 0;
        try {
            n = studentDAO.deleteStuById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int insertStu(Student student) {
        int n = 0;
        try {
            n = studentDAO.insertStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public int countByDepartmentId(int departmentId) {
        int count = 0;
        try {
            count = studentDAO.countByDepartmentId(departmentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int countByClassId(int classId) {
        int count = 0;
        try {
            count = studentDAO.countByClassId(classId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
