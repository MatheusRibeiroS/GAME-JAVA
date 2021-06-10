import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.rmi.server.Skeleton;

import javax.imageio.*;

class pvpGame extends JFrame {
  final int AttSkl1 = 0;
  final int AttSkl2 = 1;
  final int DeadSkl1 = 2;
  final int DeadSkl2 = 3;
  final int RelaxSkl = 4;
  final int WalkSkl1 = 5;
  final int WalkSkl2 = 6;
  final int WalkSkl3 = 7;
  final int WalkSkl4 = 8;

  Image Skeleton[] = new Image[9];
  //Image SwordKnight[] = new Image[6];
  //Image Unicorn[] = new Image[6];
  
  Drawning drawning = new Drawning();

  class Drawning extends JPanel {

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
      super.paintComponent(g);
      //g.drawImage(img, 0, 0, this);
    //   g.drawImage(Skeleton[AttSkl1], 0, 0, this);
    //   g.drawImage(Skeleton[AttSkl2], 50, 0, this);
    //   g.drawImage(Skeleton[DeadSkl1], 100, 0, this);
    //   g.drawImage(Skeleton[DeadSkl2], 150, 0, this);
    g.drawImage(Skeleton[RelaxSkl], 200, 0, this);
    //   g.drawImage(Skeleton[WalkSkl1], 250, 0, this);
    //   g.drawImage(Skeleton[WalkSkl2], 300, 0, this);
    //   g.drawImage(Skeleton[WalkSkl3], 380, 0, this);
    //   g.drawImage(Skeleton[WalkSkl4], 420, 0, this);
      Toolkit.getDefaultToolkit().sync();
    }
  }

  pvpGame() {
    super("PVP GAME");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    add(drawning);
    pack();
    setVisible(true);
    movement m = new movement();
    addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        m.skelMov(c);
      }
    });
  }

  static public void main(String[] args) {
    pvpGame pvp = new pvpGame();
  }
}
