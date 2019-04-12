import SUT.TestCase;
import Utils.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.*;

public class RF01_IORelationFinder {


    public static Map<Integer, Integer> check_IO_Relations(TestCase testCase,
                                                                 List<ArrayList<Integer>> inOutFieldsIndex,
                                                                 ArrayList<TestCase> dataSet) throws IllegalAccessException {

        System.out.println("        # extracting input and output data columns is started");

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

                System.out.format("        # relation status: \"%-10s\" --> \"%s\" -> ",
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

        return allNoRelFields;
    }

    public static boolean isRelation(ArrayList<Object> inputColumn, ArrayList<Object> outputColumn, Integer dataSetSize) {

        Object inputCompare = inputColumn.get(0);
        Integer affectedOutputs = 0;


        for (int i = 0; i < dataSetSize; i++) {

            if (!inputCompare.equals(inputColumn.get(i))) {

                if (!outputColumn.get(i).equals(outputColumn.get(i - 1))) {

                    inputCompare = inputColumn.get(i);
                    affectedOutputs++;
                }
            }
        }
        System.out.print(affectedOutputs + " - ");
        return affectedOutputs != 0;
    }


}

