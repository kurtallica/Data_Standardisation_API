package kurt.project.standardise.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("kurt.project.standardise"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        Contact contact = new Contact(
                "Kurtis Fleming",
                "https://www.linkedin.com/in/kurtfleming",
                "kurtallica@hotmail.com"
                );
        return new ApiInfo(
                "Data Standardisation REST API",
                "Data Standardisation API proof-of-concept",
                "v1.0.0",
                "",
                contact,
                "",
                "",
                List.of()); //returns empty list - used for vendor extensions.
    }
}
