package reiff.projectile;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;


public class ProjectileFrame extends JFrame {

    private final JSlider angleSlider;
    private final JSlider velocitySlider;
    private final JTextField secondsField;
    private final JLabel nextToxLabel;
    private final JLabel nextToyLabel;
    private final JLabel nextToPeakyLabel;
    private final JLabel nextToxiLabel;

    private final ProjectileGraph graph;

    public ProjectileFrame() {
        setSize(1000, 1000);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        setContentPane(main);

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        west.setLayout(new GridLayout(11, 2));
        final JLabel angleLabel = new JLabel("Angle");
        final JLabel velocityLabel = new JLabel("Velocity");
        final JLabel secondsLabel = new JLabel("Seconds");
        final JLabel xlabel = new JLabel(("x"));
        final JLabel ylabel = new JLabel(("y"));
        final JLabel peakyLabel = new JLabel(("Peak Y"));
        final JLabel xiLabel = new JLabel(("X Intercept"));
        nextToxLabel = new JLabel();
        nextToyLabel = new JLabel();
        nextToPeakyLabel = new JLabel();
        nextToxiLabel = new JLabel();


        angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 31);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);


        JLabel angleValueLabel = new JLabel("31");

        angleSlider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();

                int angleValue = source.getValue();
                angleValueLabel.setText(String.valueOf(angleValue));
                recalculateValues();

        });

        velocitySlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 65);
        velocitySlider.setMajorTickSpacing(10);
        velocitySlider.setMinorTickSpacing(1);
        velocitySlider.setPaintTicks(true);
        velocitySlider.setPaintLabels(true);


        JLabel velocityValueLabel = new JLabel("65");

        velocitySlider.addChangeListener(e -> {
            JSlider source = (JSlider) e.getSource();

                int velocityValue = source.getValue();
                velocityValueLabel.setText(String.valueOf(velocityValue));
                recalculateValues();

        });

        secondsField = new JTextField("2.7");
        secondsField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                recalculateValues();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                recalculateValues();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                recalculateValues();
            }
        });

        west.add(angleLabel);
        west.add(angleSlider);
        west.add(new JLabel());
        west.add(angleValueLabel);

        west.add(velocityLabel);
        west.add(velocitySlider);
        west.add(new JLabel());
        west.add(velocityValueLabel);


        west.add(secondsLabel);
        west.add(secondsField);

        west.add(xlabel);
        west.add(nextToxLabel);

        west.add(ylabel);
        west.add(nextToyLabel);

        west.add(peakyLabel);
        west.add(nextToPeakyLabel);

        west.add(xiLabel);
        west.add(nextToxiLabel);

        graph = new ProjectileGraph();
        main.add(graph, BorderLayout.CENTER);
        recalculateValues();
    }

    private void recalculateValues() {
        try {
            Projectile projectile = new Projectile(

                    angleSlider.getValue(),
                    velocitySlider.getValue()
            );
            projectile.setSeconds(Double.parseDouble(secondsField.getText())
            );
            nextToxLabel.setText(String.valueOf(projectile.getX()));
            nextToyLabel.setText(String.valueOf(projectile.getY()));
            nextToPeakyLabel.setText(String.valueOf(projectile.getPeakY()));
            nextToxiLabel.setText(String.valueOf(projectile.getInterceptX()));
            graph.setProjectile(projectile);

        } catch (NumberFormatException e) {
            // ignore
        }
    }
}








