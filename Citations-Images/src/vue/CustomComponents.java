package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class CustomComponents extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public Dimension getMinimumSize() {
        return new Dimension(1300, 600);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(1300, 600);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1300, 600);
    }

    @Override
    public void paintComponent(Graphics g) {
        int margin = 50;
        Dimension dim = getSize();
        super.paintComponent(g);
        //g.setColor(Color.yellow);
        g.fillRect(margin, margin, dim.width - margin * 2, dim.height - margin * 2);
    }
}