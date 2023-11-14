import java.util.ArrayList;
public class Treasure {

    private int value;
    private String description;

    public Treasure(){
        worth();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    private String color;
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void worth(){
        value = 5;
        description = "Gold";
        color = ConsoleColors.YELLOW ;
    }

    public String getConsoleStr(){
        return color + description.charAt(0) + ConsoleColors.RESET;
    }

}
