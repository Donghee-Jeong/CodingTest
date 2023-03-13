package lv2;

import java.util.*;

public class OpenChat {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution().solution(
                                new String[]{
                                        "Enter uid1234 Muzi"
                                        , "Enter uid4567 Prodo"
                                        , "Leave uid1234"
                                        , "Enter uid1234 Prodo"
                                        , "Change uid4567 Ryan"
                                }
                        )
                )
        );
    }

    private static class Solution {
        public String[] solution(String[] record){
            Map<String, String> userMap = new HashMap<>();
            List<User> results = new ArrayList<>();

            for (String rec : record) {
                String[] msg = rec.split(" ");
                switch (msg[0]) {
                    case "Enter" :
                        userMap.put(msg[1], msg[2]);
                        results.add(new User(msg[1], Message.ENTER));
                        break;
                    case "Leave" :
                        results.add(new User(msg[1], Message.LEAVE));
                        break;
                    case "Change" :
                        userMap.put(msg[1], msg[2]);
                        break;
                }
            }

            List<String> answer = new ArrayList<>();
            for (User user : results) {
                answer.add(user.getResult(userMap));
            }

            return answer.toArray(new String[0]);
        }
    }

    private static class User {
        private final String uid;
        private final Message message;

        public User(String uid, Message message) {
            this.uid = uid;
            this.message = message;
        }

        public String getResult(Map<String, String> userMap) {
            return String.format(message.getMsg(), userMap.get(uid));
        }
    }


    enum Message {
        ENTER("%s님이 들어왔습니다."),
        LEAVE("%s님이 나갔습니다.");

        private final String msg;

        Message(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }
    }
}
