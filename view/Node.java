package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Node extends JPanel {
	private String text;

	public Node(String text) {
		this.text = text;
		setSize(50, 50);
		setBackground(Color.BLACK);
	}

	public void setText(String text) {
		this.text = text;
		repaint();
	}

	public String getText() {
		return this.text;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
	}

}
