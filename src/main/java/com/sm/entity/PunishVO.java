package com.sm.entity;

import java.util.Date;

public class PunishVO {
    private Integer id;
    private String studentName;
    private String className;
    private String departmentName;
    private String punish;
    private String studentId;
    private Date punishDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPunish() {
        return punish;
    }

    public void setPunish(String punish) {
        this.punish = punish;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Date getPunishDate() {
        return punishDate;
    }

    public void setPunishDate(Date punishDate) {
        this.punishDate = punishDate;
    }


    @Override
    public String toString() {
        return "PunishVO{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", className='" + className + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", punish='" + punish + '\'' +
                ", studentId='" + studentId + '\'' +
                ", punishDate=" + punishDate +
                '}';
    }
}
