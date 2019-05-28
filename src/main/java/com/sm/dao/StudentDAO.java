package com.sm.dao;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    /**
     * 查询所有学生（视图对象）
     * @return  List<StudentVO>
     * @throws SQLException
     */
    List<StudentVO> selectAll() throws SQLException;

    List<StudentVO> selectByDepartmentId(int departmentId) throws SQLException;

    List<StudentVO> selectByClassId(int classId) throws SQLException;

    List<StudentVO> selectByKeywords(String keywords) throws SQLException;

    int updateStudent (Student student) throws SQLException;

    int deleteStuById(String id) throws SQLException;

    int insertStudent(Student student) throws SQLException;

    int countByDepartmentId(int departmentId)throws SQLException;

    /**
     * 根据班级id统计人数
     * @param classId
     * @return
     * @throws SQLException
     */
    int countByClassId(int classId) throws SQLException;
}
