package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class unicornKnight {
  private int life = 10;
  private Image Sprite;
  private int x , y ;
  private Rectangle rect;

  final int WALKUNI1 = 0;
  final int WALKUNI2 = 1;
  final int WALKUNI3 = 2;
  final int WALKUNI4 = 3;
  final int DEADUNI = 4;
  final int ATTKUNI = 5;

  public unicornKnight() {
  Image Unicorn[] = new Image[6];
    try {
  // Unicorn Sprites Imported
  Unicorn[WALKUNI1] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking1-Unicorn.png"));
  Unicorn[WALKUNI2] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking2-Unicorn.png"));
  Unicorn[WALKUNI3] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking3-Unicorn.png"));
  Unicorn[WALKUNI4] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Walking4-Unicorn.png"));
  Unicorn[DEADUNI] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Dead-Unicorn.png"));
  Unicorn[ATTKUNI] = ImageIO.read(new File("../img/Unicorn-Knight-Sprites/Attacking-Unicorn.png"));
} catch (IOException e) {
  JOptionPane.showMessageDialog(null, "A imagem não pôde ser carregada!\n" + e, "Error",
    JOptionPane.ERROR_MESSAGE);
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
