package com.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.dao.entity.SchoolClassEntity;
import com.edu.dao.entity.SchoolEntity;
import com.edu.service.SchoolService;
import com.edu.service.UserClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName UserController
 * @Descripion 课表 班级
 * @Author ChaoS_Zhang t7_chaos@163.com
 * @Date 2021/4/18 下午5:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("${server.baseurl}/login")
public class LoginController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/signin")
    public String getClass(HttpServletRequest request, @RequestBody String data) {

        JSONObject requestDataJson = JSONObject.parseObject(data);

        String uid = StringUtils.isEmpty(requestDataJson.getString("uid")) ? "" : requestDataJson.getString("uid");
        String sid = StringUtils.isEmpty(requestDataJson.getString("sid")) ? "" : requestDataJson.getString("sid");
        String aid = StringUtils.isEmpty(requestDataJson.getString("aid")) ? "" : requestDataJson.getString("aid");
        int phone = ObjectUtils.isEmpty(requestDataJson.getInteger("phone")) ? 0 : requestDataJson.getInteger("phone");

        if (0 == phone) {
            return "";
        }

        SchoolEntity schoolEntity = new SchoolEntity();
        schoolEntity.setPhone(phone);

        return createJsonResult(schoolService.getSchool(schoolEntity));
    }


}
