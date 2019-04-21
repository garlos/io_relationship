import SUT.TestCase;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class DS01_InOutRecognizer {

    public static List<ArrayList<Integer>> recognizeInOutFields(TestCase testCase) {

        System.out.format("        # the SUT's TestCase.java (POJO) inputs and outputs are recognizing... \n");

        List<Field> fields = Utils.ReflectionUtils.getAllFields(testCase.getClass());

        ArrayList<Integer> inputIndexes = new ArrayList<>();
        ArrayList<Integer> outputIndexes = new ArrayList<>();

        List<ArrayList<Integer>> fieldsIndex = new ArrayList<>();

        for (int i = 0; i < fields.size(); i++) {
            if (fields.get(i).getName().toLowerCase().startsWith("_inp_")) {
                inputIndexes.add(i);
            } else if (fields.get(i).getName().toLowerCase().startsWith("_out_")) {
                outputIndexes.add(i);
            }
        }

        fieldsIndex.add(inputIndexes);
        fieldsIndex.add(outputIndexes);

        return fieldsIndex;
    }
}
