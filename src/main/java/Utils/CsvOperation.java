package Utils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import SUT.TestCase;

public class CsvOperation {

    private static ArrayList<TestCase> testSuitesArr = new ArrayList<>();
    private static String csvFields;


    public static void saveDataSetToCSV(ArrayList<TestCase> dSet, int fileType, String csvHeaders) throws IOException {


        File file = new File(Utils.Config.filePath(fileType));

        if (file.exists()) {
            file.delete();
        }

        FileWriter fw;
        try {
            fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(csvHeaders);
            bw.newLine();
            for (int i = 0; i < dSet.size(); i++) {

                ArrayList<String> values = ReflectionUtils.getAllFieldsStringValue(dSet.get(i));
                for (int j = 0; j < values.size(); j++) {
                    bw.write(values.get(j) + ",");
                }
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not find");
        } catch (NumberFormatException e) {
            System.out.println("not a number");
        }
        System.out.format("        # DataSet CSV file is saved in %s \n", Utils.Config.filePath(fileType));

    }


    public static ArrayList<TestCase> readCsvData(String filePath) throws IOException {

        List<Field> fields = ReflectionUtils.getAllFields(TestCase.class);
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                TestCase testCase = new TestCase();
                String[] values = line.split(",");
                for (int i = 0; i < fields.size(); i++) {
                    ReflectionUtils.setField(fields.get(i), testCase, values[i]);
                }
                testSuitesArr.add(testCase);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not find");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("not a number");
        }
        return testSuitesArr;
    }


    public static String readCsvFields(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            csvFields = br.readLine();
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return csvFields;
    }


    public static String csvHeadersGenerator(Class target) {

        StringBuilder headers = new StringBuilder();

        List<Field> fields = ReflectionUtils.getAllFields(target);
        for (Field field : fields) {
            headers.append(field.getName()).append(",");
        }
        return headers.toString();
    }

}

