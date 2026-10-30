public class ejercicio {
    public static void main(String[] args) { // Se agregó 'public'
        int cantidadClientes = Reutilizacion.ingresarEnteroMayorQue("por favor ingrese la cantidad de clientes que compraron el dia de hoy: ", 0);
        String sumaValores = calculoClientes (cantidadClientes);
        generarMensaje (sumaValores);
    }
    public static String calculoClientes(int cantidadClientes) {
        int contadorCliente = 1;
        int clientesPremium = 0;
        int clientesFrecuentes = 0;
        int clientesRegulares = 0;
        int clientesOcasionales = 0;
        String resultado = "";

        while (contadorCliente <= cantidadClientes) {
            int cantidadProductos = Reutilizacion.ingresarEnteroMayorQue("Ingrese la cantidad de productos del cliente " + contadorCliente + ": ", 0);
            int contadorProducto = 1;
            double totalCliente = 0;

            while (contadorProducto <= cantidadProductos) {
                double valorProducto = Reutilizacion.ingresarRealMayorQue("Ingrese el valor del producto #" + contadorProducto + ": ", 0.0);
                totalCliente += valorProducto;
                contadorProducto++;
            }
            if (totalCliente >= 200000) {
                clientesPremium++;
            } else if (totalCliente >= 100000 && totalCliente <= 199999) {
                clientesFrecuentes++;
            } else if (totalCliente >= 50000 && totalCliente <= 99999) {
                clientesRegulares++;
            } else {
                clientesOcasionales++;
            }
            contadorCliente++;
        }
        resultado = " Resumen de clientes por categoría: " +
                "\nCliente Premium: " + clientesPremium +
                "\nCliente Frecuente: " + clientesFrecuentes +
                "\nCliente Regular: " + clientesRegulares +
                "\nCliente Ocasional: " + clientesOcasionales;

        return resultado;
    }

    public static void generarMensaje (String sumaValores) {
        String mensaje = "" + sumaValores;
        System.out.println(mensaje);
    }
}