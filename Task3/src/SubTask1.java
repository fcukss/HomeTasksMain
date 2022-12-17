import java.util.*;

public class SubTask1 {

    public static void findLongestChain(List<String> list) {
        List<String> res = new ArrayList<>();
        Map<List<String>, Integer> results = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            List<String> tempRes = new ArrayList<>(findequils(list, res, i));
            results.put(tempRes, tempRes.size());
        res.clear();
        }

        List<Map.Entry<List<String>, Integer>> toSort = new ArrayList<>();
        toSort.addAll(results.entrySet());
        toSort.sort(Map.Entry.<List<String>, Integer>comparingByValue().reversed());

        System.out.println(toSort.get(0));
    }


    public static List<String> findequils(List<String> list, List<String> res, int num) {

        List<String> temp = new ArrayList<>(list);

        res.add(temp.get(num));
        temp.remove(num);
        for (int i = 0; i < temp.size(); i++) {
            char first = res.get(0).charAt(0);
            char last = res.get(res.size() - 1).charAt(res.get(res.size() - 1).length() - 1);

            if (first == temp.get(i).charAt(temp.get(i).length() - 1)) {
                res.add(0, temp.get(i));
                temp.remove(i);
                i = 0;
            }
            if (last == temp.get(i).charAt(0)) {
                res.add(temp.get(i));
                temp.remove(i);
                i = 0;
            }
            if (temp.size() == 1) {
                if (first == temp.get(0).charAt(temp.get(0).length() - 1)) {
                    res.add(0, temp.get(0));
                }
                if (last == temp.get(0).charAt(0)) {
                    res.add(temp.get(0));
                }
            }
        }
        return res;
    }


    public static void main(String args) {

        List<String> list = Arrays.asList(args.toLowerCase().split("[-.,:;()?!\"\\s–]+"));

       findLongestChain(list);

    }
}