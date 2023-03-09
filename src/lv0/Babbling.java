package lv0;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Babbling {
    public static void main(String[] args) {
        System.out.println("옹알이로 발음할 수 있는 문자열 갯수 : "
                + new Solution().solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}));
    }

    static class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            for (String babStr : babbling) {
                AtomicInteger babContain = new AtomicInteger();
                Arrays.stream(BabblingWords.values())
                        .filter(babWord -> babStr.contains(babWord.getWord()))
                        .forEach(babWord -> babContain.addAndGet(babWord.getWord().length()));

                if (babContain.get() == babStr.length()) {
                    answer++;
                }
            }

            return answer;
        }
    }

    enum BabblingWords {
    //"aya", "ye", "woo", "ma"
        AYA("aya"),
        YE("ye"),
        WOO("woo"),
        MA("ma");

        private final String word;

        BabblingWords(String word) {
            this.word = word;
        }

        public String getWord() {
            return word;
        }
    }

}