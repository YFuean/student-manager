package com.sm.dao;

import com.sm.entity.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    /**
     * 查询所有院系
     * @return List<Department>
     * @throws SQLException
     */
    List<Department> getAll() throws SQLException;

    /**
     * 根据id删除院系
     * @param id
     */
    int deleteById(int id)throws SQLException;

    /**
     * 新增院系
     * @param department
     * @return department
     * @throws SQLException
     */
    int insertDepartment(Department department) throws SQLException;

    /**
     * 根据院系名查院系
     * @param
     * @return department
     * @throws SQLException
     */
    List<Department> getDepartmentByName(String departmentName) throws SQLException;

}
