package com.saucedemo.page;

import org.openqa.selenium.By;

public class InventoryPage {

    public static By productsTitle = By.cssSelector("span.title");
    public static By itemsCards = By.cssSelector("div.inventory_item");
    public static By clickProducto1 = By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Backpack']\n");
    public static By BackProduct = By.xpath("//button[@id='back-to-products']\n");
    public static By clickAddCart = By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']\n");
    public static By getQuantity = By.xpath("//span[@class='shopping_cart_badge']\n");
    public static By clickProducto2 = By.xpath("//div[@class='inventory_item_name ' and text()='Sauce Labs Bike Light']\n");
    public static By clickAddCart2 = By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    public static By clickCart = By.xpath("//a[@class='shopping_cart_link']/span[@class='shopping_cart_badge']\n");
    public static By cartTittle = By.xpath("//span[@class='title']");
    public static By clickRemove = By.xpath("//button[@data-test='remove-sauce-labs-bike-light']\n");
    public static By checkoutClick = By.xpath("//button[@data-test='checkout']\n");
    public static By informationTittle = By.xpath("//span[@class='title' and contains(text(), 'Checkout: Your Information')]\n");
    public static By firstNameInput = By.xpath("//*[@id=\"first-name\"]");
    public static By lastNameInput = By.xpath("//*[@id=\"last-name\"]");
    public static By postalCodeInput = By.xpath("//input[@id='postal-code']\n");
    public static By btnContinue = By.xpath("//input[@id='continue']\n");
    public static By clickFinish = By.xpath("//button[@id='finish']\n");
    public static By MsjEnd = By.xpath("//h2[@class='complete-header']\n");
}

