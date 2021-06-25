import java.awt.*;

public class colision {
  Rectangle rectSkl, rectUni, rectSwordK, attkUni, attkSkl, attkSwordK;

  colision(int x1, int y1, int x2, int y2, int x3, int y3, int moveStateSkl, int moveStateUni, int moveStateSwordK,
      Image Skeleton[], Image Unicorn[], Image SwordKnight[]) {
    rectSkl = new Rectangle(x1, y1, Skeleton[moveStateSkl].getWidth(null), Skeleton[moveStateSkl].getHeight(null));
    rectUni = new Rectangle(x2, y2, Unicorn[moveStateUni].getWidth(null) - 27, Unicorn[moveStateUni].getHeight(null));
    rectSwordK = new Rectangle(x3, y3, SwordKnight[moveStateSwordK].getWidth(null),
        SwordKnight[moveStateSwordK].getHeight(null));
    attkSkl = new Rectangle(Skeleton[moveStateSkl].getWidth(null) + 10, Skeleton[moveStateSkl].getHeight(null), x1,
        Skeleton[moveStateSkl].getHeight(null));
    attkUni = new Rectangle(Unicorn[moveStateUni].getWidth(null) - 10, Unicorn[moveStateUni].getHeight(null) - 6,
        Unicorn[moveStateUni].getWidth(null) + 10, Unicorn[moveStateUni].getWidth(null) + 10);
  }

  public int colisionP1(String character) {
    if (character.equals("Skeleton")) {
      if (rectSkl.intersects(rectUni) || rectSkl.intersects(rectSwordK)) {
        return 1;
      }
      if (attkSkl.intersects(rectUni) || attkSkl.intersects(rectSwordK)) {
        return 2;
      }
    }
    if (character.equals("Unicorn")) {
      if (rectUni.intersects(rectSkl) || rectUni.intersects(rectSwordK)) {
        return 1;
      }
      if (attkUni.intersects(rectSkl) || attkUni.intersects(rectSwordK)) {
        return 2;
      }
    }
    if (character.equals("SwordKnight")) {
      if (rectSwordK.intersects(rectUni) || rectSwordK.intersects(rectSkl)) {
        return 1;
      }
      if (attkSwordK.intersects(rectUni) || attkSwordK.intersects(rectSkl)) {
        return 2;
      }
    }
    return 0;
  }

  public Rectangle getRectSkl() {
    return rectSkl;
  }

  public Rectangle getRectUni() {
    return rectUni;
  }

  public Rectangle getRectSwordK() {
    return rectSwordK;
  }

  public void setRectSkl(Rectangle rectSkl) {
    this.rectSkl = rectSkl;
  }

  public void setRectUni(Rectangle rectUni) {
    this.rectUni = rectUni;
  }

  public void setRectSwordK(Rectangle rectSwordK) {
    this.rectSwordK = rectSwordK;
  }

}
