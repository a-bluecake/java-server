package cc.abluecake.adminserver.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("cc.abluecake.adminserver.mapper")
public class MyBatisPlusConfig {

}
