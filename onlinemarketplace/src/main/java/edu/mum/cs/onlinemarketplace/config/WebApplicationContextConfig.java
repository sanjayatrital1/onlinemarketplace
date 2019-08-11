package edu.mum.cs.onlinemarketplace.config;

import edu.mum.cs.onlinemarketplace.domain.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.springframework.web.servlet.view.xml.MarshallingView;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan("edu.mum.cs")
public class WebApplicationContextConfig implements WebMvcConfigurer {
    /**
     * Configure to display image
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("/resources/static/images/");
    }

    /**
     * For image upload
     *
     * @return
     */
    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(10240000);
        return resolver;
    }
}
