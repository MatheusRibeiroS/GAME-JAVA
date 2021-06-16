import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import javax.imageio.*;
import javax.swing.Timer.*;

public class movement {

  Image Skeleton[] = new Image[9];
  Image Unicorn[] = new Image[6];
  Image SwordKnight[] = new Image[12];

  final int RelaxSkl = 0;
  final int AttSkl1 = 1;
  final int AttSkl2 = 2;
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
  final int DeadUni = 4;
  final int AttkUni = 5;

  final int Relax1SwordK = 0;
  final int Relax2SwordK = 1;
  final int Attk1SwordK = 2;
  final int Attk2SwordK = 3;
  final int Attk3SwordK = 4;
  final int Attk4SwordK = 5;
  final int Attk5SwordK = 6;
  final int Attk6SwordK = 7;
  final int Attk7SwordK = 8;
  final int Walk1SwordK = 9;
  final int Walk2SwordK = 10;

  int globMove;

  int moveStateSkl = RelaxSkl;
  int moveStateUni = WalkUni1;
  int moveStateSwordK = Relax1SwordK;
  int posXSkl = 350;
  int posYSkl = 0;
  int posXUni = 500;
  int posYUni = 500;
  int posXSwordK = 600;
  int posYSwordK = 500;
  boolean validation = true;
  int character = 0;
  Image background;

  public class Drawning extends JPanel {

