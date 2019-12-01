public class Soda extends Product {
    Soda(){
        Name = "Gazoz";
        Price = 30.00;
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
