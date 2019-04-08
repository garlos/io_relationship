import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import Utils.*;

public class CsvOperation {

    private static ArrayList<TestCase> testSuitesArr = new ArrayList<>();
    private static String csvFields;


    public static void saveCSV(ArrayList<TestCase> dSet, String filePath, String csvFields) throws IOException {

        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(csvFields);
        bw.newLine();
        for (int i = 0; i < dSet.size(); i++) {
            bw.write(dSet.get(i).getTestId().toString() + "," +
                    dSet.get(i).getStaffType().toString() + "," +
                    dSet.get(i).getWorkHour().toString() + "," +
                    dSet.get(i).getQuality().toString() + "," +
                    dSet.get(i).getAge().toString() + "," +
                    dSet.get(i).getSalary().toString() + "," +
                    dSet.get(i).getExReward().toString() + ","
            );
            bw.newLine();
        }
        bw.close();
        fw.close();
    }


    public static ArrayList<TestCase> readCsvData(String filePath) throws IOException {

        String line;
        List<Field> fields = ReflectionUtils.getAllFields(TestCase.class);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {

                TestCase testCase = new TestCase();
                String[] values = line.split(",");
                for (int i = 0; i < fields.size(); i++) {
                    ReflectionUtils.setField(fields.get(i), testCase, values[i]);
                }
                System.out.println(testCase.getSalary());
                testSuitesArr.add(testCase);
            }

        } catch (FileNotFoundException e) {
            //Some error logging
        } catch (IllegalAccessException e) {
            e.printStackTrace();
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

}

