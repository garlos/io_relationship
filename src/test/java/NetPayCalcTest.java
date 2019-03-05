import java.text.DecimalFormat;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

public class NetPayCalcTest {

    @org.junit.Test
    public void netPayCalc() {
        NetPayCalc netPayC = new NetPayCalc();
        InputRange inRang = new InputRange();
        ArrayList<ArrayList<Integer>> dSet = inRang.setInputData();
        Double[] xArr = new Double[dSet.size()];

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        for (int i = 0; i < dSet.size(); i++) {
            Integer x0 = dSet.get(i).get(0);
            Integer x1 = dSet.get(i).get(1);
            Integer x2 = dSet.get(i).get(2);
            Integer x3 = dSet.get(i).get(3);
            xArr[i] = netPayC.netPayCalc(x0, x1, x2, x3);
//            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d\\ Salary: %s\n", i+1, x0, x1, x2, x3, df.format(xArr[i]));
        }

        assertArrayEquals(xArr,xArr);

//      assertEquals(1897,(int)b);
    }
}
