package com.sm.dao;
import com.sm.entity.PunishVO;
import com.sm.entity.RewardVO;
import com.sm.entity.Student;
import com.sm.entity.StudentVO;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    /**
     * 查询所有学生（视图对象）
     * @return  List<StudentVO>
     * @throws SQLException
     */
    List<StudentVO> selectAll() throws SQLException;

    List<StudentVO> selectByDepartmentId(int departmentId) throws SQLException;

    List<StudentVO> selectByClassId(int classId) throws SQLException;

    List<StudentVO> selectByKeywords(String keywords) throws SQLException;

    /**
     * 查询奖励学生
     * @return List<RewardVO>
     * @throws SQLException
     */
    List<RewardVO> selectAllReward() throws SQLException;

    List<RewardVO> selectByStuId(String id) throws SQLException;

    List<RewardVO> selectRewByKeywords(String keywords) throws SQLException;

    /**
     * 查看惩罚学生
     * @return List<PunishVO>
     * @throws SQLException
     */
    List<PunishVO> selectAllPunish() throws SQLException;

    List<PunishVO> selectPunByKeywords(String keywords) throws SQLException;

    /**
     *学生
     */
    int updateStudent (Student student) throws SQLException;

    int deleteStuById(String id) throws SQLException;

    int insertStudent(Student student) throws SQLException;

    /**
     *奖励
     */
    int deleteRewById(int rewId) throws SQLException;

    int updateRew(RewardVO rewardVO) throws SQLException;

    int insertRew(RewardVO rewardVO) throws SQLException;

    /**
     * 惩罚
     */
    int deletePunById(int punId) throws SQLException;

    int updatePun(PunishVO punishVO) throws SQLException;

    int insertPun(PunishVO punishVO) throws SQLException;

    /**
     * 统计
     */
    int countByDepartmentId(int departmentId)throws SQLException;

    /**
     * 根据班级id统计人数
     * @param classId
     * @return
     * @throws SQLException
     */
    int countByClassId(int classId) throws SQLException;
}
