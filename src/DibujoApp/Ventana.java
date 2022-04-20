/*
██████╗░██╗░░░██╗██╗  ███████╗██╗░░░░░██╗  ████████╗░█████╗░██╗░░░██╗░█████╗░██████╗░
██╔══██╗╚██╗░██╔╝╚═╝  ██╔════╝██║░░░░░██║  ╚══██╔══╝██╔══██╗██║░░░██║██╔══██╗██╔══██╗
██████╦╝░╚████╔╝░░░░  █████╗░░██║░░░░░██║  ░░░██║░░░██║░░██║╚██╗░██╔╝███████║██████╔╝
██╔══██╗░░╚██╔╝░░░░░  ██╔══╝░░██║░░░░░██║  ░░░██║░░░██║░░██║░╚████╔╝░██╔══██║██╔══██╗
██████╦╝░░░██║░░░██╗  ███████╗███████╗██║  ░░░██║░░░╚█████╔╝░░╚██╔╝░░██║░░██║██║░░██║
╚═════╝░░░░╚═╝░░░╚═╝  ╚══════╝╚══════╝╚═╝  ░░░╚═╝░░░░╚════╝░░░░╚═╝░░░╚═╝░░╚═╝╚═╝░░╚═╝
 */
package DibujoApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class Ventana extends JFrame {

    Points p = null;
    JPanel panelm;
    JButton btnPincel;

    public Ventana() {
        p = new Points();

        setTitle("Draw");
        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        iniciar();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        addMouseMotionListener(new MouseMotionAdapter() {
            
            @Override
            public void mouseDragged(MouseEvent evt) {
                p.GuardarPuntos(evt.getX(), evt.getY());
                System.out.println(evt.getX() + " " + evt.getY());
                Dibujar();
            }
        });
        
    }

    private void iniciar() {

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);

        panelm = new JPanel();
        panelm.setBounds(0, 0, 700, 500);
        panelm.setBackground(Color.WHITE);
        panel.setLayout(null);
        panel.add(panelm);

        btnPincel = new JButton("Pincel");
        btnPincel.setBounds(710, 5, 70, 40);
        panel.add(btnPincel);
    }

    public void Dibujar(){
        Graphics2D g2d = (Graphics2D) panelm.getGraphics();
        int size = 20;
        
        g2d.setColor(Color.BLACK);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        
        for(int i = 0; i < p.listax().size(); i++){
            int x = p.listax().get(i);
            int y = p.listay().get(i);
            g2d.fillOval(x, y-size*2, size, size);
        }
    }
}
