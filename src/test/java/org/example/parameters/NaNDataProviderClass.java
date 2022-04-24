package org.example.parameters;

import org.testng.annotations.DataProvider;

public class NaNDataProviderClass {

        @DataProvider(name="NaNProvider")

        public static Object[][] getDataFromDataProvider(){
            return new Object[][] {
                    {"NaN", "89"},
                    {"-91.8", "NaN"},
                    {"NaN", "NaN"},
            };
        }
}
