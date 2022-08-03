package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.*;

public class ShouldFindExampleOfJUnit5Code {

    @Test
    void shouldFindSelenideAsRepository(){
        //открыть страницу githab.com
        open("https://github.com");
        // ввести в поле поиска selenide и нажать Enter
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter();
        //нажать на линк от первого результата поиска
        $$("ul.repo-list li").first().$("a").click();
        // перецйти в wiki
        $("#wiki-tab").click();
        // проверить наличие  Soft assertions в списке
        $("#wiki-body").shouldHave(text("Soft assertions"));
        // открыть страницу SoftAssertions
        $(byLinkText("Soft assertions")).click();
        // проверить, что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5"));
    }
}
