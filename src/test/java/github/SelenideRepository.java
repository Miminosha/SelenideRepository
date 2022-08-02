package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepository {

    @Test
    void shouldFindSelenideAsRepository(){
        //открыть страницу githab.com
        open("https://github.com");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        //check: в заголовке selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
    }
}
