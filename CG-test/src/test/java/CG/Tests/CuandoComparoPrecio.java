package CG.Tests;

import CG.Steps.Usuario;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static net.thucydides.core.annotations.ClearCookiesPolicy.BeforeEachTest;

@RunWith(SerenityRunner.class)
public class CuandoComparoPrecio {

    @Managed(driver="chrome", uniqueSession = true, clearCookies=BeforeEachTest)
    WebDriver driver;

    @Steps()
    Usuario usuario;

    @Test
    public void mantieneElPrecio(){
        usuario.ingresa();
        usuario.cierraLaNotificacion();
        usuario.buscaElComponente("Mother Asrock A320M-HDV R4.03 Ryzen M-ATX");
        usuario.comparaPrecio("Mother Asrock A320M-HDV R4.03 Ryzen M-ATX", "$5,430");
    }

}
