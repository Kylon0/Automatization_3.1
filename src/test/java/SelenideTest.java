import org.junit.jupiter.api.Test;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTest {

    @Test
    void shouldSubmitRequest() {
        open("http://localhost:7777");
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=name] input").setValue("Иванов Иван");
        form.$("[data-test-id=phone] input").setValue("+79533556677");
        form.$("[data-test-id=agreement]").click();
        form.$("[type=button]").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

}
