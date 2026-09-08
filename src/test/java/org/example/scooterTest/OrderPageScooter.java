package org.example.scooterTest;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPageScooter {
    private WebDriver driver;
    private By orderHeader = By.xpath(".//div[text()='Для кого самокат']");
    private By aboutOrderHeader = By.xpath(".//div[text()='Про аренду']");
    private By acceptCookieButton = By.xpath(".//button[text()='да все привыкли']");
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    private By surnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By subwayField = By.xpath(".//input[@placeholder='* Станция метро']");
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By orderNextButton = By.xpath(".//button[text()='Далее']");
    private By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By rentalPeriodField = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderCreateButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    private By orderConfirmButton = By.xpath(".//button[text()='Да']");
    private By confirmHeader = By.xpath(".//button[text()='Посмотреть статус']");

    public OrderPageScooter(WebDriver driver) {
        this.driver = driver;
    }

    public String getOrderHeader() {
        return this.driver.findElement(this.orderHeader).getText();
    }

    public String getConfirmHeader() {
        return this.driver.findElement(this.confirmHeader).getText();
    }

    public void isPageOpen(String headerText, String text) {
        MatcherAssert.assertThat(headerText, CoreMatchers.is(text));
    }

    public void acceptCookieButtonClick() {
        this.driver.findElement(this.acceptCookieButton).click();
    }

    public void setName(String name) {
        this.driver.findElement(this.nameField).sendKeys(new CharSequence[]{name});
    }

    public void setSurname(String surname) {
        this.driver.findElement(this.surnameField).sendKeys(new CharSequence[]{surname});
    }

    public void setAddress(String address) {
        this.driver.findElement(this.addressField).sendKeys(new CharSequence[]{address});
    }

    public void setSubway(String subway) {
        this.driver.findElement(this.subwayField).click();
        this.driver.findElement(By.xpath(".//div[text()='" + subway + "']")).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.driver.findElement(this.phoneNumberField).sendKeys(new CharSequence[]{phoneNumber});
    }

    public void clickOrderNextButton() {
        this.driver.findElement(this.orderNextButton).click();
    }

    public void setDate(String date) {
        this.driver.findElement(this.dateField).sendKeys(new CharSequence[]{date});
    }

    public void setRentalPeriod(String rentalPeriod) {
        this.driver.findElement(this.aboutOrderHeader).click();
        this.driver.findElement(this.rentalPeriodField).click();
        this.driver.findElement(By.xpath(".//div[text()='" + rentalPeriod + "']")).click();
    }

    public void setColor(String color) {
        this.driver.findElement(By.xpath(".//label[text()='" + color + "']")).click();
    }

    public void setComment(String comment) {
        this.driver.findElement(this.commentField).sendKeys(new CharSequence[]{comment});
    }

    public void clickOrderCreateButton() {
        this.driver.findElement(this.orderCreateButton).click();
    }

    public void clickOrderConfirmButton() {
        this.driver.findElement(this.orderConfirmButton).click();
    }
}
