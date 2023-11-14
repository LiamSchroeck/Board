class Monster extends LivingThing {
    public Monster(String name, int Health, String pieceColor) {
        super(name, Health, pieceColor);
    }

    public int Damage;

    public int getDamage() {
        Damage = 1;
        return Damage;
    }

    public int Hurt(){
        LivingThing.health = health - Damage;
        return LivingThing.health;
    }
}
