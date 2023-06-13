package org.product.repositorios.config;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.repositorios.ProductAdapterRepositoryImpl;
import org.product.repositorios.ProductRepository;
import org.springframework.context.annotation.Bean;

public class RepositoryConfig {

    @Bean
    public ProductAdapterRepository productAdapterRepository(ProductRepository productRepository){
        return new ProductAdapterRepositoryImpl(productRepository);
    }
}
