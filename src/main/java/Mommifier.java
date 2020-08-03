import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mommifier {

    public String[] insertBetweenContinuesVowels(String[] sourse) {
        List<String> list = new ArrayList<>();
        Arrays.stream(sourse).forEach(s -> {
            if(vowelsBeyond30percentage(s)){
                list.add(insertMommy(s));
            }else {
                list.add(s);
            }
        });
        String[] result = new String[list.size()];
        for (int o = 0; o < result.length; o++){
            result[o] = list.get(o);
        }
        return result;
    }

    Boolean vowelsBeyond30percentage(String s){
        String[] singleString = s.split("");

        float count = 0;
        for (String single :singleString){
            if (single.equals("a") ||single.equals("e")||single.equals("i")||single.equals("o")||single.equals("u")||single.equals("A")||single.equals("E")||single.equals("I")||single.equals("O")||single.equals("U")){
                count++;
            }

        }
        return  (count/(float) singleString.length) > 0.3;
    }

    String insertMommy(String s){
        String[] singleString = s.split("");
        List<String> stringList = new ArrayList<>();
        //int currentIndex = 0;
        for (int i = 0;i < singleString.length-1;i++){
            if (isVowel(singleString[i]) && isVowel(singleString[i+1])){
                stringList.add(singleString[i]);
                stringList.add("mommy");
            }
            else {
                stringList.add(singleString[i]);
            }

        }
        //add the last element
        stringList.add(singleString[singleString.length-1]);
        StringBuilder result = new StringBuilder();
        stringList.stream().forEach(single->result.append(single));
        return result.toString();

    }


    boolean isVowel(String single){
        if (single.equals("a") ||single.equals("a")||single.equals("a")||single.equals("a")||single.equals("a")||single.equals("a")||single.equals("a")||single.equals("a")||single.equals("a")||single.equals("a")){
            return true;
        }else {
            return false;
        }
    }

}
