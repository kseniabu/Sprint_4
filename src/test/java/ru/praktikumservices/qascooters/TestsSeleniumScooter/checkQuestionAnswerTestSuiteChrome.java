package ru.praktikumservices.qascooters.TestsSeleniumScooter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikumservices.qascooters.PageObjectSelenium.HomePageFaqScooter;

public class checkQuestionAnswerTestSuiteChrome {
    private WebDriver driver;

    @Before
    public void acceptCookie() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    @Test
    public void checkFirstAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        String actualAnswer = objHomePageFaq.clickToFirstQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkSecondAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        String actualAnswer = objHomePageFaq.clickToSecondQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkThirdAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        String actualAnswer = objHomePageFaq.clickToThirdQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkForthAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        String actualAnswer = objHomePageFaq.clickToForthQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkFifthAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        String actualAnswer = objHomePageFaq.clickToFifthQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkSixthAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        String actualAnswer = objHomePageFaq.clickToSixthQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkSeventhAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        String actualAnswer = objHomePageFaq.clickToSeventhQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @Test
    public void checkEightAnswer() {
        HomePageFaqScooter objHomePageFaq = new HomePageFaqScooter(driver);
        objHomePageFaq.scrollToHeaderOfFaq();

        String expectedAnswer = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        String actualAnswer = objHomePageFaq.clickToEightQuestionOfFaq();

        Assert.assertEquals("Неверный ответ", expectedAnswer, actualAnswer);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
