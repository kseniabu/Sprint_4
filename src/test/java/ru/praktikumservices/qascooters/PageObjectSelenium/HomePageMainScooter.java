package ru.praktikumservices.qascooters.PageObjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HomePageMainScooter {
    private WebDriver driver;

    //конструктор класса
    public HomePageMainScooter(WebDriver driver){
        this.driver = driver;
    }

    //локатор для кнопки "Заказать" в основной части
    private By orderButtonInMain = By.xpath(".//div[@class='Home_RoadMap__2tal_']/div[5]/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //локатор для кнопки "Заказать" в хэдере
    private By orderButtonInHeader = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    //метод кликает по кнопке "Заказать" в основной части
    public void clickToOrderButtonInMain() {
        driver.findElement(orderButtonInMain).click();
    }

    //метод делает скролл до кнопки "Заказать" в основной части
    public void scrollToOrderButtonInMain() {
        WebElement element = driver.findElement(orderButtonInMain);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //метод кликает по кнопке "Заказать" в хэдере
    public void clickToOrderButtonInHeader() {
        driver.findElement(orderButtonInHeader).click();
    }
}