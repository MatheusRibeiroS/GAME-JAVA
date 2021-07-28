package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class Skeleton {

  public int life = 10;
  public int x, y;
  private Rectangle rect;
  public static Skeleton skeleton;

  //  Static Initializer Block
  static {
    skeleton = new Skeleton();
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

  public int sprite = 0;
  public Image Skeleton[] = new Image[9];

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
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public Image getSkeleton() {
    return Skeleton[sprite];
  }

  public Rectangle getRect() {
    return rect;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }
}
