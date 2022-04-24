package org.example.tests;

import io.qameta.allure.*;
import org.example.base.BaseTest;
import org.example.listeners.AllureListener;
import org.example.parameters.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class AdditionTest extends BaseTest {

    public static final String ADDITION = "+";


    @Test(dataProvider= "PositiveProvider", dataProviderClass = DataProviderClass.class)
    @Epic(value = "Сложение")
    @Feature(value = "Позитивные проверки сложения")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Позитивные проверки сложения")
    public void CheckAddition(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickAdditionButton()
                .checkResult(valueLeft, valueRight, ADDITION);
    }

    @Test(dataProvider="ErrorProvider", dataProviderClass = ErrorDataProviderClass.class)
    @Epic(value = "Сложение")
    @Feature(value = "Проверки на показ сообщения об ошибке")
    @Description("Проверки на показ сообщения об ошибке")
    public void CheckErrorCorrectly(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickAdditionButton()
                .checkErrorCorrectly(ERROR);
    }

    @Test(dataProvider="BigProvider", dataProviderClass = BigDataProviderClass.class)
    @Epic(value = "Сложение")
    @Feature(value = "Проверки на большие числа")
    @Description("Проверки на большие числа")
    public void CheckBigFields(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickAdditionButton()
                .checkResult(valueLeft, valueRight, ADDITION);
    }

    @Test(dataProvider="InfinityProvider", dataProviderClass = InfinityDataProviderClass.class)
    @Epic(value = "Сложение")
    @Feature(value = "Сложение с бесконечностями")
    @Severity(SeverityLevel.MINOR)
    @Description("Сложение с бесконечностями")
    public void CheckInfinityAddition(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickAdditionButton()
                .checkInfinity(valueLeft, valueRight, ADDITION);
    }

    @Test(dataProvider="NaNProvider", dataProviderClass = NaNDataProviderClass.class)
    @Epic(value = "Сложение")
    @Feature(value = "Проверки c результатом NaN")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверки c результатом NaN")
    public void CheckNaN(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickAdditionButton()
                .checkNanOperation();
    }

}
