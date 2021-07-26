package characters;

import java.awt.*;

public class TridentKnight {
  public static int life  = 10;
  private Image Sprite;
  public static int x, y;
  private Rectangle rect;

  private Image tridentKnight[] = new Image[10];
  

  public Image getSprite() {
    return Sprite;
  }

  public void setSprite(Image Sprite) {
    this.Sprite = Sprite;
  }

  public Rectangle getRect() {
    return rect;
  }

  public void setRect(Rectangle rect) {
    this.rect = rect;
  }
}
