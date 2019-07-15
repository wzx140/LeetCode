package introduce.conclution;

public class ReverseWordsInAStringIII {
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder();
//        the start of the word
        int begin = 0;
//        the state of recording the word
        boolean record = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && record) {
                for (int j = i - 1; j >= begin; j--) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                record = false;
            } else if (s.charAt(i) != ' ' && !record) {
                record = true;
                begin = i;
            }
        }
        for (int i = s.length() - 1; i >= begin; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

//    Too much if-else reduced speed
    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        int storeIndex = 0;
//        the state of recording the word
        boolean record = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && record) {
                sb.insert(storeIndex, s.charAt(i));
                storeIndex++;
            } else if (s.charAt(i) != ' ' && !record) {
                record = true;
                sb.insert(0, s.charAt(i));
                storeIndex = 1;
            } else if (s.charAt(i) == ' ' && record) {
                sb.insert(storeIndex, ' ');
                record = false;
            }
        }
        sb.insert(storeIndex, ' ');
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    //    use split and reverse
    public String reverseWords3(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append((new StringBuilder(word)).reverse());
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
