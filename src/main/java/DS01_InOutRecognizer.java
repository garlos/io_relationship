import java.util.ArrayList;
import java.util.List;

public class DS01_InOutRecognizer {

    public static List<ArrayList<Integer>> inOutRecognizer(String[] fields) {

        ArrayList<Integer> inputIndexes = new ArrayList<>();
        ArrayList<Integer> outputIndexes = new ArrayList<>();
        List<ArrayList<Integer>> fieldsIndex = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {

            if (fields[i].toLowerCase().startsWith("get_in_")) {
                inputIndexes.add(i);
            } else if (fields[i].toLowerCase().startsWith("get_out_")) {
                outputIndexes.add(i);
            }
        }

        fieldsIndex.add(inputIndexes);
        fieldsIndex.add(outputIndexes);

        return fieldsIndex;
    }
}
