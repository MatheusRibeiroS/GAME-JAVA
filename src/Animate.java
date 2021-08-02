import characters.*;
import java.awt.event.*;
import javax.swing.*;

public class Animate {

  int character = 0;
  boolean validation = true;
  boolean attk = false;

  public void animateSkel() {
    if ((Skeleton.skl.getSprite() == Skeleton.RELAXSKL) || (Skeleton.skl.getSprite() == Skeleton.WALKSKL4)
        || (Skeleton.skl.getSprite() == Skeleton.ATTSKL1) || (Skeleton.skl.getSprite() == Skeleton.ATTSKL2)
        || (Skeleton.skl.getSprite() == Skeleton.RELAXSKL_L) || (Skeleton.skl.getSprite() == Skeleton.WALKSKL4_L)
        || (Skeleton.skl.getSprite() == Skeleton.ATTSKL1_L) || (Skeleton.skl.getSprite() == Skeleton.ATTSKL2_L)) {
      if (Skeleton.skl.isLeft) {
        Skeleton.skl.setSprite(Skeleton.WALKSKL1_L);
      } else {
        Skeleton.skl.setSprite(Skeleton.WALKSKL1);
      }
    } else if (Skeleton.skl.getSprite() == Skeleton.WALKSKL1 || Skeleton.skl.getSprite() == Skeleton.WALKSKL1_L) {
      if (Skeleton.skl.isLeft) {
        Skeleton.skl.setSprite(Skeleton.WALKSKL2_L);
      } else {
        Skeleton.skl.setSprite(Skeleton.WALKSKL2);
      }
    } else if (Skeleton.skl.getSprite() == Skeleton.WALKSKL2 || Skeleton.skl.getSprite() == Skeleton.WALKSKL2_L) {
      if (Skeleton.skl.isLeft) {
        Skeleton.skl.setSprite(Skeleton.WALKSKL3_L);
      } else {
        Skeleton.skl.setSprite(Skeleton.WALKSKL3);
      }
    } else if (Skeleton.skl.getSprite() == Skeleton.WALKSKL3 || Skeleton.skl.getSprite() == Skeleton.WALKSKL3_L) {
      if (Skeleton.skl.isLeft) {
        Skeleton.skl.setSprite(Skeleton.WALKSKL4_L);
      } else {
        Skeleton.skl.setSprite(Skeleton.WALKSKL4);
      }
    }
  }

  public void animateSwordK() {
    if ((SwordKnight.sword.getSprite() == SwordKnight.RELAX1SWORDK)
        || (SwordKnight.sword.getSprite() == SwordKnight.WALK2SWORDK)
        || SwordKnight.sword.getSprite() == SwordKnight.RELAX2SWORDK
        || (SwordKnight.sword.getSprite() == SwordKnight.RELAX1SWORDK_L)
        || (SwordKnight.sword.getSprite() == SwordKnight.WALK2SWORDK_L)
        || SwordKnight.sword.getSprite() == SwordKnight.RELAX2SWORDK_L) {
      if (SwordKnight.sword.isLeft) {
        SwordKnight.sword.setSprite(SwordKnight.WALK1SWORDK_L);
      } else {
        SwordKnight.sword.setSprite(SwordKnight.WALK1SWORDK);
      }
    } else if (SwordKnight.sword.getSprite() == SwordKnight.WALK1SWORDK
        || SwordKnight.sword.getSprite() == SwordKnight.WALK1SWORDK_L) {
      if (SwordKnight.sword.isLeft) {
        SwordKnight.sword.setSprite(SwordKnight.WALK2SWORDK_L);
      } else {
        SwordKnight.sword.setSprite(SwordKnight.WALK2SWORDK);
      }
    }
  }

  public void animateUni() {
    if (UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI1
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI4
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.ATTKUNI
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI1_L
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI4_L
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.ATTKUNI_L) {
      if (UnicornKnight.unicorn.isLeft) {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI2_L);
      } else {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI2);
      }
    } else if (UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI2
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI2_L) {
      if (UnicornKnight.unicorn.isLeft) {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI3_L);
      } else {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI3);
      }
    } else if (UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI3
        || UnicornKnight.unicorn.getSprite() == UnicornKnight.WALKUNI3_L) {
      if (UnicornKnight.unicorn.isLeft) {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI4_L);
      } else {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI4);
      }
    }
  }

  Timer t = new Timer(75, new ActionListener() {
    public void actionPerformed(ActionEvent ae) {
      attk = true;
      if ((SwordKnight.sword.getSprite() == SwordKnight.WALK1SWORDK)
          || (SwordKnight.sword.getSprite() == SwordKnight.WALK2SWORDK)
          || (SwordKnight.sword.getSprite() == SwordKnight.RELAX1SWORDK)
          || (SwordKnight.sword.getSprite() == SwordKnight.WALK1SWORDK_L)
          || (SwordKnight.sword.getSprite() == SwordKnight.WALK2SWORDK_L)
          || (SwordKnight.sword.getSprite() == SwordKnight.RELAX1SWORDK_L)) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK1SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK1SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK1SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK1SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK2SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK2SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK2SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK2SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK3SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK3SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK3SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK3SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK4SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK4SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK4SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK4SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK5SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK5SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK5SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK5SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK6SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK6SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK6SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK6SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.ATTK7SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.ATTK7SWORDK);
        }
      } else if (SwordKnight.sword.getSprite() == SwordKnight.ATTK7SWORDK
          || SwordKnight.sword.getSprite() == SwordKnight.ATTK7SWORDK_L) {
        if (SwordKnight.sword.isLeft) {
          SwordKnight.sword.setSprite(SwordKnight.RELAX2SWORDK_L);
        } else {
          SwordKnight.sword.setSprite(SwordKnight.RELAX2SWORDK);
        }
        attk = false;
        ((Timer) ae.getSource()).stop();
      }
    }
  });
}