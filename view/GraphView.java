package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import controller.GraphController;
import model.Vertex;

public class GraphView extends JPanel{
	private List<VertexView> vertexViews = new ArrayList<>();

	public GraphView(GraphController controller) {
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		// Thiết lập layout cho MainPanel là null để có thể tự do vị trí của childPanel
		setLayout(null);

		// Tạo một đối tượng MouseAdapter để xử lý sự kiện click chuột
		MouseAdapter mouseAdapter = new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// Nếu click vào nút thêm đỉnh mới được thêm
				if (controller.getCodeExcute() != 1) return;
				// lấy tọa độ của chuột
				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();
				// Tạo đỉnh ngay tại vị trí click
				Vertex vertex = new Vertex("A", new Point(x,y));
				// Thêm đỉnh vừa tạo vào graph
				controller.addVertex(vertex);			
				// Tạo view
				Ellipse2D.Float el = new Ellipse2D.Float(x, y, 40, 40);
				VertexView vertexView = new VertexView(el, "A");
				vertexViews.add(vertexView);
				repaint();
			}

		};
		// Thêm đối tượng MouseAdapter vào JPanel
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (VertexView vertexView : vertexViews) {
			vertexView.drawPoint(g2d, 0, Color.GREEN);

		}
	}


}
