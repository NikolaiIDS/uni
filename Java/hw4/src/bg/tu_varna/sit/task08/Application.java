package bg.tu_varna.sit.task08;

/**
 * Анализирайте задачата и определите грешката (без да пренаписвате целия код),
 *  така че да се получи изчисляване диаметъра на балон след даден брой надувания.
 * За улеснение се приема, че балонът след първото надуване е с формата на кълбо и се раздува пропорционално (съответно за извършване на нужните изчисления важат формулите за обем и лице на околната повърхнина на кълбо).
 * Приемаме, че при едно надуване обемът му се увеличава със средния обем на издишаните от човек газове (0.5 куб.дм).
 * Ако повърхнината на балона се разтегне повече от 10 пъти спрямо първоначалната му, балонът се спуква и обемът му става 0.
 * Критичният обем настъпва при стойност (10*area^3/(36*PI))^(1/3).
 *
 * Вход: area=10.0; blowings = 200;
 * Очакван изход: Boooom! The diameter is 0,00 cm.
 *
 * Вход: area=10.0; blowings = 20;
 * Очакван изход: The diameter is 26,73 cm.
 */

public class Application {
    public static void main(String[] args) {
        Balloon balloon = new Balloon(10.0);
        balloon.calculateVolume(200);
        double result = balloon.calculateDiameter();
        balloon.setDiameter(result);
        System.out.println(String.format("The diameter is %.2f cm.", balloon.getDiameter()));
    }
}
