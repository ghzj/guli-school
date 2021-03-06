package io.github.ghzj.guli.common.web;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import io.github.ghzj.guli.common.web.handler.GlobalExceptionHandler;
import io.github.ghzj.guli.common.web.handler.GlobalResponseBodyHandler;
import io.github.ghzj.guli.common.web.servlet.CorsFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;

@Configuration
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class CommonWebAutoConfiguration implements WebMvcConfigurer {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // ========== 全局处理器 ==========

    @Bean
    @ConditionalOnMissingBean(GlobalResponseBodyHandler.class)
    public GlobalResponseBodyHandler globalResponseBodyHandler() {
        return new GlobalResponseBodyHandler();
    }

    // TODO: 2021/1/11 ghzj 异常入库暂时关了，等做到rpc在开启
    @Bean
    @ConditionalOnMissingBean(GlobalExceptionHandler.class)
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    // ========== 拦截器相关 ==========

    // TODO: 2021/1/11 ghzj 日志暂时关了，等做到rpc在开启
//    @Bean
//    @ConditionalOnClass(name = {"cn.iocoder.mall.systemservice.rpc.systemlog.SystemExceptionLogRpc", "org.apache.dubbo.config.annotation.Reference"})
//    @ConditionalOnMissingBean(AccessLogInterceptor.class)
//    public AccessLogInterceptor accessLogInterceptor() {
//        return new AccessLogInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        try {
//            registry.addInterceptor(this.accessLogInterceptor());
//            logger.info("[addInterceptors][加载 AccessLogInterceptor 拦截器完成]");
//        } catch (NoSuchBeanDefinitionException e) {
//            logger.warn("[addInterceptors][无法获取 AccessLogInterceptor 拦截器，因此不启动 AccessLog 的记录]");
//        }
//    }

    // ========== 过滤器相关 ==========

//    @Bean
//    @ConditionalOnMissingBean
//    public FilterRegistrationBean<CorsFilter> corsFilter() {
//        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new CorsFilter());
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

    // ========== MessageConverter 相关 ==========

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 创建 FastJsonHttpMessageConverter 对象
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 自定义 FastJson 配置
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 设置字符集
        fastJsonConfig.setCharset(Charset.defaultCharset());
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, // 剔除循环引用
                SerializerFeature.WriteNonStringKeyAsString); // 解决 Integer 作为 Key 时，转换为 String 类型，避免浏览器报错
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        // 设置支持的 MediaType
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        // 添加到 converters 中
        // 注意，添加到最开头，放在 MappingJackson2XmlHttpMessageConverter 前面
        converters.add(0, fastJsonHttpMessageConverter);
    }

}
