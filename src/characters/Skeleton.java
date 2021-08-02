package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class Skeleton {

  public int life = 10;
  public int x = 150, y = 150;
  public boolean isLeft = false;
  public static Skeleton skl;

  //  Static Initializer Block
  static {
    skl = new Skeleton();
  }

  public static final int RELAXSKL = 0;
  public static final int ATTSKL1 = 1;
  public static final int ATTSKL2 = 2;
  public static final int DEADSKL1 = 3;
  public static final int DEADSKL2 = 4;
  public static final int WALKSKL1 = 5;
  public static final int WALKSKL2 = 6;
  public static final int WALKSKL3 = 7;
  public static final int WALKSKL4 = 8;
  public static final int RELAXSKL_L = 9;
  public static final int ATTSKL1_L = 10;
  public static final int ATTSKL2_L = 11;
  public static final int DEADSKL1_L = 12;
  public static final int DEADSKL2_L = 13;
  public static final int WALKSKL1_L = 14;
  public static final int WALKSKL2_L = 15;
  public static final int WALKSKL3_L = 16;
  public static final int WALKSKL4_L = 17;

  private int sprite = 0;
  public Image Skeleton[] = new Image[19];

  public Skeleton() {
    try {
      // Skeleton Sprites
      Skeleton[RELAXSKL] = ImageIO.read(new File("../img/Skeleton-Sprites/Relaxed-Skeleton.png"));
      Skeleton[ATTSKL1] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking1-Skeleton.png"));
      Skeleton[ATTSKL2] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking2-Skeleton.png"));
      Skeleton[DEADSKL1] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead1-Skeleton.png"));
      Skeleton[DEADSKL2] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead2-Skeleton.png"));
      Skeleton[WALKSKL1] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking1-Skeleton.png"));
      Skeleton[WALKSKL2] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking2-Skeleton.png"));
      Skeleton[WALKSKL3] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking3-Skeleton.png"));
      Skeleton[WALKSKL4] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking4-Skeleton.png"));
      Skeleton[RELAXSKL_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Relaxed-Skeleton-left.png"));
      Skeleton[ATTSKL1_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking1-Skeleton-left.png"));
      Skeleton[ATTSKL2_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking2-Skeleton-left.png"));
      Skeleton[DEADSKL1_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead1-Skeleton-left.png"));
      Skeleton[DEADSKL2_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead2-Skeleton-left.png"));
      Skeleton[WALKSKL1_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking1-Skeleton-left.png"));
      Skeleton[WALKSKL2_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking2-Skeleton-left.png"));
      Skeleton[WALKSKL3_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking3-Skeleton-left.png"));
      Skeleton[WALKSKL4_L] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking4-Skeleton-left.png"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public void damage() {
    if(life > 0) {
      this.life --;
      System.out.println("A vida do Esqueleto eh: " + life);
    }
  }

  public Image getSkeleton() {
    return Skeleton[sprite];
  }

  public Rectangle getRect() {
    return new Rectangle(x, y, getSkeleton().getWidth(null), getSkeleton().getHeight(null));
  }

  public int getSprite() {
    return this.sprite;
  }

  public void setSprite(int sprite) {
    this.sprite = sprite;
  }
  
}
