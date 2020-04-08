package com.yuntian.helloworld.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author guangleilei.
 * @date Created in 13:49 2019/8/13
 * @description
 * Spring Boot 可以让您的配置外部化，以便可以在不同环境中使用相同的应用程序代码。
 * 您可以使用 properties 文件、YAML 文件、环境变量或者命令行参数来外部化配置。
 * 可以使用 @Value 注解将属性值直接注入到 bean 中，可通过 Spring 的 Environment 访问，
 * 或者通过 @ConfigurationProperties 绑定到结构化对象。
 */
@Component
@Data
public class TestProerties {

    @Value("${test.count}")
    private Integer count;

}
