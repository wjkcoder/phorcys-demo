package cn.phorcys.demo.impl;

import cn.phorcys.demo.api.UserService;
import cn.phorcys.demo.db.entity.SapItemRecord;
import cn.phorcys.framework.commons.exception.ExceptionUtils;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ThreadPoolExecutor;

@Service
public class UserServiceImpl implements UserService {
    @Override
    @DS("interface")
//    @Transactional
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String getUserInfo(String name) {
        SapItemRecord sr = new SapItemRecord();
        sr.setBatchId(1L);
        sr.setItemCode("ITEM01");
        sr.setDescription("物料1号");
        if(sr.insert()){
            LambdaQueryWrapper<SapItemRecord> item01 = new QueryWrapper<SapItemRecord>().lambda().eq(SapItemRecord::getItemCode, name);
            SapItemRecord sapItemRecord = new SapItemRecord().selectOne(item01);
//            ExceptionUtils.seed("内层事务异常");
            return sapItemRecord.getDescription();
        }

        return "response : wonder";
    }
}
