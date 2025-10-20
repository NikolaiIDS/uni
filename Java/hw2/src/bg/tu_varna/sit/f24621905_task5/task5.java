package bg.tu_varna.sit.f24621905_task5;

class Application {
    public static void main(String[] args) {
        SoftDrink drink1 = new SoftDrink("Coca-Cola", "2025-12-31", 500, 10);
        SoftDrink drink2 = new SoftDrink("Pepsi", "2025-11-30", 330, 11);
        SoftDrink drink3 = new SoftDrink("Coca-Cola", "2025-12-31", 500, 10);

        drink1.printInfo();
        drink2.printInfo();

        System.out.println("drink1 equals drink3? " + drink1.equals(drink3));
        System.out.println("drink1 equals drink2? " + drink1.equals(drink2));
    }
}

class SoftDrink {
    private String brand;
    private String expirationDate;
    private int bottleVolume;
    private int sugarAmount;

    public SoftDrink(String brand, String expirationDate, int bottleVolume, int sugarAmount) {
        this.brand = brand;
        this.expirationDate = expirationDate;
        this.bottleVolume = bottleVolume;
        this.sugarAmount = sugarAmount;
    }

    public String getBrand() { return brand; }
    public String getExpirationDate() { return expirationDate; }
    public int getBottleVolume() { return bottleVolume; }
    public int getSugarAmount() { return sugarAmount; }

    public void printInfo() {
        System.out.println("Brand: " + brand + ", Expiration: " + expirationDate +
                ", Volume: " + bottleVolume + "ml, Sugar: " + sugarAmount + "g/100ml");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SoftDrink other = (SoftDrink) obj;
        return bottleVolume == other.bottleVolume &&
                sugarAmount == other.sugarAmount &&
                brand.equals(other.brand) &&
                expirationDate.equals(other.expirationDate);
    }
}
