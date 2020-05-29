package CG.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class PaginaDeResultadosCG extends PageObject {

    /*
    @FindBy(css = ".clearfix h4.products__name")
    List<WebElementFacade> titulo;
    */

    public List<String> obteneLosDatos(String palabraClave) {
        /*return titulo.stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
        */
        return findAll("//h4[contains(@Class, 'products__name')]")
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public String getPrecio(String componente) {
        // el componente se va a estar inyectando en {0}
        return  findBy("//a[contains(text(),'{0}')]", componente)
                .then().findBy("//div[contains(@Class, 'products__inner')]")
                .then().getText();
    }
}
