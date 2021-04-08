package przemar5.dev.paint.display.panels;

import przemar5.dev.paint.display.Display;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class FooterPanel extends JPanel
{
    private Display display;
    private JLabel mousePositionLabel;

    public FooterPanel()
    {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        addBorder();
        addMousePositionPane();
    }

    private void addBorder()
    {
        Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        Border loweredBevel = BorderFactory.createLoweredBevelBorder();
        CompoundBorder border = BorderFactory.createCompoundBorder(
                raisedBevel, loweredBevel);
        setBorder(border);
    }

    private void addMousePositionPane()
    {
        mousePositionLabel = new JLabel();
        mousePositionLabel.setText("(0,0)");
        mousePositionLabel.setBackground(Color.BLUE);
        add(mousePositionLabel);
    }

    public void setMousePosition(int x, int y)
    {
        mousePositionLabel.setText("(" + x + "," + y + ")");
    }
}
