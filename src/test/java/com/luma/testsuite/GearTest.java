package com.luma.testsuite;

import com.luma.pages.HomePage;
import com.luma.pages.ProductDetailPage;
import com.luma.pages.ProductListPage;
import com.luma.pages.ShoppingCartPage;
import com.luma.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GearTest extends TestBase {

    HomePage homePage = new HomePage();
    ProductListPage listPage = new ProductListPage();
    ProductDetailPage detailPage = new ProductDetailPage();
    ShoppingCartPage cartPage = new ShoppingCartPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {

        homePage.mouseHoverOnGear();
        homePage.mouseHoverAndClickOnBags();
        listPage.clickOnOverNightDuffle();
        detailPage.changeQuantity("3");
        detailPage.clickOnAddToCart();
        Assert.assertEquals(detailPage.getSuccessMessageOfAddToCart(), "You added Overnight Duffle to your shopping cart.",
                "product not add in cart");
        detailPage.clickOnShoppingCart();
        Assert.assertEquals(cartPage.getProductNameOfOvernightDuffle(), "Overnight Duffle",
                "product name Mismatch");
        Thread.sleep(2000);
       /* Assert.assertEquals(cartPage.getQuantityOfProduct(), "3",
                "Quantity Mismatch");*/
        Assert.assertEquals(cartPage.getPriseOfProduct(), "$135.00",
                "Price Mismatch");
        cartPage.changeQuantity("5");
        cartPage.clickOnUpdateButton();
        Thread.sleep(2000);
        Assert.assertEquals(cartPage.getPriseOfProduct(), "$225.00",
                "Updated Price Mismatch");

    }
}
