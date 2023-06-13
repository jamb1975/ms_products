package org.product.r2dbc.postgresql.routes;

import org.product.usecase.ProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RoutesProduct {

    @Bean
    public RouterFunction<ServerResponse> routes(ProductUseCase productUseCase) {

        return route(POST("/products"), productUseCase::create)
                .andRoute(DELETE("/products/{productId}"), productUseCase::delete)
                .andRoute(GET("/products/{productId}"), productUseCase::findProductById)
                .andRoute(PUT("//products"), productUseCase::update)
                .andRoute(GET("/products"), productUseCase::findAllProducts);

    }
}
