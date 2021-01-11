package test;

import model.Cart;
import model.Product;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;
import page.ProductPage;
import page.ResultsPage;
import service.CheckCartEmpty;
import service.ProductCreator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WebDriverShopTest extends CommonConditions {

       @Test
        public void searchProductWithFailedArticleTest(){
            Product testProduct = ProductCreator.withFailedSearchAndFailedCoupon();
            ResultsPage checkResult = new HomePage(driver)
                    .openPage()
                    .searchForProductArticle(testProduct.getFailedArticle());

            assertThat(checkResult.getCheckResultSeacrh().contains(testProduct.getFailedArticle())).isTrue();

        }

    @Test
    public void searchProductWithActualArticleTest(){
        Product testProduct = ProductCreator.withAllProperty();
        ResultsPage checkResult = new HomePage(driver)
                .openPage()
                .searchForProductArticle(testProduct.getArticle());

        assertThat(checkResult.selectProductLink()).isTrue();

    }

        @Test
        public void cartAfterAddingProductTest(){
            Product testProduct = ProductCreator.withAllProperty();
            CartPage cartPage = new ProductPage(driver,testProduct.getProductUrl())
                    .openPage()
                    .selectedProductSize()
                    .addToCart()
                    .openCart();

            assertThat(cartPage.getSneakersArticle(),is(equalTo(testProduct.getArticle())));
            assertThat(cartPage.actualSizeSelected(),is(equalTo(testProduct.getSize())));
            assertThat(cartPage.getCartOrderTotal(),is(equalTo(Double.parseDouble(testProduct.getPrice()))));

        }

    @Test
    public void cartAfterAddingSomeProductTest(){
        Product testProduct = ProductCreator.withAddSomeProduct();
        CartPage cartPage = new ProductPage(driver,testProduct.getProductUrl(),testProduct.getProductSecondUrl())
                .openPage()
                .selectedProductSize()
                .addToCart()
                .openPageSecondProduct()
                .selectedSecondProductSize()
                .addToCart()
                .openCart();

        assertThat(cartPage.actualSizeSelected(),is(equalTo(testProduct.getSize())));
        assertThat(cartPage.actualSizeSecondSelected(),is(equalTo(testProduct.getSize())));
        assertThat(cartPage.getSneakersArticle(),is(equalTo(testProduct.getArticle())));
        assertThat(cartPage.getSneakersSecondArticle(),is(equalTo(testProduct.getSecondArticle())));
        assertThat(cartPage.getCartOrderTotal(),is(equalTo(Double.parseDouble(testProduct.getSumPrice()))));



    }

    @Test
    public void checkCartAfterDeleting(){
        Product testProduct = ProductCreator.withAllProperty();
        Cart testCart = CheckCartEmpty.withEmpty();
        CartPage cartPage =  new ProductPage(driver,testProduct.getProductUrl())
                .openPage()
                .selectedProductSize()
                .addToCart()
                .openCart();

        assertThat(cartPage.getSneakersArticle(),is(equalTo(testProduct.getArticle())));
        assertThat(cartPage.actualSizeSelected(),is(equalTo(testProduct.getSize())));
        assertThat(cartPage.getCartOrderTotal(),is(equalTo(Double.parseDouble(testProduct.getPrice()))));

        cartPage.deleteFromCart()
                .openCartFromMAin();

        assertThat(cartPage.checkCart()).isTrue();

    }

    @Test
    public void checkCorrectPromokode(){
        Product testProduct = ProductCreator.withAllProperty();
        CartPage cartPage =  new ProductPage(driver,testProduct.getProductUrl())
                .openPage()
                .selectedProductSize()
                .addToCart()
                .openCart();

        assertThat(cartPage.getSneakersArticle(),is(equalTo(testProduct.getArticle())));
        assertThat(cartPage.actualSizeSelected(),is(equalTo(testProduct.getSize())));
        assertThat(cartPage.getCartOrderTotal(),is(equalTo(Double.parseDouble(testProduct.getPrice()))));

        cartPage.inputCorrectPromocode(testProduct.getCoupon())
                .buttonPromocode();

        assertThat(cartPage.searchChangePrice()).isNotEqualTo(Double.parseDouble((testProduct.getPrice())));


    }

    @Test
    public void checkFaildPromokode(){
        Product testProduct = ProductCreator.withAllProperty();
        CartPage cartPage =  new ProductPage(driver,testProduct.getProductUrl())
                .openPage()
                .selectedProductSize()
                .addToCart()
                .openCart();

        assertThat(cartPage.getSneakersArticle(),is(equalTo(testProduct.getArticle())));
        assertThat(cartPage.actualSizeSelected(),is(equalTo(testProduct.getSize())));
        assertThat(cartPage.getCartOrderTotal(),is(equalTo(Double.parseDouble(testProduct.getPrice()))));

        cartPage.inputCorrectPromocode(testProduct.getCoupon())
                .buttonPromocode();

        assertThat(cartPage.getCartOrderTotal()).isEqualTo(Double.parseDouble((testProduct.getPrice())));


    }

}
