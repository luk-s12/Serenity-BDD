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
public class CuandoBuscamos {


    @Managed(driver="chrome", clearCookies=BeforeEachTest)
    WebDriver driver;

    @Steps()
    Usuario usuario;

    private final String COMPONENTE = "Mother";

    @Test
    public void mother(){
        usuario.ingresa();
        usuario.cierraLaNotificacion();
        usuario.buscaElComponente(COMPONENTE);
        usuario.obtieneLosDatos(COMPONENTE);
    }


}
