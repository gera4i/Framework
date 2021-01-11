package service;

import model.Product;
import org.testng.annotations.Test;

public class ProductCreator {
    public static final String PRODUCT_ARTICLE="testdata.product.article";
    public static final String PRODUCT_SECOND_ARTICLE="testdata.product.second.article";
    public static final String PRODUCT_SIZE="testdata.product.size";
    public static final String PRODUCT_SECOND_SIZE="testdata.product.size";
    public static final String PRODUCT_PRICE="testdata.product.price";
    public static final String PRODUCT_SUM_PRICE="testdata.product.sum.price";
    public static final String PRODUCT_SECOND_PRICE="testdata.product.price";
    public static final String PRODUCT_FAILED_ARTICLE="testdata.product.failed.article";
    public static final String PRODUCT_URL="testdata.product.product.url";
    public static final String PRODUCT_SECOND_URL="testdata.product.product.second.url";
    public static final String PRODUCT_COUPON="testdata.product.product.coupon";
    public static final String PRODUCT_FAILD_COUPON="testdata.product.product.failed.coupon";

    public static Product withAllProperty(){
        return new Product(TestDataReader.getTestData(PRODUCT_ARTICLE),
                TestDataReader.getTestData(PRODUCT_SIZE),
                TestDataReader.getTestData(PRODUCT_PRICE),
                TestDataReader.getTestData(PRODUCT_URL),
                TestDataReader.getTestData(PRODUCT_COUPON));
    }

    public static Product withAddSomeProduct(){
        return new Product(TestDataReader.getTestData(PRODUCT_ARTICLE),
                TestDataReader.getTestData(PRODUCT_SIZE),
                TestDataReader.getTestData(PRODUCT_PRICE),
                TestDataReader.getTestData(PRODUCT_URL),
                TestDataReader.getTestData(PRODUCT_SECOND_ARTICLE),
                TestDataReader.getTestData(PRODUCT_SECOND_SIZE),
                TestDataReader.getTestData(PRODUCT_SECOND_PRICE),
                TestDataReader.getTestData(PRODUCT_SECOND_URL),
                TestDataReader.getTestData(PRODUCT_SUM_PRICE));
    }
    public static Product withFailedSearchAndFailedCoupon(){
        return new Product(TestDataReader.getTestData(PRODUCT_FAILED_ARTICLE),
                TestDataReader.getTestData(PRODUCT_FAILD_COUPON));
    }
}
