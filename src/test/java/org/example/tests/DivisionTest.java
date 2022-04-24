package org.example.tests;

import io.qameta.allure.*;
import org.example.base.BaseTest;
import org.example.listeners.AllureListener;
import org.example.parameters.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class DivisionTest extends BaseTest {

    public static final String DIVISION = "/";

    @Test(dataProvider= "PositiveProvider", dataProviderClass = DataProviderClass.class)
    @Epic(value = "Деление")
    @Feature(value = "Позитивные проверки деления")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Позитивные проверки деления")
    public void CheckDivision(String valueLeft, String valueRight) {
        if (valueRight != "0"){
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickDivisionButton()
                .checkResult(valueLeft, valueRight, DIVISION);
        } else {
            openApp()
                    .enterValue(valueLeft, valueRight)
                    .clickDivisionButton()
                    .checkErrorCorrectly(CAN_T_DIVIDE_BY_ZERO);
        }
    }

    @Test(dataProvider="ErrorProvider", dataProviderClass = ErrorDataProviderClass.class)
    @Epic(value = "Деление")
    @Feature(value = "Проверки на показ сообщения об ошибке")
    @Description("Проверки на показ сообщения об ошибке")
    public void CheckErrorCorrectly(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickDivisionButton()
                .checkErrorCorrectly(ERROR);
    }

    @Test(dataProvider="NaNProvider", dataProviderClass = NaNDataProviderClass.class)
    @Epic(value = "Деление")
    @Feature(value = "Проверки c результатом NaN")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверки c результатом NaN")
    public void CheckNaN(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickDivisionButton()
                .checkNanOperation();
    }

    @Test(dataProvider="BigProvider", dataProviderClass = BigDataProviderClass.class)
    @Epic(value = "Деление")
    @Feature(value = "Проверки на большие числа")
    @Description("Проверки на большие числа")
    public void CheckBigFields(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickDivisionButton()
                .checkResult(valueLeft, valueRight, DIVISION);
    }

    @Test(dataProvider="InfinityProvider", dataProviderClass = InfinityDataProviderClass.class)
    @Epic(value = "Деление")
    @Feature(value = "Деление с бесконечностями")
    @Severity(SeverityLevel.MINOR)
    @Description("Деление с бесконечностями")
    public void CheckInfinityDivision(String valueLeft, String valueRight) {
        if (valueRight != "0"){
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickDivisionButton()
                .checkInfinity(valueLeft, valueRight, DIVISION);
        } else {
            openApp()
                    .enterValue(valueLeft, valueRight)
                    .clickDivisionButton()
                    .checkErrorCorrectly(CAN_T_DIVIDE_BY_ZERO);
        }
    }

}
