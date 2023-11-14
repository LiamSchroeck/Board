public class space {
    private LivingThing Occupant;
    private Treasure cache;

    public space() {
        setOccupant(null);
        setCache(null);
    }

    public space(LivingThing S) {
        setOccupant(S);
        setCache(null);
    }

    public LivingThing getOccupant() {
        return Occupant;
    }

    public void setOccupant(LivingThing occupant) {
        Occupant = occupant;
    }

    public Treasure getCache() {
        return cache;
    }

    public void setCache(Treasure cache) {
        this.cache = cache;
    }

    public void TC(Treasure t) {
        cache = t;
    }

    public String GetConsoleStr(boolean reveal) {
        if (getOccupant() == null && getCache() == null) {
            return " - ";
        } else {
            if (reveal) {
                if(getOccupant() != null) {
                    return " " + Occupant.getConsoleStr() + " ";
                }else if(getCache() != null) {
                    return " " + getCache().getConsoleStr() + " ";
                }else{
                    return " - ";
                }
            } else {
                if(getOccupant() instanceof Explorer){
                    return " " + ((Explorer) getOccupant()).getConsoleStr() + " ";
                }else{
                    return " - ";
                }

            }
        }
    }
}

