import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Translator extends JFrame implements ActionListener {

    String[] englishWords = {"Dog", "Cat", "baby", "House", "Bread", "Plane"};
    String[] frenchWords = {"Chien", "Chat", "Bebe", "Maison", "Pain", "Avion"};

    private JPanel titlePanel, inputPanel, mainPanel, instructPanel, inputHolderPanel;
    private JTextField englishTextField, frenchTextField;
    private JButton translateButton;
    JLabel title, definitionsLabel;
    TranslatorImagePanel translatorImagePanel;
    
    public static void main(String[] args) {
        Translator frame = new Translator();
        frame.setSize(800,800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setUpGUI();
        frame.setVisible(true);
    }

    public void setUpTitle(){
        titlePanel = new JPanel(new FlowLayout());
        title =new JLabel("English to French Translator");
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);
    }

    public void setUpGUI(){
        setUpTitle();
        createTextFields();
        setUpImagePanel();
    }

    public void createTextFields(){
        inputPanel = new JPanel();
        translateButton = new JButton("Translate");
        translateButton.addActionListener(this);
        englishTextField = new JTextField(20);
        frenchTextField = new JTextField(20);
        inputPanel.add(new JLabel("English:"));
        inputPanel.add(englishTextField);
        inputPanel.add(translateButton);
        inputPanel.add(new JLabel("French:"));
        inputPanel.add(frenchTextField);
        definitionsLabel = new JLabel("adsdsdf");

        instructPanel = new JPanel();
        definitionsLabel = new JLabel("Choose from: baby, cat, dog, bread, house, plane.");
        instructPanel.add(definitionsLabel);

        inputHolderPanel = new JPanel(new GridLayout(2,1));
        inputHolderPanel.add(instructPanel);
        inputHolderPanel.add(inputPanel);
        add(inputHolderPanel, BorderLayout.SOUTH);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == translateButton){
            String inputWord = englishTextField.getText();
            int index = getWordIndex(inputWord);
            
            if (index != -1) {
                frenchTextField.setText(frenchWords[index]);
                translatorImagePanel.updateImage(index);
            } else {
                frenchTextField.setText("Error: Translation not found");
                translatorImagePanel.updateImage(-1);
            }
            
        }
    
    }

    private int getWordIndex(String word) {
        for (int i = 0; i < englishWords.length; i++) {
            if (englishWords[i].equalsIgnoreCase(word)) {
                return i;
            }
        }
        return -1;
    }

    public void setUpImagePanel(){
        translatorImagePanel = new TranslatorImagePanel();
        mainPanel = new JPanel();

        mainPanel.add(translatorImagePanel);
        
        add(mainPanel, BorderLayout.CENTER);
    }

}
