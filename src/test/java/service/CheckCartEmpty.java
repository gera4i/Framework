package service;

import model.Cart;
import model.Product;

public class CheckCartEmpty {
    public static final String CART_EMPTY="testdata.cart.empty";

    public static Cart withEmpty(){
        return new Cart(TestDataReader.getTestData(CART_EMPTY));
    }

}
