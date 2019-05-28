package com.sm.service;

import com.sm.entity.CClass;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    List<StudentVO> selectAll();

    List<StudentVO> getStuByDepartmentId(int departmentId) ;

    List<StudentVO> getStuByClassId(int classId) ;

    List<StudentVO> getStuByKeywords(String keywords) ;

    int updateStudent(Student student);

    int deleteStuById(String id);

    int insertStu(Student student);

    int countByDepartmentId(int departmentId);

    int countByClassId(int classId);
}
