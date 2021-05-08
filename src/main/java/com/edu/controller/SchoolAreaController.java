package com.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.edu.dao.entity.SchoolAreaEntity;
import com.edu.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName SchoolAreaController
 * @Descripion TODO
 * @Author ChaoS_Zhang t7_chaos@163.com
 * @Date 2021/5/2 下午12:24
 * @Version 1.0
 **/
@RestController
@RequestMapping("${server.baseurl}/area")
public class SchoolAreaController extends BaseController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping
    public String getArea(HttpServletRequest request, @RequestBody String data) {
        SchoolAreaEntity query = JSONObject.toJavaObject(JSONObject.parseObject(data), SchoolAreaEntity.class);
        if (ObjectUtils.isEmpty(query) || StringUtils.isEmpty(query.getSid())) {
            return "";
        }

        if (StringUtils.isEmpty(query.getAid())) {
            return createJsonResult(schoolService.getAreas(query));
        } else {
            return createJsonResult(schoolService.getArea(query));
        }
    }

    @PutMapping
    public String createArea(HttpServletRequest request, @RequestBody String data) {
        SchoolAreaEntity create = JSONObject.toJavaObject(JSONObject.parseObject(data), SchoolAreaEntity.class);
        return createJsonResult(schoolService.createArea(create));
    }

    @PostMapping
    public String updateArea(HttpServletRequest request, @RequestBody String data) {
        SchoolAreaEntity update = JSONObject.toJavaObject(JSONObject.parseObject(data), SchoolAreaEntity.class);
        return createJsonResult(schoolService.updateArea(update));
    }

}
