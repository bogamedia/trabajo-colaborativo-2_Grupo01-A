
/**
 * La clase Controlador ejecuta la totalidad del programa.
 * 
 * @author Carlos Bogarín Gómez: B2103
 *          Aportes:
 *          - Compilación de los aportes de los otros compañeros en un solo programa.
 *          
 *          Javier Padilla:
 *          Aportes:
 *          - Versión inicial del proyecto con dos clases de tipo Interfaz pero
 *              con fines distintos.
 *              
 *          Tatiana Briones:
 *          Aportes:
 *          - Ejercicio de JSpinner
 *              
 * @version Lunes 17 de Octubre de 2016
 */
public class Controlador
{
    //
    Interfaz interfaz;
    /**
     * Constructor para objetos de la clase Controlador.
     */
    public Controlador()
    {
        //
        interfaz = new Interfaz(this);
    }
    
    /**
     * 
     */
    public void iniciar()
    {
        //
    }
    
    /**
     * 
     */
    public static void main (String[] args)
    {
        Controlador controlador;
        controlador = new Controlador();
        controlador.iniciar();
    } 
}