    Drawning() {

      try {
        setPreferredSize(new Dimension(1000, 600));
        background = ImageIO.read(new File("../img/Background.JPG"));
        // Skeleton Sprites imported
        Skeleton[RelaxSkl] = ImageIO.read(new File("../img/Skeleton-Sprites/Relaxed-Skeleton.png"));
        Skeleton[AttSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking1-Skeleton.png"));
        Skeleton[AttSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking2-Skeleton.png"));
        Skeleton[DeadSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead1-Skeleton.png"));
        Skeleton[DeadSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead2-Skeleton.png"));
        Skeleton[WalkSkl1] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking1-Skeleton.png"));
        Skeleton[WalkSkl2] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking2-Skeleton.png"));
        Skeleton[WalkSkl3] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking3-Skeleton.png"));
        Skeleton[WalkSkl4] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking4-Skeleton.png"));
        // Unicorn Sprites Imported
        Unicorn[WalkUni1] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking1-Unicorn.png"));
        Unicorn[WalkUni2] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking2-Unicorn.png"));
        Unicorn[WalkUni3] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking3-Unicorn.png"));
        Unicorn[WalkUni4] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking4-Unicorn.png"));
        Unicorn[DeadUni] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Dead-Unicorn.png"));
        Unicorn[AttkUni] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Attacking-Unicorn.png"));
        // Sword Knight Imported
        SwordKnight[Relax1SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Relaxed1-Sword-Knight.png"));
        SwordKnight[Relax2SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Relaxed2-Sword-Knight.png"));
        SwordKnight[Attk1SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking1-Sword-Knight.png"));
        SwordKnight[Attk2SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking2-Sword-Knight.png"));
        SwordKnight[Attk3SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking3-Sword-Knight.png"));
        SwordKnight[Attk4SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking4-Sword-Knight.png"));
        SwordKnight[Attk5SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking5-Sword-Knight.png"));
        SwordKnight[Attk6SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking6-Sword-Knight.png"));
        SwordKnight[Attk7SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Attacking7-Sword-Knight.png"));
        SwordKnight[Walk1SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Walking1-Sword-Knight.png"));
        SwordKnight[Walk2SwordK] = ImageIO.read(new File("../img/Sword-Knight-Sprites/Walking2-Sword-Knight.png"));

      } catch (IOException e) {
        JOptionPane.showMessageDialog(this, "A imagem não pôde ser carregada!\n" + e, "Error",
            JOptionPane.ERROR_MESSAGE);
        System.exit(1);
      }

      Timer t = new Timer(250, new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
          if (moveStateSwordK == Walk1SwordK || moveStateSwordK == Walk2SwordK || moveStateSwordK == Relax1SwordK) {
            moveStateSwordK = Attk1SwordK;
          }
          if (moveStateSwordK == Attk1SwordK) {
            moveStateSwordK = Attk2SwordK;
          }
          if (moveStateSwordK == Attk2SwordK) {
            moveStateSwordK = Attk3SwordK;
          }
          if (moveStateSwordK == Attk3SwordK) {
            moveStateSwordK = Attk4SwordK;
          }
          if (moveStateSwordK == Attk4SwordK) {
            moveStateSwordK = Attk5SwordK;
          }
          if (moveStateSwordK == Attk5SwordK) {
            moveStateSwordK = Attk6SwordK;
          }
          if (moveStateSwordK == Attk6SwordK) {
            moveStateSwordK = Attk7SwordK;
          }
          if (moveStateSwordK == Attk7SwordK) {
            moveStateSwordK = Relax2SwordK;
          }
          if (moveStateSwordK == Relax2SwordK) {
            moveStateSwordK = Relax1SwordK;
          }
          swordKMov(globMove);
        }
      });
      t.start();
      t.stop();
    }

    public void paintComponent(Graphics g) {

      if (validation) {
        posYSkl = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
        validation = false;
        posYSkl = (getSize().height / 2) - Skeleton[RelaxSkl].getHeight(this);
      }

      super.paintComponent(g);
      g.drawImage(background, 0, 0, getSize().width, getSize().height, this);
      g.drawImage(Skeleton[moveStateSkl], posXSkl, posYSkl, this);
      g.drawImage(Unicorn[moveStateUni], posXUni, posYUni, this);
      g.drawImage(SwordKnight[moveStateSwordK], posXSwordK, posYSwordK, this);
      Toolkit.getDefaultToolkit().sync();
    }
  }

  // Declares a new Instance of Drawning Class to be used on pvpGame.
  Drawning draw = new Drawning();

  public void moveP1(int move, String P1) {
    globMove = move;
    if (P1.equals("Skeleton")) {
      skelMov(move);
    }
    if (P1.equals("Unicorn")) {
      uniMov(move);
    }
    if (P1.equals("SwordKnight")) {
      swordKMov(move);
    }
  }

  // public void moveP2(int move, String P2) {
  // if (P2.equals("Skeleton")) {

  // }
  // if (P2.equals("Unicorn")) {

  // }
  // if (P2.equals("SwordKnight")) {

  // }
  // }

  public void animateSkel() {
    if ((moveStateSkl == RelaxSkl) || (moveStateSkl == WalkSkl4) || (moveStateSkl == AttSkl1)
        || (moveStateSkl == AttSkl2)) {
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
    if (moveStateUni == WalkUni1 || moveStateUni == WalkUni4 || moveStateUni == AttkUni) {
      moveStateUni = WalkUni2;
    } else if (moveStateUni == WalkUni2) {
      moveStateUni = WalkUni3;
    } else if (moveStateUni == WalkUni3) {
      moveStateUni = WalkUni4;
    }
  }

  public void animateSwordK() {
    if ((moveStateSwordK == Relax1SwordK) || (moveStateSwordK == Walk2SwordK) || moveStateSwordK == Relax2SwordK) {
      moveStateSwordK = Walk1SwordK;
    } else if (moveStateSwordK == Walk1SwordK) {
      moveStateSwordK = Walk2SwordK;
    }
  }

  // Move Skeleton
  public void skelMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {

      animateSkel();
      posXSkl += 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_LEFT) {
      animateSkel();
      posXSkl -= 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_UP) {

      animateSkel();
      posYSkl -= 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_DOWN) {

      animateSkel();
      posYSkl += 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_SPACE) {
      if (moveStateSkl == AttSkl1) {
        moveStateSkl = AttSkl2;
        draw.repaint();
      }
      if (moveStateSkl != AttSkl2) {
        moveStateSkl = AttSkl1;
        draw.repaint();
      }
    }
  }

  // Move Unicorn
  public void uniMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateUni();
      posXUni += 5;
      draw.repaint();
    } else if (move == KeyEvent.VK_LEFT) {
      animateUni();
      posXUni -= 5;
      draw.repaint();
    } else if (move == KeyEvent.VK_UP) {
      animateUni();
      posYUni -= 5;
      draw.repaint();
    } else if (move == KeyEvent.VK_DOWN) {
      animateUni();
      posYUni += 5;
      draw.repaint();
    } else if (move == KeyEvent.VK_SPACE) {
      if (moveStateUni != AttkUni) {
        moveStateUni = AttkUni;
      } else {
        moveStateUni = WalkUni1;
      }
      draw.repaint();
    }
  }

  // Move Sword Knight
  public void swordKMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateSwordK();
      posXSwordK += 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_LEFT) {
      animateSwordK();
      posXSwordK -= 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_UP) {

      animateSwordK();
      posYSwordK -= 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_DOWN) {

      animateSwordK();
      posYSwordK += 5;
      draw.repaint();

    }
    if (move == KeyEvent.VK_SPACE) {
      draw.repaint();
    }
  }

}
