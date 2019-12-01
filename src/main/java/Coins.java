import java.util.HashMap;

public class Coins {

    private HashMap<Double,Integer> coins = new HashMap<>();
    private Double[] coinArray = {0.50,1.00,5.00,10.00};
    // as an initial state, 10 of each coin has been accepted.
    // 10*0.50 Krş
    // 10*1 TL etc.
    Coins() {
        for (Double c : coinArray) {
            coins.put(c,5);
        }
    }
    public void increaseCoinValue(double key){
        coins.put(key,coins.get(key)+1);
    }

    public void decreaseCoinValue(double key,int count){
        if (coins.get(key)>=count) {
            coins.put(key, coins.get(key) - count);
        }
    }

    public String findChange(double value){
        HashMap<Double,Integer> change = new HashMap<>();

        double temp = value;
        String chg = "";
        boolean isEmpty = true;
        for (Double c : coinArray) {
            change.put(c, 0);
        }
        for (int i = coinArray.length-1;i >= 0; i--){
            while(temp >= coinArray[i]) {
                temp -= coinArray[i];
                change.put(coinArray[i], change.get(coinArray[i]) + 1);
            }
            if (coins.get(coinArray[i]) < change.get(coinArray[i])){
                change.put(coinArray[i],coins.get(coinArray[i]));
                temp = value - coinArray[i]*change.get(coinArray[i]);
            }
        }
        for (HashMap.Entry<Double,Integer> entry : change.entrySet()) {
            if (entry.getValue()!=0){
                isEmpty = false;
                decreaseCoinValue(entry.getKey(),entry.getValue());
                chg = chg + entry.getValue().toString()+ "x  "+entry.getKey().toString()+"TL\n\t";
            }
        }
        if (isEmpty){
            chg = "00.00 TL";
        }
        return chg;
    }
}
