import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        List<Integer> res;
        HashMap<Integer, List<Integer>> listHashMap = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            res = new ArrayList<>();
            for (int j = i; j < a.size() - 1; j++) {
                if (Math.abs(a.get(i) - a.get(j + 1)) <= 1) {
                    res.add(a.get(j + 1));
                }
            }
            res.add(a.get(i));
            listHashMap.put(i, res);
        }
        List<Integer> tempList;
        List<Integer> tempListSize = new ArrayList<>();
        for(Map.Entry<Integer, List<Integer>> map:listHashMap.entrySet()){
            if(map.getValue().size()>1){
                tempList=new ArrayList<>();
                tempList.addAll(map.getValue());
                for (int i=0;i<tempList.size();i++) {
                    for (int j=i;j<tempList.size()-1;j++) {
                        if (Math.abs(tempList.get(i) - tempList.get(j + 1)) > 1) {
                            tempList.remove(j+1);
                            j--;
                            break;
                        }
                    }
                }
                tempListSize.add(tempList.size());
            }
        }
        Collections.sort(tempListSize);
        return tempListSize.get(tempListSize.size()-1);
    }

}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("PATH"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aTemp[i]);
            a.add(aItem);
        }

        int result = Result.pickingNumbers(a);

        System.out.println(result);

        bufferedReader.close();
        bufferedWriter.close();
    }
}
