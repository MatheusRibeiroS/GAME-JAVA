import characters.*;
import java.awt.*;


public class Colision extends Movement {
  Rectangle rectSkl, rectUni, rectSwordK, attkUni, attkSkl, attkSwordK;

  Colision() {
    rectSkl = new Rectangle(Skeleton.skeleton.x, Skeleton.skeleton.y, Skeleton.skeleton.getSkeleton().getWidth(null),
        Skeleton.skeleton.getSkeleton().getHeight(null));
    rectUni = new Rectangle(UnicornKnight.unicornKnight.x, UnicornKnight.unicornKnight.y, UnicornKnight.unicornKnight.getUnicorn().getWidth(null) - 27,
        UnicornKnight.unicornKnight.getUnicorn().getHeight(null));
    rectSwordK = new Rectangle(SwordKnight.swordKnight.x, SwordKnight.swordKnight.y, SwordKnight.swordKnight.getSwordKnight().getWidth(null),
        SwordKnight.swordKnight.getSwordKnight().getHeight(null));
    attkSkl = new Rectangle(Skeleton.skeleton.getSkeleton().getWidth(null) + 10,
        Skeleton.skeleton.getSkeleton().getHeight(null), Skeleton.skeleton.x, Skeleton.skeleton.getSkeleton().getHeight(null));
    attkUni = new Rectangle(UnicornKnight.unicornKnight.getUnicorn().getWidth(null) - 10, UnicornKnight.unicornKnight.getUnicorn().getHeight(null) - 6,
        UnicornKnight.unicornKnight.getUnicorn().getWidth(null) + 10, UnicornKnight.unicornKnight.getUnicorn().getWidth(null) + 10);
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
