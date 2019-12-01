public class Coke extends Product {

    Coke() {
        Name = "Kola";
        Price = 15.00;
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
