package com.sm.service;

import com.sm.entity.CClass;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface CClassService {
    List<CClass> selectByDepartmentId(int departmentId);

    int deleteClassById(int id);

    int addCClass(CClass cClass);

    List<CClass> selectAllClass();

    int countByDepartmentId(int departmentId);

    /**
     * 根据院系id获取所有班级的完整信息（包括每个班级的自身信息，学生数）
     * @return List<Map>
     */
    List<Map> selectClassInfo(int departmentId);
}
