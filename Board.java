import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Board {

    public static Explorer Gazoo = new Explorer( "Gazoo", 20,"YELLOW");
    public static String user;
    public static int row = 0;
    public static int col = 0;
    private static List<List<space>> b;
    private static Scanner input = new Scanner(System.in);

    static ArrayList<Treasure> RT = new ArrayList<Treasure>();

    public static void IT(int num){
        while (num > 1){
            RT.add(new Treasure());
            num -= 1;
        }
    }

    public static void AT() {
        createTreasure(5);
    }

    public static void createTreasure(int numTreasures) {
        Treasure treasure1 = new Treasure();
        Treasure treasure2 = new Treasure();
        Treasure treasure3 = new Treasure();
        Treasure treasure4 = new Treasure();
        Treasure treasure5 = new Treasure();
        RT.add(treasure1);
        RT.add(treasure2);
        RT.add(treasure3);
        RT.add(treasure4);
        RT.add(treasure5);
        Random random = new Random();
        for (Treasure t :RT) {


            int randomRow;
            int randomCol;
            do {
                randomRow = ThreadLocalRandom.current().nextInt(0, row);
                randomCol = ThreadLocalRandom.current().nextInt(0, col);

            } while (b.get(randomRow).get(randomCol).getOccupant() != null || b.get(randomRow).get(randomCol).getCache() != null);


            b.get(randomRow).get(randomCol).setCache(t);

            if (b.get(randomRow).get(randomCol).getOccupant() == Gazoo) {
                System.out.println("Found gold");
            }
        }
    }

    public static void pb() {
        pb(false);
    }

    public static void pb(boolean reveal) {
        for (List<space> row : b) {
            for (space cell : row) System.out.print(cell.GetConsoleStr(reveal));
            System.out.println();
        }
    }

    public static void findGazoo() {
        for (row = 0; row < b.size(); row++) {
            for (col = 0; col < b.get(row).size(); col++) {
                space cell = b.get(row).get(col);
                if (cell.getOccupant() instanceof LivingThing) {
                    LivingThing occupant = (LivingThing) cell.getOccupant();
                    if (occupant.getName().equals("Gazoo")) {
                        System.out.println("Found Gazoo: (" + row + ", " + col + ")");
                        return;
                    }
                }
            }
        }
        System.out.println("Gazoo not found on the board.");
    }

    public void move() {
        user = "";
        System.out.println("move somewhere");
        while (!user.equals("q")) {
            user = input.nextLine();
            user.toLowerCase();
            switch (user) {
                case "w":
                    b.get(row).get(col).setOccupant(null);
                    row -= 1;
                    b.get(row).get(col).setOccupant(Gazoo);
                    pb();
                    break;
                case "a":
                    b.get(row).get(col).setOccupant(null);
                    col -= 1;
                    b.get(row).get(col).setOccupant(Gazoo);
                    pb();
                    break;
                case "s":
                    b.get(row).get(col).setOccupant(null);
                    row += 1;
                    b.get(row).get(col).setOccupant(Gazoo);
                    pb();
                    break;
                case "d":
                    b.get(row).get(col).setOccupant(null);
                    col += 1;
                    b.get(row).get(col).setOccupant(Gazoo);
                    pb();
                    break;
                case "r":
                    pb(true);
                    break;
            }
        }
    }

    public Board(int row, int col) {
        this.row = row;
        this.col = col;
        IB(row, col);
    }

    public static void IB(int rows, int col) {
        b = new ArrayList<>(rows);
        for (int i = 0; i < rows; i++) {
            List<space> row = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                row.add(new space());
            }
            b.add(row);
        }
        AT();
        IT(5);
        b.get(0).get(0).setOccupant(Gazoo);
        findGazoo();
    }
}
