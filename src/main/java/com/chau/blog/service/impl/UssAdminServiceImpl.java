package com.chau.blog.service.impl;

import com.chau.blog.dao.UssAdminServiceDao;
import com.chau.blog.dto.UssAdminParam;
import com.chau.blog.model.UssAdmin;
import com.chau.blog.model.UssPermission;
import com.chau.blog.service.UssAdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UssAdminServiceImpl implements UssAdminService {
    private transient Logger logger = LoggerFactory.getLogger(UssAdminServiceImpl.class);

    @Override
    public UssAdmin getAdminByUsername(String username) {
        return null;
    }

    @Override
    public UssAdmin register(UssAdminParam umsAdminParam) {
        return null;
    }

    @Override
    public List<UssPermission> getPermissionList(Long adminId) {
        return null;
    }

}
