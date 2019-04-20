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
            throws IllegalAccessException, IOException {


        ArrayList<Integer> finalTestIdList = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : noRelfields.entrySet()) {

            ArrayList<TestCase> tempDataSet;
            Cloner cloner = new Cloner();
            tempDataSet = cloner.deepClone(dataSet);

            tempDataSet = setConstantValuesToNoRelInputColumn(tempDataSet, entry.getKey());
            ArrayList<Integer> remainedTestIds = removeDuplicatedTestInputs(tempDataSet, inOutFieldsIndex);

            for (Integer remainedTestId : remainedTestIds) {

                if (!finalTestIdList.contains(remainedTestId)) {

                    finalTestIdList.add(remainedTestId);
                    System.out.println("remained testId: " + remainedTestId);

                }
            }

            tempDataSet.clear();
        }

        System.out.println("final list size: " + finalTestIdList.size());
        retrievedRemainedTestSuitesDataSet(dataSet, finalTestIdList);
        CsvOperation.saveDataSetToCSV(dataSet, 1, CsvOperation.csvHeadersGenerator(TestCase.class));
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

        System.out.println("new list size: " + newList.size());
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


        for (int i = 0; i < dataSet.size(); i++) {

            if (!remainedTestIds.contains(dataSet.get(i).getTestId())) {
                dataSet.remove(dataSet.get(i).getTestId());
            }
        }
    }
}

