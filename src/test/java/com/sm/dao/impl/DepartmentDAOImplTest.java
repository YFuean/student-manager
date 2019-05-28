package com.sm.dao.impl;

import com.sm.dao.DepartmentDAO;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class DepartmentDAOImplTest {
    private DepartmentDAO departmentDAO = DAOFactory.getDepartmentDAOInstance();
    @Test
    public void getAll() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        departmentList.forEach(department -> System.out.println(department));
    }

    @Test
    public void delete(){
        try {
            departmentDAO.deleteById(20);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertDepartment() {
        Department department = new Department();
        department.setDepartmentName("测试院系");
        department.setLogo("https://yfuean-student-manager.oss-cn-shanghai.aliyuncs.com/img/9aa68a3a-637a-46c2-819a-a4bea407fb8a.jpg ");
        try {
            departmentDAO.insertDepartment(department);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDepartmentByName() {
        List<Department> departmentList = null;
        try {
            departmentList = departmentDAO.getDepartmentByName("计算机与软件学院");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        departmentList.forEach(department -> System.out.println(department));
    }
}