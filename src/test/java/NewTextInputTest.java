import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NewTextInputTest {

    String emptyLineInput = "     ";
    String newTextInput = "Hello, Appium!";
    private AndroidDriver driver;

    private MobileObjects mobileObjects;

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @BeforeEach
    public void setUp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:deviceName", "Samsung Galaxy");
        caps.setCapability("appium:appPackage", "ru.netology.testing.uiautomator");
        caps.setCapability("appium:appActivity", "ru.netology.testing.uiautomator.MainActivity");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:ensureWebviewsHavePages", true);
        caps.setCapability("appium:nativeWebScreenshot", true);
        caps.setCapability("appium:newCommandTimeout", 3600);
        caps.setCapability("appium:connectHardwareKeyboard", true);

        driver = new AndroidDriver(this.getUrl(), caps);

        mobileObjects = new MobileObjects(driver);
    }

    @Test
    public void emptyLineInputTest() {

        mobileObjects.initialText.isDisplayed();

//        MobileElement initialText = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
//        initialText.isDisplayed();

        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(emptyLineInput);

//        MobileElement userInput = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
//        userInput.isDisplayed();
//        userInput.sendKeys(emptyLineInput);

        mobileObjects.btnChange.isDisplayed();
        mobileObjects.btnChange.click();

//        MobileElement btnChange = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonChange"));
//        btnChange.isDisplayed();
//        btnChange.click();

        mobileObjects.afterInputText.isDisplayed();

//        MobileElement afterInputText = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/textToBeChanged"));
//        afterInputText.isDisplayed();

        Assertions.assertEquals(mobileObjects.initialText.getText(), mobileObjects.afterInputText.getText());


    }

    @Test
    public void secondActivityTextTest() {

        mobileObjects.userInput.isDisplayed();
        mobileObjects.userInput.sendKeys(newTextInput);

//        MobileElement userInput = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/userInput"));
//        userInput.isDisplayed();
//        userInput.sendKeys(newTextInput);

        mobileObjects.btnActivity.isDisplayed();
        mobileObjects.btnActivity.click();

//        MobileElement btnActivity = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/buttonActivity"));
//        btnActivity.isDisplayed();
//        btnActivity.click();

        mobileObjects.secondActivityText.isDisplayed();

//        MobileElement secondActivityText = (MobileElement) driver.findElement(By.id("ru.netology.testing.uiautomator:id/text"));
//        secondActivityText.isDisplayed();

        Assertions.assertEquals(mobileObjects.secondActivityText.getText(), newTextInput);


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

