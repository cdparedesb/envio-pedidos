package com.acme.envio_pedidos.soap;

import com.acme.envio_pedidos.model.PedidoResponse;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class XmlParser {

    public static PedidoResponse xmlToJsonResponse(String xml) {
        PedidoResponse response = new PedidoResponse();
        PedidoResponse.EnviarPedidoRespuesta datos = new PedidoResponse.EnviarPedidoRespuesta();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new java.io.ByteArrayInputStream(xml.getBytes()));

            Node codigoNode = doc.getElementsByTagName("Codigo").item(0);
            Node mensajeNode = doc.getElementsByTagName("Mensaje").item(0);

            if (codigoNode != null) {
                datos.setCodigoEnvio(codigoNode.getTextContent());
            }
            if (mensajeNode != null) {
                datos.setEstado(mensajeNode.getTextContent());
            }

            response.setEnviarPedidoRespuesta(datos);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }
}
