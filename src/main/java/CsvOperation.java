import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvOperation {

    public void saveData(ArrayList<TestSuite> dSet, String csvFields) throws IOException {

        File file = new File("DataSet.csv");
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


    public List<List<String>> readData() throws IOException {
        String file = "DataSet.csv";
        String line;
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        }
        return records;
    }
}
