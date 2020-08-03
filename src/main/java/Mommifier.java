import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mommifier {

    public String[] insertBetweenContinuesVowels(String[] source) {
        List<String> stringList = new ArrayList<>();
        Arrays.stream(source).forEach(str -> {
            if(vowelsBeyond30percentage(str)){
                stringList.add(insertMommy(str));
            }else {
                stringList.add(str);
            }
        });
        String[] resultArray = new String[stringList.size()];
        for (int o = 0; o < resultArray.length; o++){
            resultArray[o] = stringList.get(o);
        }
        return resultArray;
    }

    Boolean vowelsBeyond30percentage(String stringToBeTest){
        String[] EvertCharToString = stringToBeTest.split("");
        float vowel = 0;
        for (String single :EvertCharToString){
            if (single.equals("a") ||single.equals("e")||single.equals("i")||single.equals("o")||single.equals("u")||single.equals("A")||single.equals("E")||single.equals("I")||single.equals("O")||single.equals("U")){
                vowel++;
            }
        }
        return  (vowel/(float) EvertCharToString.length) > 0.3;
    }

    String insertMommy(String stringToBeModify){
        String[] EveryCharToString = stringToBeModify.split("");
        List<String> listAfterInsert = new ArrayList<>();
        //int currentIndex = 0;
        for (int i = 0;i < EveryCharToString.length-1;i++){
            if (isVowel(EveryCharToString[i]) && isVowel(EveryCharToString[i+1])){
                listAfterInsert.add(EveryCharToString[i]);
                listAfterInsert.add("mommy");
            }
            else {
                listAfterInsert.add(EveryCharToString[i]);
            }
        }
        //add the last element
        listAfterInsert.add(EveryCharToString[EveryCharToString.length-1]);
        StringBuilder resultStringBuilder = new StringBuilder();
        listAfterInsert.stream().forEach(single->resultStringBuilder.append(single));
        return resultStringBuilder.toString();

    }


    boolean isVowel(String toBeTest){
        String pattern = "[AEIOUaeiou]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(toBeTest);
        return m.matches();
    }

}
