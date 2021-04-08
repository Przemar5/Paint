package przemar5.dev.paint.display.canvas;

import przemar5.dev.paint.display.panels.FooterPanel;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class AppCanvas extends Canvas implements MouseMotionListener
{
    private FooterPanel footerPanel;

    public AppCanvas(FooterPanel footerPanel)
    {
        this.footerPanel = footerPanel;
        setBackground(Color.WHITE);
        addMouseMotionListener(this);
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e)
    {
        footerPanel.setMousePosition(e.getX(), e.getY());
    }
}
