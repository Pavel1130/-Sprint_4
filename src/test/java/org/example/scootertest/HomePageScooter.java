package org.example.scootertest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageScooter {
    private final WebDriver driver;

    private static final By ACCORDION_ITEM = By.xpath(".//div[@class='accordion__item']");
    private static final By FAQ_QUESTION = By.xpath(".//div[@class='accordion__heading']");
    private static final By FAQ_ANSWER = By.xpath(".//div[@class='accordion__panel']");

    private static final By HEADER_ORDER_BUTTON =
            By.xpath("//div[contains(@class, 'Header_Nav')]//button[text()='Заказать']");

    private static final By PAGE_ORDER_BUTTON =
            By.xpath("//div[contains(@class, 'Home_FinishButton')]//button[text()='Заказать']");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://qa-scooter.praktikum-services.ru");
    }

    public void scrollToFAQ() {
        WebElement accordion = driver.findElement(ACCORDION_ITEM);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", accordion);
    }

    public void clickQuestion(int index) {
        List<WebElement> questions = driver.findElements(FAQ_QUESTION);
        if (index < 0 || index >= questions.size()) {
            throw new IllegalArgumentException("Invalid question index: " + index);
        }
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(questions.get(index)))
                .click();
    }

    public String getAnswerText(int index) {
        List<WebElement> answers = driver.findElements(FAQ_ANSWER);
        if (index < 0 || index >= answers.size()) {
            throw new IllegalArgumentException("Invalid answer index: " + index);
        }
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(answers.get(index)))
                .getText();
    }

    public void clickHeaderOrderButton() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(HEADER_ORDER_BUTTON))
                .click();
    }

    public void clickPageOrderButton() {
        WebElement button = driver.findElement(PAGE_ORDER_BUTTON);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(PAGE_ORDER_BUTTON))
                .click();
    }
}
