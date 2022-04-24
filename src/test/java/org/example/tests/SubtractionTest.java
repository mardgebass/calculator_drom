package org.example.tests;

import io.qameta.allure.*;
import org.example.base.BaseTest;
import org.example.listeners.AllureListener;
import org.example.parameters.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class SubtractionTest extends BaseTest {

    public static final String SUBTRACTION = "-";

    @Test(dataProvider= "PositiveProvider", dataProviderClass = DataProviderClass.class)
    @Epic(value = "Вычитание")
    @Feature(value = "Позитивные проверки вычитания")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Позитивные проверки вычитания")
    public void CheckSubtraction(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickSubtractButton()
                .checkResult(valueLeft, valueRight, SUBTRACTION);
    }

    @Test(dataProvider="ErrorProvider", dataProviderClass = ErrorDataProviderClass.class)
    @Epic(value = "Вычитание")
    @Feature(value = "Проверки на показ сообщения об ошибке")
    @Description("Проверки на показ сообщения об ошибке")
    public void CheckErrorCorrectly(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickSubtractButton()
                .checkErrorCorrectly(ERROR);
    }

    @Test(dataProvider="BigProvider", dataProviderClass = BigDataProviderClass.class)
    @Epic(value = "Вычитание")
    @Feature(value = "Проверки на большие числа")
    @Description("Проверки на большие числа")
    public void CheckBigFields(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickSubtractButton()
                .checkResult(valueLeft, valueRight, SUBTRACTION);
    }

    @Test(dataProvider="NaNProvider", dataProviderClass = NaNDataProviderClass.class)
    @Epic(value = "Вычитание")
    @Feature(value = "Проверки c результатом NaN")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверки c результатом NaN")
    public void CheckNaN(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickSubtractButton()
                .checkNanOperation();
    }

    @Test(dataProvider="InfinityProvider", dataProviderClass = InfinityDataProviderClass.class)
    @Epic(value = "Вычитание")
    @Feature(value = "Вычитание с бесконечностями")
    @Severity(SeverityLevel.MINOR)
    @Description("Вычитание с бесконечностями")
    public void CheckInfinitySubtraction(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickSubtractButton()
                .checkInfinity(valueLeft, valueRight, SUBTRACTION);
    }

}
