//inputs:
//	1-	staffType: 1:office		2:worker	3:Engineer
//  2-	work Hours: 100-200
//  3-	extra Hours: 0-50
//	4-	work Quality: 70-100
//outputs:
//	grossPay = netPay + rewardPay - tax - insurance


public class GrossPay {

    public static void main(String[] args) {
        Double grossPay;
        Double netPay;
        int personCount = 100;
        Double[][] dataSet = new Double[personCount][5];
        NetPayCalc netPaymentCalc = new NetPayCalc();



//        dataSet = SetDataSet.setData(personCount, dataSet);  // set DataSet for all personCount
//
//        for (int i = 0; i < personCount; i++) {
//            System.out.println("No." + (i + 1));
//            System.out.println("staff type: " + dataSet[i][0]);
//            System.out.println("work hours: " + dataSet[i][1]);
//            System.out.println("ex-hours  : " + dataSet[i][2]);
//            System.out.println("Quality   : " + dataSet[i][3]);
//
//            netPay = netPaymentCalc.netPayCalc(dataSet[i][0], dataSet[i][1], dataSet[i][2], dataSet[i][3]);
//            System.out.println("---------");
//            netPay = Math.round((netPay * 100) / 100.0);
//            System.out.println("Net Pay  : " + netPay);
//
//            grossPay = Math.round((netPay - TaxCalc.taxCalc(netPay)) * 100) / 100.0;   // {{grossPay = netPay - tax}} ;
//            dataSet[i][4] = grossPay;       //save output in index 4 of dataset
//            System.out.println("Gross Pay: " + grossPay);
//            System.out.println("==========================");
//        }
    }
}
