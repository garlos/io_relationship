import SUT.TestCase;
import Utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

public class RF01_IORelationFinder {


    public static Map<Integer, Integer> check_IO_Relations(TestCase testCase,
                                                                 List<ArrayList<Integer>> inOutFieldsIndex,
                                                                 ArrayList<TestCase> dataSet) throws IllegalAccessException {
        System.out.format("        # I/O relations are identifying... \n");
        System.out.format("        # input and output data columns is extracting... \n\n");

        List<Field> fields = Utils.ReflectionUtils.getAllFields(testCase.getClass());

        ArrayList<Object> inputColumn = new ArrayList<>();
        ArrayList<Object> outputColumn = new ArrayList<>();

        Map<Integer, Integer> allNoRelFields = new HashMap<>();


        for (int inp_index = 0; inp_index < inOutFieldsIndex.get(0).size(); inp_index++) {

            for (int out_index = 0; out_index < inOutFieldsIndex.get(1).size(); out_index++) {

                for (int i = 0; i < dataSet.size(); i++) {

                    inputColumn.add(ReflectionUtils.getField(dataSet.get(i), fields.get(inOutFieldsIndex.get(0).get(inp_index))));
                    outputColumn.add(ReflectionUtils.getField(dataSet.get(i), fields.get(inOutFieldsIndex.get(1).get(out_index))));

                }

                System.out.format("        _* relation status: \"%-10s\" --> \"%s\" -> ",
                        fields.get(inOutFieldsIndex.get(0).get(inp_index)).getName(),
                        fields.get(inOutFieldsIndex.get(1).get(out_index)).getName());

                if (!isRelation(inputColumn, outputColumn, dataSet.size())) {

                    allNoRelFields.put(inOutFieldsIndex.get(0).get(inp_index), inOutFieldsIndex.get(1).get(out_index));
                    System.out.format("NO \n");
                } else {
                    System.out.format("YES \n");
                }

                inputColumn.clear();
                outputColumn.clear();

            }

        }

        System.out.format("\n        # I/O relations identified. \n");
        return allNoRelFields;
    }

    public static boolean isRelation(ArrayList<Object> inputColumn, ArrayList<Object> outputColumn, Integer dataSetSize) {

        Object outputCompare = outputColumn.get(0);
        Integer effectiveInputs = 0;


        for (int i = 1; i < dataSetSize; i++) {

            if (!outputCompare.equals(outputColumn.get(i))) {

                if (!inputColumn.get(i).equals(inputColumn.get(i - 1))) {

                    outputCompare = outputColumn.get(i);
                    effectiveInputs++;
                }
            }
        }
        System.out.print(effectiveInputs + " - ");
        return effectiveInputs != 0;
    }

}

