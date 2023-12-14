import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.UsuarioDTOInput;
import org.example.service.UsuarioService;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class InsercaoApiTest {
    @Test
    public void testeInsercao() throws IOException {
        URL url1 = new URL("https://randomuser.me/api/");
        HttpURLConnection conexao1 = (HttpURLConnection) url1.openConnection();
        conexao1.setRequestMethod("GET");
        int codigo = conexao1.getResponseCode();

        if(codigo == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(conexao1.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            } in .close();

            ObjectMapper objectMapper = new ObjectMapper();
            UsuarioDTOInput usuario = objectMapper.readValue(response.toString(), UsuarioDTOInput.class);
            String json = objectMapper.writeValueAsString(usuario);

            URL url = new URL("http://localhost:4567/usuario");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setDoOutput(true);
            conexao.getOutputStream().write(json.getBytes());

            assertEquals(201, conexao.getResponseCode());
        }
    }
}
