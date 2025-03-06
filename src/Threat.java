public class Threat {
private String kind;
private int health;
        private int damage;


        //region setgetcons

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Threat(String kind, int health, int damage) {
        this.kind = kind;
        this.health = health;
        this.damage = damage;
    }


    //endregion
}
