package Menu;

import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuAnimation {

    private static final int ANIMATION_DURATION = 300; // Duración de la animación en milisegundos
    private static final float ACCELERATION = 0.5f;
    private static final float DECELERATION = 0.5f;

    // Método para mostrar u ocultar el menú con animación
    public static void showMenu(Component component, MenuItem item, MigLayout layout, boolean show) {
        int targetHeight = component.getPreferredSize().height;

        // Se crea el animador solo cuando es necesario
        Animator animator = new Animator(ANIMATION_DURATION, new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                // Calcula la fracción de animación en función de si se está mostrando u ocultando
                float adjustedFraction = show ? fraction : 1f - fraction;
                
                // Ajusta las restricciones de tamaño del componente
                layout.setComponentConstraints(component, "h " + (int)(targetHeight * adjustedFraction) + "!");
                
                component.revalidate();
                component.repaint();
            }
        });

        // Configura propiedades del animador
        animator.setResolution(0);
        animator.setAcceleration(ACCELERATION);
        animator.setDeceleration(DECELERATION);
        animator.start();
    }
}

