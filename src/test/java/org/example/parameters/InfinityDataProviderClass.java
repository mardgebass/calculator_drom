package org.example.parameters;

import org.testng.annotations.DataProvider;

public class InfinityDataProviderClass {

        @DataProvider(name="InfinityProvider")

        public static Object[][] getDataFromDataProvider(){
            return new Object[][] {
                    {"Infinity", "44"},
                    {"-44", "Infinity"},
                    {"-Infinity", "44"},
                    {"-44", "-Infinity"},
                    {"Infinity", "Infinity"},
                    {"-Infinity", "Infinity"},
                    {"Infinity", "-Infinity"},
                    {"-Infinity", "-Infinity"},
                    {"0", "Infinity"},
                    {"Infinity", "0"},
            };
        }
}
