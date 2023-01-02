package userinterface;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

public class ComponentPrinter implements Printable {
    /**
     * The component to be printed.
     */
    Component component;

    /**
     * The amount of pixels to shift the component to the right.
     */
    int translateX;

    /**
     * The amount of pixels to shift the component to the bottom.
     */
    int translateY;

    /**
     * Constructs a new <code>ComponentPrinter</code> for the specified component.
     * @param component     The component that this component printer will print.
     * @param translateX    The amount of pixels to move the component towards the right.
     * @param translateY    The amount of pixels to move the component towards the bottom.
     */
    public ComponentPrinter(Component component, int translateX, int translateY) {
        this.component = component;
        this.translateX = translateX;
        this.translateY = translateY;
    }

    /**
     * Prints the component of this <code>ComponentPrinter</code>.
     * {@inheritDoc}
     */
    @Override
    public int print(Graphics graphics, PageFormat format, int pageIndex)
            throws PrinterException {
        // We assume that there is only one page.
        if (pageIndex == 0) {
            // Position the component appropriately
            ((Graphics2D)graphics).translate(translateX, translateY);

            // Paints the component on the graphics that are about to be printed for this page.
            component.paint(graphics);
            return PAGE_EXISTS;
        }

        // We don't have a page other than the first page.
        return NO_SUCH_PAGE;
    }
}
