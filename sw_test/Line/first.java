import java.util.regex.Pattern;

public class first {
    static String[] condition = {"team_name", "application_name", "error_level", "message"};

    public static int solution(String[] logs) {
        int answer = 0;
        int logLen = logs.length;
        String matcher = "^[a-zA-Z]*$";

        for(int i = 0; i < logLen; i++) {
            if(logs[i].length() > 100) {
                answer++; continue;
            }
            String[] words = logs[i].replace(" :", "").split(" ");
            int check = 0;

            for(int j = 0; j < words.length; j++) {
                if(j % 2 == 0) {   // 메세지 컬럼 확인
                    if(words[j].equals(condition[check])) {
                        j++;
                        if(j >= words.length) break;

                        if(Pattern.matches(matcher, words[j])) check++;
                    } else break;
                }
            }
            if(check != 4) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        String[] input = {
            "team_name : db application_name : dbtest error_level : info message : test",
            "team_name : test application_name : I DONT CARE error_level : error message : x",
            "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever",
            "team_name : oberervability application_name : LogViewer error_level : error"
        };

        String[] input2 = {
            "team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange",
            "no such file or directory",
            "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11",
            "team_name : recommend application_name : recommend error_level : info message : Success!",
            "   team_name : db application_name : dbtest error_level : info message : test",
            "team_name     : db application_name : dbtest error_level : info message : test",
            "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"
        };
        System.out.println(solution(input2));
    }
}