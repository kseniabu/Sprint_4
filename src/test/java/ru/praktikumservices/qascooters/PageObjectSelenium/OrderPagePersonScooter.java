package ru.praktikumservices.qascooters.PageObjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPagePersonScooter {
    private WebDriver driver;

    //конструктор класса
    public OrderPagePersonScooter(WebDriver driver){
        this.driver = driver;
    }

    //локатор для поля "Имя" на форме создания заказа "Для кого самокат"
    private By nameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[1]/input");
    //локатор для поля "Фамилия" на форме создания заказа "Для кого самокат"
    private By surnameInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[2]/input");
    //локатор для поля "Адрес куда привезти заказ" на форме создания заказа "Для кого самокат"
    private By adressInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[3]/input");
    //локатор для поля "Станция метро" на форме создания заказа "Для кого самокат"
    private By metroInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/div/div/input");
    //локатор для поля "Телефон" на форме создания заказа "Для кого самокат"
    private By phoneInput = By.xpath(".//div[@class='Order_Form__17u6u']/div[5]/input");

    //локатор для селектора "Станция метро - Бульвар Рокоссовского"
    private By metroBulvarRocossovskogo = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/div/div[2]/ul/li[1]/button");
    //локатор для селектора "Станция метро - Черкизовская"
    private By metroCherkisovskaya = By.xpath(".//div[@class='Order_Form__17u6u']/div[4]/div/div[2]/ul/li[2]/button");

    //локатор для кнопки "Далее" на форме создания заказа "Для кого самокат"
    private By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //метод заполняет поле "Имя" на форме создания заказа "Для кого самокат"
    public void setNameInput(String Name) {
        driver.findElement(nameInput).sendKeys(Name);
    }

    //метод заполняет поле "Фамилия" на форме создания заказа "Для кого самокат"
    public void setSurnameInput(String Surname) {
        driver.findElement(surnameInput).sendKeys(Surname);
    }

    //метод заполняет поле "Адрес" на форме создания заказа "Для кого самокат"
    public void setAdressInput(String Adress) {
        driver.findElement(adressInput).sendKeys(Adress);
    }

    //метод выбирает станцию метро "Бульвар Рокоссовского" в селекторе "Станция метро" на форме создания заказа
    public void chooseMetroBulvarRocossovskogo() {
        driver.findElement(metroInput).click();
        driver.findElement(metroBulvarRocossovskogo).click();
    }

    //метод выбирает станцию метро "Черкизовская" в селекторе "Станция метро" на форме создания заказа
    public void chooseMetroCherkisovskaya () {
        driver.findElement(metroInput).click();
        driver.findElement(metroCherkisovskaya).click();
    }

    //метод заполняет поле "Телефон" на форме создания заказа "Для кого самокат"
    public void setPhoneInput(String Phone) {
        driver.findElement(phoneInput).sendKeys(Phone);
    }

    //метод кликает по кнопке "Далее" на форме создания заказа "Для кого самокат"
    public void clickToNextButton() {
        driver.findElement(nextButton).click();
    }

    //шаг заполнения полей на форме "Для кого самокат" - метро Черкизовская
    public void fillFieldsPersonOrderCherkisovskaya(String Name, String Surname, String Adress, String Phone){
        setNameInput(Name);
        setSurnameInput(Surname);
        setAdressInput(Adress);
        chooseMetroCherkisovskaya();
        setPhoneInput(Phone);
        clickToNextButton();
    }

    //шаг заполнения полей на форме "Для кого самокат" - метро Бульвар Рокоссовского
    public void fillFieldsPersonOrderBulvarRocossovskogo(String Name, String Surname, String Adress, String Phone){
        setNameInput(Name);
        setSurnameInput(Surname);
        setAdressInput(Adress);
        chooseMetroBulvarRocossovskogo();
        setPhoneInput(Phone);
        clickToNextButton();
    }


}


