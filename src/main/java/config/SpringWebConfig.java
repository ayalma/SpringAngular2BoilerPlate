package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by alimohammadi on 7/10/16.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "web")
public class SpringWebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/app/**")
                .addResourceLocations("/src/app/");
        registry
                .addResourceHandler("/dist/**")
                .addResourceLocations("/dist/");

        registry
                .addResourceHandler("/**")
                .addResourceLocations("/src/");

        registry.addResourceHandler("/node_modules/**")
                .addResourceLocations("/node_modules/");
        super.addResourceHandlers(registry);
    }


}
