import characters.*;
import java.awt.*;

public class Collision {

  Collision() {
    // attkskl = new Rectangle(Skeleton.skl.getSkeleton().getWidth(null) + 10,
    // Skeleton.skl.getSkeleton().getHeight(null),
    // Skeleton.skl.x, Skeleton.skl.getSkeleton().getHeight(null));
    // attkUni = new Rectangle(UnicornKnight.unicorn.getUnicorn().getWidth(null) -
    // 10,
    // UnicornKnight.unicorn.getUnicorn().getHeight(null) - 6,
    // UnicornKnight.unicorn.getUnicorn().getWidth(null) + 10,
    // UnicornKnight.unicorn.getUnicorn().getWidth(null) + 10);
  }

  public int collide(String character) {
    if (character.equals("Skeleton")) {
      if (Skeleton.skl.getRect().intersects(UnicornKnight.unicorn.getRect())
          || Skeleton.skl.getRect().intersects(SwordKnight.sword.getRect())) {
        return 1;
      }
    }
    // if (character.equals("Unicorn")) {
    // if (rectUni.intersects(rectskl) || rectUni.intersects(rectSwordK)) {
    // return 1;
    // }
    // if (attkUni.intersects(rectskl) || attkUni.intersects(rectSwordK)) {
    // return 2;
    // }
    // }
    // if (character.equals("SwordKnight")) {
    // if (rectSwordK.intersects(rectUni) || rectSwordK.intersects(rectskl)) {
    // return 1;
    // }
    // if (attkSwordK.intersects(rectUni) || attkSwordK.intersects(rectskl)) {
    // return 2;
    // }
    // }
    return 0;
  }
}