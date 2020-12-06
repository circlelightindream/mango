package com.treasuremountain.mango.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动
 *
 * @author mengyuanming
 * @version 1.0
 * @date 2020/10/28 6:34
 */
@SpringBootApplication(scanBasePackages = {"com.treasuremountain.mango.admin"})
@MapperScan("com.treasuremoutain.mango.admin.dao")
public class MangoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangoAdminApplication.class, args);
    }

}
