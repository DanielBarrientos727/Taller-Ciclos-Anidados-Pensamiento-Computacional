public class Tienda {
    public static void main(String[] args) {

        int cantidadClientes = Reutilizacion.ingresarEntero(
                "Ingrese la cantidad de clientes: ");
        String mensaje = procesarDatos(cantidadClientes);

        generarMensaje(mensaje);
    }

    public static String procesarDatos(int cantidadClientes) {
        int contadorCliente = 1;
        int contadorPremium = 0;
        int contadorFrecuente = 0;
        int contadorRegular = 0;
        int contadorOcasional = 0;
        String resultado = "";

        while (contadorCliente <= cantidadClientes) {

            int cantidadProductos = Reutilizacion.ingresarEntero(
                    "Ingrese la cantidad de productos del cliente "
                            + contadorCliente + ": ");

            int contadorProducto = 1;
            double totalCompra = 0;

            while (contadorProducto <= cantidadProductos) {

                double valor = Reutilizacion.ingresarRealD(
                        "Ingrese el valor del producto #"
                                + contadorProducto + ": ");

                totalCompra += valor;
                contadorProducto++;
            }

            resultado += "Cliente " + contadorCliente
                    + " total de compra: " + totalCompra + "\n";

            if (totalCompra >= 200000) {
                resultado += "Categoria: Cliente Premium\n";
                contadorPremium++;

            } else if (totalCompra >= 100000) {
                resultado += "Categoria: Cliente Frecuente\n";
                contadorFrecuente++;

            } else if (totalCompra >= 50000) {
                resultado += "Categoria: Cliente Regular\n";
                contadorRegular++;

            } else {
                resultado += "Categoria: Cliente Ocasional\n";
                contadorOcasional++;
            }

            contadorCliente++;
        }

        resultado += "\nCantidad de clientes por categoria:\n";
        resultado += "Premium: " + contadorPremium + "\n";
        resultado += "Frecuentes: " + contadorFrecuente + "\n";
        resultado += "Regulares: " + contadorRegular + "\n";
        resultado += "Ocasionales: " + contadorOcasional;
        return resultado;
    }
    public static void generarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}