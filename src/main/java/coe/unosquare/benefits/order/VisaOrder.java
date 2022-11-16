package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

public class VisaOrder extends Order {
    public VisaOrder(Map<Product, Integer> productsMap) {
        super(productsMap);
    }

    @Override
    public Double pay(String paymentType) {
        double discount = 0.0;
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
        }
        return calculateTotal(discount);
    }
}
