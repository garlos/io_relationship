import java.text.DecimalFormat;
import java.util.ArrayList;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030


//public class SetDataSet {

//    public static Integer[][] setData() {

//        NetPayCalc netPayC = new NetPayCalc();
//        InputGenerator inRang = new InputGenerator();
//        ArrayList<ArrayList<Integer>> dSet = inRang.setInputData();
//        Double[] xArr = new Double[dSet.size()];
//
//        DecimalFormat df = new DecimalFormat();
//        df.setMaximumFractionDigits(2);
//
//        for (int i = 0; i < dSet.size(); i++) {
//            Integer x0 = dSet.get(i).get(0);
//            Integer x1 = dSet.get(i).get(1);
//            Integer x2 = dSet.get(i).get(2);
//            Integer x3 = dSet.get(i).get(3);
//            xArr[i] = netPayC.netPayCalc(x0, x1, x2, x3);
////            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d\\ Salary: %s\n", i+1, x0, x1, x2, x3, df.format(xArr[i]));
//        }

//        return dataSet;
//    }
//}


//DecimalFormat df = new DecimalFormat();
//df.setMaximumFractionDigits(2);
//for (int i = 0; i < pCount; i++) {
//dataSet[i][0] = Math.round(RandomRange.intRandom(1, 3) * 100) / 100;          //staff type
//dataSet[i][1] = Math.round(RandomRange.intRandom(151, 200) * 100) / 100;      //work hour
//dataSet[i][2] = Math.round(RandomRange.intRandom(1, 50) * 100) / 100;         //ex-hour
//dataSet[i][3] = Math.round(RandomRange.intRandom(71, 90) * 100) / 100;        //quality
