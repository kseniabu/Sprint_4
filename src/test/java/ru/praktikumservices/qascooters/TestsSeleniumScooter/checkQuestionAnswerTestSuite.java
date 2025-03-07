package ru.praktikumservices.qascooters.TestsSeleniumScooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikumservices.qascooters.PageObjectSelenium.HomePageFaqScooter;

import java.util.Arrays;
import java.util.Collection;

    @RunWith(Parameterized.class)
    public class checkQuestionAnswerTestSuite {
        private WebDriver driver;
        private String baseUrl;
        private String actualAnswer;
        private String expectedAnswer;

        private static WebDriver initDriver() {

            String browser = System.getProperty("browser");
            if ("chrome".equals(browser)) {
                return new ChromeDriver();
            } else if ("firefox".equals(browser)) {
                return new FirefoxDriver();
            }
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        public checkQuestionAnswerTestSuite(String actualAnswer, String expectedAnswer) {
            this.actualAnswer = actualAnswer;
            this.expectedAnswer = expectedAnswer;
        }

        @Before
        public void setUp() {
            driver = initDriver();
            baseUrl = System.getProperty("url");
        }

        @Test
        public void checkFirstAnswer() {
            driver.get(baseUrl);
            HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
            objHomePageFaq.clickToAcceptCookie();
            objHomePageFaq.scrollToHeaderOfFaq();
            Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
        }

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            WebDriver driver = initDriver();
            HomePageFaqScooter objHomePageFaqData = new HomePageFaqScooter(driver);
            return Arrays.asList(new Object[][]{
                    {objHomePageFaqData.getFirstQuestionOfFaq(), objHomePageFaqData.getFirstExpectedAnswer()},
                    {objHomePageFaqData.getSecondQuestionOfFaq(), objHomePageFaqData.getSecondExpectedAnswer()},
                    {objHomePageFaqData.getThirdQuestionOfFaq(), objHomePageFaqData.getThirdExpectedAnswer()},
                    {objHomePageFaqData.getForthQuestionOfFaq(), objHomePageFaqData.getForthExpectedAnswer()},
                    {objHomePageFaqData.getFifthQuestionOfFaq(), objHomePageFaqData.getFifthExpectedAnswer()},
                    {objHomePageFaqData.getSixthQuestionOfFaq(), objHomePageFaqData.getSixthExpectedAnswer()},
                    {objHomePageFaqData.getSeventhQuestionOfFaq(), objHomePageFaqData.getSeventhExpectedAnswer()},
                    {objHomePageFaqData.getEightQuestionOfFaq(), objHomePageFaqData.getEightExpectedAnswer()},
            });
        }

        @After
        public void teardown() {
            driver.quit();
        }
}