package org.example.parameters;

import org.testng.annotations.DataProvider;

public class ErrorDataProviderClass {

        @DataProvider(name="ErrorProvider")

        public static Object[][] getDataFromDataProvider(){
            return new Object[][] {
                    {"", ""},
                    {"3", ""},
                    {"", "9"},
                    {"два", "три"},
                    {"#6", "окунь"},
            };
        }
}
