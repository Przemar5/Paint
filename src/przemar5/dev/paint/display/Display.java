package przemar5.dev.paint.display;

import przemar5.dev.paint.display.panels.ActionPanel;
import przemar5.dev.paint.display.panels.FooterPanel;
import przemar5.dev.paint.display.panels.PaintingPanel;

import javax.swing.*;
import java.awt.*;

public class Display
{
    private String title;
    private JFrame frame;
    private ActionPanel actionPanel;
    private PaintingPanel paintingPanel;
    private FooterPanel footerPanel;

    public Display(String title, int width, int height)
    {
        this.title = title;
        createFrame(title, width, height);
        createActionPanel();
        createFooterPanel();
        createPaintingPanel();
    }

    private void createFrame(String title, int width, int height)
    {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(320, 240));
        frame.setResizable(true);
        frame.setUndecorated(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createActionPanel()
    {
        actionPanel = new ActionPanel();
        frame.add(actionPanel, BorderLayout.NORTH);
        frame.pack();
    }

    private void createPaintingPanel()
    {
        paintingPanel = new PaintingPanel(footerPanel, this);
        frame.add(paintingPanel, BorderLayout.CENTER);
        frame.pack();
    }

    private void createFooterPanel()
    {
        footerPanel = new FooterPanel();
        frame.add(footerPanel, BorderLayout.SOUTH);
        frame.pack();
    }

    public JFrame getFrame()
    {
        return frame;
    }
}
