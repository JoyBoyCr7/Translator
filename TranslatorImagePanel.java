import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class TranslatorImagePanel extends JPanel{
    Image[] pics;
    String[] images = {"dog.jpg", "cat.jpg", "baby.jpg", "house.jpg", "bread.jpg", "plane.jpg","error.jpg"};

    final int NUM_PICS = images.length;

    JPanel imagePanel;

    Image currentImage;

    ImageIcon icon;
    JLabel imageLabel;

    public TranslatorImagePanel(){
        loadAllImages();
        setUpImagePanel();
    }

    public void loadAllImages(){
        pics = new Image[NUM_PICS];
        for(int i = 0; i < NUM_PICS; i++){
            loadImage(images[i], i);
        }
    }

    public void loadImage(String name, int index){
        String path = "images/"+name;
        File file = new File(path);
        try {
            pics[index] = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setUpImagePanel(){
        imagePanel = new JPanel(new FlowLayout());
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        currentImage = pics[0];

        icon = new ImageIcon();
        icon.setImage(currentImage);
        imageLabel.setIcon(icon);

        imagePanel.add(imageLabel);

        add(imagePanel);
    }
// updates image panel, It's offset by one because of the error image at the end of the array
    public void updateImage(int index) {
        if (index >= 0 && index < pics.length - 1) {
            currentImage = pics[index];
        } else {
            currentImage = pics[pics.length - 1];
        }
        icon.setImage(currentImage);
        imageLabel.setIcon(icon);  
        imageLabel.repaint();   
    }
}


