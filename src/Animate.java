import characters.*;
import java.awt.event.*;
import javax.swing.*;

public class Animate {

  int character = 0;
  int moveStateSkl = 0;
  int moveStateUni = 0;
  int moveStateSwordK = 0;
  boolean validation = true;
  boolean attk = false;

  public void animateSkel() {
    if ((moveStateSkl == Skeleton.RELAXSKL) || (moveStateSkl == Skeleton.WALKSKL4) || (moveStateSkl == Skeleton.ATTSKL1)
        || (moveStateSkl == Skeleton.ATTSKL2)) {
      moveStateSkl = Skeleton.WALKSKL1;
    } else if (moveStateSkl == Skeleton.WALKSKL1) {
      moveStateSkl = Skeleton.WALKSKL2;
    } else if (moveStateSkl == Skeleton.WALKSKL2) {
      moveStateSkl = Skeleton.WALKSKL3;
    } else if (moveStateSkl == Skeleton.WALKSKL3) {
      moveStateSkl = Skeleton.WALKSKL4;
    }
  }

  public void animateSwordK() {
    if ((moveStateSwordK == SwordKnight.RELAX1SWORDK) || (moveStateSwordK == SwordKnight.WALK2SWORDK)
        || moveStateSwordK == SwordKnight.RELAX2SWORDK) {
      moveStateSwordK = SwordKnight.WALK1SWORDK;
    } else if (moveStateSwordK == SwordKnight.WALK1SWORDK) {
      moveStateSwordK = SwordKnight.WALK2SWORDK;
    }
  }

  public void animateUni() {
    if (moveStateUni == UnicornKnight.WALKUNI1 || moveStateUni == UnicornKnight.WALKUNI4
        || moveStateUni == UnicornKnight.ATTKUNI) {
      moveStateUni = UnicornKnight.WALKUNI2;
    } else if (moveStateUni == UnicornKnight.WALKUNI2) {
      moveStateUni = UnicornKnight.WALKUNI3;
    } else if (moveStateUni == UnicornKnight.WALKUNI3) {
      moveStateUni = UnicornKnight.WALKUNI4;
    }
  }

  Timer t = new Timer(75, new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
      attk = true;
      if ((moveStateSwordK == SwordKnight.WALK1SWORDK) || (moveStateSwordK == SwordKnight.WALK2SWORDK)
          || (moveStateSwordK == SwordKnight.RELAX1SWORDK)) {
        moveStateSwordK = SwordKnight.ATTK1SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK1SWORDK) {
        moveStateSwordK = SwordKnight.ATTK2SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK2SWORDK) {
        moveStateSwordK = SwordKnight.ATTK3SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK3SWORDK) {
        moveStateSwordK = SwordKnight.ATTK4SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK4SWORDK) {
        moveStateSwordK = SwordKnight.ATTK5SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK5SWORDK) {
        moveStateSwordK = SwordKnight.ATTK6SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK6SWORDK) {
        moveStateSwordK = SwordKnight.ATTK7SWORDK;
      } else if (moveStateSwordK == SwordKnight.ATTK7SWORDK) {
        moveStateSwordK = SwordKnight.RELAX2SWORDK;
        attk = false;
        ((Timer) ae.getSource()).stop();
      }
    }
  });
}