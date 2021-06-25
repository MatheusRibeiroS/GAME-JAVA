package characters;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class tridentKnight {
  private int life  = 10;
  private Image Sprite;
  private int x, y;
  private Rectangle rect;

  private Image tridentKnight[] = new Image[10];
  
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
