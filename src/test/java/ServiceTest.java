import org.example.dto.UsuarioDTOInput;
import org.example.model.Login;
import org.example.model.Name;
import org.example.service.UsuarioService;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ServiceTest {
    @Test
    public void testeInsercao() {
        UsuarioService usuarioService = new UsuarioService();
        UsuarioDTOInput usuario = new UsuarioDTOInput();
        Name name = new Name();
        name.setTitle("Mr.");
        name.setFirst("Jhon");
        name.setLast("Doe");
        usuario.setName(name);
        Login login = new Login();
        login.setPassword("teste123");
        usuario.setLogin(login);
        usuario.setId(1);

        usuarioService.adicionar(usuario);

        assertEquals(1, usuarioService.listar().size());
    }
}
