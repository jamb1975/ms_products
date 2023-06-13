package org.product.r2dbc.postgresql.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Product {

    @Column(value = "TIPO_PRODUCTO")
    private String tipoProducto;
    @Column(value = "PRODUCT_ID")
    private String ProductId;
    @Column(value = "FECHA_COMPRA")
    private LocalDateTime fechaCompra;
    @Column(value = "BODEGA")
    private int bodeg;
    @Column(value = "PRECIO_VENTA")
    private BigDecimal precioVenta;
}
