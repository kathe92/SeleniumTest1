package utils;

public class TestContextSetup {
    public static String textLandingPage;
    public String TestContextSetup(String landingPageProductName) {
        textLandingPage = landingPageProductName;
        return textLandingPage;
    }
}
