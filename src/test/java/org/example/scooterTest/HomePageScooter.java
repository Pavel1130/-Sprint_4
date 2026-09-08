package org.example.scooterTest;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageScooter {
    private WebDriver driver;
    private By question1 = By.xpath(".//div[@class='accordion__item'][1]");
    private By question2 = By.xpath(".//div[@class='accordion__item'][2]");
    private By question3 = By.xpath(".//div[@class='accordion__item'][3]");
    private By question4 = By.xpath(".//div[@class='accordion__item'][4]");
    private By question5 = By.xpath(".//div[@class='accordion__item'][5]");
    private By question6 = By.xpath(".//div[@class='accordion__item'][6]");
    private By question7 = By.xpath(".//div[@class='accordion__item'][7]");
    private By question8 = By.xpath(".//div[@class='accordion__item'][8]");
    private By answer1 = By.id("accordion__panel-0");
    private By answer2 = By.id("accordion__panel-1");
    private By answer3 = By.id("accordion__panel-2");
    private By answer4 = By.id("accordion__panel-3");
    private By answer5 = By.id("accordion__panel-4");
    private By answer6 = By.id("accordion__panel-5");
    private By answer7 = By.id("accordion__panel-6");
    private By answer8 = By.id("accordion__panel-7");
    private By headerOrderButton = By.xpath(".//button[text()='Заказать'][1]");
    private By pageOrderButton = By.xpath(".//div[contains(@class, 'Home_FinishButton')]/button");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public void clickQuestion1() {
        this.driver.findElement(this.question1).click();
    }

    public void clickQuestion2() {
        this.driver.findElement(this.question2).click();
    }

    public void clickQuestion3() {
        this.driver.findElement(this.question3).click();
    }

    public void clickQuestion4() {
        this.driver.findElement(this.question4).click();
    }

    public void clickQuestion5() {
        this.driver.findElement(this.question5).click();
    }

    public void clickQuestion6() {
        this.driver.findElement(this.question6).click();
    }

    public void clickQuestion7() {
        this.driver.findElement(this.question7).click();
    }

    public void clickQuestion8() {
        this.driver.findElement(this.question8).click();
    }

    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, CoreMatchers.is(text));
    }

    public String getAnswer1() {
        return this.driver.findElement(this.answer1).getText();
    }

    public String getAnswer2() {
        return this.driver.findElement(this.answer2).getText();
    }

    public String getAnswer3() {
        return this.driver.findElement(this.answer3).getText();
    }

    public String getAnswer4() {
        return this.driver.findElement(this.answer4).getText();
    }

    public String getAnswer5() {
        return this.driver.findElement(this.answer5).getText();
    }

    public String getAnswer6() {
        return this.driver.findElement(this.answer6).getText();
    }

    public String getAnswer7() {
        return this.driver.findElement(this.answer7).getText();
    }

    public String getAnswer8() {
        return this.driver.findElement(this.answer8).getText();
    }

    public void clickHeaderOrderButton() {
        this.driver.findElement(this.headerOrderButton).click();
    }

    public void clickPageOrderButton() {
        WebElement bigButton = this.driver.findElement(this.pageOrderButton);
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{bigButton});
        this.driver.findElement(this.pageOrderButton).click();
    }
}
