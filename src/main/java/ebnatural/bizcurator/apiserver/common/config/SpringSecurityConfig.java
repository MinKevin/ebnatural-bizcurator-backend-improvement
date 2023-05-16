package ebnatural.bizcurator.apiserver.common.config;

import ebnatural.bizcurator.apiserver.common.exception.AuthFailureHandler;
import ebnatural.bizcurator.apiserver.common.exception.AuthSuccessHandler;
import ebnatural.bizcurator.apiserver.common.jwt.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@RequiredArgsConstructor
public class SpringSecurityConfig {
    private final AuthSuccessHandler authSuccessHandler;
    private final AuthFailureHandler authFailureHandler;
    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.csrf().disable();
        http.rememberMe().disable();
        http.cors();

        http.authorizeRequests()
                .antMatchers("/login", "/signup", "/api/users/login", "/api/users/signup").permitAll()
                .antMatchers("/api/admins/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/api/notices/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/notices/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/notices/**").hasRole("ADMIN")
                .anyRequest().authenticated();

        return http.build();
    }
    @Bean
    public CustomAuthenticationProvider customAuthenticationProvider() {
        return new CustomAuthenticationProvider(passwordEncoder());
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
