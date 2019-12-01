public class Fanta extends Product {
    Fanta() {
        Name = "Fanta";
        Price = 20.00;
    }
    @Override
    public String getName() {
        return Name;
    }
    @Override
    public double getPrice() {
        return Price;
    }
}
