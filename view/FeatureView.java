package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.GraphController;

public class FeatureView extends JPanel {
	private GraphController graphController;
	private Mybutton selectedButton = null;

	public FeatureView(GraphController graphController) {
		this.graphController = graphController;
		// Tạo đường dẫn tuyệt đối đến tập tin hình ảnh

		// Sử dụng BoxLayout với hướng dọc
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(100, 500));

		// Danh sách các chức nang
		String[] icon = { "src\\view\\images\\plus.png", "src\\view\\images\\remove.png",
				"src\\view\\images\\molecular.png", "src\\view\\images\\edit.png", "src\\view\\images\\trash.png",
				"src\\view\\images\\move.png" };
		String[] desc = { "Thêm đỉnh", "Xóa đỉnh", "Nối đỉnh", "Sửa tên", "Xóa đồ thị", "Di chuyển đồ thị" };
		int[] codeExcute = { 1, 2, 3, 4, 5, 6 };
		// Tạo 5 button và thêm vào panel
		for (int i = 0; i < icon.length; i++) {
			final int index = i; // Tạo biến final index và gán giá trị của i
			ImageIcon imgIcon = new ImageIcon(icon[i]);
			Mybutton button = new Mybutton(imgIcon, desc[i]);
			button.setIcon(imgIcon); // Chèn icon vào JButton
			button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Đặt màu nền cho button được chọn
	                if (selectedButton != null) {
	                    selectedButton.setBackground(null);
	                }
	                button.setBackground(Color.LIGHT_GRAY);
	                selectedButton = button;
	                
	                // Xử lý tác vụ khi nút được click
	                graphController.setCodeExcute(codeExcute[index]);
	            }
	        });
			add(button);
		}

	}
}
