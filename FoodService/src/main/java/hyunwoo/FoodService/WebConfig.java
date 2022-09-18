package hyunwoo.FoodService;

import hyunwoo.FoodService.login.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/","/members/add", "/login","/css/**", "/*.ico", "/error" );
    }


    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToMenuConverter());
        registry.addConverter(new MenuToStringConverter());

    }
}
