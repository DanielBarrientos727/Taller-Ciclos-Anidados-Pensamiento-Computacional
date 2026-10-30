public class taller2 {

    // Constantes
    public static final int CLIENTES = 0;
    public static final int PRODUCTOS = 0;
    public static final double PRECIOS = 0.0;

    public static void main(String[] args) {

        int cantidadClientes = Reutilizacion.ingresarEnteroMayorQue(
                "¡MUY BUENOS DÍAS, SEÑOR CLIENTE! :D\n"
                        + "Por favor, digite cuántos clientes ingresaron "
                        + "el día de hoy a la tienda => ",
                CLIENTES
        );

        String mensaje = procesarDatos(cantidadClientes);
        generarMensaje(mensaje);
    }

    public static String procesarDatos(int cantidadClientes) {

        // Contadores
        int contadorCliente = 1;
        int premium = 0;
        int frecuente = 0;
        int regular = 0;
        int ocasional = 0;

        String resultado = "";

        // Pues damos el recorrido y ya
        while (contadorCliente <= cantidadClientes) {

            int cantidadProductos = Reutilizacion.ingresarEnteroMayorQue(
                    "Por favor, ingrese la cantidad de productos del cliente "
                            + contadorCliente + ": ",
                    PRODUCTOS
            );

            int contadorProducto = 1;
            double totalCompra = 0;

            // Pasamos por los productos de los clientes
            while (contadorProducto <= cantidadProductos) {

                double precio = Reutilizacion.ingresarRealMayorQue(
                        "Por favor, ingrese el precio del producto "
                                + contadorProducto + ": ",
                        PRECIOS
                );

                totalCompra += precio;
                contadorProducto++;
            }

            // Clasificamos a los clientes
            if (totalCompra >= 200000) {

                resultado += "Categoría: Cliente Premium\n";
                premium++;

            } else if (totalCompra >= 100000) {

                resultado += "Categoría: Cliente Frecuente\n";
                frecuente++;

            } else if (totalCompra >= 50000) {

                resultado += "Categoría: Cliente Regular\n";
                regular++;

            } else {

                resultado += "Categoría: Cliente Ocasional\n";
                ocasional++;
            }

            resultado += "Cliente " + contadorCliente
                    + " - Total de compra: $" + totalCompra + "\n\n";

            contadorCliente++;
        }

        // Y damos un pequeño resumen
        resultado += "Clientes Premium: " + premium + "\n";
        resultado += "Clientes Frecuentes: " + frecuente + "\n";
        resultado += "Clientes Regulares: " + regular + "\n";
        resultado += "Clientes Ocasionales: " + ocasional;

        return resultado;
    }

    public static void generarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}