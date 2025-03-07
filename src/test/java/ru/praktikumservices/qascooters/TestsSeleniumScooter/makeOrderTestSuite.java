package ru.praktikumservices.qascooters.TestsSeleniumScooter;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikumservices.qascooters.PageObjectSelenium.HomePageMainScooter;
import ru.praktikumservices.qascooters.PageObjectSelenium.OrderPagePersonScooter;
import ru.praktikumservices.qascooters.PageObjectSelenium.OrderPageRentScooter;

public class makeOrderTestSuite {
    private WebDriver driver;
    private String baseUrl;

    @Before
    public void setDriver() {
        String browser = System.getProperty("browser");
        if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            driver = new FirefoxDriver();
        }
        baseUrl = System.getProperty("url");
    }

    @Test
    public void orderFromHeader() {
        driver.get(baseUrl);
        HomePageMainScooter objMainOfScooter = new HomePageMainScooter(driver);
        OrderPagePersonScooter objOrderPagePerson = new OrderPagePersonScooter(driver);
        OrderPageRentScooter objOrderPageRent = new OrderPageRentScooter(driver);

        objMainOfScooter.clickToAcceptCookie();
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

        objMainOfScooter.clickToAcceptCookie();
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
