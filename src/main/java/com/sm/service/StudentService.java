package com.sm.service;

import com.sm.entity.*;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

    List<StudentVO> selectAll();
    List<StudentVO> getStuByDepartmentId(int departmentId) ;
    List<StudentVO> getStuByClassId(int classId) ;
    List<StudentVO> getStuByKeywords(String keywords) ;



    List<RewardVO> selectAllReward();
    List<RewardVO> selectByStuId(String id);
    List<RewardVO> selectRewByKeywords(String keywords) ;


    List<PunishVO> selectAllPunish();
    List<PunishVO> selectPunByKeywords(String keywords);


    int updateStudent(Student student);
    int deleteStuById(String id);
    int insertStu(Student student);


    int delRewById(int rewId);
    int upRew(RewardVO rewardVO);
    int inRew(RewardVO rewardVO);

    int delPunById(int punId);
    int upPun(PunishVO punishVO);
    int inPun(PunishVO punishVO);

    int countByDepartmentId(int departmentId);
    int countByClassId(int classId);
}
