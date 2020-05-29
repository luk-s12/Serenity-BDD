package CG.Steps;

import CG.PageObject.PaginaDeResultadosCG;
import CG.PageObject.PaginaPrincipalCG;
import net.thucydides.core.annotations.Step;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Usuario {

    private String componente;

    //Va a inyectar el nombre declarado del Steps
    private String actor;

    private PaginaPrincipalCG paginaPrincipalCG;
    private PaginaDeResultadosCG paginaDeResultadosCG;


    @Step("EL #actor ingreso a CG")
    public void ingresa() {
        paginaPrincipalCG.open();
    }

    @Step("El #actor cerro el pop de notificacion con el boton aceptar")
    public void cierraLaNotificacion() {
        paginaPrincipalCG.cerraPop();
    }

    @Step("El #actor busco en la caja el componente {0}")
    public void buscaElComponente(String palabraClave) {
        paginaPrincipalCG.ingresa(palabraClave);
        paginaPrincipalCG.busca();
    }

    @Step("El #actor esta sobre la busqueda de la {0} y obtuvo los 50 datos")
    public void obtieneLosDatos(String palabraClave) {
        List<String> datos = paginaDeResultadosCG.obteneLosDatos(palabraClave);

        //datos.forEach(System.out::println);
        //System.out.println(datos.stream().anyMatch(elemento -> "Mother MSI X570-A PRO AM4".equals(elemento)));

        assertThat(datos.size(), is(equalTo(50)));
    }


    @Step("El #actor comprueba la {0} si sigue igual a {1}")
    public void comparaPrecio(String componente, String precioEsperado) {
        String precio = paginaDeResultadosCG.getPrecio(componente);

        assertThat(precio, containsString(precioEsperado));


    }
}
