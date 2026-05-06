package bg.tu_varna.sit.task08;

public class Balloon {
    private double diameter;
    private double area;
    private double volume;

    public Balloon() {}

    public Balloon(double area) {
        this.area=area;
        this.volume=0.0;
        this.diameter=0.0;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void calculateVolume(int blowings) {
        if (blowings <= 0) {
            System.out.println("Not proper number of blowings");
            return;
        }
        for (int i = 1; i <= blowings; i++) {
            volume += 0.5;
            if (volume > Math.pow(Math.pow(10 * area, 3) / 36 * Math.PI, 1.0/3.0)) {
                volume = 0.0;
                System.out.println("Boooom!");
                break;
            }
        }
    }

    public double calculateDiameter() {
        return 2*10*Math.cbrt((3*volume)/(4*Math.PI));
    }
}
