package bg.tu_varna.sit.f24621905.task2;

class RealEstateAgency {
    private String name;
    private Property[] properties;

    public RealEstateAgency(String name, Property[] properties) {
        this.name = name;
        this.properties = properties;
    }


    public double calculateTotalExpectedCommission() {
        double totalCommission = 0;
        for (Property property : properties) {
            totalCommission += property.calculateCommission();
        }
        return totalCommission;
    }


    public int getPropertiesForSale() {
        int count = 0;
        for (Property property : properties) {
            if (property.getPropertyType() == PropertyType.sale) {
                count++;
            }
        }
        return count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }
}
