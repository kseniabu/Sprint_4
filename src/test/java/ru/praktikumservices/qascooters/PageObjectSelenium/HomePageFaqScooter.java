package ru.praktikumservices.qascooters.PageObjectSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageFaqScooter {
    private WebDriver driver;

    //конструктор класса
    public HomePageFaqScooter(WebDriver driver){
        this.driver = driver;
    }

    //локатор для кнопки принятия куки
    private By acceptCookieButton = By.className("App_CookieButton__3cvqF");

    //локатор для заголовка раздела FAQ
    private By titleOfFaqSection = By.xpath(".//div[@class='Home_FourPart__1uthg']/div[@class='Home_SubHeader__zwi_E']");

    //локатор для первого вопроса раздела FAQ
    private By firstQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[1]/div/div[@class='accordion__button']");
    //локатор для второго вопроса раздела FAQ
    private By secondQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[2]/div/div[@class='accordion__button']");
    //локатор для третьего вопроса раздела FAQ
    private By thirdQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[3]/div/div[@class='accordion__button']");
    //локатор для четвертого вопроса раздела FAQ
    private By forthQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[4]/div/div[@class='accordion__button']");
    //локатор для пятого вопроса раздела FAQ
    private By fifthQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[5]/div/div[@class='accordion__button']");
    //локатор для шестого вопроса раздела FAQ
    private By sixthQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[6]/div/div[@class='accordion__button']");
    //локатор для седьмого вопроса раздела FAQ
    private By seventhQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[7]/div/div[@class='accordion__button']");
    //локатор для восьмого вопроса раздела FAQ
    private By eighthQuestionOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[8]/div/div[@class='accordion__button']");

    //локатор для первого ответа раздела FAQ
    private By firstAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[1]/div[2]/p");
    //локатор для второго ответа раздела FAQ
    private By secondAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[2]/div[2]/p");
    //локатор для третьего ответа раздела FAQ
    private By thirdAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[3]/div[2]/p");
    //локатор для четвертого ответа раздела FAQ
    private By forthAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[4]/div[2]/p");
    //локатор для пятого ответа раздела FAQ
    private By fifthAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[5]/div[2]/p");
    //локатор для шестого ответа раздела FAQ
    private By sixthAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[6]/div[2]/p");
    //локатор для седьмого ответа раздела FAQ
    private By seventhAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[7]/div[2]/p");
    //локатор для восьмого ответа раздела FAQ
    private By eighthAnswerOfFaq = By.xpath(".//div[@class='Home_FAQ__3uVm4']/div/div[8]/div[2]/p");

    //метод принимает куки
    public void clickToAcceptCookie() {
        driver.findElement(acceptCookieButton).click();
    }

    //метод делает скролл до загаловка раздела FAQ
    public void scrollToHeaderOfFaq() {
        WebElement element = driver.findElement(titleOfFaqSection);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //метод получения ответа на первый вопрос
    public String getFirstQuestionOfFaq() {
        driver.findElement(firstQuestionOfFaq).click();
        return driver.findElement(firstAnswerOfFaq).getText();
    }

    //метод получения ответа на второй вопрос
    public String getSecondQuestionOfFaq() {
        driver.findElement(secondQuestionOfFaq).click();
        return driver.findElement(secondAnswerOfFaq).getText();
    }

    //метод получения ответа на третий вопрос
    public String getThirdQuestionOfFaq() {
        driver.findElement(thirdQuestionOfFaq).click();
        return driver.findElement(thirdAnswerOfFaq).getText();
    }

    //метод получения ответа на четвертый вопрос
    public String getForthQuestionOfFaq() {
        driver.findElement(forthQuestionOfFaq).click();
        return driver.findElement(forthAnswerOfFaq).getText();
    }

    //метод получения ответа на пятый вопрос
    public String getFifthQuestionOfFaq() {
        driver.findElement(fifthQuestionOfFaq).click();
        return driver.findElement(fifthAnswerOfFaq).getText();
    }

    //метод получения ответа на шестой вопрос
    public String getSixthQuestionOfFaq() {
        driver.findElement(sixthQuestionOfFaq).click();
        return driver.findElement(sixthAnswerOfFaq).getText();
    }

    //метод получения ответа на седьмой вопрос
    public String getSeventhQuestionOfFaq() {
        driver.findElement(seventhQuestionOfFaq).click();
        return driver.findElement(seventhAnswerOfFaq).getText();
    }

    //метод получения ответа на восьмой вопрос
    public String getEightQuestionOfFaq() {
        driver.findElement(eighthQuestionOfFaq).click();
        return driver.findElement(eighthAnswerOfFaq).getText();
    }

    //метод для получения ожидаемого ответа на первый вопрос
    public String getFirstExpectedAnswer() {
        return "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    }

    //метод для получения ожидаемого ответа на второй вопрос
    public String getSecondExpectedAnswer() {
        return "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    }

    //метод для получения ожидаемого ответа на третий вопрос
    public String getThirdExpectedAnswer() {
        return "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    }

    //метод для получения ожидаемого ответа на четвертый вопрос
    public String getForthExpectedAnswer() {
        return "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    }

    //метод для получения ожидаемого ответа на пятый вопрос
    public String getFifthExpectedAnswer() {
        return "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    }

    //метод для получения ожидаемого ответа на шестой вопрос
    public String getSixthExpectedAnswer() {
        return "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    }

    //метод для получения ожидаемого ответа на седьмой вопрос
    public String getSeventhExpectedAnswer() {
        return "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    }

    //метод для получения ожидаемого ответа на восьмой вопрос
    public String getEightExpectedAnswer() {
        return "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    }

}
