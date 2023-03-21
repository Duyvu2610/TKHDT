package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ShowGraph extends JPanel{
    public ShowGraph(){
        setLayout(new BorderLayout());
        setBackground(Color.GRAY);
        // Đăng ký bắt sự kiện click chuột
        
    
        setLayout(null); // Thiết lập layout cho MainPanel là null để có thể tự do vị trí của childPanel
        
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                Node childPanel = new Node("1");
                childPanel.setLocation(e.getX(), e.getY()); 
                add(childPanel); // Thêm childPanel vào MainPanel
                repaint(); // Vẽ lại MainPanel và childPanel
            }
        });
        
    }
}
