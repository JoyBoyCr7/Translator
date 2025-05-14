import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class TranslatorControl extends JPanel {
    private JTextField englishTextField, frenchTextField;
    private JButton translateButton;
    private JPanel imagePanel, controlsPanel;

    TranslatorImagePanel translator;

    public TranslatorControl(TranslatorImagePanel translator) {
        this.translator = translator;
        setupControls();
    }

    private void setupControls() {
        englishTextField = new JTextField(40);
        frenchTextField = new JTextField(40);
        translateButton = new JButton("Translate");
        imagePanel = new JPanel();
        controlsPanel = new JPanel();

        controlsPanel.add(translateButton);
        add(controlsPanel);

    }

    





    
    
}
