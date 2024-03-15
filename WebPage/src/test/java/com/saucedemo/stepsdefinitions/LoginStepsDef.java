package com.saucedemo.stepsdefinitions;

import com.saucedemo.steps.InventorySteps;
import com.saucedemo.steps.LoginSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepsDef {

    private WebDriver driver;
    private Scenario scenario;
    private InventorySteps inventorySteps;
    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Before(order = 0)
    public void setUp(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

   @After
    public void quitDriver(){
        driver.quit();
    }

    @Dado("que me encuentro en la página de login de Saucedemo")
    public void que_me_encuentro_en_la_página_de_login_de_sacedemo() {
        driver.get("https://www.saucedemo.com/");
        screenShot();
    }
    @Cuando("inicio sesión con las credenciales usuario: {string} y contraseña: {string}")
    public void inicio_sesión_con_las_credenciales_usuario_y_contraseña(String user, String password) {
        LoginSteps loginSteps = new LoginSteps(driver);
        loginSteps.typeUser(user);
        loginSteps.typePassword(password);
        loginSteps.login();
        screenShot();
    }
    @Entonces("valido que debería aparecer el título de {string}")
    public void valido_que_debería_aparecer_el_título_de(String expectedTitle) {
        String title =  inventorySteps(driver).getTitle();
        Assertions.assertEquals(expectedTitle, title);
    }
    @Y("también valido que al menos exista un item")
    public void también_valido_que_al_menos_exista_un_item() {
        int itemsListSize = inventorySteps(driver).getItemSize();
        screenShot();
        Assertions.assertTrue(itemsListSize > 0, "El tamaño de la lista es: " + itemsListSize);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }

    @Y("selecciono un producto")
    public void seleccionoUnProducto() {
        InventorySteps.clickProducto();
        screenShot();
    }

    @Entonces("Valido que debería aparecer {string}")
    public void validoQueDeberíaAparecer(String expectedTitle) {
        String BackProduct =  inventorySteps(driver).getBackProduct();
        Assertions.assertEquals(expectedTitle, BackProduct);
    }

    @Y("regreso a la lista de productos")
    public void regresoALaListaDeProductos() throws InterruptedException {
        InventorySteps.clickRegresar();
        screenShot();
    }

    @Y("agrego el producto al carrito")
    public void agregoElProductoAlCarrito() {
        InventorySteps.clickAddCart();
        screenShot();
    }

    @Entonces("valido que en el carrito de compras deba aparecer {int}")
    public void validoQueEnElCarritoDeComprasDebaAparecer(int expectedQuantity) {
        int actualQuantity = Integer.parseInt(inventorySteps(driver).getQuantity());
        Assertions.assertEquals(expectedQuantity, actualQuantity);
        screenShot();
    }

    @Y("selecciono un segundo producto")
    public void seleccionoUnSegundoProducto() throws InterruptedException {
        InventorySteps.clickProducto2();
        screenShot();
    }

    @Y("agrego el segundo producto al carrito")
    public void agregoElSegundoProductoAlCarrito() {
        InventorySteps.clickAddCart2();
        screenShot();
    }

    @Y("hago click en el carrito de compras")
    public void hagoClickEnElCarritoDeCompras() throws InterruptedException {
        InventorySteps.clickCart();
        screenShot();
    }

    @Entonces("valido que deberia aparecer el titulo de {string}")
    public void validoQueDeberiaAparecerElTituloDe(String expectedTitle) {
        String CartTittle =  inventorySteps(driver).getCartTittle();
        Assertions.assertEquals(expectedTitle, CartTittle);
    }

    @Y("retiro el segundo producto")
    public void retiroElSegundoProducto() throws InterruptedException {
        InventorySteps.clickRemove();
        screenShot();
    }

    @Y("hago click en checkout")
    public void hagoClickEnCheckout() throws InterruptedException {
        InventorySteps.CheckOutClick();
        screenShot();
    }

    @Entonces("valido que aparezca el titulo de {string}")
    public void validoQueAparezcaElTituloDe(String expectedTitle) {
        String informationTittle =  inventorySteps(driver).getInformationTittle();
        Assertions.assertEquals(expectedTitle, informationTittle);
    }

    @Y("completo los datos del usuario: {string}, {string} y {string}")
    public void completoLosDatosDelUsuarioY(String firstName, String lastName, String postalCode) throws InterruptedException {
        InventorySteps inventorySteps = new InventorySteps(driver);
        inventorySteps.typeFirstName(firstName);
        inventorySteps.typeLastName(lastName);
        inventorySteps.typePostalCode(postalCode);
        inventorySteps.btnContinue();
        screenShot();
    }

    @Y("finalizo mi compra")
    public void finalizoMiCompra() {
        InventorySteps.clickFinish();
        screenShot();
    }

    @Entonces("debe mostrar el mensaje {string}")
    public void debeMostrarElMensaje(String expectedTitle) throws InterruptedException {
        String MsjEnd =  inventorySteps(driver).getMsjEnd();
        Assertions.assertEquals(expectedTitle, MsjEnd);
    }
}
