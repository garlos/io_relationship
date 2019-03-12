import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class DataSetMakerTest {

    @org.junit.Test
    public void netPayCalc() throws IOException {
        NetPayCalc netPayC = new NetPayCalc();
        InputGenerator inRang = new InputGenerator();
        ArrayList<TestSuite> dSet = inRang.setInputData();
        CsvOperation csv = new CsvOperation();

//        DecimalFormat df = new DecimalFormat();
//        df.setMaximumFractionDigits(2);


        for (int i = 0; i < dSet.size(); i++) {

            Integer inp0 = dSet.get(i).getStaffType();
            Integer inp1 = dSet.get(i).getWorkHour();
            Integer inp2 = dSet.get(i).getQuality();
            Integer inp3 = dSet.get(i).getAge();
            dSet.get(i).setSalary(netPayC.netPayCalc(inp0, inp1, inp2, inp3).getSalary());
            dSet.get(i).setExReward(netPayC.netPayCalc(inp0, inp1, inp2, inp3).getExReward());

            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d\\ Salary: %d \\Retirement: %b\n",
                    i + 1,
                    inp0,
                    inp1,
                    inp2,
                    inp3,
                    dSet.get(i).getSalary(),
                    dSet.get(i).getExReward());
        }
        String csvFields = "No,StaffType,WorkHours,Quality,Age,Salary,Ex-Reward";

        csv.saveData(dSet, csvFields);
//        assertArrayEquals(xArr, xArr);
//        assertEquals(1897,(int)b);
    }
}
