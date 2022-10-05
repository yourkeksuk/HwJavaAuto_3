import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {


    @Test
    void testForm(){

        open("http://localhost:9999");
        SelenideElement form = $("[form.form_size_m.form_theme_alfa-on-white]");
        form.$("[data-test-id=name]").setValue("Пупкин Василий");
        form.$("[data-test-id=phone]").setValue("+79999999999");
        form.$("[data-test-id=agreement]").click();
        form.$("[button__content]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }

}