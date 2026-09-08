package org.example.scooterTest;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String surname;
    private final String address;
    private final String subway;
    private final String phoneNumber;
    private final String date;
    private final String rentalPeriod;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surname, String address, String subway, String phoneNumber, String date, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.subway = subway;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    @Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][]{{"Иван", "Иванов", "г. Москва, ул. Пушкина, д.10", "Театральная", "89151234567", "01.01.2050", "сутки", "чёрный жемчуг", "Не звонить в дверь"}, {"Ирина", "Авдеева", "проспект Маяковского 6", "Маяковская", "+79657654321", "10.10.2030", "двое суток", "серая безысходность", "Привезите чистый самокат"}};
    }

    @Test
    public void OrderPositiveTest() {
        this.driver = new FirefoxDriver();
        this.driver.get("https://qa-scooter.praktikum-services.ru");
        HomePageScooter objHomePage = new HomePageScooter(this.driver);
        objHomePage.clickHeaderOrderButton();
        OrderPageScooter objOrderPage = new OrderPageScooter(this.driver);
        objOrderPage.acceptCookieButtonClick();
        objOrderPage.setName(this.name);
        objOrderPage.setSurname(this.surname);
        objOrderPage.setAddress(this.address);
        objOrderPage.setSubway(this.subway);
        objOrderPage.setPhoneNumber(this.phoneNumber);
        objOrderPage.clickOrderNextButton();
        objOrderPage.setDate(this.date);
        objOrderPage.setRentalPeriod(this.rentalPeriod);
        objOrderPage.setColor(this.color);
        objOrderPage.setComment(this.comment);
        objOrderPage.clickOrderCreateButton();
        objOrderPage.clickOrderConfirmButton();
        objOrderPage.isPageOpen(objOrderPage.getConfirmHeader(), "Посмотреть статус");
    }

    @After
    public void teardown() {
        this.driver.quit();
    }
}
