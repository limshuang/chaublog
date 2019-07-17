package com.chau.blog.dao;

import com.chau.blog.model.UssAdmin;
import com.chau.blog.model.UssPermission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UssAdminServiceDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UssPermission> getPermissionList(@Param("adminId") Long adminId);

    /**
     *根据用户名查询
     */
    @Select("SELECT * FROM uss_admin WHERE username = #{username}")
    List<UssAdmin> searchUserBuName(@Param("username") String username);
    /**
     * 新增用户
     */
    @Insert("INSERT INTO " +
            "uss_admin " +
            "(id, username, password, icon, email, nick_name, note, create_time, login_time, status) " +
            "VALUES " +
            "( #{user.id}, #{user.username}, #{user.password}, #{user.icon}, #{user.email}, #{user.nickName}, #{user.note}, #{user.createTime}, #{user.loginTime}, #{user.status})")
    int insertUser(@Param("user")UssAdmin ussAdmin);
}
