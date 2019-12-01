import java.nio.file.FileAlreadyExistsException;
import java.util.HashMap;

public class Coins {

    HashMap<Double,Integer> coins = new HashMap<>();
    Double[] coinArray = {0.50,1.00,5.00,10.00};
    // as an initial state, 10 of each coin has been accepted.
    // 10*0.50 Krş
    // 10*1 TL etc.
    public Coins() {
        coins.put(0.50,10);
        coins.put(1.00,10);
        coins.put(5.00,10);
        coins.put(10.00,10);
    }
    public void increaseCoinValue(double key){
        coins.put(key,coins.get(key)+1);
    }
    public void decreaseCoinValue(double key){
        if (coins.get(key)>0) {
            coins.put(key, coins.get(key) - 1);
        }
    }
    public String findChange(double value){
        HashMap<Double,Integer> change = new HashMap<>();
        String chg = "İade Tutarı: \n\t";
        boolean isEmpty = true;
        for (int j = 0; j <coinArray.length;j++){
            change.put(coinArray[j],0);
        }
        for (int i = coinArray.length-1;i >= 0; i--){
            while(value >= coinArray[i]) {
                value -= coinArray[i];
                change.put(coinArray[i], change.get(coinArray[i]) + 1);
            }
        }
        for (HashMap.Entry<Double,Integer> entry : change.entrySet()) {
            if (entry.getValue()!=0){
                isEmpty = false;
                chg = chg + entry.getValue().toString()+ "x  "+entry.getKey().toString()+"TL\n\t";
            }
        }
        if (isEmpty){
            chg += "00.00 TL";
        }
        return chg;
    }
}
