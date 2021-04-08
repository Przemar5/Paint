package przemar5.dev.paint.display.canvas;

import przemar5.dev.paint.display.panels.PaintingPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Resizer extends JPanel implements MouseListener
{
    public static final int VERTICAL = 1, HORIZONTAL = 2, BOTH = 3;
    public static final int DEFAULT_WIDTH = 10;
    private PaintingPanel paintingPanel;
    private int pressedX, pressedY;
    private int direction;

    public Resizer(PaintingPanel paintingPanel, int direction)
    {
        this.paintingPanel = paintingPanel;
        this.direction = direction;
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        addMouseListener(this);
        initMouseHover();
        repaint();
    }

    private void initMouseHover()
    {
        if (direction == VERTICAL) {
            setCursor(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));
        }
        else if (direction == HORIZONTAL) {
            setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        }
        else if (direction == BOTH) {
            setCursor(Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR));
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e)
    {
        pressedX = e.getX();
        pressedY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        int deltaX = e.getX() - pressedX;
        int deltaY = e.getY() - pressedY;

        if (direction == VERTICAL) {
            paintingPanel.resizeCanvasBy(0, deltaY);
        }
        else if (direction == HORIZONTAL) {
            paintingPanel.resizeCanvasBy(deltaX, 0);
        }
        else if (direction == BOTH) {
            paintingPanel.resizeCanvasBy(deltaX, deltaY);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
