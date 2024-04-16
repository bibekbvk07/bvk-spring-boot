package com.bibek.customer_crud_demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

/*
    // add support for JDBC from default table 'users' and 'authorities' provided by spring boot
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        // Tells Spring Security to use JDBC authentication with our data source
        return new JdbcUserDetailsManager(dataSource);
    }
 */

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id= ?");

        // define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/bvk/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/bvk/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/bvk/customers").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/bvk/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/bvk/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/bvk/employees/**").hasRole("ADMIN"));
        // use basic http authentication
        http.httpBasic(Customizer.withDefaults());

        //disable cross site request forgery (CSRF)
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }

    /* If we had to hard code the user roles
    @Bean
    public InMemoryUserDetailsManager userDetailsManager (){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}bibek123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}bibek123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}bibek123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary,susan);
    }
     */
}
