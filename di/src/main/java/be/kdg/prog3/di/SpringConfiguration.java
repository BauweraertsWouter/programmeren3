package be.kdg.prog3.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class SpringConfiguration {
    @Bean("specialService")
    public Service getSpecialService() {
        return new Service("SpecialService");
    }
}
