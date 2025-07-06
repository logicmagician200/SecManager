package xyz.supersec.secmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.supersec.secmanager.db.mapper")
public class SecManagerApplication {


	public static void main(String[] args) {
		SpringApplication.run(SecManagerApplication.class, args);
	}


}
