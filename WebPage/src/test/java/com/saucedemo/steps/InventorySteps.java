package com.saucedemo.steps;

import com.saucedemo.page.InventoryPage;
import io.cucumber.java.sl.In;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class InventorySteps {

    private static WebDriver driver;
    public InventorySteps(WebDriver driver){
        this.driver = driver;
    }

    public static void clickProducto() {
        WebElement clickProducto = driver.findElement(InventoryPage.clickProducto1);
        clickProducto.click();
        System.out.println("Se selecciono un producto de la lista");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InventoryPage.clickAddCart));
    }

    public static void clickRegresar() throws InterruptedException {
        WebElement clickRegresar = driver.findElement(InventoryPage.BackProduct);
        Thread.sleep(3000);
        clickRegresar.click();
        System.out.println("Regreso a la lista de productos");
    }

    public static void clickAddCart() {
        WebElement clickAddCart = driver.findElement(InventoryPage.clickAddCart);
        clickAddCart.click();
        System.out.println("Se agrego 1 producto al carrito de compras");
    }

    public static void clickProducto2() throws InterruptedException {
        Thread.sleep(3000);
        WebElement clickPorducto2 = driver.findElement(InventoryPage.clickProducto2);
        clickPorducto2.click();
        System.out.println("Selecciono un segundo producto");
    }

    public static void clickAddCart2() {
        WebElement clickAddCart2 = driver.findElement(InventoryPage.clickAddCart2);
        clickAddCart2.click();
        System.out.println("Se agrego un segundo producto al carrito");
    }

    public static void clickCart() throws InterruptedException {
        WebElement clickCart = driver.findElement(InventoryPage.clickCart);
        clickCart.click();
        Thread.sleep(3000);
    }

    public static void clickRemove() throws InterruptedException {
        Thread.sleep(3000);
        WebElement clickRemove = driver.findElement(InventoryPage.clickRemove);
        clickRemove.click();
        System.out.println("Se retiro el segundo producto");
    }

    public static void CheckOutClick() throws InterruptedException {
        Thread.sleep(3000);
        WebElement checkoutClick = driver.findElement(InventoryPage.checkoutClick);
        checkoutClick.click();
    }

    public static void clickFinish() {
        WebElement clickFinish = driver.findElement(InventoryPage.clickFinish);
        clickFinish.click();
    }

    public String getTitle(){
        return this.driver.findElement(InventoryPage.productsTitle).getText();
    }
    public String getBackProduct() {
        String backProductText = this.driver.findElement(InventoryPage.BackProduct).getText();
        System.out.println("Se regresó a la lista de productos.");
        return backProductText;
    }
    public int getItemSize(){
        List<WebElement> items = this.driver.findElements(InventoryPage.itemsCards);
        int size = items.size();
        System.out.println("Se encontro " +size+ " Elementos.");
        return items.size();
    }
    public String getQuantity() {
        WebElement quantityElement = this.driver.findElement(InventoryPage.getQuantity);
        String quantity = quantityElement.getText();
        System.out.println("Cantidad de productos en el carrito: " + quantity);
        return quantity;
    }
    public String getCartTittle() {
        return this.driver.findElement(InventoryPage.cartTittle).getText();
    }

    public String getInformationTittle() {
        return this.driver.findElement(InventoryPage.informationTittle).getText();
    }

    public void typeFirstName(String firstName) throws InterruptedException {
        Thread.sleep(3000);
        WebElement firstNameInput = driver.findElement(InventoryPage.firstNameInput);
        firstNameInput.clear();
        firstNameInput.sendKeys("Jose Manuel");
    }

    public void typeLastName(String lastName) {
        WebElement lastNameInput = driver.findElement(InventoryPage.lastNameInput);
        lastNameInput.clear();
        lastNameInput.sendKeys("Flores Calle");
    }

    public void typePostalCode(String postalCode) {
        WebElement postalCodeInput = driver.findElement(InventoryPage.postalCodeInput);
        postalCodeInput.clear();
        postalCodeInput.sendKeys("02002");
    }

    public void btnContinue() throws InterruptedException {
        Thread.sleep(3000);
        WebElement btnContinue = driver.findElement(InventoryPage.btnContinue);
        btnContinue.click();
        System.out.println("Se ingreso la informacion correctamente");
    }

    public String getMsjEnd() throws InterruptedException {
        Thread.sleep(3000);
        String MsjEnd = this.driver.findElement(InventoryPage.MsjEnd).getText();
        System.out.println("Se genero correctamente la compra");
        return MsjEnd;
    }
}
