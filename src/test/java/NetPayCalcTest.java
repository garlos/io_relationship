import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;

public class NetPayCalcTest {

    @org.junit.Test
    public void netPayCalc() {
        NetPayCalc netPayC = new NetPayCalc();
        InputGenerator inRang = new InputGenerator();
        ArrayList<ArrayList<Integer>> dSet = inRang.setInputData();
        ArrayList<String> xArr = new ArrayList<>();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        for (int i = 0; i < dSet.size(); i++) {
            Integer x0 = dSet.get(i).get(0);
            Integer x1 = dSet.get(i).get(1);
            Integer x2 = dSet.get(i).get(2);
            Integer x3 = dSet.get(i).get(3);
            Integer x4 = dSet.get(i).get(4);
            xArr = (netPayC.netPayCalc(x0, x1, x2, x3, x4));
            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d - %d\\ Salary: %s \\Retirement: %s\n", i + 1, x0, x1, x2, x3, x4,
                    xArr.get(0),
                    xArr.get(1));
            xArr.clear();
        }

//        assertArrayEquals(xArr, xArr);

//      assertEquals(1897,(int)b);
    }
}
