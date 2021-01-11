package model;

import java.util.Objects;

public class Product {
    private String productUrl;
    private String productSecondUrl;
    private String article;
    private String secondArticle;
    private String failedArticle;
    private String size;
    private String secondSize;
    private String price;
    private String secondPrice;
    private String sumPrice;
    private String coupon;
    private String failedCoupon;

    public  Product(String article,String size,String price,String productUrl,String coupon){
        this.article=article;
        this.size=size;
        this.price=price;
        this.productUrl = productUrl;
        this.coupon=coupon;
    }

    public  Product(String article,String size,String price,String productUrl,String secondArticle,String secondSize,String secondPrice,String productSecondUrl,String sumPrice){
        this.article=article;
        this.size=size;
        this.price=price;
        this.productUrl = productUrl;
        this.secondArticle=secondArticle;
        this.secondSize=secondSize;
        this.secondPrice=secondPrice;
        this.productSecondUrl = productSecondUrl;
        this.sumPrice=sumPrice;

    }

    public  Product(String failedArticle,String failedCoupon){
        this.failedArticle=failedArticle;
        this.failedCoupon=failedCoupon;
    }

    public String getArticle(){ return article; }

    public void setArticle(String article){
        this.article=article;
    }

    public String getSecondArticle(){ return secondArticle; }

    public void setSecondArticle(String secondArticle){
        this.secondArticle=secondArticle;
    }

    public String getFailedArticle(){ return failedArticle; }

    public void setFailedArticle(String failedArticle){
        this.failedArticle=failedArticle;
    }

    public String getSize(){
        return size;
    }

    public void setSize(String size){
        this.size=size;
    }

    public String getSecondSize(){
        return secondSize;
    }

    public void setSecondSize(String secondSize){
        this.secondSize=secondSize;
    }

    public String getProductUrl(){
        return productUrl;
    }

    public void setProductUrl(String productUrl){
        this.productUrl=productUrl;
    }

    public String getProductSecondUrl(){
        return productSecondUrl;
    }

    public void setProductSecondUrl(String productSecondUrl){
        this.productSecondUrl=productSecondUrl;
    }

    public String getPrice(){
        return price;
    }

    public void setSecondPrice(String secondPrice){
        this.secondPrice=secondPrice;
    }

    public String getSecondPrice(){
        return secondPrice;
    }

    public void setSumPrice(String sumPrice){
        this.sumPrice=sumPrice;
    }

    public String getSumPrice(){
        return sumPrice;
    }

    public void setPrice(String price){
        this.price=price;
    }

    public String getCoupon(){
        return coupon;
    }

    public void setCoupon(String coupon){
        this.coupon=coupon;
    }

    public String getFailedCoupon(){
        return failedCoupon;
    }

    public void setFailedCoupon(String failedCoupon){
        this.failedCoupon=failedCoupon;
    }



    @Override
    public String toString() {
        return "Product{" +
                "article='" + article + '\'' +
                ", size='" + size + '\'' +
                ", price='" + price + '\'' +
                ", failedArticle='" + failedArticle + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(getArticle(),product.getArticle()) &&
                Objects.equals(getSize(), product.getSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getArticle(), getSize());
    }
}
