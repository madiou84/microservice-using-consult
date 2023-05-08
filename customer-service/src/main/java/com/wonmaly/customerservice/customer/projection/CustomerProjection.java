package com.wonmaly.customerservice.customer.projection;

import com.wonmaly.customerservice.customer.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer", types = Customer.class)
public interface CustomerProjection {
    Long getId();

    String getName();

    String getEmail();
}
