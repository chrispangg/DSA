import java.util.*;

public class EncodeandDecodeStrings {
    public String encode(List<String> strs) {
        String result = "";
        for (String str : strs) {
            result = result + str + ":;";
        }
        return result;
    }

    public List<String> decode(String str) {
        List<Character> chars = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            chars.add(ch);
        }
        List<String> result = new ArrayList<String>();
        String word = "";
        for (int i = 0; i < chars.size(); i++) {
            word = word + chars.get(i);
            if (chars.get(i) == ';' && chars.get(i - 1) == ':') {
                String substr = word.substring(0, word.length() - 2);
                result.add(substr);
                word = "";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeandDecodeStrings s = new EncodeandDecodeStrings();
        List<String> strs = new ArrayList<>(Arrays.asList("lint", "code", ":", "love", "you"));
        String encoded = s.encode(strs);
        System.out.println(encoded);
        List<String> result = s.decode(encoded);
        System.out.println(result.toString());

    }
}
