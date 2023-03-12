package view;

import javax.swing.*;

import model.BFS;
import model.DFS;
import model.IFeature;

import java.awt.*;
import java.util.ArrayList;

public class App extends JFrame{
    private ArrayList<IFeature> menuData ;
    public App(ArrayList<IFeature> menuData){
        this.menuData = menuData;
        init();
    }
    private void init(){
        setSize(1200,700);
        setLocationRelativeTo(null);
        setTitle("FlowLayout Example");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel app = new JPanel(new BorderLayout());
        app.setPreferredSize(new Dimension(1200,700));
        app.add(leftCol(), BorderLayout.WEST);
        app.add(rightCol());
        app.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(app);
        setVisible(true);
    }

   public JPanel leftCol(){
    JPanel leftJPanel = new JPanel();
    leftJPanel.setLayout(new BorderLayout());
    // Menu
    Menu menu = new Menu(menuData);
    menu.setPreferredSize(new Dimension(400, 200));
    //File
    Menu file = new Menu(menuData);

    file.setPreferredSize(new Dimension(400, 150));
    file.setBorder(BorderFactory.createTitledBorder("File"));



    //matrix
    JPanel matrix = new JPanel();
    matrix.setPreferredSize(new Dimension(400, 350));
    matrix.setBorder(BorderFactory.createTitledBorder("Adjacency matrix"));

    //
    leftJPanel.setPreferredSize(new Dimension(400, 700));

    // add component
    leftJPanel.add(menu, BorderLayout.NORTH);
    leftJPanel.add(file);
    leftJPanel.add(matrix, BorderLayout.SOUTH);
    return leftJPanel;
   }

   public JPanel rightCol(){
    JPanel rightJPanel = new JPanel(new BorderLayout());
    //Screen
    JPanel screen = new JPanel();
    screen.setPreferredSize(new Dimension((int) rightJPanel.getPreferredSize().getWidth(),500));
    screen.setBorder(BorderFactory.createTitledBorder("hih"));
    //Notify
    JPanel notify = new JPanel();
    notify.setPreferredSize(new Dimension((int) rightJPanel.getPreferredSize().getWidth(),200));
    notify.setBorder(BorderFactory.createTitledBorder("hih"));
    rightJPanel.setBorder(BorderFactory.createTitledBorder(getTitle()));

    // add component
    rightJPanel.add(screen);
    rightJPanel.add(notify, BorderLayout.SOUTH);
    return rightJPanel;
   }
   public static void main(String[] args) {
    ArrayList<IFeature> menuData = new ArrayList<>();
    menuData.add(new BFS());
    menuData.add(new BFS());
    menuData.add(new DFS());
 


    App app = new App(menuData);
    }
    
    
}
