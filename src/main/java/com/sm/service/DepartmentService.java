package com.sm.service;

import com.sm.entity.Department;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    /**
     * 查询
     * @return DepartmentList
     */
    List<Department> selectAll();

    /**
     * 删除
     * @param id
     */
    int deleteDepartmentById(int id);

    /**
     * 新增
     * @param department
     * @return
     */
    int addDepartment(Department department);

    /**
     * 根据名称查
     * @param departmentName
     * @return departmentList
     */
    List<Department> selectDepartmentByName(String departmentName);

    /**
     * 获取所有院系的完整信息（包括每个学院的自身信息，班级数，学生数）
     * @return List<Map>
     */
    List<Map> selectDepartmentInfo();
}
