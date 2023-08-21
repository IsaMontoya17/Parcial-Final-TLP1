package vistaGUI;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Image;

public class PanelRegreso extends JPanel {

    /**
     * Create the panel.
     */
    public PanelRegreso() {
        setBackground(new Color(255, 234, 244));
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 234, 244));
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout(1, 1, 0, 0));
        
        String rutaGif = "./datos/ejercicio.gif"; 
        ImageIcon gifIcon = new ImageIcon(rutaGif);
        
        Image image = gifIcon.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);

        JLabel lblNewLabel = new JLabel();
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setIcon(scaledIcon);
        panel.add(lblNewLabel);
    }
    
}//CIERRE DE LA CLASE
