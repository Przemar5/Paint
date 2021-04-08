package przemar5.dev.paint.display.panels;

import przemar5.dev.paint.display.Display;
import przemar5.dev.paint.display.canvas.AppCanvas;
import przemar5.dev.paint.display.canvas.Resizer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class PaintingPanel extends JPanel
{
    private AppCanvas canvas;
    private HashMap<String, Resizer> resizers;
    private int offsetX = 10, offsetY = 10;

    public PaintingPanel(FooterPanel footerPanel, Display display)
    {
        resizers = new HashMap<String, Resizer>();
        setBackground(Color.DARK_GRAY);
        setLayout(null);
        addCanvas(footerPanel, 200, 200, display);
        addResizers();
    }

    private void addCanvas(FooterPanel footerPanel, int width, int height, Display display)
    {
        canvas = new AppCanvas(footerPanel);
        canvas.setBounds(offsetX, offsetY, width, height);
        canvas.setSize(width, height);
        add(canvas);
    }

    private void addResizers()
    {
        addHorizontalResizer();
        addVerticalResizer();
        addCornerResizer();
    }

    private void addHorizontalResizer()
    {
        resizers.put("horizontal", new Resizer(
                this,
                Resizer.HORIZONTAL
        ));
        resizers.get("horizontal").setBounds(
                2*offsetX + canvas.getWidth(),
                offsetY,
                Resizer.DEFAULT_WIDTH,
                canvas.getHeight()
        );
        add(resizers.get("horizontal"));
    }

    private void addVerticalResizer()
    {
        resizers.put("vertical", new Resizer(
                this,
                Resizer.VERTICAL
        ));
        resizers.get("vertical").setBounds(
                offsetX,
                2*offsetY + canvas.getHeight(),
                canvas.getWidth(),
                Resizer.DEFAULT_WIDTH
        );
        add(resizers.get("vertical"));
    }

    private void addCornerResizer()
    {
        resizers.put("both", new Resizer(
                this,
                Resizer.BOTH
        ));
        resizers.get("both").setBounds(
                2*offsetX + canvas.getWidth(),
                2*offsetY + canvas.getHeight(),
                Resizer.DEFAULT_WIDTH,
                Resizer.DEFAULT_WIDTH
        );
        add(resizers.get("both"));
    }

    public void resizeCanvasBy(int x, int y)
    {
        int width = canvas.getWidth() + x;
        int height = canvas.getHeight() + y;

        canvas.setBounds(offsetX, offsetY, width, height);

        resizers.get("horizontal").setBounds(
                2*offsetX + width, offsetY, Resizer.DEFAULT_WIDTH, height);
        resizers.get("vertical").setBounds(
                offsetX, 2*offsetY + height, width, Resizer.DEFAULT_WIDTH);
        resizers.get("both").setBounds(
                2*offsetX + width, 2*offsetY + height, Resizer.DEFAULT_WIDTH, Resizer.DEFAULT_WIDTH);

        resizers.get("horizontal").setVisible((height < 10) ? false : true);
        resizers.get("vertical").setVisible((width < 10) ? false : true);
    }
}
