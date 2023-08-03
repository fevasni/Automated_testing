import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        AuthenticationSuite authSuite = new AuthenticationSuite(driver);
        ProductSuite productSuite = new ProductSuite(driver);
        PaymentSuite paymentSuite = new PaymentSuite(driver);
        
        authSuite.userRegistrationTest();
        authSuite.loginTest();

        productSuite.productCatalogueDisplayTest();
        productSuite.addToCartTest();
        productSuite.shoppingCartTest();
        productSuite.wishlistTest();

        paymentSuite.paymentGatewayIntegrationTest();

        authSuite.logoutTest();
        
        //Tests complete and close down
        authSuite.tearDown();
        
    }
}

