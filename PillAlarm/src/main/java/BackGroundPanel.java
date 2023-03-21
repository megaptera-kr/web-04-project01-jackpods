import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BackGroundPanel extends JPanel {
    private final Image backGroundImage;

    BackGroundPanel(String fileName) throws IOException {
        backGroundImage = ImageIO.read(new File(fileName));
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(backGroundImage,0,0,this);
    }
}