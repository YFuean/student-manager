package com.sm.factory;

import com.sm.service.AdminService;
import com.sm.service.CClassService;
import com.sm.service.DepartmentService;
import com.sm.service.StudentService;
import com.sm.service.impl.AdminServiceImpl;
import com.sm.service.impl.CClassServiceImpl;
import com.sm.service.impl.DepartmentServiceImpl;
import com.sm.service.impl.StudentServiceImpl;

public class ServiceFactory {
    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }
    public static DepartmentService getDepartmentServiceInstance() {
        return new DepartmentServiceImpl();
    }
    public  static CClassService getCClassServiceInstance(){return new CClassServiceImpl(); }
    public static StudentService getStudentServiceInstance(){return new StudentServiceImpl();}
}