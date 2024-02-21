package reiff.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {

    private final JSlider angleSlider;
    private final JTextField velocityField;
    private final JTextField secondsField;
    private final JLabel nextToxLabel;
    private final JLabel nextToyLabel;
    private final JLabel nextToPeakyLabel;
    private final JLabel nextToxiLabel;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(9, 2));
        JLabel angleLabel = new JLabel("Angle");
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel(("x"));
        JLabel yLabel = new JLabel(("y"));
        JLabel peakYLabel = new JLabel(("Peak Y"));
        JLabel xiLabel = new JLabel(("X Intercept"));
        nextToxLabel = new JLabel();
        nextToyLabel = new JLabel();
        nextToPeakyLabel = new JLabel();
        nextToxiLabel = new JLabel();
        JLabel emptySpace = new JLabel();
        JButton calculateButton = new JButton("Calculate");


        angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);


        JLabel angleValueLabel = new JLabel("0");

        angleSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int angleValue = source.getValue();
                    angleValueLabel.setText(String.valueOf(angleValue));
                    recalculateValues();
                }
            }
        });

        velocityField = new JTextField();
        velocityField.getDocument().addDocumentListener(new DocumentListener() {

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


        secondsField = new JTextField();
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

        add(angleLabel);
        add(angleSlider);
        add(new JLabel());
        add(angleValueLabel);

        add(velocityLabel);
        add(velocityField);

        add(secondsLabel);
        add(secondsField);

        add(xLabel);
        add(nextToxLabel);

        add(yLabel);
        add(nextToyLabel);

        add(peakYLabel);
        add(nextToPeakyLabel);

        add(xiLabel);
        add(nextToxiLabel);

        add(emptySpace);
        add(calculateButton);


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateValues();
            }
        });

        //recalculateValues();
    }

    private void recalculateValues() {
        try {
            Projectile projectile = new Projectile(

                    (double) angleSlider.getValue(),
                    Double.parseDouble(velocityField.getText())
            );
            projectile.setSeconds(Double.parseDouble(secondsField.getText())
            );
            nextToxLabel.setText(String.valueOf(projectile.getX()));
            nextToyLabel.setText(String.valueOf(projectile.getY()));
            nextToPeakyLabel.setText(String.valueOf(projectile.getPeakY()));
            nextToxiLabel.setText(String.valueOf(projectile.getInterceptX()));
        } catch (NumberFormatException e) {
            // ignore
        }
    }
}








