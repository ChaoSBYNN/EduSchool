package com.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.dao.entity.SchoolAreaEntity;
import com.edu.dao.entity.UserScheduleEntity;
import com.edu.service.UserScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName CheckInController
 * @Descripion TODO
 * @Author ChaoS_Zhang t7_chaos@163.com
 * @Date 2021/5/2 下午12:36
 * @Version 1.0
 **/
@RestController
@RequestMapping("${server.baseurl}/schedule")
public class UserScheduleController extends BaseController {

    @Autowired
    private UserScheduleService userScheduleService;

    @PostMapping("checkin")
    public String checkIn(HttpServletRequest request, @RequestBody String data) {
        UserScheduleEntity checkin = JSONObject.toJavaObject(JSONObject.parseObject(data), UserScheduleEntity.class);
        return createJsonResult(userScheduleService.checkIn(checkin));
    }

    @GetMapping
    public String getAll(HttpServletRequest request, @RequestBody String data) {
        UserScheduleEntity query = JSONObject.toJavaObject(JSONObject.parseObject(data), UserScheduleEntity.class);
        return createJsonResult(userScheduleService.getAll(query));
    }

    @PutMapping
    public String create(HttpServletRequest request, @RequestBody String data) {
        UserScheduleEntity create = JSONObject.toJavaObject(JSONObject.parseObject(data), UserScheduleEntity.class);
        return createJsonResult(userScheduleService.create(create));
    }

}
