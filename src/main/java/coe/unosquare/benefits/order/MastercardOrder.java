package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class MastercardOrder extends Order {

    public MastercardOrder(Map<Product, Integer> productsMap) {
        super(productsMap);
    }

    @Override
    public Double pay(String paymentType) {
        double discount = 0.0;
        if (paymentType.equals("Mastercard")) {
            if (getProducts().entrySet()
                    .stream()
                    .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                    .sum() >= 100) {
                discount = 0.17;
            } else if (getProducts().entrySet().stream()
                    .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                    .sum() >= 75) {
                discount = 0.12;
            } else {
                discount = 0.08;
            }
        }
        return calculateSubtotal(discount);
    }

}
