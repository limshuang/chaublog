package com.chau.blog.service.impl;

import com.chau.blog.dao.UssAdminServiceDao;
import com.chau.blog.dto.UssAdminParam;
import com.chau.blog.model.UssAdmin;
import com.chau.blog.model.UssPermission;
import com.chau.blog.service.UssAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("UssAdminService")
public class UssAdminServiceImpl implements UssAdminService {
    private transient Logger LOGGER = LoggerFactory.getLogger(UssAdminServiceImpl.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UssAdminServiceDao ussAdminServiceDao;

    @Override
    public UssAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public UssAdmin register(UssAdminParam umsAdminParam) {
        UssAdmin ussAdmin = new UssAdmin();
        BeanUtils.copyProperties(umsAdminParam, ussAdmin);
        ussAdmin.setCreateTime(new Date());
        ussAdmin.setStatus(1);
        //查询是否有相同用户名的用户
        List<UssAdmin> ussAdminList = ussAdminServiceDao.searchUserBuName(ussAdmin.getUsername());
        if (ussAdminList.size() > 0) {
            LOGGER.info("存在相同用户名");
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(ussAdmin.getPassword());
        ussAdmin.setPassword(encodePassword);
        ussAdminServiceDao.insertUser(ussAdmin);
        return ussAdmin;
    }

    @Override
    public String login(String username, String password) {
        return null;
    }

    @Override
    public List<UssPermission> getPermissionList(Long adminId) {
        return null;
    }

}
