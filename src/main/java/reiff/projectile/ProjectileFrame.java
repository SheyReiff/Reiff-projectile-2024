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
    private JSlider angleSlider;
    private JTextField velocityField;
    private JTextField secondsField;
    private JLabel nextToXLabel;
    private JLabel nextToYLabel;
    private JLabel nextToPeakYLabel;
    private JLabel nextToXILabel;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(6, 2));
        JLabel angleLabel = new JLabel("Angle");
        JLabel velocityLabel = new JLabel("Velocity");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel(("X"));
        JLabel yLabel = new JLabel(("Y"));
        JLabel peakYLabel = new JLabel(("Peak Y"));
        JLabel XILabel = new JLabel(("X Intercept"));
        JLabel nextToXLabel = new JLabel();
        JLabel nextToYLabel = new JLabel();
        JLabel nextToPeakYLabel = new JLabel();
        JLabel nextToXILabel = new JLabel();
        JLabel emptySpace = new JLabel();
        JButton calculateButton = new JButton("Calculate");


        JSlider angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
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

        JTextField velocityField = new JTextField();
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


        JTextField secondsField = new JTextField();
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

        setLayout(new GridLayout(0, 2));

        add(angleLabel);
        add(angleSlider);
        add(new JLabel());
        add(angleValueLabel);

        add(velocityLabel);
        add(velocityField);

        add(secondsLabel);
        add(secondsField);

        add(xLabel);
        add(nextToXLabel);

        add(yLabel);
        add(nextToYLabel);

        add(peakYLabel);
        add(nextToPeakYLabel);

        add(XILabel);
        add(nextToXILabel);

        add(emptySpace);
        add(calculateButton);


        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateValues();
            }
        });

        recalculateValues();
    }

    private void recalculateValues() {
        Projectile projectile = new Projectile(
                angleSlider.getValue(),
                Double.parseDouble(velocityField.getText())
        );
        projectile.setSeconds(Double.parseDouble(secondsField.getText())
        );
        nextToXLabel.setText(String.valueOf(projectile.getX()));
        nextToYLabel.setText(String.valueOf(projectile.getY()));
        nextToPeakYLabel.setText(String.valueOf(projectile.getPeakY()));
        nextToXILabel.setText(String.valueOf(projectile.getInterceptX()));
    }

}








