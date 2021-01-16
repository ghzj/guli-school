package io.github.ghzj.generator.config;

import io.github.ghzj.generator.entity.properties.GeneratorProperties;
import io.github.ghzj.generator.template.CustomTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ghzj
 * @date 2021/1/14 21:25
 */
@Configuration
@EnableConfigurationProperties(GeneratorProperties.class)
public class GeneratorPropertiesConfiguration {

    @Autowired
    private GeneratorProperties generatorProperties;

    @Bean
    public CustomTemplateFactory customTemplateFactory(){
        return new CustomTemplateFactory(generatorProperties.getTemplateClassScanPackagePath(), generatorProperties.getTemplateDirPath());
    }

}
