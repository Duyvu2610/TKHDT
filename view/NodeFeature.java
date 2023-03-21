package view;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
public class NodeFeature extends JPanel{
    public NodeFeature() {
        ImageIcon icon = new ImageIcon("view\\images\\1.png"); 

        // Sử dụng BoxLayout với hướng dọc
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(70, 500));
        
        // Tạo 5 button và thêm vào panel
        for (int i = 1; i <= 7; i++) {
            Mybutton button = new Mybutton(icon,"hihi");
            button.setPreferredSize(new Dimension(getWidth(), 100)); 
            button.setIcon(icon); //Chèn icon vào JButton           
            add(button);
        }

    }
}
