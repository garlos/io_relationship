import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class NetPayCalcTest {

    @org.junit.Test
    public void netPayCalc() throws IOException {
        NetPayCalc netPayC = new NetPayCalc();
        InputGenerator inRang = new InputGenerator();
        ArrayList<ArrayList<Integer>> inSet = inRang.setInputData();
        String[][] outSet = new String[inSet.size()][2];
        SaveCSV csv = new SaveCSV();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);


        for (int i = 0; i < inSet.size(); i++) {

            Integer x0 = inSet.get(i).get(0);
            Integer x1 = inSet.get(i).get(1);
            Integer x2 = inSet.get(i).get(2);
            Integer x3 = inSet.get(i).get(3);
            Integer x4 = inSet.get(i).get(4);
            outSet[i][0] = netPayC.netPayCalc(x0, x1, x2, x3, x4).get(0);
            outSet[i][1] = netPayC.netPayCalc(x0, x1, x2, x3, x4).get(1);

            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d - %d\\ Salary: %s \\Retirement: %s\n",
                    i + 1,
                    x0,
                    x1,
                    x2,
                    x3,
                    x4,
                    outSet[i][0],
                    outSet[i][1]);
        }

        csv.save(inSet, outSet);
//        assertArrayEquals(xArr, xArr);
//        assertEquals(1897,(int)b);
    }
}
