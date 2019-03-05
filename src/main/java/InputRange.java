import java.text.DecimalFormat;
import java.util.ArrayList;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030

public class InputRange {
    private Integer[] staffType = new Integer[3];
    private Integer[] workHour = new Integer[50];
    private Integer[] exHour = new Integer[50];
    private Integer[] quality = new Integer[20];
    ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
    ArrayList<Integer> row = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> setInputData() {


        //generate Sequential inputs
        for (int i = 0; i < 3; i++) {
            staffType[i] = i + 1;
        }
        for (int i = 0; i < 50; i++) {
            workHour[i] = i + 150;
        }
        for (int i = 0; i < 50; i++) {
            exHour[i] = i + 1;
        }
        for (int i = 0; i < 20; i++) {
            quality[i] = i + 70;
        }


        // aList is an ArrayList of ArrayLists
        // combining inputs
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        int n = 150000;
        int count = 0;
        while (count < n) {
            for (int i = 0; i < staffType.length; i++) {
                for (int j = 0; j < workHour.length; j++) {
                    for (int z = 0; z < exHour.length; z++) {
                        for (int w = 0; w < quality.length; w++) {
                            row.clear();
                            row.add(staffType[i]);
                            row.add(workHour[j]);
                            row.add(exHour[z]);
                            row.add(quality[w]);
                            ArrayList<Integer> arrC2 = new ArrayList<>(row);
                            aList.add(arrC2);
                            count++;
                        }
                    }
                }
            }
        }
        return aList;
    }
}