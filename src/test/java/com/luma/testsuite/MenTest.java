package com.luma.testsuite;

import com.luma.pages.HomePage;
import com.luma.pages.ProductListPage;
import com.luma.pages.ShoppingCartPage;
import com.luma.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MenTest extends TestBase {
    HomePage homePage = new HomePage();
    ProductListPage listPage =new ProductListPage();
    ShoppingCartPage cartPage = new ShoppingCartPage();

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart(){

        homePage.mouseHoverOnMan();
        homePage.mouseHoverOnBottom();
        homePage.mouseHoverAndClickOnPents();
        listPage.mouseHoverOnCronusYogaPents();
        listPage.clickOnSize32();
        listPage.clickOnColorBlack();
        listPage.mouseHoverOnCronusYogaPents();
        listPage.clickOnAddCartInCronusYogaPents();
        Assert.assertEquals(listPage.getSuccessMessageOfAddToCart(),
                "You added Cronus Yoga Pant to your shopping cart.",
                "Product not added in cart!");
        listPage.clickOnShoppingCart();

        Assert.assertEquals(cartPage.getShoppingCartTitle(),
                "Shopping Cart",
                "page title Mismatch!");

        Assert.assertEquals(cartPage.getProductNameOfCronusYogaPent(),
                "Cronus Yoga Pant",
                "Product name Mismatch!");

        Assert.assertEquals(cartPage.getSize32(),
                "32",
                "Product size Mismatch!");

        Assert.assertEquals(cartPage.getProductColorBlack(),
                "Black",
                "Product color Mismatch!");

    }
}
