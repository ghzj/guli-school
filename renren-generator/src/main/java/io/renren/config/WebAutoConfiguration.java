package io.renren.config;

import io.renren.Interceptor.ErrorCodeInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ghzj
 * @date 2021/1/13 21:25
 */
@Configuration
@AutoConfigureAfter(DbConfig.class)
public class WebAutoConfiguration implements WebMvcConfigurer {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    public ErrorCodeInterceptor errorCodeInterceptor() {
        return new ErrorCodeInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            registry.addInterceptor(this.errorCodeInterceptor());
            logger.info("[addInterceptors][加载 AccessLogInterceptor 拦截器完成]");
        } catch (NoSuchBeanDefinitionException e) {
            logger.warn("[addInterceptors][无法获取 AccessLogInterceptor 拦截器，因此不启动 AccessLog 的记录]");
        }
    }


}
