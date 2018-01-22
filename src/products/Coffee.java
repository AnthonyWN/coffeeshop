package products;

public class Coffee {
    CoffeeTypes description;
    String size;
    Double number;
    
    public Coffee(CoffeeTypes desc, String size, Double number){
        this.description = desc;
        this.number = number;
        this.size = size;
    }

    public CoffeeTypes getDescription() {
        return description;
    }

    public void setDescription(CoffeeTypes Description) {
        this.description = Description;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }
    
}
