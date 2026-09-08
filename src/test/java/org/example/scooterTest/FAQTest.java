package org.example.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FAQTest {
    private WebDriver driver;

    @Test
    public void FAQCorrectAnswerText() {
        this.driver = new ChromeDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru");
        WebElement tableFAQ = this.driver.findElement(By.xpath(".//div[@class='accordion']"));
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{tableFAQ});
        HomePageScooter objHomePage = new HomePageScooter(this.driver);
        objHomePage.clickQuestion1();
        objHomePage.isCorrectText(objHomePage.getAnswer1(), "Сутки — 400 рублей. Оплата курьеру — наличными или картой.");
        objHomePage.clickQuestion2();
        objHomePage.isCorrectText(objHomePage.getAnswer2(), "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.");
        objHomePage.clickQuestion3();
        objHomePage.isCorrectText(objHomePage.getAnswer3(), "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.");
        objHomePage.clickQuestion4();
        objHomePage.isCorrectText(objHomePage.getAnswer4(), "Только начиная с завтрашнего дня. Но скоро станем расторопнее.");
        objHomePage.clickQuestion5();
        objHomePage.isCorrectText(objHomePage.getAnswer5(), "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.");
        objHomePage.clickQuestion6();
        objHomePage.isCorrectText(objHomePage.getAnswer6(), "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.");
        objHomePage.clickQuestion7();
        objHomePage.isCorrectText(objHomePage.getAnswer7(), "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
        objHomePage.clickQuestion8();
        objHomePage.isCorrectText(objHomePage.getAnswer8(), "Да, обязательно. Всем самокатов! И Москве, и Московской области.");
    }

    @After
    public void teardown() {
        this.driver.quit();
    }
}
