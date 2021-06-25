import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.Timer;

public class movement {

  Timer t = null;

  int moveStateSkl = RelaxSkl;
  int moveStateUni = WalkUni1;
  int moveStateSwordK = Relax1SwordK;

  boolean validation = true;
  boolean attk = false;
  int character = 0;
  

  colision Colision;
  
  public void moveP1(int move, String P1) {
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
      //if(posXSkl < background.getWidth(null)) {
        posXSkl += 5;
      //}
    
    }
    if (move == KeyEvent.VK_LEFT) {
      animateSkel();
      //if(posXSkl < background.getWidth(null)) {
        posXSkl -= 5;
      //}
    }
    if (move == KeyEvent.VK_UP) {
      animateSkel();
      //if(posYSkl > background.getHeight(null)) {
        posYSkl -= 5;
      //}
    }
    if (move == KeyEvent.VK_DOWN) {

      animateSkel();
      //if(posYSkl < background.getHeight(null)) {
        posYSkl += 5;
      //}

    }
    if (move == KeyEvent.VK_SPACE) {
      if (moveStateSkl == AttSkl1) {
        moveStateSkl = AttSkl2;

      }
      if (moveStateSkl != AttSkl2) {
        moveStateSkl = AttSkl1;
      }
    }
  }

  // Move Unicorn
  public void uniMov(int move) {
    Colision.setRectUni(Colision.rectUni);
    if (move == KeyEvent.VK_RIGHT) {
      animateUni();
      posXUni += 5;

    } else if (move == KeyEvent.VK_LEFT) {
      animateUni();
      posXUni -= 5;

    } else if (move == KeyEvent.VK_UP) {
      animateUni();
      posYUni -= 5;

    } else if (move == KeyEvent.VK_DOWN) {
      animateUni();
      posYUni += 5;

    } else if (move == KeyEvent.VK_SPACE) {
      if (moveStateUni != AttkUni) {
        moveStateUni = AttkUni;
      } else {
        moveStateUni = WalkUni1;
      }
    }
  }

  // Move Sword Knight
  public void swordKMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateSwordK();
      posXSwordK += 5;

    } else if (move == KeyEvent.VK_LEFT) {
      animateSwordK();
      posXSwordK -= 5;

    } else if (move == KeyEvent.VK_UP) {

      animateSwordK();
      posYSwordK -= 5;

    } else if (move == KeyEvent.VK_DOWN) {
      animateSwordK();
      posYSwordK += 5;

    } else if (move == KeyEvent.VK_SPACE) {
      if(!attk){
        t.start();
      }
    }

    t = new Timer(75, new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        attk = true;
        if ((moveStateSwordK == Walk1SwordK) || (moveStateSwordK == Walk2SwordK) || (moveStateSwordK == Relax1SwordK)) {
          moveStateSwordK = Attk1SwordK;
        } else if (moveStateSwordK == Attk1SwordK) {
          moveStateSwordK = Attk2SwordK;
        } else if (moveStateSwordK == Attk2SwordK) {
          moveStateSwordK = Attk3SwordK;
        } else if (moveStateSwordK == Attk3SwordK) {
          moveStateSwordK = Attk4SwordK;
        } else if (moveStateSwordK == Attk4SwordK) {
          moveStateSwordK = Attk5SwordK;
        } else if (moveStateSwordK == Attk5SwordK) {
          moveStateSwordK = Attk6SwordK;
        } else if (moveStateSwordK == Attk6SwordK) {
          moveStateSwordK = Attk7SwordK;
        } else if (moveStateSwordK == Attk7SwordK) {
          moveStateSwordK = Relax2SwordK;
          attk = false;
          ((Timer)ae.getSource()).stop();
        }
      }
    });
  }

  public Image[] getSkeleton() {
    return Skeleton;
  }

  public Image[] getUnicorn() {
    return Unicorn;
  }

  public Image[] getSwordKnight() {
    return SwordKnight;
  }

  public int getPosXSkl() {
      return posXSkl;
  } 

  public void createColision() {
    Colision = new colision(posXSkl,posYSkl,posXUni,posYUni, posXSwordK, posYSwordK, moveStateSkl, moveStateUni, moveStateSwordK, getSkeleton(),getUnicorn(),getSwordKnight());
  }

}