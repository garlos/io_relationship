import SUT.TestCase;
import Utils.CsvOperation;
import Utils.ReflectionUtils;
import com.rits.cloning.Cloner;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class RF02_DataSetReducer {



    public static void redundantTestCaseReducer(ArrayList<TestCase> dataSet,
                                                Map<Integer, Integer> noRelfields,
                                                List<ArrayList<Integer>> inOutFieldsIndex)
            throws IllegalAccessException, IOException, IllegalArgumentException {

        System.out.format("        # redundant test suites are reducing... \n");


        ArrayList<Integer> finalTestIdList = new ArrayList<>();

        System.out.format("        # constant values are updating in fields column's with no relation to output... \n");
        for (Map.Entry<Integer, Integer> entry : noRelfields.entrySet()) {

            ArrayList<TestCase> tempDataSet;

            Cloner cloner = new Cloner();
            tempDataSet = cloner.deepClone(dataSet);

            tempDataSet = setConstantValuesToNoRelInputColumn(tempDataSet, entry.getKey());
            ArrayList<Integer> remainedTestIds = removeDuplicatedTestInputs(tempDataSet, inOutFieldsIndex);

            for (Integer remainedTestId : remainedTestIds) {

                if (!finalTestIdList.contains(remainedTestId)) {

                    finalTestIdList.add(remainedTestId);
//                    System.out.println("Remained Test Id: " + remainedTestId);

                }
            }

            tempDataSet.clear();
        }


        System.out.format("        # number of union of all test suites: %d \n", finalTestIdList.size());

        retrievedRemainedTestSuitesDataSet(dataSet, finalTestIdList);

        System.out.format("        # number of final reduced data set test suites: %d \n", dataSet.size());

        CsvOperation.saveDataSetToCSV(dataSet, 1, CsvOperation.csvHeadersGenerator(TestCase.class));
        System.out.format("        # reduced data set generated. \n");
    }

    public static ArrayList<Integer> removeDuplicatedTestInputs(ArrayList<TestCase> dataSet,
                                                                List<ArrayList<Integer>> inOutFieldsIndex) {

        ArrayList<String> AllFieldsStringValue;
        ArrayList<String> newList = new ArrayList<>();
        ArrayList<Integer> remainedTestId = new ArrayList<>();

        for (int i = 0; i < dataSet.size(); i++) {

            StringBuilder inputValues = new StringBuilder();
            AllFieldsStringValue = ReflectionUtils.getAllFieldsStringValue(dataSet.get(i));

            for (int j = 0; j < inOutFieldsIndex.get(0).size(); j++) {

                inputValues.append(AllFieldsStringValue.get(inOutFieldsIndex.get(0).get(j))).append(",");
            }

            if (!newList.contains(inputValues.toString())) {

                newList.add(inputValues.toString());
                remainedTestId.add(dataSet.get(i).getTestId());

            }
        }

        System.out.format("        # number of remained test suites (no duplicated): %d \n", newList.size());
        return remainedTestId;
    }

    public static ArrayList<TestCase> setConstantValuesToNoRelInputColumn(ArrayList<TestCase> dataSet,
                                                                          int noRelInputColumn)
            throws IllegalAccessException {


        TestCase testCase = new TestCase();
        List<Field> fields = Utils.ReflectionUtils.getAllFields(testCase.getClass());
        Object firstRecordValues = ReflectionUtils.getField(dataSet.get(0), fields.get(noRelInputColumn));

        for (TestCase tCase : dataSet) {

            ReflectionUtils.setField(fields.get(noRelInputColumn), tCase, firstRecordValues);

        }

        return dataSet;
    }

    public static void retrievedRemainedTestSuitesDataSet(ArrayList<TestCase> dataSet, ArrayList<Integer> remainedTestIds) {

        ArrayList<Integer> redundantTestSuites = new ArrayList<>();

        for (int i = 0; i < dataSet.size(); i++) {

            redundantTestSuites.add(dataSet.get(i).getTestId());
        }

        redundantTestSuites.removeAll(remainedTestIds);
        System.out.format("        # number of redundant test suites: %d \n", redundantTestSuites.size());
        int i = 0;

        while (i < dataSet.size()) {
            if (redundantTestSuites.contains(dataSet.get(i).getTestId()))
                dataSet.remove(i--);
            i++;
        }

    }
}

