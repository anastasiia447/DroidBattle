import area.Arena;
import area.TeamArena;
import droid.*;

import utilits.SaveFight;
import utilits.ShowFight;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Main {

    public static class Menu {
        private static final String[] options = {"1- Create Droid",
                "2- List of created Droids",
                "3- Fight 1 vs 1",
                "4- Team Fight",
                "5- Save Fight",
                "6- Show Fight",
                "7- Exit"
        };

        public static String[] getOptions() {
            return options;
        }

        public static void printMenu(String[] options) {
            for (String option : options) {
                System.out.println(option);
            }
            System.out.print("Choose your option : ");
        }

        public static Droid createDroid() {
            Scanner scanner = new Scanner(System.in);

            String[] droidOptions = {"1- InvisibleDroid",
                    "2- TurtleDroid",
                    "3- PoliceDroid",
                    "4- NinjaDroid",
            };

            printMenu(droidOptions);

            switch (scanner.nextInt()) {
                case 1:
                    System.out.print("Input DroidName:");
                    scanner.nextLine();

                    return new InvisibleDroid(50, 10, scanner.nextLine());
                case 2:
                    System.out.print("Input DroidName:");
                    scanner.nextLine();

                    return new TurtleDroid(60, 9, scanner.nextLine());
                case 3:
                    System.out.print("Input DroidName:");
                    scanner.nextLine();

                    return new PoliceDroid(50, 10, scanner.nextLine());
                case 4:
                    System.out.print("Input DroidName:");
                    scanner.nextLine();

                    return new NinjaDroid(40, 13, scanner.nextLine());
                default:
                    break;
            }
            return new Droid(0, 0, "0");
        }

        public static void printList(List<Droid> droids) {
            for (Droid droid : droids) {
                System.out.println(droid);
            }
        }

        public static void droidFight(List<Droid> droids) throws InterruptedException {
            Arena arena = new Arena(droids.get(0), droids.get(1));
            Droid winner = arena.startFight();

            SaveFight.log("--------------");
            SaveFight.log("The winner is " + winner.getName());
        }

        public static void teamFight(List<Droid> droids) throws InterruptedException {
            TeamArena arena = new TeamArena(droids);
            Droid winner = arena.startFight();

            SaveFight.log("--------------");
            SaveFight.log("The winner is " + winner.getName() + "'s team");
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {

        Scanner scanner = new Scanner(System.in);


        List<Droid> droids = new ArrayList<>();

        int option;
        boolean Start = true;
        while (Start) {
            Menu.printMenu(Menu.getOptions());

            switch (scanner.nextInt()) {
                case 1:
                    System.out.println("---------------------");
                    droids.add(Menu.createDroid());
                    System.out.println("---------------------");
                    break;
                case 2:
                    System.out.println("---------------------");
                    Menu.printList(droids);
                    System.out.println("---------------------");
                    break;
                case 3:
                    SaveFight.setBaos(new ByteArrayOutputStream());
                    SaveFight.log("---------------------");
                    Menu.droidFight(droids);
                    SaveFight.log("---------------------");
                    break;
                case 4:
                    SaveFight.setBaos(new ByteArrayOutputStream());
                    System.out.println("---------------------");
                    Menu.teamFight(droids);
                    System.out.println("---------------------");
                    break;
                case 5:
                    SaveFight.save();
                    break;
                case 6:
                    ShowFight.show();
                    break;
                case 7:
                    Start = false;
                    break;
                default:
                    break;
            }
        }
    }
}

