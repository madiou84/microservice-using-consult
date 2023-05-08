package com.wonmaly.inventoryservice.product.projection;

import com.wonmaly.inventoryservice.product.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullProduct", types = Product.class)
public interface ProductProjection {
    Long getId();

    String getName();

    double getPrice();

    int getQuantity();
}
