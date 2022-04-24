package org.example.parameters;

import org.testng.annotations.DataProvider;

public class ResetDataProviderClass {

        @DataProvider(name="ResetProvider")

        public static Object[][] getDataFromDataProvider(){
            return new Object[][] {
                    {"123", "456"},
                    {"", "123"},
                    {"123", ""},
            };
        }
}
