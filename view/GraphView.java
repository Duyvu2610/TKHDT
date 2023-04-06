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

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.GraphController;
import controller.VertexController;
import model.Vertex;

public class GraphView extends JPanel {
	private List<VertexController> vertexs;
	private GraphController controller;
	private VertexController vertexController;

	public GraphView(GraphController controller) {
		this.controller = controller;
		this.vertexs = new ArrayList<VertexController>();

		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		// Thiết lập layout cho MainPanel là null để có thể tự do vị trí của childPanel
		setLayout(null);

		// Tạo một đối tượng MouseAdapter để xử lý sự kiện click chuột
		MouseAdapter mouseAdapter = new MouseAdapter() {
			// Khởi tạo các biến
			private boolean dragging = false;
			private Vertex currentVertex;
			Point currentClick;

			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				// lấy tọa độ của chuột
				currentClick = new Point(e.getX(), e.getY());
				// Nếu click vào nút thêm đỉnh mới được thêm
				if (controller.getCodeExcute() == 1) {
					// Hiển thị hộp thoại yêu cầu nhập tên đỉnh
					String name = JOptionPane.showInputDialog(null, "Enter vertex name:");
					if (name != null && !name.isEmpty()) {
						addVertexView(currentClick, name);
					}
				} else if (controller.getCodeExcute() == 2) {
					removeVertexAt(currentClick);
				}

			}

//		    @Override
//		    public void mousePressed(MouseEvent e) {
//		    	currentClick = new Point(e.getX(),e.getY());
//		        super.mousePressed(e);
//		        if (controller.getCodeExcute() == 6) {
//		            for (VertexView vertexView : vertexViews) {
//		                if (vertexView.isClick(currentClick)) {
//		                    dragging = true;
//		                    currentVertexView = vertexView;
//		                    break;
//		                }
//		            }
//		        }
//		    }
//
//		    @Override
//		    public void mouseDragged(MouseEvent e) {
//		        super.mouseDragged(e);
//		        if (dragging && controller.getCodeExcute() == 6) {
//		        	System.out.println(currentClick.getX());
//		        	// Cập nhật vị trí mới của VertexView
//		            currentVertexView.move(currentClick);
//		         // Lưu lại tọa độ của chuột để tính toán khoảng cách tiếp theo
//		            currentClick = new Point(e.getX(),e.getY());
//		            revalidate();
//		            repaint();
//		        }
//		    }
//
//		    @Override
//		    public void mouseReleased(MouseEvent e) {
//		    	if (controller.getCodeExcute() == 6) {
//		    		System.out.println("tha");
//			        super.mouseReleased(e);
//			        dragging = false;
//			        currentVertexView = null;
//		        }
//		    	
//		    }

		};
		// Thêm đối tượng MouseAdapter vào JPanel
		addMouseListener(mouseAdapter);
		addMouseMotionListener(mouseAdapter);

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (Vertex vertex : controller.getVertices()) {
			vertexController = new VertexController(vertex);
			vertexController.updateView(g2d, Color.GREEN);
			vertexs.add(vertexController);
		}
	}

	// Thêm đỉnh mới vào đồ thị và cập nhật view
	public void addVertexView(Point location, String name) {
		Vertex vertex = new Vertex(name, location);
		controller.addVertex(vertex);
		repaint();
	}

	// Xóa đỉnh vừa click
	public void removeVertexAt(Point location) {
		for (int i = 0; i < vertexs.size(); i++) {
			controller.removeVertex(vertexs.get(i).vertexClicked(location));
		}
		revalidate();
		repaint();
	}


}
