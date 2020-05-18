package cn.phorcys.demo.api;

import cn.phorcys.rpc.framework.annotation.DubboExpose;

@DubboExpose
public interface UserService {
    String getUserInfo(String name);
}
