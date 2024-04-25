import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FormularioCine {
    private JPanel principal;
    private JComboBox cboPelicula;
    private JComboBox cboCantidad;
    private JButton cboComprar;
    private JTextArea txtEntradas;
    private JButton btnPelicula1;
    private JButton btnPelicula2;
    private JLabel AndresTayupanta;
    private  Cine objcine = new Cine();

    public FormularioCine() {
        try {
        String a="",b="";
        do {
            b= JOptionPane.showInputDialog("Ingrese su número de cédula real");
            a = JOptionPane.showInputDialog("Ingrese su nombre real");
        }while(b.length()<10);
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Taller1ProgramacionIII.dat"));
            o.writeObject(a+b);
        }catch (Exception ex) {

        }
        cboComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            String peliculaEscogida = cboPelicula.getSelectedItem().toString();
            int cant =(int) cboCantidad.getSelectedItem();

             if (cant>3){
                JOptionPane.showMessageDialog(null,"NO SE PUEDE COMPRAR MAS DE 3 BOLETOS POR CLIEMTE","ERROR",JOptionPane.ERROR_MESSAGE);
                return;
             }
             if (cant>objcine.cantidadEntradasDisponibles()){
                    JOptionPane.showMessageDialog(null,"NO HAY SUFIENTES ENTRADAS","ERROR",JOptionPane.ERROR_MESSAGE);

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FormularioCine");
        frame.setContentPane(new FormularioCine().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
