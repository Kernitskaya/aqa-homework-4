package ru.netology.selenium;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import utils.DateUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OrderCard {
    private String startUrl = "http://localhost:9999";
    private String validName = "Иван Тестеров";
    private String validPhone = "+79999999999";
    private String city = "Москва";

    @Test
    void testValidOrder() {
        open(startUrl);
        SelenideElement form = $("[id=root]");
        form.$("[placeholder='Город']").setValue(city);
        String futureDate = DateUtils.getAfterThreeDaysDate();
        form.$("[placeholder='Дата встречи']").setValue(futureDate);
        form.$("[name='name']").setValue(validName);
        form.$("[name='phone']").setValue(validPhone);
        form.$(".checkbox__box").click();
        form.$(withText("Забронировать")).click();

        $("[data-test-id=notification]").waitUntil(visible, 15000);
        $(".notification__content").shouldHave(text(String.format("Встреча успешно забронирована на %s", futureDate)));
    }
}
