package CG.PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://compragamer.com/")
public class PaginaPrincipalCG extends PageObject {

    @FindBy(css = "#aceptarNotificacion")
    WebElementFacade pop;

    @FindBy(css = "#searchQuery")
    WebElementFacade cajaDeBusqueda;

    @FindBy(css = "#botonBusqueda")
    WebElementFacade botonDeBusqueda;


    public void cerraPop() {
        pop.click();
    }

    public void ingresa(String palabraClave) {
        cajaDeBusqueda.type(palabraClave);
    }

    public void busca() {
        botonDeBusqueda.click();
    }


}
