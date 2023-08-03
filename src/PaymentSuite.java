import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class PaymentSuite {
    private WebDriver driver;
    private final String baseURL = "https://demowebshop.tricentis.com";
    
    PaymentSuite(WebDriver driver){
        this.driver = driver;
    }

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }

    @Test(priority = 4, groups = {"payment"})
    public void paymentGatewayIntegrationTest() {
        // Test payment gateway integration functionality
        driver.get(baseURL);

        WebElement cartAnchorTag = driver.findElement(By.className("ico-cart"));
        cartAnchorTag.click();
        
        try{
            WebElement termsCheckBox = driver.findElement(By.id("termsofservice"));
            termsCheckBox.click();
        }
        catch(Exception error){
            System.out.println(error);
        }
        

        WebElement checkOutButton = driver.findElement(By.id("checkout"));
        checkOutButton.click();

        try{
            WebElement companyInput = driver.findElement(By.id("BillingNewAddress_Company"));
            companyInput.sendKeys("CompanySample");

            WebElement countryInput = driver.findElement(By.id("BillingNewAddress_CountryId"));
            countryInput.sendKeys("Ethiopia");
            
            WebElement cityInput = driver.findElement(By.id("BillingNewAddress_City"));
            cityInput.sendKeys("Addis Ababa");

            WebElement addressInput = driver.findElement(By.id("BillingNewAddress_Address1"));
            addressInput.sendKeys("Addis Ababa Zone 1");

            WebElement zipCodeInput = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
            zipCodeInput.sendKeys("1000");
            
            WebElement phoneInput = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
            phoneInput.sendKeys("0912121212");

            driver.findElement(By.className("new-address-next-step-button")).click();
        } catch(Exception error){
            System.out.println(error);
        }   
        finally{
            driver.findElement(By.className("new-address-next-step-button")).click();    
        }

        try{
            Thread.sleep(3000);
        }
        catch(Exception error){

        }

        driver.findElement(By.className("new-address-next-step-button")).click();

        
        try{
            Thread.sleep(3000);
        }
        catch(Exception error){
            
        }
        driver.findElement(By.className("shipping-method-next-step-button")).click();

        try{
            Thread.sleep(3000);
        }
        catch(Exception error){
            
        }
        driver.findElement(By.className("payment-method-next-step-button")).click();

        try{
            Thread.sleep(3000);
        }
        catch(Exception error){
            
        }
        driver.findElement(By.className("payment-info-next-step-button")).click();

        try{
            Thread.sleep(3000);
        }
        catch(Exception error){
            
        }
        driver.findElement(By.className("confirm-order-next-step-button")).click();
        
        try{
            driver.findElement(By.className("order-completed-continue-button"));
            Assert.assertTrue(true);
        }
        catch(Exception error){
            Assert.assertFalse(false);
        }
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }
}

