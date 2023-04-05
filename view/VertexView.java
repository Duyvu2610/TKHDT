package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;

public class VertexView {
    private Ellipse2D.Float el = new Ellipse2D.Float();
    private String label;

    public VertexView(Ellipse2D.Float el, String label) {
        setEl(el);
        setLabel(label);
    }

    private void setEl(Float el2) {
        this.el = el2;
    }

    private void setLabel(String label) {
        this.label = label;
    }

    public void drawPoint(Graphics2D g, int index, Color colorPoint) {
        g.setColor(colorPoint);
        g.fill(el);

        // set font and color for label
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.setColor(Color.BLACK);

        // get font metrics
        FontMetrics fm = g.getFontMetrics();

        // calculate label position
        int x = (int) (el.getX() + el.getWidth() / 2 - fm.stringWidth(label) / 2);
        int y = (int) (el.getY() + el.getHeight() / 2 + fm.getAscent() / 2);

        // draw label
        g.drawString(label, x, y);
    }
}

