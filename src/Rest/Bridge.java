package Rest;

public class Bridge {

 public static class Npc {

  String name, threeDimensionalModel;
  int hp = 0, x, y, z;

  public void death() {}

  public void attack(Npc npc) {
   npc.hp -= 0;
   System.out.printf("'%s' attacks %s with 0 DMG\n", this.name, npc.name);
  }

  public Npc(String name, String threeDimensionalModel, int x, int y, int z, int hp) {
   this.name = name;
   this.x = x;
   this.y = y;
   this.z = z;
   this.threeDimensionalModel = threeDimensionalModel;
   this.hp = hp;
   System.out.printf("NPC with name: '%s' was created\n", this.name);
  }

  public void checkHPstatus() {
   System.out.printf("'%s' has %dHP%n\n", this.name, this.hp);
  }
 }

 public static class Archer extends Npc {

  int attackStrength, speed;

  public Archer(String name, String threeDimensionalModel, int x, int y, int z, int hp, int attackStrength, int speed) {
   super(name, threeDimensionalModel, x, y, z, hp);
   this.attackStrength = attackStrength;
   this.speed = speed;
  }

  public void attack(Npc npc) {
   npc.hp -= attackStrength;
   System.out.printf("'%s' attacks %s with %d DMG\n", this.name, npc.name, this.attackStrength);
  }

  public void attack(Flyweight.Tree tree) {
   System.out.printf("%s destroyed %s\n", this.name, tree.askName());
   tree.isDestroyed = true;
  }

 }

 public static class Rogue extends Npc {

  int attackStrength, speed, defense;

  public Rogue(String name, String threeDimensionalModel, int x, int y, int z, int hp, int attackStrength, int speed) {
   super(name, threeDimensionalModel, x, y, z, hp);
   this.attackStrength = attackStrength;
   this.speed = speed;
  }

  public void attack(Npc npc) {
   npc.hp -= attackStrength;
   System.out.printf("'%s' attacks '%s' with %d DMG\n", this.name, npc.name, this.attackStrength);
  }

  public void attack(Flyweight.Tree tree) {
   System.out.printf("%s destroyed %s\n", this.name, tree.askName());
   tree.isDestroyed = true;
  }

 }
}