package com.acme.envio_pedidos.model;

public class PedidoResponse {

    private EnviarPedidoRespuesta enviarPedidoRespuesta;

    public EnviarPedidoRespuesta getEnviarPedidoRespuesta() {
        return enviarPedidoRespuesta;
    }

    public void setEnviarPedidoRespuesta(EnviarPedidoRespuesta enviarPedidoRespuesta) {
        this.enviarPedidoRespuesta = enviarPedidoRespuesta;
    }

    public static class EnviarPedidoRespuesta {
        private String codigoEnvio;
        private String estado;

        public String getCodigoEnvio() {
            return codigoEnvio;
        }

        public void setCodigoEnvio(String codigoEnvio) {
            this.codigoEnvio = codigoEnvio;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }
    }
}
