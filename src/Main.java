import Rest.Adapter;
import Rest.Facade;
import Rest.Flyweight.*;
import Rest.Bridge.*;
import Rest.Proxy;

public class Main {

 public static void main(String[] args) {

  // Flyweight
  TreeType pineType = new TreeType("Pine", "Black");

  Tree pine = new Tree(34, 50, -3, 12, 3, 1, pineType);
  pine.check();

  System.out.println();

  TreeType oakType = new TreeType("Oak", "Green");

  Tree oak = new Tree(56, 34, 76, 1, 4, 4, oakType);
  oak.check();

  System.out.println();

  Archer archer01 = new Archer("Arthur", "archer01_3d", 15, 15, 0, 100, 14, 3);
  archer01.checkHPstatus();


  Rogue rogue01 = new Rogue("Samuel", "rogue_3d", 55, 155, 0, 350, 45, 2);
  rogue01.checkHPstatus();

  rogue01.attack(oak);


  if (oak.isDestroyed)
   System.out.println("Oak is destroyed");

  archer01.attack(rogue01);
  rogue01.checkHPstatus();


  Adapter.NPCInfo.printNPCInfo(Adapter.getData(rogue01));

  Facade.Save save = Facade.SaveGame.createSaveFile();

  Facade.LoadGame.loadFromSaveFile(save);

  System.out.println("********************************\n");

  Proxy.ProxyMod.loadToServerSave(save);
  Proxy.ProxyMod.turnOnOffServer();

  Proxy.ProxyMod.loadToServerSave(save);

 }

}