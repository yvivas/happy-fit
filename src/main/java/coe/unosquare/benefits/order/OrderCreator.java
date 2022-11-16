package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class OrderCreator {
    private OrderCreator(){}

    public static Order constructOrder(String type, Map<Product, Integer> products) {
        switch(type) {
            case "Visa": return new VisaOrder(products);
            case "Mastercard": return new MastercardOrder(products);
            default: return new StandardOrder(products);
        }
    }
}
