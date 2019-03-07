import java.util.ArrayList;

public class NetPayCalc {

    final private double STANDARD;
    private double rate;
    private ArrayList<String> returnArr = new ArrayList<>();

    public NetPayCalc() {
        STANDARD = 4;
        rate = 0;
    }

    public ArrayList<String> netPayCalc(Integer staffType, Integer hours, Integer exHours, Integer workQuality, Integer age) {

        Double exPay = 0.0;
        Double netPay;
        Double grossPay;
        Boolean retirement;

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

        netPay = (hours * (STANDARD * rate)) + (exHours * (rate * (STANDARD * 2)));

        if ((exHours >= 25) && (workQuality >= 90)) {
            exPay += (exHours - 25) * (STANDARD * rate);     //reward
        } else if ((exHours >= 20) || (workQuality >= 80)) {
            netPay += 200;
        }
        netPay += exPay;

        grossPay = Math.round((netPay - TaxCalc.taxCalc(netPay)) * 100) / 100.0;   // {{grossPay = netPay - tax}} ;

        if (age > 60) {
            retirement = true;
        } else {
            retirement = false;
        }

        returnArr.add(grossPay.toString());
        returnArr.add(retirement.toString());

        return returnArr;
    }
}
