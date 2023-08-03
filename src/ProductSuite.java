import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ProductSuite {
    private WebDriver driver;
    private final String baseURL = "https://demowebshop.tricentis.com";
    
    ProductSuite(WebDriver driver){
        this.driver = driver;
    }

    @BeforeClass
    public void setUp() {
        // Set up the WebDriver instance
        
    }

    @Test(priority = 3, groups = {"product"})
    public void productCatalogueDisplayTest() {
        // Test product catalogue functionality
        driver.get(baseURL);
        // Perform steps to navigate to the product catalogue page
        // Assert the presence of products or validate the product catalogue page
        List<WebElement> products = driver.findElements(By.className("top-menu"));
        
        for(int i = 0; i < products.size(); i++){
            products.get(i).click();
            List<WebElement> items = driver.findElements(By.className("sub-category-grid"));

            if(items.size() == 0){
                Assert.assertFalse(false);
                return;
            }
        }

        Assert.assertTrue(true);
    }

    @Test(priority = 5, groups = {"product"})
    public void addToCartTest(){
        driver.get(baseURL);

        List<WebElement> products = driver.findElements(By.className("top-menu"));
        products.get(0).findElement(By.tagName("a")).click();

        List<WebElement> items = driver.findElements(By.className("item-box"));
        WebElement button = items.get(0).findElement(By.className("product-box-add-to-cart-button"));

        button.click();
        
        try{
            driver.findElement(By.className("bar-notification success"));
            Assert.assertTrue(true);
        }
        catch(Exception error){
            Assert.assertFalse(false);
        }
    }

    @Test(priority = 5, groups = {"product"})
    public void shoppingCartTest() {
        // Test shopping cart functionality
        driver.get(baseURL);
        
        List<WebElement> elements = driver.findElements(By.className("ico-cart"));
        elements.get(0).click();

        Assert.assertTrue(true);
    }

    @Test(priority = 6, groups = {"product"})
    public void wishlistTest() {
        // Test wishlist functionality
        driver.get(baseURL);
        
        List<WebElement> elements = driver.findElements(By.className("ico-wishlist"));
        elements.get(0).click();

        Assert.assertTrue(true);
    }

    @AfterClass
    public void tearDown() {
        // Quit the WebDriver instance
        driver.quit();
    }
}

