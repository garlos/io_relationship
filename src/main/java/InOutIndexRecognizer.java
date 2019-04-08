import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class InOutIndexRecognizer {


    public static List<ArrayList<Integer>> inOutRecognizer(String[] fields) {

        ArrayList<Integer> inputIndexes = new ArrayList<>();
        ArrayList<Integer> outputIndexes = new ArrayList<>();
        List<ArrayList<Integer>> fieldsIndex = new ArrayList<>();

        for (int i = 0; i < fields.length; i++) {

            if (fields[i].startsWith("in_")) {
                inputIndexes.add(i);
            } else if (fields[i].startsWith("out_")) {
                outputIndexes.add(i);
            }
        }

        fieldsIndex.add(inputIndexes);
        fieldsIndex.add(outputIndexes);

        return fieldsIndex;
    }

    public static Field[] fieldsRecognizer(Object object) {

//        TestCase testSuite = new TestCase();
        Class objectClass = object.getClass();
        Field[] fields = objectClass.getDeclaredFields();
//        System.out.println(fields[0].getName());


//        fieldsIndex.add(inputIndexes);
//        fieldsIndex.add(outputIndexes);

        return fields;
    }
}
