import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

class PVPGame extends JFrame {
  Image img;
  Image img1;
  Image img2;
  Image img3;
  Image img4;
  Image img5;
  Image img6;
  Image img7;
  Image img8;
  
  Drawning drawning = new Drawning();

  class Drawning extends JPanel {

    Drawning() {
      try {
        setPreferredSize(new Dimension(1000, 600));
        //img = ImageIO.read(new File("background.jpeg"));
        img = ImageIO.read(new File("./img/Skeleton-Sprites/Relaxed-Skeleton.png"));
        img1 = ImageIO.read(new File("./img/Skeleton-Sprites/Attacking1-Skeleton.png"));
        img2 = ImageIO.read(new File("./img/Skeleton-Sprites/Attacking2-Skeleton.png"));
        img3 = ImageIO.read(new File("./img/Sword-Knight-Sprites/pixil-frame-0.png"));
        img4 = ImageIO.read(new File("./img/Sword-Knight-Sprites/Preparing-Attack-Sword-Knight.png"));
        img5 = ImageIO.read(new File("./img/Unicorn-Knight/UnicornAttack.png"));
        img6 = ImageIO.read(new File("./img/Unicorn-Knight/UnicornDead.png"));
        img7 = ImageIO.read(new File("./img/Unicorn-Knight/UnicornWalk1.png"));
        img8 = ImageIO.read(new File("./img/Trident-Knight/TridentKnight.png"));
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "The image cannot be loaded!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(img, 0, 0, this);
      g.drawImage(img, 0, 0, this);
      g.drawImage(img1, 50, 0, this);
      g.drawImage(img2, 100, 0, this);
      g.drawImage(img3, 150, 0, this);
      g.drawImage(img4, 200, 0, this);
      g.drawImage(img5, 250, 0, this);
      g.drawImage(img6, 300, 0, this);
      g.drawImage(img7, 380, 0, this);
      g.drawImage(img8, 420, 0, this);
      Toolkit.getDefaultToolkit().sync();
    }
  }

  PVPGame() {
    super("PVP GAME");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(drawning);
    pack();
    setVisible(true);
  }

  static public void main(String[] args) {
    PVPGame PVP = new PVPGame();
  }
}
