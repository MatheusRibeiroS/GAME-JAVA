import java.awt.event.*;
import characters.*;

public class Movement extends Animate {

  final int ADD = 7;

  Collision collision = new Collision();

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
    /*
     * if (P1.equals("TridenKnight")) { tKnightMov(move); }
     */
  }

  // Move Skeleton
  public void skelMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      Skeleton.skl.x += ADD;
      animateSkel();
      // border value = 30
      if(collision.collide("Skeleton") == 1 || Skeleton.skl.x > Paint.background.getWidth(null) - 30) {
        Skeleton.skl.x -= ADD;
      }
      
    }
    if (move == KeyEvent.VK_LEFT) {
      Skeleton.skl.x -= ADD;
      animateSkel();
      if(collision.collide("Skeleton") == 1 || Skeleton.skl.x < 0) {
        Skeleton.skl.x += ADD;
      }
    }
    if (move == KeyEvent.VK_UP) {
      Skeleton.skl.y -= ADD;
      animateSkel();
      if (collision.collide("Skeleton") == 1 || Skeleton.skl.y < 110) {
        Skeleton.skl.y += ADD;
      }
    }
    if (move == KeyEvent.VK_DOWN) {
      Skeleton.skl.y += ADD;
      animateSkel();
      // border value = 30
      if (collision.collide("Skeleton") == 1 || Skeleton.skl.y > Paint.background.getHeight(null) - 110) {
        Skeleton.skl.y -= ADD;
      }
    }
    if (move == KeyEvent.VK_SPACE) {
      if (Skeleton.skl.getSprite() == Skeleton.ATTSKL1) {
        Skeleton.skl.setSprite(Skeleton.ATTSKL2);
      }
      if (Skeleton.skl.getSprite() != Skeleton.ATTSKL2) {
        Skeleton.skl.setSprite(Skeleton.ATTSKL1);
      }
    }
  }

  // Move Unicorn
  public void uniMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateUni();
      UnicornKnight.unicorn.x += ADD;
      // border value = 30
      if (collision.collide("Unicorn") == 1 || UnicornKnight.unicorn.x > Paint.background.getWidth(null) - 30) {
        UnicornKnight.unicorn.x -= ADD;
      }

    } else if (move == KeyEvent.VK_LEFT) {
      animateUni();
      UnicornKnight.unicorn.x -= ADD;
      if (collision.collide("Unicorn") == 1 || UnicornKnight.unicorn.x < 0) {
        UnicornKnight.unicorn.x += ADD;
      }

    } else if (move == KeyEvent.VK_UP) {
      animateUni();
      UnicornKnight.unicorn.y -= ADD;
      if (collision.collide("Unicorn") == 1 || UnicornKnight.unicorn.y < 110) {
        UnicornKnight.unicorn.y += ADD;
      }

    } else if (move == KeyEvent.VK_DOWN) {
      animateUni();
      UnicornKnight.unicorn.y += ADD;
      // border value = 30
      if (collision.collide("Unicorn") == 1 || UnicornKnight.unicorn.y > Paint.background.getHeight(null) - 110) {
        UnicornKnight.unicorn.y -= ADD;
      }
    } else if (move == KeyEvent.VK_SPACE) {
      if (UnicornKnight.unicorn.getSprite() != UnicornKnight.ATTKUNI) {
        UnicornKnight.unicorn.setSprite(UnicornKnight.ATTKUNI);
      } else {
        UnicornKnight.unicorn.setSprite(UnicornKnight.WALKUNI1);
      }
    }
  }

  // Move Sword Knight
  public void swordKMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateSwordK();
      SwordKnight.sword.x += ADD;
      // border value = 30
      if (collision.collide("SwordKnight") == 1|| SwordKnight.sword.x > Paint.background.getWidth(null) - 30) {
        SwordKnight.sword.x -= ADD;
      }

    } else if (move == KeyEvent.VK_LEFT) {
      animateSwordK();
      SwordKnight.sword.x -= ADD;
      if (collision.collide("SwordKnight") == 1|| SwordKnight.sword.x < 0) {
        SwordKnight.sword.x += ADD;
      }

    } else if (move == KeyEvent.VK_UP) {
      animateSwordK();
      SwordKnight.sword.y -= ADD;
      if (collision.collide("SwordKnight") == 1|| SwordKnight.sword.y < 110) {
        SwordKnight.sword.y += ADD;
      }

    } else if (move == KeyEvent.VK_DOWN) {
      animateSwordK();
      SwordKnight.sword.y += ADD;
      if (collision.collide("SwordKnight") == 1|| SwordKnight.sword.y > Paint.background.getHeight(null) - 110) {
        SwordKnight.sword.y -= ADD;
      }

    } else if (move == KeyEvent.VK_SPACE) {
      if (!attk) {
        t.start();
      }
    }
  }
}