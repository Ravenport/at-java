package org.example.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.UsuarioDTOInput;
import org.example.dto.UsuarioDTOOutput;
import org.example.service.UsuarioService;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.delete;
import static spark.Spark.put;

public class UsuarioController {
    private UsuarioService service = new UsuarioService();
    ObjectMapper objectMapper = new ObjectMapper();

    public void respostasRequisicoes() {
        get("/usuarios", (request, response) -> {
            response.type("application/json");
            response.status(200);

            String json = objectMapper.writeValueAsString(service.listar());
            return json;
        });

        get("/usuario/:id", (request, response) -> {
            response.type("application/json");
            response.status(200);

            Integer id = Integer.valueOf(request.params("id"));

            String json = objectMapper.writeValueAsString(service.buscar(id));
            return json;
        });

        put("/usuario/:id", (request, response) -> {
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(request.body(), UsuarioDTOInput.class);

            Integer id = Integer.valueOf(request.params("id"));
            service.alterar(usuarioDTOInput, id);

            response.type("application/json");
            response.status(201);
            return "Produto alterado com sucesso.";
        });

        post("/usuario", (request, response) -> {
            UsuarioDTOInput usuarioDTOInput = objectMapper.readValue(request.body(), UsuarioDTOInput.class);
            service.adicionar(usuarioDTOInput);
            response.type("application/json");
            response.status(201);
            return "Produto inserido com sucesso.";
        });

        delete("/usuarios/:id", (request, response) -> {
            response.type("application/json");
            response.status(204);

            Integer id = Integer.valueOf(request.params("id"));

            service.excluir(id);
            return "Produto excluido com sucesso!!";
        });
    }
}
