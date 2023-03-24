package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.CreateArrayByFile;
import model.Graph;
import model.ICreateArray;

public class ShowGraph extends JPanel {
	Graph graph;
	int count = 0;
	AdjacencyMatrix adjacencyMatrix;
	ICreateArray iCreateArray;

	public ShowGraph() {
		graph = new Graph();
		iCreateArray =  new CreateArrayByFile();
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		// Đăng ký bắt sự kiện click chuột

		setLayout(null); // Thiết lập layout cho MainPanel là null để có thể tự do vị trí của childPanel

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int beforeSize = graph.getSize();
				Node childPanel = new Node("1");
				graph.listNodes.add(childPanel);
				graph.meantsureUpdate(beforeSize, graph.getSize());
				childPanel.setLocation(e.getX(), e.getY());
				add(childPanel);
				repaint(); // Vẽ lại MainPanel và childPanel
			}
		});
		

	}
}
