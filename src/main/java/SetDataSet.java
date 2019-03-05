import java.text.DecimalFormat;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030


public class SetDataSet {

    public static Integer[][] setData(int pCount, Integer[][] dataSet) {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        for (int i = 0; i < pCount; i++) {
            dataSet[i][0] = Math.round(RandomRange.intRandom(1, 3) * 100) / 100;          //staff type
            dataSet[i][1] = Math.round(RandomRange.intRandom(151, 200) * 100) / 100;      //work hour
            dataSet[i][2] = Math.round(RandomRange.intRandom(1, 50) * 100) / 100;         //ex-hour
            dataSet[i][3] = Math.round(RandomRange.intRandom(71, 90) * 100) / 100;        //quality
        }
        return dataSet;
    }
}
