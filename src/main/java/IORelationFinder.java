import java.util.*;

public class IORelationFinder {
    private List<List<String>> content;
    private List<String> tmpContent;


    public void ioRelFinder(List<List<String>> content) {
        this.content = content;

        extractSpecifiedRecords(content);
//        relout1_in1();


    }

    public void extractSpecifiedRecords(List<List<String>> content) {

        Map<Integer, String> hashMap = new HashMap<>();
        int count = 0;
        String str = content.get(1).get(2).trim() +
                content.get(1).get(3).trim() +
                content.get(1).get(4).trim();
        for (int i = 1; i < content.size(); i++) {
            String tempStr = content.get(i).get(2).trim() +
                    content.get(i).get(3).trim() +
                    content.get(i).get(4).trim();
            if (str.equals(tempStr)) {
                System.out.println(content.get(i).get(0));
//                        content.get(i).get(1) +
//                        content.get(i).get(2) +
//                        content.get(i).get(3) +
//                        content.get(i).get(4));

            }
//            if (toString().equals())
//            hashMap.put(Integer.parseInt(content.get(i).get(0)), content.get(i).get(2).trim() + content.get(i).get(3).trim() + content.get(i).get(4).trim());
        }
//        System.out.println(hashMap.get(1));

//        for (int i = 0; i < hashMap.size(); i++) {
//            if (hashMap.get(1).equals(hashMap.get(i))) {
//                tmpContent.add(content.get(i).get(0));
//                System.out.println(i);
//
//            }
//        }
//
//        for (int i = 1; i < tmpContent.size(); i++) {
//            System.out.println(tmpContent.get(i));
//        }
    }

//        System.out.format("hash count: %d", hashMap.size());
//        Scanner scan = new Scanner(System.in);
//        scan.next();
//


    //        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }


//        for (String str : strings) {
//            if (counts.containsKey(str)) {
//                counts.put(str, counts.get(str) + 1);
//            } else {
//                counts.put(str, "1");
//            }
//        }


}


//    public void relout1_in1() {
//        for (int j = 1; j < content.size() - 1; j++) {
//
//            System.out.format("period: %d\n", j);
//            for (int i = 1; i < content.size() - 1; i++) {
//                if ((!content.get(j).get(1).equals(content.get(j + 1).get(1))) &&
//                        (content.get(i).get(5).equals(content.get(i + 1).get(5)))) {
//                    count++;
//                    System.out.format("this row: %s - %s - %s\n", content.get(i).get(0),
//                            content.get(i).get(1),
//                            content.get(i).get(5));
//                }
//            }
//        }
//        System.out.format("count: %d", count);
//    }

