package view;

import javax.swing.*;
import java.awt.*;

public class AdjacencyMatrix extends JPanel {
    private int[][] matrix = {{1,2,3,4},{4,5,6,4},{1,2,3,6},{1,2,3,6}};
    private int size;

    public AdjacencyMatrix() {
        this.size = matrix.length + 1;
        int[][] matrix1 = new int[size][size];
        

        setLayout(new GridLayout(size, size));

        // Tạo và thêm các ô vào panel
        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
                matrix1[i][j] = i;
                matrix1[0][j] = j;
                if (i != 0 && j !=0){
                    
                    matrix1[i][j] = matrix[i-1][j-1];
                }
                JPanel cell = new JPanel(new BorderLayout());
                cell.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                
                JLabel label = new JLabel((i == 0 & j == 0) ? "":Integer.toString(matrix1[i][j]));
                label.setHorizontalAlignment(JLabel.CENTER);
                cell.add(label, BorderLayout.CENTER);
                add(cell);
            }
        }
    }
}
