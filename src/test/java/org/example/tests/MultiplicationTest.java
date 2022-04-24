package org.example.tests;

import io.qameta.allure.*;
import org.example.base.BaseTest;
import org.example.listeners.AllureListener;
import org.example.parameters.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class MultiplicationTest extends BaseTest {

    public static final String MULTIPLICATION = "*";

    @Test(dataProvider= "PositiveProvider", dataProviderClass = DataProviderClass.class)
    @Epic(value = "Умножение")
    @Feature(value = "Позитивные проверки умножения")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Позитивные проверки умножения")
    public void CheckMultiplication(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickMultiplicationButton()
                .checkResult(valueLeft, valueRight, MULTIPLICATION);
    }

    @Test(dataProvider="ErrorProvider", dataProviderClass = ErrorDataProviderClass.class)
    @Epic(value = "Умножение")
    @Feature(value = "Проверки на показ сообщения об ошибке")
    @Description("Проверки на показ сообщения об ошибке")
    public void CheckErrorCorrectly(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickMultiplicationButton()
                .checkErrorCorrectly(ERROR);
    }

    @Test(dataProvider="BigProvider", dataProviderClass = BigDataProviderClass.class)
    @Epic(value = "Умножение")
    @Feature(value = "Проверки на большие числа")
    @Description("Проверки на большие числа")
    public void CheckBigFields(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickMultiplicationButton()
                .checkResult(valueLeft, valueRight, MULTIPLICATION);
    }

    @Test(dataProvider="NaNProvider", dataProviderClass = NaNDataProviderClass.class)
    @Epic(value = "Умножение")
    @Feature(value = "Проверки c результатом NaN")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверки c результатом NaN")
    public void CheckNaN(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickMultiplicationButton()
                .checkNanOperation();
    }

    @Test(dataProvider="InfinityProvider", dataProviderClass = InfinityDataProviderClass.class)
    @Epic(value = "Умножение")
    @Feature(value = "Умножение с бесконечностями")
    @Severity(SeverityLevel.MINOR)
    @Description("Умножение с бесконечностями")
    public void CheckInfinityMultiplication(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickMultiplicationButton()
                .checkInfinity(valueLeft, valueRight, MULTIPLICATION);
    }

}
