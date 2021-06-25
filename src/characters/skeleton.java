package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class skeleton {
  private int life = 10;
  private Image Sprite;
  private int x, y;
  private Rectangle rect;

  final int RELAXSKL = 0;
  final int ATTSKL1 = 1;
  final int ATTSKL2 = 2;
  final int DEADSKL1 = 3;
  final int DEADSKL2 = 4;
  final int WALKSKL1 = 5;
  final int WALKSKL2 = 6;
  final int WalkSkl3 = 7;
  final int WALKSKL4 = 8;

  public skeleton() {
    try {
      Image Skeleton[] = new Image[9];
      // SwordKnight Sprites
      Skeleton[RELAXSKL] = ImageIO.read(new File("../img/Skeleton-Sprites/Relaxed-Skeleton.png"));
      Skeleton[ATTSKL1] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking1-Skeleton.png"));
      Skeleton[ATTSKL2] = ImageIO.read(new File("../img/Skeleton-Sprites/Attacking2-Skeleton.png"));
      Skeleton[DEADSKL1] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead1-Skeleton.png"));
      Skeleton[DEADSKL2] = ImageIO.read(new File("../img/Skeleton-Sprites/Dead2-Skeleton.png"));
      Skeleton[WALKSKL1] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking1-Skeleton.png"));
      Skeleton[WALKSKL2] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking2-Skeleton.png"));
      Skeleton[WalkSkl3] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking3-Skeleton.png"));
      Skeleton[WALKSKL4] = ImageIO.read(new File("../img/Skeleton-Sprites/Walking4-Skeleton.png"));
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error", JOptionPane.ERROR_MESSAGE);
      System.exit(1);
    }
  }

  public int getLife() {
    return life;
  }

  public void setLife(int life) {
    this.life = life;
  }

  public Image getSprite() {
    return Sprite;
  }

  public void setSprite(Image Sprite) {
    this.Sprite = Sprite;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Rectangle getRect() {
    return rect;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }

  
}
