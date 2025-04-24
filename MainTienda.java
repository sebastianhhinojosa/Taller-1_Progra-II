// NOMBRES: SEBASTIAN HINOJOSA Y ANDY SILVA

public class MainTienda {
    public static void main(String[] args) {
        AppStore appStore = new AppStore();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean salir = true;

        while (salir) {
            System.out.println("\nTienda - Menú Principal");
            System.out.println("1.- Información de cada juego");
            System.out.println("2.- Comprar licencias de un juego");
            System.out.println("3.- Vender licencias de un juego");
            System.out.println("4.- Ver juego más vendido");
            System.out.println("5.- Calcular descuento por volumen");
            System.out.println("6. Ver juegos a comprar según política de porcentaje");
            System.out.println("7. Ver juegos a comprar según política de categoría");
            System.out.println("8.- Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nInformación de cada juego");
                    Juego[] juegos = {
                            appStore.darJuego1(), appStore.darJuego2(),
                            appStore.darJuego3(), appStore.darJuego4()
                    };
                    for (Juego j : juegos) {
                        System.out.println("Nombre: " + j.darNombre() +
                                ", Categoría: " + j.darCategoria() +
                                ", Precio: $" + j.darPrecio() +
                                ", Tamaño: " + j.darTamanio() + " KB" +
                                ", Licencias disponibles: " + j.darCantidadLicencias() +
                                ", Vendidas: " + j.darCantidadVendidas());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del juego: ");
                    String nombreCompra = scanner.nextLine();
                    Juego juegoCompra = appStore.buscarJuego(nombreCompra);
                    if (juegoCompra != null) {
                        System.out.println("Licencias disponibles actualmente: " + juegoCompra.darCantidadLicencias());
                        System.out.print("Cantidad de licencias a comprar: ");
                        int cantidadCompra = scanner.nextInt();
                        scanner.nextLine();

                        if ((cantidadCompra > juegoCompra.darCantidadLicencias()) || (cantidadCompra <= 0) ){
                            System.out.print("\nERROR: Cantidad ingresada no valida\n");
                        }else {
                            appStore.comprarLicenciasJuego(nombreCompra, cantidadCompra);
                            System.out.println("Compra realizada.");
                        }

                    } else {
                        System.out.println("El juego no fue encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del juego: ");
                    String nombreVenta = scanner.nextLine();
                    Juego juegoVenta = appStore.buscarJuego(nombreVenta);
                    if (juegoVenta != null) {
                        System.out.println("Licencias disponibles actualmente: " + juegoVenta.darCantidadLicencias());
                        System.out.print("Cantidad de licencias a vender: ");
                        int cantidadVenta = scanner.nextInt();
                        scanner.nextLine();
                        boolean exito = appStore.venderLicenciasJuego(nombreVenta, cantidadVenta);
                        if (exito) {
                            System.out.println("Venta realizada con éxito.");
                        } else {
                            System.out.println("No se pudo realizar la venta (stock insuficiente).");
                        }
                    } else {
                        System.out.println("El juego no fue encontrado.");
                    }
                    break;

                case 4:
                    String masVendido = appStore.darJuegoMasVendido();
                    System.out.println("Juego más vendido: " + masVendido);
                    break;

                case 5:
                    System.out.println("Ingrese la cantidad que desea comprar de cada juego:");
                    System.out.print("Candy Crush: ");
                    int c1 = scanner.nextInt();
                    System.out.print("Flow: ");
                    int c2 = scanner.nextInt();
                    System.out.print("FIFA: ");
                    int c3 = scanner.nextInt();
                    System.out.print("Clash of Clans: ");
                    int c4 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\n" + appStore.calcularVentaPorVolumen(c1, c2, c3, c4));
                    break;

                case 8:
                    salir = false;
                    System.out.println("Saliendo del programa...");
                    break;

                case 6:
                    System.out.println(appStore.metodo1());
                    break;
                case 7:
                    System.out.println(appStore.metodo2());
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}


