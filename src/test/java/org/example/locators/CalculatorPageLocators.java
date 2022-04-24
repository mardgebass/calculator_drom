package org.example.locators;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;

// Весь список локаторов для элементов экрана калькулятора

public class CalculatorPageLocators {

    public By additionButton() {
        return MobileBy.AccessibilityId("additionButton");
    }

    public By subtractButton() {
        return MobileBy.AccessibilityId("subtractButton");
    }

    public By multiplicationButton() {
        return MobileBy.AccessibilityId("multiplicationButton");
    }

    public By divisionButton() {
        return MobileBy.AccessibilityId("divisionButton");
    }

    public By resetButton() {
        return MobileBy.AccessibilityId("resetButton");
    }

    public By inputFieldLeft() {
        return MobileBy.AccessibilityId("inputFieldLeft");
    }

    public By inputFieldRight() {
        return MobileBy.AccessibilityId("inputFieldRight");
    }

    public By resultTextView() {
        return MobileBy.AccessibilityId("resultTextView");
    }

}
