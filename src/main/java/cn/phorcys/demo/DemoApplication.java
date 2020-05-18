package cn.phorcys.demo;

import cn.phorcys.rpc.framework.annotation.DubboConfig;
import cn.phorcys.rpc.framework.annotation.DubboExposeScan;
import cn.phorcys.rpc.register.config.PhorcysZookeeperConfiguration;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "cn.phorcys",exclude = DruidDataSourceAutoConfigure.class)
@DubboExposeScan(basePackage = "cn.phorcys.demo.api")
@Configuration
@MapperScan(basePackages="cn.phorcys.demo.db.dao")
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
    }

}
