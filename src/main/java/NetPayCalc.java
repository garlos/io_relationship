public class NetPayCalc {

    final private double STANDARD;
    private double rate;

    public NetPayCalc() {
        STANDARD = 4;
        rate = 0;
    }

    public Double netPayCalc(Integer staffType, Integer hours, Integer exHours, Integer workQuality) {

        double exPay = 0;
        double netPay;

        switch (staffType) {
            case 1:
                rate = 1.6;
            case 2:
                rate = 2.2;
            case 3:
                rate = 3.1;
        }

        netPay = (hours * (STANDARD * rate)) + (exHours * (rate * (STANDARD * 2)));

        if ((exHours >= 25) && (workQuality >= 90)) {
            exPay += (exHours - 25) * (STANDARD * rate);     //reward
        } else if ((exHours >= 20) || (workQuality >= 80)) {
            netPay += 200;
        }

        netPay += exPay;
        return netPay;
    }
}
