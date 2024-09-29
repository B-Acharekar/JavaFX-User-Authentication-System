package application;

public class UserData {
 private static String username;

 public static String getUsername() {
     return username;
 }

 public static void setUsername(String username) {
     UserData.username = username;
 }
}
