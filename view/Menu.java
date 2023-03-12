package view;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import model.IFeature;

public class Menu extends JPanel{
    private ArrayList<IFeature> data;

    public Menu(ArrayList<IFeature> data) {
        this.data = data;
        setLayout(new FlowLayout(FlowLayout.LEADING));
        System.out.println((int)Math.ceil((double)data.size()/3));
        for (int i = 0; i < data.size(); i++) {
            int index = i;
            JButton button = new JButton(data.get(index).getClass().getName().substring(6));
            button.setPreferredSize(new Dimension(120,60));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // show a warning message
                    data.get(index).search();
                }
            });
            
            add(button);
        }
        setBorder(BorderFactory.createTitledBorder("Menu"));
    }
    
}
