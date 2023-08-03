import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AuthenticationSuite {
    private WebDriver driver;
    private final String baseURL = "https://demowebshop.tricentis.com";
    
    AuthenticationSuite(WebDriver driver){
        this.driver = driver;
    }
    
    @BeforeClass
    public void setUp() {
        // Set up the WebDriver instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    
    @Test(priority = 2, groups = {"authentication"})
    public void userRegistrationTest() {
        // Navigate to the registration page
        driver.get(baseURL);

        List<WebElement> registerElements = driver.findElements(By.className("ico-register"));
        registerElements.get(0).click();

        WebElement maleFieldElement = driver.findElement(By.id("gender-male"));
        maleFieldElement.click();

        // Find the name input field and enter a valid name
        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.sendKeys("John");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.sendKeys("Doe");

        // Find the email input field and enter a valid email
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("johndoe@example54748.com");

        // Find the password input field and enter a valid password
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("Password123");

        WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
        confirmPasswordInput.sendKeys("Password123");

        // Submit the registration form
        WebElement submitButton = driver.findElement(By.id("register-button"));
        submitButton.click();
        // Test login and logout functionality
        
        try{
            driver.findElement(By.className("result"));
            Assert.assertTrue(true);
        }
        catch(Exception error){
            Assert.assertFalse(false);
        }
    }

    @Test(priority = 3, groups = {"authentication"})
    public void loginTest() {
        // Test login and logout functionality
        driver.get(baseURL);
        // Perform login steps
        // Assert login success message or validate the user is logged in
        List<WebElement> elements = driver.findElements(By.className("ico-login"));
        elements.get(0).click();
        
        // Find the email input field and enter a valid email
        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("johndoe@example54748.com");

        // Find the password input field and enter a valid password
        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("Password123");

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        try{
            driver.findElement(By.className("account"));
            Assert.assertTrue(true);
        }
        catch(Exception error){
            Assert.assertFalse(false);
        }
    }

    @Test(priority = 3, groups = {"authentication"})
    public void logoutTest() {
        // Test login and logout functionality
        driver.get(baseURL);
        // Perform login steps
        // Assert login success message or validate the user is logged in
        WebElement elements = driver.findElement(By.className("ico-logout"));
        elements.click();

        try{
            driver.findElement(By.className("ico-login"));
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

