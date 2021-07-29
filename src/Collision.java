import characters.*;

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
    if (character.equals("Unicorn")) {
      if (UnicornKnight.unicorn.getRect().intersects(Skeleton.skl.getRect())
          || UnicornKnight.unicorn.getRect().intersects(SwordKnight.sword.getRect())) {
        return 1;
      }
    }
    if (character.equals("SwordKnight")) {
      if (SwordKnight.sword.getRect().intersects(UnicornKnight.unicorn.getRect())
          || SwordKnight.sword.getRect().intersects(Skeleton.skl.getRect())) {
        return 1;
      }
    }
    return 0;
  }

  public void attk(String character) {
    if (character == "Skeleton") {
      if (Skeleton.skl.getRect().intersects(UnicornKnight.unicorn.getRect())) {
        UnicornKnight.unicorn.damage();
      }
      if (Skeleton.skl.getRect().intersects(SwordKnight.sword.getRect())) {
        SwordKnight.sword.damage();
      }
    }
    if (character == "Unicorn") {
      if (UnicornKnight.unicorn.getRect().intersects(Skeleton.skl.getRect())) {
        Skeleton.skl.damage();
      }
      if (UnicornKnight.unicorn.getRect().intersects(SwordKnight.sword.getRect())) {
        SwordKnight.sword.damage();
      }
    }
    if (character == "SwordKnight") {
      if (SwordKnight.sword.getRect().intersects(Skeleton.skl.getRect())) {
        Skeleton.skl.damage();
      }
      if (SwordKnight.sword.getRect().intersects(UnicornKnight.unicorn.getRect())) {
        UnicornKnight.unicorn.damage();
      }
    }
  }
}