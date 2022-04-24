package org.example.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.example.locators.CalculatorPageLocators;
import java.math.BigDecimal;
import java.math.RoundingMode;
import static com.codeborne.selenide.Selenide.$;

public class CalculatorPage {

    private CalculatorPageLocators locator() {
        return new CalculatorPageLocators();
    }

    @Step("Тап '+' для сложения")
    public CalculatorPage clickAdditionButton() {
        $(locator().additionButton()).click();
        return new CalculatorPage();
    }

    @Step("Тап '-' для вычитания")
    public CalculatorPage clickSubtractButton() {
        $(locator().subtractButton()).click();
        return new CalculatorPage();
    }

    @Step("Тап '*' для умножения")
    public CalculatorPage clickMultiplicationButton() {
        $(locator().multiplicationButton()).click();
        return new CalculatorPage();
    }

    @Step("Тап '/' для деления")
    public CalculatorPage clickDivisionButton() {
        $(locator().divisionButton()).click();
        return new CalculatorPage();
    }

    @Step("Тап 'RESET', чтобы сбросить значения в полях ввода")
    public CalculatorPage clickResetButton() {
        $(locator().resetButton()).click();
        return new CalculatorPage();
    }

    @Step("Вводим значение {0} в поле слева и {1} в поле справа")
    public CalculatorPage enterValue(String valueLeft, String valueRight) {
        $(locator().inputFieldLeft()).sendKeys(valueLeft);
        $(locator().inputFieldRight()).sendKeys(valueRight);
        return new CalculatorPage();
    }

    @Step("Проверяем результат")
    public CalculatorPage checkResult(String valueLeft, String valueRight, String action) {
        double v1 = Double.parseDouble(valueLeft);
        double v2 = Double.parseDouble(valueRight);
        double v3 = 0;

        if ( action.equals("+") ) {
            v3 = v1 + v2;
        } else if ( action.equals("-") ) {
            v3 = v1 - v2;
        } else if ( action.equals("*") ) {
            v3 = v1 * v2;
        } else if ( action.equals("/") ) {
            v3 = v1 / v2;
        }

        String addResult = round(v1) + " " + action + " " + round(v2) + " = " + round(v3);

        $(locator().resultTextView()).shouldHave(Condition.text(addResult));
        return new CalculatorPage();
    }

    public double infinity(String value){
        double v = 0;
        if (value.equals("Infinity")) {
            v = Double.POSITIVE_INFINITY;
        } else if (value.equals("-Infinity")) {
            v = Double.NEGATIVE_INFINITY;
        } else {
            v = (Double.parseDouble(value));
        }
        return v;
    }

    @Step("Проверяем результаты вычислений с бесконечностью")
    public CalculatorPage checkInfinity(String valueLeft, String valueRight, String action) {

        double v3 = 0;
        String v4 = "";

        if ( action.equals("+") ) {
            v3 = infinity(valueLeft) + infinity(valueRight);
        } else if ( action.equals("-") ) {
            v3 = infinity(valueLeft) - infinity(valueRight);
        } else if ( action.equals("*") ) {
            v3 = infinity(valueLeft) * infinity(valueRight);
        } else if ( action.equals("/") && valueRight != "0") {
            v3 = infinity(valueLeft) / infinity(valueRight);
        }

        String addResult = " = " + v3 + v4;
        $(locator().resultTextView()).shouldHave(Condition.text(addResult));

        return new CalculatorPage();
    }

    @Step("Проверяем результат вычислений = NaN")
    public CalculatorPage checkNanOperation() {
        $(locator().resultTextView()).shouldHave(Condition.text(" = NaN"));
        return new CalculatorPage();
    }

    // Вспомогательный метод для округления
    public String round(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.toString();
    }

    @Step("Проверяем текст ошибки")
    public CalculatorPage checkErrorCorrectly(String text) {
        $(locator().resultTextView()).shouldHave(Condition.text(text));
        return new CalculatorPage();
    }

    @Step("Проверяем сброс значений")
    public CalculatorPage CheckResetCorrectly() {
        $(locator().inputFieldLeft()).shouldHave(Condition.exactText(""));
        $(locator().inputFieldRight()).shouldHave(Condition.exactText(""));
        return new CalculatorPage();
    }

}
