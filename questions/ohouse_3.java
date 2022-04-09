import java.util.HashSet;

public class ohouse_3 {
    public static String solution(String tstring, String[][] variables) {
        String answer = "";
        HashSet<String> map = new HashSet<String>();
        map.add(tstring);
        while(true) {
            String[] arr = tstring.split(" ");
            int[] check = new int[arr.length];

            for(int idx = 0; idx < variables.length; idx++) {
                String key = variables[idx][0];
                String value = variables[idx][1];

                String tmpStr = "";
                for(int i = 0; i < arr.length; i++) {
                    if(arr[i].startsWith("{")) {
                        String temp = arr[i].substring(1, arr[i].length() - 1);
                        if(temp.equals(key) && check[i] == 0) {
                            check[i] = 1;
                            arr[i] = value;
                        }
                    }
                    if(i == arr.length - 1) tmpStr += arr[i];
                    else tmpStr += (arr[i] + " ");
                }
                tstring = tmpStr;
            }

            if(map.contains(tstring)) break;
            else map.add(tstring);
        }

        answer = tstring;

        return answer;
    }
    public static void main(String[] args) {
        String tstring = "this is {template} {template} is {state}";
        String[][] variables = {
            {"template", "{state}"}, 
            {"state", "{template}"}
        };

        System.out.println(solution(tstring, variables));
    }
}