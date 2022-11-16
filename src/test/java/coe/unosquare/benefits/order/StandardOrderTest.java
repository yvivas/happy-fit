package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StandardOrderTest {
    @Test
    void orderWithAmexCard100Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.00);
        assertEquals(0.0, payOrder(products, "Amex"));
    }
}
