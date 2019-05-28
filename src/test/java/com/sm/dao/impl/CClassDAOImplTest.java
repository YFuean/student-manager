package com.sm.dao.impl;

import com.sm.dao.CClassDAO;
import com.sm.entity.CClass;
import com.sm.entity.Department;
import com.sm.factory.DAOFactory;
import org.junit.Test;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CClassDAOImplTest {
    private CClassDAO cClassDAO = DAOFactory.getCClassDAOInstance();

    @Test
    public void selectByDepartmentId(){
        List<CClass> classList = null;
        try {
            classList = cClassDAO.selectByDepartmentId(15);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        classList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void deleteById() {
        try {
            cClassDAO.deleteById(26);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getClassByName() {
        List<CClass> classList = null;
        try {
            classList = cClassDAO.getClassByName("软件1811");
        }catch (SQLException e) {
            e.printStackTrace();
        }
        classList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void insertClass() {
        CClass cClass = new CClass();
        cClass.setDepartmentId(11);
        cClass.setClassName("测试机械");
        try {
            cClassDAO.insertClass(cClass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectAll() {
        List<CClass> classList = null;
        try {
            classList = cClassDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        classList.forEach(cClass -> System.out.println(cClass));
    }

    @Test
    public void countByDepartmentId() {
        int number = 0;
        try {
            number = cClassDAO.countByDepartmentId(15);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(number);
    }
}