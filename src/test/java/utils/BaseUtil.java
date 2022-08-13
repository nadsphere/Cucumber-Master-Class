package utils;

import pages.PageObjectManager;
import java.io.IOException;

public class BaseUtil {
    public String landingProductName;
    public PageObjectManager pom;
    public TestBase tb;
    public GenericUtil gu;

    public BaseUtil() throws IOException {
        tb = new TestBase();
        pom = new PageObjectManager(tb.WebDriverManager());
        gu = new GenericUtil(tb.WebDriverManager());
    }
}
