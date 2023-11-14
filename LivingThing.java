public class LivingThing {
    public String name;
    public static int health;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (name == null){
            this.name = "undefined";
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (health <= 0){
            System.out.println("entity dead");
            System.exit(0);
        }
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }

    public String pieceColor;

    public LivingThing(String name, int health, String pieceColor){
        this.name = name;
        this.health = health;
        this.pieceColor = ConsoleColors.BLUE;
    }
    public String getConsoleStr(){
        return pieceColor + name.charAt(0) + ConsoleColors.RESET;
    }
}


