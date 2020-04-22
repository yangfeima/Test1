package com.nacos.producer.config;

import org.springframework.context.annotation.Bean;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Configuration;

/**
 * 分页配置
 *
 * @author HX0011159
 * @date 2020/4/21
 * @since <版本号>
 */
@Configuration
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
