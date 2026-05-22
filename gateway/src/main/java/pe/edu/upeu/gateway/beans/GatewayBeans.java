package pe.edu.upeu.gateway.beans;

import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class GatewayBeans {

    @Bean
    @Profile("eureka-off")
    public RouteLocator routeLocatorEurekaOff(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        route -> route
                                .path("/university-crud/**")
                                .uri("http://localhost:8081")
                )
                .route(
                        route -> route
                                .path("/job-ms/**")
                                .uri("http://localhost:8082")
                )
                .build();
    }

    @Bean
    @Profile("eureka-on")
    public RouteLocator routeLocatorEurekaOn(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        route -> route
                                .path("/university-crud/**")
                                .uri("lb://university-crud")
                )
                .route(
                        route -> route
                                .path("/job-ms/**")
                                .uri("lb://job-ms")
                )
                .build();
    }
}
