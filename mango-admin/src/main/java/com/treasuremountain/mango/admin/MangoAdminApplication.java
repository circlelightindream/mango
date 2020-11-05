package com.treasuremountain.mango.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动
 *
 * @author  mengyuanming
 * @date  2020/10/28 6:34
 * @version 1.0
 */
@SpringBootApplication(scanBasePackages = {"com.treasuremountain.mango"})
@MapperScan("com.treasuremoutain.mango.dao")
public class MangoAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MangoAdminApplication.class, args);
	}

}
