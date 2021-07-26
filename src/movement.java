import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import characters.*;

public class Movement extends Animate {

    Colision colision = new Colision();
  

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

      animateSkel();
      if(Skeleton.skeleton.x < Paint.background.getWidth(null)) {
       Skeleton.skeleton.x += ADD;
      }

    }
    if (move == KeyEvent.VK_LEFT) {
      animateSkel();
      if(Skeleton.skeleton.x < Paint.background.getWidth(null)) {
      Skeleton.skeleton.x -= ADD;
      }
    }
    if (move == KeyEvent.VK_UP) {
      animateSkel();
      if(Skeleton.skeleton.x > Paint.background.getHeight(null)) {
      Skeleton.skeleton.y -= ADD;
      }
    }
    if (move == KeyEvent.VK_DOWN) {

      animateSkel();
      if(Skeleton.skeleton.y < Paint.background.getHeight(null)) {
      Skeleton.skeleton.y += ADD;
      }
    }
    if (move == KeyEvent.VK_SPACE) {
      if (moveStateSkl == Skeleton.ATTSKL1) {
        moveStateSkl = Skeleton.ATTSKL2;
      }
      if (moveStateSkl != Skeleton.ATTSKL2) {
        moveStateSkl = Skeleton.ATTSKL1;
      }
    }
  }

  // Move Unicorn
  public void uniMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateUni();
      animateUni();
      UnicornKnight.unicornKnight.x += ADD;

    } else if (move == KeyEvent.VK_LEFT) {
      animateUni();
      UnicornKnight.unicornKnight.x -= ADD;

    } else if (move == KeyEvent.VK_UP) {
      animateUni();
      UnicornKnight.unicornKnight.y -= ADD;

    } else if (move == KeyEvent.VK_DOWN) {
      animateUni();
      UnicornKnight.unicornKnight.y += ADD;

    } else if (move == KeyEvent.VK_SPACE) {
      if (moveStateUni != UnicornKnight.ATTKUNI) {
        moveStateUni = UnicornKnight.ATTKUNI;
      } else {
        moveStateUni = UnicornKnight.WALKUNI1;
      }
    }
  }

  // Move Sword Knight
  public void swordKMov(int move) {
    if (move == KeyEvent.VK_RIGHT) {
      animateSwordK();
      SwordKnight.swordKnight.x += ADD;

    } else if (move == KeyEvent.VK_LEFT) {
      animateSwordK();
      SwordKnight.swordKnight.x -= ADD;

    } else if (move == KeyEvent.VK_UP) {

      animateSwordK();
      SwordKnight.swordKnight.y -= ADD;

    } else if (move == KeyEvent.VK_DOWN) {
      animateSwordK();
      SwordKnight.swordKnight.y += ADD;

    } else if (move == KeyEvent.VK_SPACE) {
      if (!attk) {
        t.start();
      }
    }
    }
}