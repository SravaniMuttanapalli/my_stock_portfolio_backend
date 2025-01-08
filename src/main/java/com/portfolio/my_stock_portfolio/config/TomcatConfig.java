package com.portfolio.my_stock_portfolio.config; // Use your actual package name

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatConfig {

    @Bean
    public ServletWebServerFactory servletContainer() {
        // Create the Tomcat factory instance
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        // Customize Tomcat settings as needed
        factory.addConnectorCustomizers(connector -> {
            // Set the connection timeout to 30 seconds (30000 milliseconds)
            connector.setProperty("connectionTimeout", "30000");

            // Example: Set the max threads to handle more connections
            connector.setProperty("maxThreads", "200");

            // Optionally, you can also set the port if you want to change it
            factory.setPort(8081);
        });

        // Return the customized Tomcat factory
        return factory;
    }
}
