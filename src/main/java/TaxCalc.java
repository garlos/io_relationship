public class TaxCalc {
    private static Double tax;

    public static double taxCalc(double netPay) {

        if (netPay > 1500) {
            tax = netPay * 0.09;
        } else if (netPay <= 1500) {
            tax = netPay * 0.05;
        }
        return tax;
    }
}
