import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class movement {

  Image Skeleton[] = new Image[9];
  // Image SwordKnight[] = new Image[6];
  // Image Unicorn[] = new Image[6];
  
  final int RelaxSkl = 0;
  final int AttSkl1 = 1;
  final int AttSkl2 = 2;
  final int DeadSkl1 = 3;
  final int DeadSkl2 = 4;
  final int WalkSkl1 = 5;
  final int WalkSkl2 = 6;
  final int WalkSkl3 = 7;
  final int WalkSkl4 = 8;

  int moveState = RelaxSkl;
  int posX = 350;
  int posY = 0;
  boolean validation = true;

  public class Drawning extends JPanel {

    Drawning() {
      try {
        setPreferredSize(new Dimension(1000, 600));
        Skeleton[AttSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking1-Skeleton.png"));
        Skeleton[AttSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking2-Skeleton.png"));
        Skeleton[DeadSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead1-Skeleton.png"));
        Skeleton[DeadSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead2-Skeleton.png"));
        Skeleton[RelaxSkl] = ImageIO.read(new File("../img/Skeleton-Sprites/Relaxed-Skeleton.png"));
        Skeleton[WalkSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking1-Skeleton.png"));
        Skeleton[WalkSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking2-Skeleton.png"));
        Skeleton[WalkSkl3] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking3-Skeleton.png"));
        Skeleton[WalkSkl4] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking4-Skeleton.png"));
      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "The image cannot be loaded!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
    }
    
    public void paintComponent(Graphics g) {

      if(validation) {
        posY = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
        validation = false;
      }

      
      
      super.paintComponent(g);
      g.drawImage(Skeleton[moveState], posX, posY, this);
      // g.drawImage(img, 0, 0, this);
      // g.drawImage(Skeleton[AttSkl1], 0, 0, this);
      // g.drawImage(Skeleton[AttSkl2], 50, 0, this);
      // g.drawImage(Skeleton[DeadSkl1], 100, 0, this);
      // g.drawImage(Skeleton[DeadSkl2], 150, 0, this);
      // g.drawImage(Skeleton[WalkSkl1], 250, 0, this);
      // g.drawImage(Skeleton[WalkSkl2], 300, 0, this);
      // g.drawImage(Skeleton[WalkSkl3], 380, 0, this);
      // g.drawImage(Skeleton[WalkSkl4], 420, 0, this);
      Toolkit.getDefaultToolkit().sync();
    }
  }

  // Declares a new Instance of Drawning Class to be used on pvpGame.
  Drawning draw = new Drawning();

  public void skelMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      if ((moveState == RelaxSkl) || (moveState == WalkSkl4)) {
        moveState = WalkSkl1;
      } else if (moveState == WalkSkl1) {
        moveState = WalkSkl2;
      } else if (moveState == WalkSkl2) {
        moveState = WalkSkl3;
      } else if (moveState == WalkSkl3) {
        moveState = WalkSkl4;
      }
      posX += 5;
      draw.repaint();
    }  if (move == KeyEvent.VK_LEFT) {
      if ((moveState == RelaxSkl) || (moveState == WalkSkl4)) {
        moveState = WalkSkl1;
      } else if (moveState == WalkSkl1) {
        moveState = WalkSkl2;
      } else if (moveState == WalkSkl2) {
        moveState = WalkSkl3;
      } else if (moveState == WalkSkl3) {
        moveState = WalkSkl4;
      }
      posX -= 5;
      draw.repaint();
    }  if (move == KeyEvent.VK_UP) {
      if ((moveState == RelaxSkl) || (moveState == WalkSkl4)) {
        moveState = WalkSkl1;
      } else if (moveState == WalkSkl1) {
        moveState = WalkSkl2;
      } else if (moveState == WalkSkl2) {
        moveState = WalkSkl3;
      } else if (moveState == WalkSkl3) {
        moveState = WalkSkl4;
      }
      posY -= 5;
      draw.repaint();
    }  if (move == KeyEvent.VK_DOWN) {
      if ((moveState == RelaxSkl) || (moveState == WalkSkl4)) {
        moveState = WalkSkl1;
      } else if (moveState == WalkSkl1) {
        moveState = WalkSkl2;
      } else if (moveState == WalkSkl2) {
        moveState = WalkSkl3;
      } else if (moveState == WalkSkl3) {
        moveState = WalkSkl4;
      }
      posY += 5;
      draw.repaint();
    }
  }
}
