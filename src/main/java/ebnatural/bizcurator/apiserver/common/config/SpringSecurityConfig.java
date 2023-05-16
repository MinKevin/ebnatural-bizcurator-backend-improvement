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
        //http.sessionManagement()
        //        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore(new JwtAuthenticationFilter(new ProviderManager(customAuthenticationProvider())),
//                        UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(new JwtAuthorizationFilter(memberRepository),
//                        BasicAuthenticationFilter.class);
// authorization
        http.authorizeRequests()
                // /와 /home은 모두에게 허용
                .antMatchers("/login", "/signup", "/api/users/login", "/api/users/signup").permitAll()
                // hello 페이지는 USER 롤을 가진 유저에게만 허용
                .antMatchers("/note/**").hasRole("USER")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/notice/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/notice/**").hasRole("ADMIN")
                .anyRequest().authenticated();
        // login
        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/api/users/login")
                .permitAll() // 모두 허용
                .successHandler(authSuccessHandler)
                .failureHandler(authFailureHandler);
        // logout
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/api/users/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me");

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
