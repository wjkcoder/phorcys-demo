package cn.phorcys.demo.dto;

import cn.phorcys.framework.commons.model.BaseRequest;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/15 2:25 下午
 */
@Getter
@Setter
public class RegisterUserRequestType extends BaseRequest {
    private String userType;

    private String userName;

    private String description;

    private String password;

    private String nickName;

    private String firstName;
}
