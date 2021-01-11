package model;

public class Cart {
    private String cartEmpty;

    public Cart(String cartEmpty){
        this.cartEmpty=cartEmpty;
    }

    public String getCartEmpty(){ return cartEmpty; }

    public void setCartEmpty(String cartEmpty){
        this.cartEmpty=cartEmpty;
    }

}
