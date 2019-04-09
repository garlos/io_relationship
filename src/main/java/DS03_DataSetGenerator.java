import SUT.TestCase;
import Utils.CsvOperation;
import java.io.IOException;
import java.util.ArrayList;


public class DS03_DataSetGenerator {


    public static void generate(ArrayList<TestCase> dSet) throws IOException {

        String csvHeaders = CsvOperation.csvHeadersGenerator();
        String filePath = "DataSet.csv";
        SUT.NetPayCalc netPayC = new SUT.NetPayCalc();

        for (int i = 0; i < dSet.size(); i++) {

            Integer inp0 = dSet.get(i).get_inp_StaffType();
            Integer inp1 = dSet.get(i).get_inp_WorkHour();
            Integer inp2 = dSet.get(i).get_inp_Quality();
            Integer inp3 = dSet.get(i).get_inp_Age();

            dSet.get(i).set_out_Salary(netPayC.netPayCalc(inp0, inp1, inp2, inp3).get_out_Salary());
            dSet.get(i).set_out_ExReward(netPayC.netPayCalc(inp0, inp1, inp2, inp3).is_out_ExReward());

//            System.out.format("No.%d \\ Inputs: %d - %d - %d - %d\\ Salary: %d \\Retirement: %b\n",
//                    i + 1,
//                    inp0,
//                    inp1,
//                    inp2,
//                    inp3,
//                    dSet.get(i).getSalary(),
//                    dSet.get(i).getExReward());
        }


        CsvOperation.saveCSV(dSet, filePath, csvHeaders);

    }
}
