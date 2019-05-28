package com.sm.service.impl;

import com.sm.entity.CClass;
import com.sm.entity.Department;
import com.sm.factory.ServiceFactory;
import com.sm.service.CClassService;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CClassServiceImplTest {
    private CClassService cClassService = ServiceFactory.getCClassServiceInstance();

    @Test
    public void selectByDepartmentId() {
        List<CClass> cClassList = cClassService.selectByDepartmentId(15);
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void deleteClassById() {
        cClassService.deleteClassById(27);
    }

    @Test
    public void addCClass() {
        CClass cClass = new CClass();
        cClass.setDepartmentId(12);
        cClass.setClassName("电气测试");
        cClassService.addCClass(cClass);
    }

    @Test
    public void selectAllClass() {
        List<CClass> cClassList = cClassService.selectAllClass();
        cClassList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void countByDepartmentId() {
        int count = cClassService.countByDepartmentId(15);
        System.out.println(count);
    }


    @Test
    public void selectClassInfo1() {
        List<Map> mapList = cClassService.selectClassInfo(15);
        mapList.forEach(map -> {
            System.out.println(map.get("cClass") + "  " + map.get("studentCount") + "个学生");
        });
    }
}