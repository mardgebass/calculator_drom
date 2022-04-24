package org.example.tests;

import io.qameta.allure.*;
import org.example.base.BaseTest;
import org.example.parameters.ResetDataProviderClass;
import org.testng.annotations.Test;

public class ResetTest extends BaseTest {

    @Test(dataProvider= "ResetProvider", dataProviderClass = ResetDataProviderClass.class)
    @Epic(value = "Сброс RESET")
    @Feature(value = "Проверяем сброс без выполнения арифметических действий")
    @Description("Проверяем сброс без выполнения арифметических действий")
    public void CheckReset(String valueLeft, String valueRight) {
        openApp()
                .enterValue(valueLeft, valueRight)
                .clickResetButton()
                .CheckResetCorrectly();
    }

    @Test
    @Epic(value = "Сброс RESET")
    @Feature(value = "Проверка сброса после сложения")
    @Description("Проверка сброса после сложения")
    public void CheckResetAfterAddition() {
        openApp()
                .enterValue("12", "3")
                .clickAdditionButton()
                .clickResetButton()
                .CheckResetCorrectly();
    }

    @Test
    @Epic(value = "Сброс RESET")
    @Feature(value = "Проверка сброса после вычитания")
    @Description("Проверка сброса после вычитания")
    public void CheckResetAfterSubtraction() {
        openApp()
                .enterValue("-122", "2")
                .clickSubtractButton()
                .clickResetButton()
                .CheckResetCorrectly();
    }

    @Test
    @Epic(value = "Сброс RESET")
    @Feature(value = "Проверка сброса после умножения")
    @Description("Проверка сброса после умножения")
    public void CheckResetAfterMultiplication() {
        openApp()
                .enterValue("66", "9.6")
                .clickMultiplicationButton()
                .clickResetButton()
                .CheckResetCorrectly();
    }

    @Test
    @Epic(value = "Сброс RESET")
    @Feature(value = "Проверка сброса после деления")
    @Description("Проверка сброса после деления")
    public void CheckResetAfterDivision() {
        openApp()
                .enterValue("0", "88656516")
                .clickDivisionButton()
                .clickResetButton()
                .CheckResetCorrectly();
    }

}
