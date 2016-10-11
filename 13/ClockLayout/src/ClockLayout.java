import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
public class ClockLayout implements LayoutManager {    
    public void addLayoutComponent(String name, Component comp) {      
    }
    public void layoutContainer(Container parent) {
        double centerX = parent.getBounds().getCenterX();
        double centerY = parent.getBounds().getCenterY();
        Insets insets = parent.getInsets();
        double horizon = centerX - insets.left;
        double vertical = centerY - insets.top;
        double radius = horizon > vertical ? vertical : horizon;
        int count = parent.getComponentCount();
        for (int i = 0; i < count; i++) {
            Component component = parent.getComponent(i);
            if (component.isVisible()) {
                Dimension size = component.getPreferredSize();
                double angle = 2 * Math.PI * i / count;
                double x = centerX + radius * Math.sin(angle);
                double y = centerY - radius * Math.cos(angle);
                component.setBounds((int) x - size.width / 2, (int) y - size.height / 2, size.width, size.height);
            }
        }
    }
    public Dimension minimumLayoutSize(Container parent) {
        return parent.getMinimumSize();
    }
    public Dimension preferredLayoutSize(Container parent) {
        return parent.getPreferredSize();
    }
    public void removeLayoutComponent(Component comp) {
    }
    
}
