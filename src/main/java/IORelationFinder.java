import java.util.*;

public class IORelationFinder {
    private ArrayList<TestSuite> content;
    private ArrayList<TestSuite> copyContent;
    private ArrayList<String> tmpContent = new ArrayList<>();


    public IORelationFinder(ArrayList<TestSuite> content) {
        this.content = content;
        this.copyContent = content;
    }


    public void extractSpecifiedRecords() {

        int count = 0;
        for (int j = 1; j < content.size(); j++) {
            String str = content.get(j).get(2).trim() +
                    content.get(j).get(3).trim() +
                    content.get(j).get(4).trim();
            for (int i = j; i < copyContent.size(); i++) {
                String tempStr = copyContent.get(i).get(2).trim() +
                        copyContent.get(i).get(3).trim() +
                        copyContent.get(i).get(4).trim();
                String x1 = copyContent.get(i).get(1);
                String out1 = copyContent.get(i).get(5);
                if (str.equals(tempStr)) {
                    tmpContent.add(copyContent.get(i).get(0));
                    copyContent.remove(i - 1);
                    System.out.format("%s - ", content.get(i).get(2).trim());
                    System.out.format("%s - ", content.get(i).get(3).trim());
                    System.out.format("%s\n", content.get(i).get(4).trim());
                    count++;
                }
            }
            System.out.println("copyContent Length: " + copyContent.size());
            System.out.println("Content Length: " + content.size());
            System.out.println("similar counts: " + (count / 3));
            System.out.println("------------------------");
        }
    }
}