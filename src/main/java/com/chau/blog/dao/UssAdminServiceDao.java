package com.chau.blog.dao;

import com.chau.blog.model.UssPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UssAdminServiceDao {

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<UssPermission> getPermissionList(@Param("adminId") Long adminId);
}
