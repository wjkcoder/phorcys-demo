package cn.phorcys.demo.controller;

import cn.phorcys.demo.api.UserService;
import cn.phorcys.demo.db.entity.SysUser;
import cn.phorcys.demo.dto.RegisterUserRequestType;
import cn.phorcys.framework.commons.logger.Logger;
import cn.phorcys.framework.commons.logger.LoggerFactory;
import cn.phorcys.framework.commons.model.GeneralRequest;
import cn.phorcys.framework.commons.model.GeneralResponse;
import cn.phorcys.framework.redis.config.RedisClient;
import com.baomidou.dynamic.datasource.toolkit.CryptoUtils;
import com.baomidou.mybatisplus.core.toolkit.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController{

    Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    UserService userService;
    @Autowired
    RedisClient redisClient;

    @GetMapping("/demo")
    @Transactional
    public GeneralResponse demo(@RequestBody(required = false) GeneralRequest request){
        List<SysUser> sysUsers = new SysUser().selectAll();
        String item01 = userService.getUserInfo("ITEM01");
        return GeneralResponse.success();
    }

    @PostMapping("/registerUser")
    @Transactional
    public GeneralResponse registerUser(@RequestBody(required = false) RegisterUserRequestType request){
        SysUser sysUser = new SysUser();
        sysUser.setDescription(request.getDescription());
        sysUser.setUserName(request.getUserName());
        try {
            sysUser.setPassword(CryptoUtils.encrypt(request.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sysUser.insert();
        return GeneralResponse.success();
    }

    public static void main(String[] args) {
        try {
            System.out.println(CryptoUtils.encrypt("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
