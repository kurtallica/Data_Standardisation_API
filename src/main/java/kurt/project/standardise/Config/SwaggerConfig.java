package kurt.project.standardise.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().info(getApiInfo());
    }

    private Info getApiInfo() {
        Contact contact = new Contact()
                .name("Kurtis Fleming")
                .url("https://www.linkedin.com/in/kurtfleming")
                .email("kurtallica@hotmail.com");

        return new Info()
                .title("Data Standardisation REST API")
                .description("Data Standardisation API proof-of-concept")
                .version("v1.0.0")
                .contact(contact);
    }
}
