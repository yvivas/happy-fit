/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * The type Order.
 */
public abstract class Order {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    protected Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     */
    public abstract Double pay(final String paymentType);
}
