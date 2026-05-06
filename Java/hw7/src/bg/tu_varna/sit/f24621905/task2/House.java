package bg.tu_varna.sit.f24621905.task2;

class House extends Property {
    private final int numberOfFloors;
    private final boolean hasGarden;

    public House(double area, double price, PropertyType propertyType, int numberOfFloors,
                 boolean hasGarden) {
        super(area, price, propertyType);
        this.numberOfFloors = numberOfFloors;
        this.hasGarden = hasGarden;
    }


    @Override
    public double calculateCommission() {
        if (getPropertyType() == PropertyType.rent && hasGarden) {
            return 0.08 * getPrice();
        } else if (getPropertyType() == PropertyType.sale && getArea() < 100) {
            return 0.05 * getPrice();
        } else {
            return 0.03 * getPrice();
        }
    }
}
