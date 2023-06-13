package org.product.repositorios;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.r2dbc.postgresql.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProductAdapterRepositoryImpl implements ProductAdapterRepository
{
    private final ProductRepository productRepository;

    public ProductAdapterRepositoryImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Mono<Product> create(Product product){
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        return null;
    }

    public Mono<Void> delete(String productId){
         return productRepository.deleteById(productId);
    }

    @Override
    public Mono<Product> findProductById(String productId) {
        return productRepository.findProductById(productId);
    }

    public Flux<Product> findAllProducts(){
            return productRepository.findAll();
    }
}
