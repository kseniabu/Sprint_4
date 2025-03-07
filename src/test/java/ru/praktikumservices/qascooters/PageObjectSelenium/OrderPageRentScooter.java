package ru.praktikumservices.qascooters.PageObjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPageRentScooter {
    private WebDriver driver;

    //конструктор класса
    public OrderPageRentScooter(WebDriver driver) {
        this.driver = driver;
    }

    //локатор для поля "Когда привезти самокат" на форме создания заказа "Про аренду"
    private By dateInput = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //локатор для поля "Срок аренды" на форме создания заказа "Про аренду"
    private By termInput = By.xpath(".//div[@class='Dropdown-placeholder']");
    //локатор для чекбокса выбора цвета "Черный жемчуг" на форме создания заказа "Про аренду"
    private By colourBlackCheckbox = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label[1]/input");
    //локатор для чекбокса выбора цвета "Серая безысходность" на форме создания заказа "Про аренду"
    private By colourGreyCheckbox = By.xpath(".//div[@class='Order_Checkboxes__3lWSI']/label[2]/input");
    //локатор для поля "Комментарий курьеру" на форме создания заказа "Про аренду"
    private By commentInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/input");

    //локатор для селектора "Срок аренды - сутки"
    private By termInputOneDay = By.xpath(".//div[@class='Dropdown-menu']/div[1]");
    //локатор для селектора "Срок аренды - двое суток"
    private By termInputTwoDays = By.xpath(".//div[@class='Dropdown-menu']/div[2]");

    //локатор для кнопки "Заказать" на форме создания заказа "Про аренду"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");

    //локатор для кнопки "Да" во всплывающем окне "Хотите оформить заказ?"
    private By confirmButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[2]/button[2]");

    //локатор для заголовка всплывающего окна после подтверждения заказа
    private By confirmationHeader = By.xpath(".//div[@class='Order_Content__bmtHS']/div[5]/div");

    //метод получения фактического заголовка всплывающего окна после подтверждения заказа
    public String getConfirmationHeader() {
        return driver.findElement(confirmationHeader).getText();
    }

    //метод кликает по кнопке "Заказать" на форме создания заказа "Про аренду"
    public void clickToOrderButton() {
        driver.findElement(orderButton).click();
    }

    //метод заполняет поле "Когда привезти самокат" на форме создания заказа "Про аренду"
    public void setDateInput(String Date) {
        driver.findElement(dateInput).sendKeys(Date);
    }

    //метод выбирает "Срок аренды - сутки" на форме создания заказа "Про аренду"
    public void chooseTermOneDay() {
        driver.findElement(termInput).click();
        driver.findElement(termInputOneDay).click();
    }

    //метод выбирает "Срок аренды - двое суток" на форме создания заказа "Про аренду"
    public void chooseTermTwoDays() {
        driver.findElement(termInput).click();
        driver.findElement(termInputTwoDays).click();
    }

    //метод выбирает "Цвет - Черный жемчуг" на форме создания заказа "Про аренду"
    public void chooseBlackColour() {
        driver.findElement(colourBlackCheckbox).click();
    }

    //метод выбирает "Цвет - серая безысходность" на форме создания заказа "Про аренду"
    public void chooseGrayColour() {
        driver.findElement(colourGreyCheckbox).click();
    }

    //метод заполняет поле "Комментарий курьера" на форме создания заказа "Про аренду"
    public void setCommentInput(String Comment) {
        driver.findElement(commentInput).sendKeys(Comment);
    }

    //метод подтверждает создание заказа во всплывающем окне "Хотите оформить заказ?"
    public void clickToConfirmButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(confirmButton).click();
    }

    //шаг заполнения полей на форме "Про аренду" - черный цвет, сутки
    public void makeOrderBlackOneDay(String Date, String Comment) {
            setDateInput(Date);
            chooseBlackColour();
            chooseTermOneDay();
            setCommentInput(Comment);
            clickToOrderButton();
        }

    //шаг заполнения полей на форме "Про аренду" - серый цвет, двое суток
    public void makeOrderGrayTwoDays(String Date, String Comment) {
            setDateInput(Date);
            chooseGrayColour();
            chooseTermTwoDays();
            setCommentInput(Comment);
            clickToOrderButton();
        }

}
