import java.util.ArrayList;

public class NetPayCalc {

    final private double STANDARD;
    private double rate;


    public NetPayCalc() {
        STANDARD = 4;
        rate = 0;
    }

    public ArrayList<String> netPayCalc(Integer staffType, Integer hours, Integer workQuality, Integer age) {

        Double exPay = 0.0;
        Double netPay;
        Double grossPay;
        Boolean exReward;
        ArrayList<String> returnArr = new ArrayList<>();

        switch (staffType) {
            case 1:
                rate = 1.6;
                break;
            case 2:
                rate = 2.2;
                break;
            case 3:
                rate = 3.1;
                break;
        }

        netPay = (hours * (STANDARD * rate)) + ((rate * (STANDARD * 2)));

        if (hours >= 25) {
            exPay += (hours - 25) * (STANDARD * rate);     //reward
        } else if ((hours >= 20) ) {
            netPay += 200;
        }
        netPay += exPay;

        grossPay = Math.round((netPay - TaxCalc.taxCalc(netPay)) * 100) / 100.0;   // {{grossPay = netPay - tax}} ;

        if ((age > 58) && (workQuality >= 78)) {
            exReward = true;
        } else {
            exReward = false;
        }

        returnArr.add(grossPay.toString());
        returnArr.add(exReward.toString());

        return returnArr;
    }
}
