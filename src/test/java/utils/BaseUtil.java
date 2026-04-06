package utils;

import pages.PageObjectManager;

public class BaseUtil {
    private String landingProductName;
    private PageObjectManager pom;
    private TestBase tb;
    private GenericUtil gu;

    public BaseUtil() {
        tb = new TestBase();
        var driver = tb.getDriver();
        pom = new PageObjectManager(driver);
        gu = new GenericUtil(driver);
    }

    public String getLandingProductName() {
        return landingProductName;
    }

    public void setLandingProductName(String landingProductName) {
        this.landingProductName = landingProductName;
    }

    public PageObjectManager getPom() {
        return pom;
    }

    public TestBase getTb() {
        return tb;
    }

    public GenericUtil getGu() {
        return gu;
    }
}
