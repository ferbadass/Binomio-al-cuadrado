/**
 * @author: Miranda Sámchez Maria Fernanda.
 * Grupo: 5IM8
 *  
*/

package binomiocuadrado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculos extends JFrame implements ActionListener {
    
    JTextField ReciboNumero, EntregoNumero, ResultadoFinal;
    JButton CalculoNumero;
    JLabel IntroduceNumeroUno, IntroduceNumeroDos, LResultadoFinal;
    
    int Factorial;
    int NumeroRecibido; 
    
    public Calculos(){
        InicializarVentana();
        InicializarComponentes();
        Factorial = 0;
        NumeroRecibido = 0; 
    }
    
    public void InicializarVentana(){
        setTitle("BINOMIO AL CUADRADO");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setBackground(new Color(0,0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
    
    public void InicializarComponentes(){
        IntroduceNumeroUno = new JLabel("Introduce primer numero: ");
        IntroduceNumeroDos = new JLabel ("Introduce un segundo numero: ");
        LResultadoFinal = new JLabel ("Resultado: ");
        CalculoNumero = new JButton("CALCULAR BINOMIO AL CUADRADO");
        ReciboNumero = new JTextField ();
        EntregoNumero = new JTextField();
        ResultadoFinal = new JTextField();
        
        setLayout(new BorderLayout());
        
        add(IntroduceNumeroUno, BorderLayout.NORTH);        
        add(UbicacionCentro(), BorderLayout.CENTER);
        add(CalculoNumero, BorderLayout.SOUTH);
        
        CalculoNumero.addActionListener(this);
        
        IntroduceNumeroUno.setVisible(true);
        IntroduceNumeroDos.setVisible(true);
        CalculoNumero.setVisible(true);
        ReciboNumero.setVisible(true);
        EntregoNumero.setVisible(true);
        ResultadoFinal.setVisible(true);
        LResultadoFinal.setVisible(true);
        
        ResultadoFinal.setEditable(false);
        
       SNumeros(ReciboNumero);
       SNumeros(EntregoNumero);
    }   
    
    private JPanel UbicacionCentro(){
        JPanel centro = new JPanel();
        centro.setLayout(new BoxLayout(centro, BoxLayout.Y_AXIS));
        centro.add(ReciboNumero);
        centro.add(IntroduceNumeroDos);
        centro.add(EntregoNumero);
        centro.add(LResultadoFinal);
        centro.add(ResultadoFinal);
        return centro;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == CalculoNumero){
            int NumeroUno, NumeroDos;
            NumeroUno = Integer.parseInt(ReciboNumero.getText());
            NumeroDos = Integer.parseInt(EntregoNumero.getText());
            
            String MiembroCuadratico = Integer.toString(NumeroUno * NumeroUno);
            String MiembroLineal = Integer.toString(2*NumeroUno*NumeroDos);
            String MiembroIndependiente = Integer.toString(NumeroDos * NumeroDos);
            
            String Resultado = MiembroCuadratico + "x^2" + "+" + MiembroLineal 
                               + "x" + "+" + MiembroIndependiente;
            
            ResultadoFinal.setText(Resultado);
        }
    }
    
     public void SNumeros(JTextField a){
    a.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
        char c= e.getKeyChar();
        int k=(int)e.getKeyChar();
        if(Character.isAlphabetic(c)){ 
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "Ingrese solo numeros ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        if(k==32){
        getToolkit().beep();
        JOptionPane.showMessageDialog(null, "No ingrese espacios ", "Mensaje error", JOptionPane.ERROR_MESSAGE);
        e.consume();
        }
        }
    });
    }
}