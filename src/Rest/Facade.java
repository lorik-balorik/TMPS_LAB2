package Rest;

import java.text.BreakIterator;

public class Facade {

 public static class History {
  String historyData;

  History(String input) {
   this.historyData = input;
  }
 }

 static class MapOfWorld {
  Time time;
  String nameOfWorld;
  int xSize, ySize, zSize;

  MapOfWorld(String nameOfWorld, int xSize, int ySize, int zSize, Time time) {

   this.nameOfWorld = nameOfWorld;
   this.xSize = xSize;
   this.ySize = ySize;
   this.zSize = zSize;
   this.time = time;
  }
 }

 static class World {
  MapOfWorld mapOfWorld;

  World(MapOfWorld mapOfWorld) {
   this.mapOfWorld = mapOfWorld;
  }
 }

 public static class Save {
  World world;
  History history;

  Save(World world, History history, Flyweight.Tree[] trees, Bridge.Npc[] npc) {
   this.world = world;
   this.history = history;
  }

 }

 static class Time {
  int year, month, day, minute, second;

  Time(int year, int month, int day, int minute, int second) {
   this.year = year;
   this.month = month;
   this.day = day;
   this.minute = minute;
   this.second = second;
  }

  void setTime(int year, int month, int day, int minute, int second) {
   this.year = year;
   this.month = month;
   this.day = day;
   this.minute = minute;
   this.second = second;
  }
 }

 public static class LoadGame {


  public static void loadFromSaveFile(Save save) {
   System.out.printf("Game loaded from save file with pararms: game time = %d:%d:%d, history = %s, name of map = '%s'\n",
    save.world.mapOfWorld.time.day, save.world.mapOfWorld.time.month,
    save.world.mapOfWorld.time.year, save.history.historyData,
    save.world.mapOfWorld.nameOfWorld);
  }
 }

 public static class SaveGame {

  public static Save createSaveFile() {
   History history = new History("Some data about save");
   Time time = new Time(1992, 12, 05, 13, 22);
   MapOfWorld mapOfWorld = new MapOfWorld("WorldN1", 10000, 10000, 5000, time);
   World world = new World(mapOfWorld);
   Flyweight.Tree trees[] = new Flyweight.Tree[99];
   Bridge.Npc npc[] = new Bridge.Npc[99];

   System.out.printf("Game was saved with pararms: game time = %d:%d:%d, history = %s, name of map = '%s'\n",
    world.mapOfWorld.time.day, world.mapOfWorld.time.month, world.mapOfWorld.time.year,
    history.historyData, world.mapOfWorld.nameOfWorld);

   return new Save(world, history, trees, npc);
  }
 }

}