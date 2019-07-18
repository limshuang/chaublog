package com.chau.blog.controller;


import com.chau.blog.common.CommonResult;
import com.chau.blog.dto.UssAdminLoginParam;
import com.chau.blog.dto.UssAdminParam;
import com.chau.blog.model.UssAdmin;
import com.chau.blog.service.UssAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Api(tags = "UssAdminController", description = "用户权限管理")
@Controller
@RequestMapping("/admin")
public class UssAdminController {
    @Autowired
    private UssAdminService ussAdminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UssAdmin> register(@RequestBody UssAdminParam ussAdminParam, BindingResult result) {
        UssAdmin ussAdmin = ussAdminService.register(ussAdminParam);
        if (ussAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(ussAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UssAdminLoginParam ussAdminLoginParam, BindingResult result) {
        String token = ussAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

}
