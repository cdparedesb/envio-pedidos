package com.acme.envio_pedidos.soap;

import com.acme.envio_pedidos.model.PedidoRequest;

public class XmlBuilder {

    public static String crearXmlDesdeJson(PedidoRequest p) {
        return """
            <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                              xmlns:env="http://WSDLs/EnvioPedidos/EnvioPedidosAcme">
              <soapenv:Header/>
              <soapenv:Body>
                <env:EnvioPedidoAcme>
                  <pedido>%s</pedido>
                  <Cantidad>%d</Cantidad>
                  <EAN>%s</EAN>
                  <Producto>%s</Producto>
                  <Cedula>%s</Cedula>
                  <Direccion>%s</Direccion>
                </env:EnvioPedidoAcme>
              </soapenv:Body>
            </soapenv:Envelope>
            """.formatted(
                p.getNumPedido(),
                p.getCantidadPedido(),
                p.getCodigoEAN(),
                p.getNombreProducto(),
                p.getNumDocumento(),
                p.getDireccion()
            );
    }
}
