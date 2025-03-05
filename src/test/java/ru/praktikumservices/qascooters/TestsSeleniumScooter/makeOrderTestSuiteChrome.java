package ru.praktikumservices.qascooters.TestsSeleniumScooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikumservices.qascooters.PageObjectSelenium.HomePageMainScooter;
import ru.praktikumservices.qascooters.PageObjectSelenium.OrderPagePersonScooter;
import ru.praktikumservices.qascooters.PageObjectSelenium.OrderPageRentScooter;

public class makeOrderTestSuiteChrome {
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
    public void orderFromHeader() {

        HomePageMainScooter objMainOfScooter = new HomePageMainScooter(driver);
        OrderPagePersonScooter objOrderPagePerson = new OrderPagePersonScooter(driver);
        OrderPageRentScooter objOrderPageRent = new OrderPageRentScooter(driver);

        objMainOfScooter.clickToOrderButtonInHeader();
        objOrderPagePerson.fillFieldsPersonOrderBulvarRocossovskogo("Катя", "Петрова", "г. Тестово, 3, квартира 5", "89172436889");
        objOrderPageRent.makeOrderBlackOneDay("15.03.2025", "привет, Курьер!");
        objOrderPageRent.clickToConfirmButton();

        String expectedConfirmationText = "Заказ оформлен";
        String actualConfirmationText = objOrderPageRent.getConfirmationHeader();

        Assert.assertEquals("Заказ не подтвержден", expectedConfirmationText, actualConfirmationText);
    }

    @Test
    public void orderFromMain() {

        HomePageMainScooter objMainOfScooter = new HomePageMainScooter(driver);
        OrderPagePersonScooter objOrderPagePerson = new OrderPagePersonScooter(driver);
        OrderPageRentScooter objOrderPageRent = new OrderPageRentScooter(driver);

        objMainOfScooter.scrollToOrderButtonInMain();
        objMainOfScooter.clickToOrderButtonInMain();
        objOrderPagePerson.fillFieldsPersonOrderCherkisovskaya("Петр", "Петров", "г. Уставший, дом 7, квартира 15, корпус 2", "+79172436700");
        objOrderPageRent.makeOrderGrayTwoDays("25.07.2025", "хорошего дня, курьер.");
        objOrderPageRent.clickToConfirmButton();

        String expectedConfirmationText = "Заказ оформлен";
        String actualConfirmationText = objOrderPageRent.getConfirmationHeader();

        Assert.assertEquals("Заказ не подтвержден", expectedConfirmationText, actualConfirmationText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
