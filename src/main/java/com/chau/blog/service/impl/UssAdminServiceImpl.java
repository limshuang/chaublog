package com.chau.blog.service.impl;

import com.chau.blog.dao.UssAdminServiceDao;
import com.chau.blog.dto.UssAdminParam;
import com.chau.blog.model.UssAdmin;
import com.chau.blog.model.UssPermission;
import com.chau.blog.service.UssAdminService;
import com.chau.blog.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

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
        String token = null;
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(!passwordEncoder.matches(password,userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public List<UssPermission> getPermissionList(Long adminId) {
        return null;
    }

}
