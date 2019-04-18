import SUT.TestCase;
import Utils.CsvOperation;
import Utils.ReflectionUtils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class RF02_DataSetReducer {


    public static void redundantTestCaseReducer(ArrayList<TestCase> dataSet,
                                                Map<Integer, Integer> noRelfields,
                                                List<ArrayList<Integer>> inOutFieldsIndex)
            throws IllegalAccessException, IOException {


//        Set<TestCase> bigSet = new HashSet<>(dataSet);

//        for (Map.Entry<Integer, Integer> entry : noRelfields.entrySet()) {

//            System.out.println(entry.getKey());


        setConstantValuesToNoRelInputColumn(dataSet, 1);
        removeDuplicates(dataSet, inOutFieldsIndex);
//        CsvOperation.saveCSV(dataSet, 1, CsvOperation.csvHeadersGenerator(TestCase.class));


//            bigSet.retainAll(hashSet);
//        }

//        System.out.println("size: " + hashSet.size());


//        for (Map.Entry<Integer, Integer> entry : noRelfields.entrySet()) {
//            for (TestCase val : bigSet) {
//                System.out.println(val.);
//            }
//        }


    }

    public static void removeDuplicates(ArrayList<TestCase> dataSet,
                                        List<ArrayList<Integer>> inOutFieldsIndex)
            throws IllegalAccessException {


        TestCase testCase = new TestCase();

        ArrayList<String> AllFieldsStringValue = new ArrayList<>();
        ArrayList<ArrayList<String>> allInputFieldsString = new ArrayList<>();
        ArrayList<String> newList = new ArrayList<>();
        String element = "";

        for (int i = 0; i < dataSet.size(); i++) {

            StringBuilder inputValues = new StringBuilder();
            AllFieldsStringValue = ReflectionUtils.getAllFieldsStringValue(dataSet.get(i));

            for (int j = 0; j < inOutFieldsIndex.get(0).size(); j++) {

                inputValues.append(AllFieldsStringValue.get(inOutFieldsIndex.get(0).get(j))).append(",");


            }
            if (!newList.contains(inputValues.toString())) {

                newList.add(inputValues.toString());
                System.out.println("No. " + i + " - added:" + inputValues);

            }
//            System.out.println();
        }

//        for (int i = 0; i < dataSet.size(); i++) {
//            System.out.format("%s\n", newList.get(i));
//
//        }

//        }


//                // Create a new ArrayList
//                ArrayList<TestCase> newList = new ArrayList<>();
//
//                // Traverse through the first list
//                for (TestCase element : dataSet) {
//
//                    // If this element is not present in newList
//                    // then add it
//                    if (!newList.contains(element)) {
//
//                        newList.add(element);
//                    }
//                }
//
//                // return the new list
//                return newList;

    }

    public static void setConstantValuesToNoRelInputColumn(ArrayList<TestCase> dataSet,
                                                           int noRelInputColumn) throws IllegalAccessException, IOException {

        TestCase testCase = new TestCase();

        List<Field> fields = Utils.ReflectionUtils.getAllFields(testCase.getClass());
        Object firstRecordValues = ReflectionUtils.getField(dataSet.get(0), fields.get(noRelInputColumn));
//        System.out.println(firstRecordValues);

        int i = 0;
        for (TestCase tCase : dataSet) {

            ReflectionUtils.setField(fields.get(noRelInputColumn), tCase, firstRecordValues);
            System.out.println("No. : " + (i++) + " " + tCase.get_inp_StaffType() + " " + tCase.get_inp_WorkHour() + " " + tCase.get_inp_Quality());
        }

//        CsvOperation.saveCSV(list, 1, CsvOperation.csvHeadersGenerator());

    }
}

