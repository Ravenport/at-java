import org.example.dto.UsuarioDTOInput;
import org.example.service.UsuarioService;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class EndpointTest {
    @Test
    public void testeListagem() throws IOException {
        URL url = new URL("http://localhost:4567/usuarios");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

        conexao.setRequestMethod("GET");
        assertEquals(200, conexao.getResponseCode());
    }
}
