package bg.tu_varna.sit.f24621905.task2;

abstract class Property implements Commission {
    private double area;
    private double price;
    private PropertyType propertyType;

    public Property(double area, double price, PropertyType propertyType) {
        this.area = area;
        this.price = price;
        this.propertyType = propertyType;
    }


    public double getArea() {
        return area;
    }

    public double getPrice() {
        return price;
    }

    public PropertyType getPropertyType() {
        return propertyType;
    }
}