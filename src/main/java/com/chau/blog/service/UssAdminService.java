package com.chau.blog.service;

import com.chau.blog.dto.UssAdminParam;
import com.chau.blog.model.UssAdmin;
import com.chau.blog.model.UssPermission;

import java.util.List;

public interface UssAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UssAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     */
    UssAdmin register(UssAdminParam umsAdminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username,String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<UssPermission> getPermissionList(Long adminId);

}
