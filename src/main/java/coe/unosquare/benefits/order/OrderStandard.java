package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class OrderStandard extends Order {

    public OrderStandard(final Map<Product, Integer> productsMap){
        super(productsMap);
    }

    @Override
    public Double pay(String paymentType) {
        double discount;
        if (paymentType.equals("Visa")) {
            if (getProducts().values()
                    .stream()
                    .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= 10) {
                discount = 0.15;
            } else if (getProducts().values()
                    .stream()
                    .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= 7) {
                discount = 0.10;
            } else {
                discount = 0.05;
            }
        } else if (paymentType.equals("Mastercard")) {
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
        } else {
            discount = 0.0;
        }
        double subtotal = getProducts().entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        return subtotal - subtotal * discount;
    }
}
