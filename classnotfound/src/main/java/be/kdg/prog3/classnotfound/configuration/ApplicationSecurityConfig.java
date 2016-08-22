package be.kdg.prog3.classnotfound.configuration;

import be.kdg.prog3.classnotfound.model.UserRepository;
import be.kdg.prog3.classnotfound.security.LoginSuccessHandler;
import be.kdg.prog3.classnotfound.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private UserRepository userRepository;

    @Autowired
    public ApplicationSecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserService(userRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .successHandler(successHandler())
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/q")
                .authenticated()
                .anyRequest().permitAll();
    }

    @Bean
    public AuthenticationSuccessHandler successHandler() {
        return new LoginSuccessHandler("/");
    }
}
