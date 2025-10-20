package bg.tu_varna.sit.f24621905.task2;

public class Application {
    public static void main(String[] args) {
        Defender defender = new Defender();
        defender.setName("Shield Guardian");
        defender.setDefensiveSkill(80);
        defender.setArmor(120);
        defender.setHealingSkill(40);

        Attacker attacker = new Attacker();
        attacker.setName("Fire Warrior");
        attacker.setEfficiency(95);

        System.out.println("=== Информация за защитника ===");
        System.out.println("Име: " + defender.getName());
        System.out.println("Живот: " + defender.getLife());
        System.out.println("Защитно умение: " + defender.getDefensiveSkill());
        System.out.println("Броня: " + defender.getArmor());
        System.out.println("Лечителско умение: " + defender.getHealingSkill());

        System.out.println("\n=== Информация за атакуващия ===");
        System.out.println("Име: " + attacker.getName());
        System.out.println("Живот: " + attacker.getLife());
        System.out.println("Ефективност: " + attacker.getEfficiency());
    }
}
