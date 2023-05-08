package com.wonmaly.orderservice.order.projection;

import com.wonmaly.orderservice.order.Customer;
import com.wonmaly.orderservice.order.Order;
import com.wonmaly.orderservice.order.OrderStatus;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "fullOrder", types = Order.class)
public interface OrderProjection {
    Long getId();

    OrderStatus getStatus();

    Long getCustomerId();

    Customer getCustomer();

//    ProductItem getProductItem();

    Date getCreatedAt();
}
