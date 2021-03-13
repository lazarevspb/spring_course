package ru.lazarev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;

/**
 * Homework for Spring course, lesson #4
 *
 * @author Valeriy Lazarev
 * @since 13.03.2021
 */
@SpringBootApplication
public class Lesson4Application {

    public static void main(String[] args) {
        SpringApplication.run(Lesson4Application.class, args);
    }

    /*
    https://howtodoinjava.com/spring-boot/configure-jetty-server/
     */
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory()
    {
        JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
        factory.setPort(8180);
        factory.setContextPath("/market");
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        return factory;
    }
}
