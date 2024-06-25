import javax.swing.*;
import java.awt.*;

class RoundColorButton extends JButton {
    public RoundColorButton(Color color) {
        setBackground(color);
        setForeground(color);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setBorderPainted(false);
        addActionListener(actionListener);
        setPreferredSize(new Dimension(45, 45));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(getBackground().darker());
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getBackground().darker());
        g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getWidth() / 2;
        return (x - radius) * (x - radius) + (y - radius) * (y - radius) <= radius * radius;
    }
}
