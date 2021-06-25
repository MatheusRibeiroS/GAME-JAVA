import java.awt.*;
import java.io.*;
import javax.swing.*;
import characters.*;
import javax.imageio.*;

public class paint extends JPanel {
  Image background;

  //create Instances of the characters

  skeleton Skl = new skeleton();
  tridentKnight tKnight = new tridentKnight();
  unicornKnight uni = new unicornKnight();
  swordKnight sKnight = new swordKnight();

  paint() {

    try {
      setPreferredSize(new Dimension(1000, 600));
      background = ImageIO.read(new File("../img/Background.JPG"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(this, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void paintComponent(Graphics g) {
    boolean validation;
    int posXSkl = 350;
    int posYSkl = 0;
  
    if (validation) {
      posYSkl = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
      validation = false;
      posYSkl = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
    }
    
    super.paintComponent(g);
    g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
    g.drawImage(Skl.getSprite(), Skl.getX(), Skl.getY(), this);
    g.drawImage(uni.getSprite(), uni.getX(), uni.getY(), this);
    g.drawImage(sKnight.getSprite(), sKnight.getX(), sKnight.getY(), this);
    Toolkit.getDefaultToolkit().sync();
    this.repaint();
  }

}

