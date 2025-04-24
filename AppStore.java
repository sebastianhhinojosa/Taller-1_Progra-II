/**
 * Tienda virtual de juegos.
 */
public class AppStore
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------



    public final static double PORCENTAJE_MINIMO = 0.25;
    public final static int LIMITE_DEPORTE = 10;
    public final static int LIMITE_ACCION = 15;



    /**
     * Representa la cantidad m nima de licencias de juegos de rompecabezas para la primera opci n de descuento.
     */
    public final static int CANT_MIN_ROMPECABEZAS = 25;

    /**
     * Representa la cantidad m nima de licencias de juegos de deporte para la segunda opci n de descuento.
     */
    public final static int CANT_MIN_DEPORTE = 20;

    /**
     * Representa la cantidad m nima de licencias de juegos de acci n para la segunda opci n de descuento.
     */
    public final static int CANT_MIN_ACCION = 12;

    /**
     * Representa el valor del primer descuento.
     */
    public final static double DESCUENTO_1 = 0.20;

    /**
     * Representa el valor del segundo descuento.
     */
    public final static double DESCUENTO_2 = 0.15;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Juego 1 de la AppStore.
     */
    private Juego juego1;

    /**
     * Juego 2 de la AppStore.
     */
    private Juego juego2;

    /**
     * Juego 3 de la AppStore.
     */
    private Juego juego3;

    /**
     * Juego 4 de la AppStore.
     */
    private Juego juego4;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la AppStore con sus 4 juegos. <br>
     * <b>post: </b> Los juegos fueron inicializados con los siguientes valores: <br>
     * Juego1 - Nombre: Candy Crush, Categor a: Rompecabezas, Precio: 3000, Tama o (en KB): 300, Cantidad de licencias: 50. <br>
     * Juego2 - Nombre: Flow, Categor a: Rompecabezas, Precio: 5500, Tama o (en KB): 250, Cantidad de licencias: 15 <br>
     * Juego3 - Nombre: FIFA, Categor a: Deporte, Precio: 7500, Tama o (en KB): 850, Cantidad de licencias: 80 <br>
     * Juego4 - Nombre: Clash of Clans, Categor a: Acci n, Precio: 2000, Tama o (en KB): 1000, Cantidad de licencias: 36 <br>
     */
    public AppStore( )
    {
        juego1 = new Juego( "Candy Crush", Juego.Categoria.ROMPECABEZAS, 3000, 300, 50 );
        juego2 = new Juego( "Flow", Juego.Categoria.ROMPECABEZAS, 5500, 250, 15 );
        juego3 = new Juego( "FIFA", Juego.Categoria.DEPORTE, 7500, 850, 80 );
        juego4 = new Juego( "Clash of Clans", Juego.Categoria.ACCION, 2000, 1000, 36 );
    }

    // -----------------------------------------------------------------
    // M todos
    // -----------------------------------------------------------------

    /**
     * Retorna el juego 1.
     * @return Juego 1.
     */
    public Juego darJuego1( )
    {
        return juego1;
    }

    /**
     * Retorna el juego 2.
     * @return Juego 2.
     */
    public Juego darJuego2( )
    {
        return juego2;
    }

    /**
     * Retorna el juego 2.
     * @return Juego 3.
     */
    public Juego darJuego3( )
    {
        return juego3;
    }

    /**
     * Retorna el juego 4.
     * @return Juego 4.
     */
    public Juego darJuego4( )
    {
        return juego4;
    }

    /**
     * Busca un juego dado su nombre.
     * @param pNombreJuego Nombre del juego. pNombreJuego != null && pNombreJuego != "".
     * @return Juego con el nombre dado, null en caso de no encontrarlo.
     */
    public Juego buscarJuego( String pNombreJuego )
    {
        Juego buscado = null;
        if( pNombreJuego.equals( juego1.darNombre( ) ) )
        {
            buscado = juego1;
        }
        else if( pNombreJuego.equals( juego2.darNombre( ) ) )
        {
            buscado = juego2;
        }
        else if( pNombreJuego.equals( juego3.darNombre( ) ) )
        {
            buscado = juego3;
        }
        else if( pNombreJuego.equals( juego4.darNombre( ) ) )
        {
            buscado = juego4;
        }

        return buscado;
    }

    /**
     * Registra la venta de licencias de un juego dado su nombre. <br>
     * <b>post: </b> Aument  la cantidad de licencias vendidas del juego. <br>
     * Si la cantidad de juegos a vender era mayor que la cantidad de existencias del juego, la venta no se realiz .
     * @param pNombreJuego Nombre del juego a vender. pNombreJuego != null && pNombreJuego != "".
     * @param pCantidad Cantidad de licencias que se van a vender. pCantidad > 0.
     * @return Retorna true si logr  realizar la venta, false de lo contrario.
     */
    public boolean venderLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        boolean respuesta = false;
        if( buscarJuego( pNombreJuego ) != null )
        {
            respuesta = buscarJuego( pNombreJuego ).venderLicencias( pCantidad );
        }
        return respuesta;
    }

    /**
     * Registra la compra de licencias de un juego dado su nombre. <br>
     * <b>post: </b> Aument  la cantidad de licencias del juego.
     * @param pNombreJuego Nombre del juego a comprar. pNombreJuego != null && pNombreJuego != "".
     * @param pCantidad Cantidad de licencias que se van a comprar. pCantidad > 0.
     */
    public void comprarLicenciasJuego( String pNombreJuego, int pCantidad )
    {
        if( buscarJuego( pNombreJuego ) != null )
        {
            buscarJuego( pNombreJuego ).comprarLicencias( pCantidad );
        }
    }

    /**
     * Retorna el nombre del juego con m s unidades vendidas. <br>
     * En caso de que se haya vendido la misma cantidad de licencias para varios juegos y esta sea la mayor cantidad, se retorna el nombre del primero <br>
     * de los juegos que cumpla con la condici n.
     * @return Nombre del juego que ha vendido una mayor cantidad de licencias o "Ninguno" en caso en el que ning n juego haya vendido licencias.
     */
    public String darJuegoMasVendido( )
    {
        String masVendido = "Ninguno";
        int cantidadMasVendida = 0;
        if( juego1.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego1.darNombre( );
            cantidadMasVendida = juego1.darCantidadVendidas( );
        }
        if( juego2.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego2.darNombre( );
            cantidadMasVendida = juego2.darCantidadVendidas( );
        }
        if( juego3.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego3.darNombre( );
            cantidadMasVendida = juego3.darCantidadVendidas( );
        }
        if( juego4.darCantidadVendidas( ) > cantidadMasVendida )
        {
            masVendido = juego4.darNombre( );
            cantidadMasVendida = juego4.darCantidadVendidas( );
        }

        return masVendido;
    }

    /**
     * Retorna una cadena de texto con el descuento por ventas de juegos en volumen teniendo en cuenta las siguientes reglas: <br>
     * - Si se quieren comprar m nimo 25 licencias de juegos de rompecabezas se dar  un descuento del 20% sobre el valor total. <br>
     * - Si se quieren comprar al menos 20 licencias de juegos de deportes y 12 licencias de juegos de acci n se dar  un descuento del 15% sobre el valor total. <br>
     * Cuando en una venta se cumplen las dos condiciones anteriores, s lo se aplica el primer descuento.
     * @param pCantidadLicenciasJuego1 Cantidad de licencias que se pretenden vender del juego1.
     * @param pCantidadLicenciasJuego2 Cantidad de licencias que se pretenden vender del juego2.
     * @param pCantidadLicenciasJuego3 Cantidad de licencias que se pretenden vender del juego3.
     * @param pCantidadLicenciasJuego4 Cantidad de licencias que se pretenden vender del juego4.
     * @return Cadena de texto que informa el precio total de las licencias de juego a vender antes del descuento, el valor del descuento y el precio final con el descuento.
     */
    public String calcularVentaPorVolumen( int pCantidadLicenciasJuego1, int pCantidadLicenciasJuego2, int pCantidadLicenciasJuego3, int pCantidadLicenciasJuego4 )
    {
        int cantRompecab = 0;
        int cantDeporte = 0;
        int cantAccion = 0;

        switch( juego1.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego1;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego1;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego1;
                break;
            }
        }
        switch( juego2.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego2;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego2;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego2;
                break;
            }
        }
        switch( juego3.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego3;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego3;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego3;
                break;
            }
        }
        switch( juego4.darCategoria( ) )
        {
            case ROMPECABEZAS:
            {
                cantRompecab += pCantidadLicenciasJuego4;
                break;
            }
            case DEPORTE:
            {
                cantDeporte += pCantidadLicenciasJuego4;
                break;
            }
            case ACCION:
            {
                cantAccion += pCantidadLicenciasJuego4;
                break;
            }
        }

        double totalVenta = ( juego1.darPrecio( ) * pCantidadLicenciasJuego1 ) + ( juego2.darPrecio( ) * pCantidadLicenciasJuego2 ) + ( juego3.darPrecio( ) * pCantidadLicenciasJuego3 ) + ( juego4.darPrecio( ) * pCantidadLicenciasJuego4 );
        double descuento = 0;

        if( cantRompecab >= CANT_MIN_ROMPECABEZAS )
        {
            descuento = totalVenta * DESCUENTO_1;
        }
        else if( cantDeporte >= CANT_MIN_DEPORTE && cantAccion >= CANT_MIN_ACCION )
        {
            descuento = totalVenta * DESCUENTO_2;
        }
        else
        {
            descuento = 0;
        }

        double totalConDescuento = totalVenta - descuento;

        String mensaje = "El precio total de la venta ser a: $" + totalVenta + ".\n" + "El descuento ser a de: $" + descuento + "\n" + "El precio con descuento ser a: $" + totalConDescuento + ".";

        return mensaje;

    }

    // -----------------------------------------------------------------
    // Puntos de Extensi n
    // -----------------------------------------------------------------

    /**
     * M todo para la extensi n 1.
     * @return Respuesta 1.
     */
    public String metodo1() {
        return "Juegos que deben ser comprados por política de porcentaje: " + darComprasPorPorcentaje();
    }


    /**
     * M todo para la extensi n 2.
     * @return Respuesta 2.
     */
    public String metodo2() {
        StringBuilder resultado = new StringBuilder();
        for (Juego j : new Juego[]{juego1, juego2, juego3, juego4}) {
            if (seDebeComprarPorCategoria(j.darNombre())) {
                resultado.append(j.darNombre()).append(" ");
            }
        }
        return resultado.length() == 0 ? "NINGUNO" : resultado.toString().trim();
    }


    public String darJuegoMenosVendido() {
        Juego[] juegos = {juego1, juego2, juego3, juego4};
        int minVendidas = Integer.MAX_VALUE;
        String nombre = "NINGUNO";

        for (Juego j : juegos) {
            if (j.darCantidadVendidas() < minVendidas) {
                minVendidas = j.darCantidadVendidas();
                nombre = j.darNombre();
            }
        }

        int iguales = 0;
        for (Juego j : juegos) {
            if (j.darCantidadVendidas() == minVendidas) {
                iguales++;
            }
        }

        return iguales == juegos.length ? "NINGUNO" : nombre;
    }

    public String darComprasPorPorcentaje() {
        String nombreMenosVendido = darJuegoMenosVendido();
        if (nombreMenosVendido.equals("NINGUNO")) return "NINGUNO";

        int cantidadReferencia = buscarJuego(nombreMenosVendido).darCantidadLicencias();
        int umbral = (int)(cantidadReferencia * PORCENTAJE_MINIMO);

        StringBuilder juegosNecesarios = new StringBuilder();
        for (Juego j : new Juego[]{juego1, juego2, juego3, juego4}) {
            if (j.darCantidadLicencias() < umbral) {
                juegosNecesarios.append(j.darNombre()).append(" ");
            }
        }

        return juegosNecesarios.length() == 0 ? "NINGUNO" : juegosNecesarios.toString().trim();
    }

    public boolean seDebeComprarPorCategoria(String nombreJuego) {
        Juego juego = buscarJuego(nombreJuego);
        if (juego == null) return false;

        switch (juego.darCategoria()) {
            case DEPORTE:
                return juego.darCantidadLicencias() < LIMITE_DEPORTE;
            case ACCION:
                return juego.darCantidadLicencias() < LIMITE_ACCION;
            default:
                return false;
        }
    }




}
