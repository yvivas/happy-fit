package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class StandardOrder extends Order {

    public StandardOrder(final Map<Product, Integer> productsMap){
        super(productsMap);
    }

    @Override
    public Double pay(String paymentType) {
        return calculateSubtotal(0.0);
    }
}
