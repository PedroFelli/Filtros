package filtros;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ShowImage extends JFrame{
    public void MostraImagem(File file, String image_name) throws IOException {
    	BufferedImage ima = ImageIO.read(file);
    // Define GUI com objetos do Swing
           JLabel lsrc2 = new JLabel(new ImageIcon(ima));
           getContentPane().add(new JScrollPane(lsrc2));

    // Atribui nome e tamanho ao frame
           setTitle("Java2DImageDisplay: =>" + image_name);
          setSize(ima.getWidth()+40, ima.getHeight()+40);
        setVisible(true);

    // Encerra a aplicação clicando no "close"


  }
}
