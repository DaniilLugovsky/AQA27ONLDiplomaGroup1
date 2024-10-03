package data;

import org.testng.annotations.DataProvider;


public class StaticProvider {

    private static final String MAXIMUM_PERMISSIBLE_VALUE_MINUS_ONE = new String(new char[39]).replace('\0', '1');
    private static final String MAXIMUM_PERMISSIBLE_VALUE = new String(new char[40]).replace('\0', '1');
    private static final String MAXIMUM_PERMISSIBLE_VALUE_PLUS_ONE = new String(new char[41]).replace('\0', '1');

    @DataProvider(name = "boundaryValues")
    public static Object[][] boundaryValue() {
        return new Object[][]{
                {MAXIMUM_PERMISSIBLE_VALUE_MINUS_ONE, true},
                {MAXIMUM_PERMISSIBLE_VALUE, true},
                {MAXIMUM_PERMISSIBLE_VALUE_PLUS_ONE, false},
        };
    }
}
