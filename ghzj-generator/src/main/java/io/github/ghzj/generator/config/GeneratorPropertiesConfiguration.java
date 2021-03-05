package io.github.ghzj.generator.config;

import io.github.ghzj.generator.entity.properties.GeneratorProperties;
import io.github.ghzj.generator.template.CustomTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Configuration
@EnableConfigurationProperties(GeneratorProperties.class)
public class GeneratorPropertiesConfiguration implements WebMvcConfigurer {

    @Autowired
    private GeneratorProperties generatorProperties;

    @Bean
    public CustomTemplateFactory customTemplateFactory(){
        return new CustomTemplateFactory(generatorProperties.getTemplateClassScanPackagePath(), generatorProperties.getTemplateDirPath());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .maxAge(3600);
    }

}
