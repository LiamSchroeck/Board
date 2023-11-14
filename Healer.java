class Healer extends LivingThing {
    public Healer(String name, int health, String pieceColor, int Heal) {
        super(name, health, pieceColor);
        HealValue = Heal;
    }

    public int HealValue;

    public int getHealValue() {
        LivingThing.health = health + 4;
        return HealValue;
    }
}
