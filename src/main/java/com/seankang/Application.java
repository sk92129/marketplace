package com.seankang;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.beans.factory.annotation.Autowired;


@ServletComponentScan
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.seankang")
@EnableJpaRepositories("com.seankang.persistence.repo")
@EntityScan("com.seankang.persistence.model")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class Application implements  CommandLineRunner{

    @Autowired
    private SampleService service;

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        return new InMemoryUserDetailsManager(User.withDefaultPasswordEncoder()
                .username("user").password("password").roles("USER").build());
    }


    @Override
    public void run(String... args) throws Exception {
        SecurityContextHolder.getContext()
                .setAuthentication(new UsernamePasswordAuthenticationToken("user", "N/A",
                        AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER")));
        try {
            System.out.println(this.service.secure());
        }
        finally {
            SecurityContextHolder.clearContext();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,  "--debug");
    }

}