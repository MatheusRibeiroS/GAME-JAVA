import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.net.http.WebSocket.Listener;
import java.sql.Time;

import javax.imageio.*;

public class movement {

  Image Skeleton[] = new Image[9];
  Image Unicorn[] = new Image[6];
  // Image SwordKnight[] = new Image[6];
  

  final int RelaxSkl = 0;
  final int AttSkl1 =  1;
  final int AttSkl2 =  2;
  final int DeadSkl1 = 3;
  final int DeadSkl2 = 4;
  final int WalkSkl1 = 5;
  final int WalkSkl2 = 6;
  final int WalkSkl3 = 7;
  final int WalkSkl4 = 8;
  final int WalkUni1 = 0;
  final int WalkUni2 = 1;
  final int WalkUni3 = 2;
  final int WalkUni4 = 3;
  final int DeadUni  = 4;
  final int AttkUni  = 5;

  int moveStateSkl = RelaxSkl;
  int moveStateUni = WalkUni1;
  int posXSkl = 350;
  int posYSkl = 0;
  int posXUni = 500;
  int posYUni = 500;
  boolean validation = true;
  int character = 0;

  public class Drawning extends JPanel {

    Drawning() {
      try {
        setPreferredSize(new Dimension(1000, 600));
        //Skeleton Sprites imported
        Skeleton[AttSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking1-Skeleton.png"));
        Skeleton[AttSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking2-Skeleton.png"));
        Skeleton[DeadSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead1-Skeleton.png"));
        Skeleton[DeadSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead2-Skeleton.png"));
        Skeleton[RelaxSkl] = ImageIO.read(new File("../img/Skeleton-Sprites/Relaxed-Skeleton.png"));
        Skeleton[WalkSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking1-Skeleton.png"));
        Skeleton[WalkSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking2-Skeleton.png"));
        Skeleton[WalkSkl3] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking3-Skeleton.png"));
        Skeleton[WalkSkl4] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking4-Skeleton.png"));
        //Unicorn Sprites Imported
        Unicorn[WalkUni1] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking1-Unicorn.png"));
        Unicorn[WalkUni2] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking2-Unicorn.png"));
        Unicorn[WalkUni3] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking3-Unicorn.png"));
        Unicorn[WalkUni4] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking4-Unicorn.png"));
        Unicorn[DeadUni] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Dead-Unicorn.png"));
        Unicorn[AttkUni] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Attacking-Unicorn.png"));

      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "The image cannot be loaded!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }
    }

    public void paintComponent(Graphics g) {

      if (validation) {
        posYSkl = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
        validation = false;
        posYSkl = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
      }

      super.paintComponent(g);
      g.drawImage(Skeleton[moveStateSkl], posXSkl, posYSkl, this);
      g.drawImage(Unicorn[moveStateUni], posXUni, posYUni, this);
      Toolkit.getDefaultToolkit().sync();
    }
  }

  // Declares a new Instance of Drawning Class to be used on pvpGame.
  Drawning draw = new Drawning();

  public void moveP1(int move, String P1) {
    if(P1.equals("Skeleton")) {
      skelMov(move);
    }
    if(P1.equals("Unicorn")) {
      uniMov(move);
    }
  }

  public void moveP2(int move, String P2) {
    if(P2.equals("Skeleton")) {
      
    }
    if(P2.equals("Unicorn")) {

    }
  }

  public void animateSkel() {
    if((moveStateSkl == RelaxSkl) || (moveStateSkl == WalkSkl4) || (moveStateSkl == AttSkl1) || (moveStateSkl == AttSkl2)) {
      moveStateSkl = WalkSkl1;
    } else if (moveStateSkl == WalkSkl1) {
      moveStateSkl = WalkSkl2;
    } else if (moveStateSkl == WalkSkl2) {
      moveStateSkl = WalkSkl3;
    } else if (moveStateSkl == WalkSkl3) {
      moveStateSkl = WalkSkl4;
    }
  }

  public void animateUni() {
    if(moveStateUni == WalkUni1 || moveStateUni == WalkUni4 || moveStateUni == AttkUni) {
      moveStateUni = WalkUni2;
    } else if(moveStateUni == WalkUni2) {
      moveStateUni = WalkUni3;
    } else if(moveStateUni == WalkUni3) {
      moveStateUni = WalkUni4;
    }
  }
  //Move Skeleton
  public void skelMov(int move) {
    if(move == KeyEvent.VK_RIGHT) {

      animateSkel();
      posXSkl += 5;
      draw.repaint();

    }
    if(move == KeyEvent.VK_LEFT) {
      animateSkel();
      posXSkl -= 5;
      draw.repaint();

    }
    if(move == KeyEvent.VK_UP) {

      animateSkel();
      posYSkl -= 5;
      draw.repaint();

    }
    if(move == KeyEvent.VK_DOWN) {

      animateSkel();
      posYSkl += 5;
      draw.repaint();

    }
    if(move == KeyEvent.VK_SPACE) {
      if(moveStateSkl == AttSkl1) {
        moveStateSkl = AttSkl2;
        draw.repaint();
      } if(moveStateSkl != AttSkl2) {
        moveStateSkl = AttSkl1;
        draw.repaint();
      }
    }
  }
  //Move Unicorn
  public void uniMov(int move) {
    if(move == KeyEvent.VK_RIGHT) {
      animateUni();
      posXUni += 5;
      draw.repaint();
    } else if(move == KeyEvent.VK_LEFT) {
      animateUni();
      posXUni -= 5;
      draw.repaint();
    } else if(move == KeyEvent.VK_UP) {
      animateUni();
      posYUni -= 5;
      draw.repaint();
    } else if(move == KeyEvent.VK_DOWN) {
      animateUni();
      posYUni += 5;
      draw.repaint();
    } else if(move == KeyEvent.VK_SPACE) {
      if(moveStateUni != AttkUni) {
        moveStateUni = AttkUni;
      } else{
        moveStateUni = WalkUni1;
      }
      draw.repaint();
    }
  }
}
