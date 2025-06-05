package com.acme.envio_pedidos.controller;

import com.acme.envio_pedidos.model.PedidoRequest;
import com.acme.envio_pedidos.model.PedidoResponse;
import com.acme.envio_pedidos.soap.XmlBuilder;
import com.acme.envio_pedidos.soap.XmlParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @PostMapping
    public PedidoResponse enviarPedido(@RequestBody PedidoRequest request) {
        // 1. Convertir PedidoRequest a XML
        String xmlRequest = XmlBuilder.crearXmlDesdeJson(request);

        // 2. Enviar XML a endpoint externo
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);

        HttpEntity<String> entity = new HttpEntity<>(xmlRequest, headers);
        String url = "https://run.mocky.io/v3/5347e0c0-155f-4961-8a7a-4293a6cabd13";
        ResponseEntity<String> respuesta = restTemplate.postForEntity(url, entity, String.class);

        // 3. Convertir respuesta XML a JSON
        return XmlParser.xmlToJsonResponse(respuesta.getBody());
    }
}
