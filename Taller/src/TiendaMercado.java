import java.util.Scanner;
public class TiendaMercado {
    public static final int CLIENTES = 0;
    public static final int COMPRAS = 0;
    public static final double PRECIOS = 0.0;
    public static void main(String[] args) {
        int numClientes = Reutilizacion.ingresarEnteroMayorQue("Buenos dias querido usuario" +
                "\nCuantos fueron los clientes del dia de hoy: ", CLIENTES);
        String jornada = calcularJornada (numClientes);
        generarMensaje (jornada);
    }
    public static String calcularJornada (int numClientes){
        int cantidadCompras;
        double compraIndividual;
        String jornada = " ";
        int totalClientesPremium = 0;
        int totalClientesFrecuentes = 0;
        int totalClientesOcasionales = 0;
        int totalClientesRegulares = 0;
        for (int contadorClientes = 1; contadorClientes <= numClientes; contadorClientes++){
            cantidadCompras = Reutilizacion.ingresarEnteroMayorQue("Cuales fueron la cantidad de compras del cliente numero " + contadorClientes + ": ", COMPRAS);
            double totalIndividualCliente = 0.0;
            for (int contadorCompras = 1; contadorCompras <= cantidadCompras; contadorCompras++){
                compraIndividual = Reutilizacion.ingresarRealMayorQue("Cual es el valor de la compra numero " + contadorCompras + ": ", PRECIOS);
                totalIndividualCliente = totalIndividualCliente + compraIndividual;
            }
            if (totalIndividualCliente >= 200000){
                totalClientesPremium = totalClientesPremium + 1;
            }
            else if (totalIndividualCliente >= 100000 && totalIndividualCliente <= 199999){
                totalClientesFrecuentes = totalClientesFrecuentes + 1;
            }
            else if (totalIndividualCliente < 100000){
                if (totalIndividualCliente < 50000){
                    totalClientesOcasionales = totalClientesOcasionales + 1;
                }
                else if (totalIndividualCliente >= 50000 && totalIndividualCliente <= 99999){
                    totalClientesRegulares = totalClientesRegulares + 1;
                }
            }
        }
        jornada = "\nEl numero de Clientes Premium es: " + totalClientesPremium +
                "\nEl numero de Clientes Frecuentes es: " + totalClientesFrecuentes +
                "\nEl numero de Clientes Ocasionales es: " + totalClientesOcasionales +
                "\nEl numero de clientes Regulares es: " + totalClientesRegulares;
        return jornada;
    }
    public static void generarMensaje (String jornada){
        System.out.println(jornada);
    }
}