import java.text.DecimalFormat;
import java.util.ArrayList;

//        min input (1,151.0,1.0,71.0) = output:1897
//        max input (3,200.0,50.0,90.0) = output:4030

public class InputGenerator {


    //    private Integer[] staffType = new Integer[3];
//    private Integer[] workHour = new Integer[50];
//    private Integer[] quality = new Integer[20];
//    private Integer[] age = new Integer[45];


    private ArrayList<TestSuite> testSuitesArr = new ArrayList<>();

//    private ArrayList<ArrayList<Integer>> aList = new ArrayList<>();
//    private ArrayList<Integer> row = new ArrayList<>();

    public ArrayList<TestSuite> setInputData() {
        //generate Sequential inputs
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 50; j++) {
                for (int w = 0; w < 20; w++) {
                    for (int z = 0; z < 45; z++) {
                        TestSuite testSuite = new TestSuite();
                        testSuite.setStaffType(i + 1);
                        testSuite.setWorkHour(j + 150);
                        testSuite.setQuality(w + 70);
                        testSuite.setAge(z + 20);
                        testSuitesArr.add(testSuite);
                    }
                }
            }
        }


//        // aList is an ArrayList of ArrayLists
//        // combining inputs
//        DecimalFormat df = new DecimalFormat();
//        df.setMaximumFractionDigits(2);
//        int n = 135000;
//        int count = 0;
//        while (count < n) {
//            for (int i = 0; i < staffType.length; i++) {
//                for (int j = 0; j < workHour.length; j++) {
//                    for (int w = 0; w < quality.length; w++) {
//                        for (int y = 0; y < age.length; y++) {
//                            row.clear();
//                            row.add(staffType[i]);
//                            row.add(workHour[j]);
//                            row.add(quality[w]);
//                            row.add(age[y]); //age
//                            ArrayList<Integer> arrC2 = new ArrayList<>(row);
//                            aList.add(arrC2);
//                            count++;
//                        }
//                    }
//                }
//            }
//        }
        return testSuitesArr;
    }
}