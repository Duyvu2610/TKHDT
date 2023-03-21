package view;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Mybutton extends JButton{
    private ImageIcon icon;
    private String desc;
    public Mybutton(ImageIcon icon, String desc) {
        this.icon = icon;
        this.desc = desc;
        setIcon(icon); //Chèn icon vào JButton       
        setToolTipText(desc);    
    }
    
    
}
