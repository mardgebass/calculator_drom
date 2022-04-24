package org.example.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.android.AndroidDriver;
import org.example.pages.CalculatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    public static final String ERROR = "Please, fill the input fields correctly";
    public static final String CAN_T_DIVIDE_BY_ZERO = "Can't divide by zero";

    // метод, который будет открывать приложение
    public CalculatorPage openApp() {
        WebDriver driver = null;
        try {
            driver = getAndroidDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Opps, we have problems with URL for driver!");
        }

        // устанавливаем драйвер для selenide
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 8000;

        return new CalculatorPage();
    }

    public static WebDriver getAndroidDriver() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nexus_5");
        capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("app", "D:/test_drom/app-debug.apk");

        // устанавливаем и открываем приложение
        return new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @AfterClass
    public void setDown() {
        closeWebDriver();
    }
}

