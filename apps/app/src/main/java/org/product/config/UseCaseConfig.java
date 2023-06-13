package org.product.config;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.r2dbc.postgresql.gateways.ProductUseCaseRepository;
import org.product.usecase.ProductUseCase;
import org.springframework.context.annotation.Bean;

public class UseCaseConfig {

    @Bean
    public ProductUseCaseRepository productUseCaseRepository(ProductAdapterRepository productAdapterRepository){
        return new ProductUseCase(productAdapterRepository);
    }

}
