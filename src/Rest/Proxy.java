package Rest;

public class Proxy {

 public static class ProxyMod {

  public static void turnOnOffServer() {

   if (Cloud.serverStatus)

    Cloud.serverStatus = false;
   else
    Cloud.serverStatus = true;

  }

  public static void loadToServerSave(Facade.Save save) {

   String response = Cloud.loadSave(save);

   if (response.equals("Succes!")) {

    System.out.println("Save has been successfully loaded");
   } else {

    System.out.println("Error: Could't load Save file to server.\nReason: Server's status is 'Offline'.");
   }

  }


 }

 static class Cloud {

  public static boolean serverStatus = false;

  static String loadSave(Facade.Save save) {
   if (save != null && serverStatus != false) {

    return "Succes";
   } else {

    return "Server is offline";
   }

  }

 }

}