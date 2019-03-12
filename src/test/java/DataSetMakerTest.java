import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class DataSetMakerTest {

    @org.junit.Test
    public void netPayCalc() throws IOException {
        NetPayCalc netPayC = new NetPayCalc();
        InputGenerator inRang = new InputGenerator();
        ArrayList<TestSuite> inSet = inRang.setInputData();
        String[][] outSet = new String[inSet.size()][2];
        CsvOperation csv = new CsvOperation();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);


        for (int i = 0; i < inSet.size(); i++) {

            Integer inp0 = inSet.get(i).getStaffType();
            Integer inp1 = inSet.get(i).getWorkHour();
            Integer inp2 = inSet.get(i).getQuality();
            Integer inp3 = inSet.get(i).getAge();
            outSet[i][0] = netPayC.netPayCalc(inp0, inp1, inp2, inp3).getSalary().toString();
            outSet[i][1] = netPayC.netPayCalc(inp0, inp1, inp2, inp3).getExReward().toString();

            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d\\ Salary: %s \\Retirement: %s\n",
                    i + 1,
                    inp0,
                    inp1,
                    inp2,
                    inp3,
                    outSet[i][0],
                    outSet[i][1]);
        }

        csv.saveData(inSet, outSet);
//        assertArrayEquals(xArr, xArr);
//        assertEquals(1897,(int)b);
    }
}
