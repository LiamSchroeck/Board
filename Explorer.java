import java.util.ArrayList;

class Explorer extends LivingThing {
    public Explorer(String name, int health, String pieceColor) {
        super(name, health, pieceColor);
    }
    ArrayList<Treasure> treasures = new ArrayList<Treasure>();

    public void addTreasure(Treasure t){
        treasures.add(t);
    }
    public ArrayList<Treasure> getTreasure(){
        return treasures;
    }

    public int getTreasurevalue(){
        int value = 0;
        int length = treasures.size();
        while (length > 0){
            value += treasures.get(0).getValue();
        }
        return value;
    }

    public ArrayList<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(ArrayList<Treasure> treasures) {
        this.treasures = treasures;
    }

}
