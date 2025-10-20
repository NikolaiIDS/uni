package bg.tu_varna.sit.f24621905.task2;

public class Defender extends Character{
    private int defenciveSKill;
    private int armor;
    private int healingSkill;

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getHealingSkill() {
        return healingSkill;
    }

    public void setHealingSkill(int healingSkill) {
        this.healingSkill = healingSkill;
    }

    public int getDefensiveSkill() {
        return defenciveSKill;
    }

    public void setDefensiveSkill(int defenciveSKill) {
        this.defenciveSKill = defenciveSKill;
    }

    public Defender() {
        super.setLife(250);
    }
}
