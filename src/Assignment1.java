/*
  Author: Axel Nilsson
  Id: am1921
  Study program: Sys
*/
import java.util.Scanner;
public class Assignment1 {
  static Scanner input = new Scanner(System.in);

  static String[][] guestList = {{"Adam Ason", "35"},
                                 {"Berta Bson", "70"},
                                 {"Ceasar Cson", "12"},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""},
                                 {"",""}};


  public static void printGuestList(String[][] arr) {
    System.out.printf("%n--------------------------%n");
    System.out.printf("\tGUEST LIST%n");
    System.out.println("   Name                Age");
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][0] != "") {
      System.out.printf("%d. %-20s%s%n", i+1, arr[i][0], arr[i][1]);
      }
    }
    System.out.printf("--------------------------%n%n");
  }
  public static void printStatistics(String[][] arr) {
    System.out.printf("%n----------------------%n");
    System.out.printf("GUEST LIST STATS%n");
    int howManyGuests = 0;
    int howManyKids = 0;
    int howManyOldies = 0;
    int oldestGuestAge = 0;
    String oldestGuestName = " ";
    int youngestGuestAge = Integer.parseInt(arr[0][1]);
    String youngestGuestName = " ";
    for (int i = 0; i < arr.length; i++) {
      if (arr[i][0] != "") {
        ++howManyGuests;
        if (Integer.parseInt(arr[i][1]) <= 13) {
          ++howManyKids;
        }
        if (Integer.parseInt(arr[i][1]) > 13) {
          ++howManyOldies;
        }
        if (Integer.parseInt(arr[i][1]) > oldestGuestAge) {
          oldestGuestAge = Integer.parseInt(arr[i][1]);
          oldestGuestName = arr[i][0];
        }
        if (Integer.parseInt(arr[i][1]) < youngestGuestAge) {
          youngestGuestAge = Integer.parseInt(arr[i][1]);
          youngestGuestName = arr[i][0];
        }
      }
    }
    System.out.println("Sum of guests: " + howManyGuests);
    System.out.println("Sum of kids: " + howManyKids);
    System.out.println("Sum of oldies: " + howManyOldies);
    System.out.printf("Oldest guest and his/her age: %s%4d%n", oldestGuestName, oldestGuestAge);
    System.out.printf("Youngest guest and his/her age: %s%4d%n", youngestGuestName, youngestGuestAge);
    System.out.printf("----------------------%n%n");
  }
  public static void addGuest(String[][] guestList) {
    if (guestList[guestList.length-1][0] == "") {
      System.out.println("You chose to add a guest");
      System.out.println("Input name of guest: ");
      String name = input.nextLine();
      System.out.println("Input age of guest: ");
      String age = input.nextLine();
      for (int i = 0; i < guestList.length; i++) {
        if (guestList[i][0] == "") {
          guestList[i][0] = name;
          guestList[i][1] = age;
          break;
        }
      }
      System.out.println("Done!\n");
    }
    else {
      System.out.println("Your guest list is full!\n");
    }
  }

  public static void changeNamneOfGuest(String[][] guestList) {
    printGuestList(guestList);
    System.out.print("Input row number of the guest: ");
    String in = input.nextLine();
    int guestRow = Integer.parseInt(in)-1;
    System.out.print("Input correct name of the guest: ");
    guestList[guestRow][0] = input.nextLine();
    System.out.println("Done!\n");
  }

  public static void changeAgeOfGuest(String[][] guestList) {
    printGuestList(guestList);
    System.out.print("Input row number of the guest: ");
    String in = input.nextLine();
    int guestRow = Integer.parseInt(in)-1;
    System.out.print("Input correct age of the guest: ");
    guestList[guestRow][1] = input.nextLine();
    System.out.println("Done!\n");
  }

  public static void removeGuest(String[][] guestList) {
    printGuestList(guestList);
    System.out.print("Input number of the row you wish to remove: ");
    String in = input.nextLine();
    int rowNum = Integer.parseInt(in)-1;
    guestList[rowNum][0] = "";
    guestList[rowNum][1] = "";
    for (int i = rowNum; i < guestList.length-1; i++) {
      if (guestList[i+1][0] != "") {
        guestList[i][0] = guestList[i+1][0];
        guestList[i][1] = guestList[i+1][1];
        guestList[i+1][0] = "";
        guestList[i+1][1] = "";
      }
    }
    System.out.println("Done!\n");
  }

  public static void changePlaces(String[][] guestList) {
    String temp1 = null;
    String temp2 = null;
    printGuestList(guestList);
    System.out.println("Which rows would you like to switch places?");
    System.out.print("Input one row: ");
    String in1 = input.nextLine();
    int row1 = Integer.parseInt(in1)-1;
    System.out.print("Input the other row: ");
    String in2 = input.nextLine();
    int row2 = Integer.parseInt(in2)-1;
    temp1 = guestList[row1][0];
    temp2 = guestList[row1][1];
    guestList[row1][0] = guestList[row2][0];
    guestList[row1][1] = guestList[row2][1];
    guestList[row2][0] = temp1;
    guestList[row2][1] = temp2;
    System.out.println("Done!\n");
  }

  public static void printMenu() {
    System.out.println("MENU OF CHOICES");
    System.out.println("1. Print guestlist");
    System.out.println("2. Print stats of guest list");
    System.out.println("3. Add guest");
    System.out.println("4. Change name of guest");
    System.out.println("5. Change age of guest");
    System.out.println("6. Switch places of two guests");
    System.out.println("7. Remove a guest from list");
    System.out.println("0. End program");
  }

  public static void main(String[] args) {
    boolean isDone = false;
    while (isDone == false) {
      printMenu();
      String in = input.nextLine();
      int choice = Integer.parseInt(in);
      switch (choice) {
        case 0: isDone = true;
          break;
        case 1: printGuestList(guestList);
          break;
        case 2: printStatistics(guestList);
          break;
        case 3: addGuest(guestList);
          break;
        case 4: changeNamneOfGuest(guestList);
          break;
        case 5: changeAgeOfGuest(guestList);
          break;
        case 6: changePlaces(guestList);
          break;
        case 7: removeGuest(guestList);
          break;
        default:
          System.out.println("Try again");
      }
    }
  }
}
