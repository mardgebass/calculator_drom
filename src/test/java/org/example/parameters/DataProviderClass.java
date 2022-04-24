package org.example.parameters;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

        @DataProvider(name="PositiveProvider")

        public static Object[][] getDataFromDataProvider(){
            return new Object[][] {
//                  целые положительные
                    {"9999", "2"},
//                  граничащие с 0
                    {"0", "1"},
                    {"1", "0"},
                    {"0", "0"},
//                  отрицательные
                    {"-999", "-1.5"},
//                  десятичные
                    {"4569.856456876875645689", "-4.598756345687785"},
//                  Запись числа через е
                    {"2e3", "748e2"},
                    {"2e7", "748e2"},
            };
        }
}
