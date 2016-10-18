import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
 * La clase Interfaz maneja las interacciones con el usuario.
 * 
 * @author Carlos Bogarín Gómez: B2103
 *          Aportes:
 *          - Compilación de los aportes de los otros compañeros en 
 *              una sola clase.
 *          
 *          Javier Padilla:
 *          Aportes:
 *          - Versión inicial del proyecto con dos clases de tipo Interfaz pero
 *              con fines distintos.
 *              
 *          Tatiana Briones:
 *          Aportes:
 *          - Ejercicio JSpinner
 *              
 * @version Lunes 17 de Octubre de 2016
 */
public class Interfaz
{
    //
    private Controlador controlador;
    
    private Ventana ventana;
    private Dialogo dialogo;
    
    private JTextField campoTexto;
    private JSpinner spinner;
    private SpinnerModel modelo;
    /**
     * Constructor para objetos de la clase Interfaz
     */
    public Interfaz(Controlador controlador)
    {
        // 
        ventana = new Ventana(this.controlador);
        dialogo = new Dialogo();
        this.controlador = controlador;
        campoTexto = new JTextField(25);
        modelo = new SpinnerNumberModel(1,  //inicio
                                        1,  //minimo
                                        1000, //maximo
                                        1); //incremento
        spinner = new JSpinner(modelo);
    }
    
    /**
     * Muestra en el campo de texto el numero seleccionado en el spinner
     * Escrito: Tatiana Briones
     */
    public void ejemploSpinner()
    {
        //ventana.setSize(300,300);
        //ventana.setLayout(new FlowLayout());
        ventana.add(campoTexto);
        ventana.add(spinner);       
        ventana.setVisible(true);
        
        //Cambios en el spinner
        ChangeListener listener = new ChangeListener()
            {
                public void stateChanged(ChangeEvent e){
                    campoTexto.setText(spinner.getValue().toString());
                }
            };
        spinner.addChangeListener(listener);
    }
    
    /**
     * La clase Ventana extiende la clase JFrame para crear 
     * componentes gráficos.
     */
    private class Ventana extends JFrame
    {
        //
        private Controlador controlador;
        
        //
        private JTextField textField;
        private Font plainFont;
        private Font boldFont;
        private Font italicFont;
        private JRadioButton blackButton;
        private JRadioButton blueButton; 
        private JCheckBox boldBox;
        private JCheckBox italicBox;
        private ButtonGroup buttons;
        private Menu menu;
        
        /**
         * 
         * 
         * @author Carlos Bogarín
         */
        public Ventana (Controlador controlador)
        {
            //
            this.controlador = controlador;
            
            this.setFrame();
            this.addRadioButton();
            this.addJCheckBox();
        }
        
        /**
         * El método setFrame crea el marco.
         * 
         * @author  Javier Padilla
         */
        public void setFrame()
        {
            this.setTitle("TC_2");
            this.setLayout(new FlowLayout());
            textField = new JTextField("Sample text", 25);
            textField.setFont(new Font("Serif",Font.PLAIN, 14));
            this.add(textField);
            this.setSize(500,500);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        /**
         * El método addRadioButton añade los radio Buttons y su función.
         * 
         * @author Javier Padilla
         */
        public void addRadioButton()
        {
            blackButton = new JRadioButton("Color: Black");
            blueButton = new JRadioButton("Color: Blue");
            this.add(blackButton);
            this.add(blueButton);
        
            buttons = new ButtonGroup();
            buttons.add(blackButton);
            buttons.add(blueButton); 
            
            blackButton.addItemListener(new HandlerClass());
            blueButton.addItemListener(new HandlerClass());
            
        }
        
        /**
         * 
         */
        public void addJCheckBox()
        {
            //
            boldBox = new JCheckBox("bold");
            italicBox = new JCheckBox("italic");
    
            this.add(boldBox);
            this.add(italicBox);
    
            HandlerClass handler = new HandlerClass();
            boldBox.addItemListener(handler);
            italicBox.addItemListener(handler);
        }
        
        /**
         * 
         * 
         * author Javier Padilla
         */
        private class HandlerClass implements ItemListener
        {
            public void itemStateChanged(ItemEvent event)
            {
                Font font = null;
                
                if(blackButton.isSelected())
                {
                    textField.setForeground(Color.BLACK);
                } else if(blueButton.isSelected())
                {
                   textField.setForeground(Color.BLUE); 
                }
                
                if(boldBox.isSelected() && italicBox.isSelected())
                    font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
                else if (boldBox.isSelected())
                    font = new Font("Serif", Font.BOLD, 14);
                else if(italicBox.isSelected())
                    font = new Font("Serif", Font.ITALIC, 14);    
        
                textField.setFont(font);
            }
        }
    }
    
    /**
     * author Javier Padilla
     */
    private class Dialogo extends JOptionPane
    {
        //
        
        /**
         * 
         */
        public double pedirNúmero(String texto, String título)
        {
            double númeroDigitado;
            String userInput = this.showInputDialog(null, texto, título, this.INFORMATION_MESSAGE);
            númeroDigitado = Double.parseDouble(userInput);
    
            return númeroDigitado;
        }
    }
}
