package ar.com.grupoesfera.csd.pois.aceptacion.pasos;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.javacrumbs.jsonunit.core.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static net.javacrumbs.jsonunit.spring.JsonUnitResultMatchers.json;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PedidosHTTPPasos extends ConfiguracionContexto{

    @Autowired
    private WebApplicationContext contexto;

    private MockMvc mockMvc;
    private ResultActions resultado;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(contexto)
                .build();
    }

    @When("el cliente hace un GET a {string}")
    public void elClienteHaceUnGETA(String ruta) throws Exception {
        resultado = mockMvc.perform(get(ruta));
    }

    @Then("recibe la respuesta con codigo de estado {int} y contenido")
    public void recibeLaRespuestaConCodigoDeEstadoYContenido(int codigoDeEstado, String respuesta) throws Exception {
        resultado.andExpect(status().is(codigoDeEstado))
                .andExpect(json()
                        .when(Option.IGNORING_ARRAY_ORDER)
                        .isEqualTo(respuesta)
                );
    }
}
