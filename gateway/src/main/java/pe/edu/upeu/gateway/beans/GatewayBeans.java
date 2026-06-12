package pe.edu.upeu.gateway.beans;

import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pe.edu.upeu.gateway.filters.AuthFilter;

@Configuration
public class GatewayBeans {
    private final AuthFilter authFilter;

    public GatewayBeans(AuthFilter authFilter) {
        this.authFilter = authFilter;
    }

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

    //config routes jwt + oauth2
    @Bean
    @Profile("oauth2")
    public RouteLocator routeLocatorOauth2(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        route -> route
                                .path("/university-crud/**")
                                .filters(filter ->{
                                    filter.filter(this.authFilter);
                                    return filter;
                                        } )
                                .uri("lb://university-crud")
                )
                .route(
                        route -> route
                                .path("/job-ms/**")
                                .filters(filter ->{
                                    filter.filter(this.authFilter);
                                    return filter;
                                } )
                                .uri("lb://job-ms")
                )
                .route(route -> route
                        .path("/auth-server/auth/**")
                        .uri("lb://auth-server")
                )
                .build();
    }

}
