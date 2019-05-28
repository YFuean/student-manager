package com.sm.service.impl;

import com.sm.entity.Department;
import com.sm.factory.ServiceFactory;
import com.sm.service.DepartmentService;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DepartmentServiceImplTest {
    private DepartmentService departmentService = ServiceFactory.getDepartmentServiceInstance();
    @Test
    public void selectAll() {
        List<Department> departmentList = departmentService.selectAll();
        departmentList.forEach(department -> System.out.println(department));
    }

    @Test
    public void delete(){
        departmentService.deleteDepartmentById(20);
    }

    @Test
    public void addDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试院系");
        department.setLogo("https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/img/9aa68a3a-637a-46c2-819a-a4bea407fb8a.jpg ");
        departmentService.addDepartment(department);
    }

    @Test
    public void selectDepartmentByName() {
        List<Department> departmentList = departmentService.selectDepartmentByName("航空工程学院");
        departmentList.forEach(department -> System.out.println(department));
    }

    @Test
    public void selectDepartmentInfo() {
        List<Map> mapList = departmentService.selectDepartmentInfo();
        mapList.forEach(map -> {
           System.out.println(map.get("department") + "  " + map.get("classCount") + "个班级  "
                   + map.get("studentCount") + "个学生");
        });
    }
}
