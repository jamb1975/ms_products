package org.product.usecase;

import org.product.r2dbc.postgresql.gateways.ProductAdapterRepository;
import org.product.r2dbc.postgresql.gateways.ProductUseCaseRepository;
import org.product.r2dbc.postgresql.model.Product;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class ProductUseCase implements ProductUseCaseRepository {

    private final ProductAdapterRepository productAdapterRepository;

    public ProductUseCase(ProductAdapterRepository productAdapterRepository){
        this.productAdapterRepository = productAdapterRepository;
    }


    @Override
    public Mono<ServerResponse> create(ServerRequest request) {
      return  request.bodyToMono(Product.class)
                .flatMap(prod ->productAdapterRepository.create(prod))
              .flatMap(prodCreate -> ServerResponse.ok().bodyValue(prodCreate))
              .onErrorResume(e -> ServerResponse.badRequest().build());

    }

    @Override
    public Mono<ServerResponse> update(ServerRequest request) {
        return  request.bodyToMono(Product.class)
                .flatMap(prod ->productAdapterRepository.update(prod))
                .flatMap(prodUpdate -> ServerResponse.ok().bodyValue(prodUpdate))
                .onErrorResume(e -> ServerResponse.badRequest().build());

    }

    @Override
    public Mono<ServerResponse> delete(ServerRequest request) {
     return
             productAdapterRepository.delete(request.pathVariable("productId"))
                .then()
                .then(ServerResponse.noContent().build())
                .onErrorResume(e -> ServerResponse.badRequest().build());
    }

    @Override
    public Mono<ServerResponse> findProductById(ServerRequest request) {
      return  productAdapterRepository.findProductById(request.pathVariable("productId"))
                .flatMap(product ->ServerResponse.ok().bodyValue(product))
                .onErrorResume(e -> ServerResponse.badRequest().build());

    }

    @Override
    public Mono<ServerResponse> findAllProducts(ServerRequest request) {
        return  productAdapterRepository.findAllProducts()
                .collectList()
                .flatMap(allProducts ->ServerResponse.ok().bodyValue(allProducts))
                .onErrorResume(e -> ServerResponse.badRequest().build());

    }
}
