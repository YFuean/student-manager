package com.sm.dao;

import com.sm.entity.CClass;
import com.sm.entity.Department;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CClassDAO {
    /**
     * 按照院系id查询班级
     * @param departmentId
     * @return List<CClass>
     * @throws  SQLException
     */
    List<CClass> selectByDepartmentId(int departmentId) throws SQLException;

    /**
     * 根据班级id删除
     * @param id
     * @return int
     * @throws SQLException
     */
    int deleteById(int id)throws SQLException;

    /**
     * 根据名称查
     * @param
     * @return department
     * @throws SQLException
     */
    List<CClass> getClassByName(String className) throws SQLException;

    /**
     * 新增班级
     * @param cClass
     * @return cClass
     * @throws SQLException
     */
    int insertClass(CClass cClass) throws SQLException;

    /**
     * 查所有
     * @return
     * @throws SQLException
     */
    List<CClass> selectAll() throws SQLException;

    /**
     * 根据院系id统计班级数
     * @param departmentId
     * @return int
     * @throws SQLException
     */
    int countByDepartmentId(int departmentId)throws SQLException;
}
