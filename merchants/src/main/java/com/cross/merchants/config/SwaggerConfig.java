package com.cross.merchants.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Tag;
import java.util.ArrayList;
import java.util.List;

/*************************************************************
 * Description:
 * Author: Dairy
 * CreateTime: 2020/1/17
 ************************************************************/

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfig {

    @Bean
    public Docket createPcRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
//            .groupName("kjds")
//            .tags(new Tag("product", "接口"),getTags())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.cross.merchants.web.rest"))
            .paths(PathSelectors.any())
            .build().globalOperationParameters(parameter());
    }
    private Tag[] getTags() {
        Tag[] tags = {
            new Tag("user", "kjds接口"),
            new Tag("api_product", "kjds接口")
        };
        return tags;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("swagger RESTful APIs")
            .description("swagger RESTful APIs")
            .termsOfServiceUrl("http://localhost:8080/")
            .version("1.0")
            .build();
    }

    /**
     * 全局参数
     *
     * @return List<Parameter>
     */
    private List<Parameter> parameter() {
        List<Parameter> params = new ArrayList<>();
        params.add(new ParameterBuilder().name("Authorization")
            .description("认证令牌")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false).build());
        return params;
    }

}
