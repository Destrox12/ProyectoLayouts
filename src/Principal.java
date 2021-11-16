import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Principal extends JFrame implements ChangeListener, ItemListener {

    CardLayout tarjetas;
    JPanel panelTarjetas;

    public Principal(){
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        setLayout(new BorderLayout());

        JPanel panelPrimero = new JPanel();
        panelPrimero.setBackground(Color.red);
        JPanel panelSegundo = new JPanel();
        panelSegundo.setBackground(Color.blue);
        JPanel panelTercero = new JPanel();
        panelTercero.setBackground(Color.pink);
        JPanel panelCuarto = new JPanel();
        panelCuarto.setBackground(Color.green);
        JPanel panelQuinto = new JPanel();
        panelQuinto.setBackground(Color.yellow);

        JButton cambiarTarjeta = new JButton("Cambiar tarjeta");
        cambiarTarjeta.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent event){
                tarjetas.next(panelTarjetas);
            }
        });

        panelPrimero.add(cambiarTarjeta);
        add(panelPrimero,BorderLayout.SOUTH);

        nuevoBoton(panelSegundo,"Siguiente");
        



        tarjetas=new CardLayout();

        panelTarjetas=new JPanel();

        panelTarjetas.setLayout(tarjetas);

        panelTarjetas.add(panelPrimero,"Bienvenida");
        panelTarjetas.add(panelSegundo,"Login");
        panelTarjetas.add(panelTercero,"Paises");
        panelTarjetas.add(panelCuarto,"Resultado");
        panelTarjetas.add(panelQuinto,"Registro");

        tarjetas.show(panelTarjetas, "");

        add(panelTarjetas,BorderLayout.CENTER);

        initPantalla();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {

    }

    private void nuevoBoton(JPanel panel, String titulo){

        JButton boton = new JButton(titulo);
        panel.add(boton);

    }

    private void initPantalla() {

        setTitle("Práctica 5"); //Título del JFrame
        setSize(600,500); //Dimensiones del JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame
    }

    public static void main(String[] args) {
        new Principal();
    }

}
