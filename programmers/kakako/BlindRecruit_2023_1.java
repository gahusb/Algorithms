package kakako;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class BlindRecruit_2023_1 {
    
    class Day {
        int year, month, day;
        Day(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public String toString() {
            return "Day{" + year + ", " + month + ", " + day + "}";
        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};

        ArrayList<Integer> list = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        String[] todayTmp = new String[3];
        todayTmp[0] = today.substring(0, 4);
        todayTmp[1] = today.substring(5, 7);
        todayTmp[2] = today.substring(8, 10);
        Day day = new Day(Integer.parseInt(todayTmp[0]), Integer.parseInt(todayTmp[1]), Integer.parseInt(todayTmp[2]));
        System.out.println(day.toString() + "\n");
        
        for(int i = 0; i < terms.length; i++) {
            String[] t = terms[i].split(" ");
            map.put(t[0], Integer.parseInt(t[1]));
        }

        for(int i = 0; i < privacies.length; i++) {
            String[] tt = privacies[i].split(" ");
            String[] dd = new String[3];
            dd[0] = tt[0].substring(0, 4);
            dd[1] = tt[0].substring(5, 7);
            dd[2] = tt[0].substring(8, 10);
            Day privacy = new Day(Integer.parseInt(dd[0]), Integer.parseInt(dd[1]), Integer.parseInt(dd[2]) - 1);
            for(String key : map.keySet()) {
                if(key.equals(tt[1])) {
                    int dal = map.get(key);
                    privacy.month += dal;
                    break;
                }
            }
            
            if(privacy.day == 0) {
                privacy.month--;
                privacy.day = 28;
            }
            
            if(privacy.month > 12) {
                privacy.year += (privacy.month / 12);
                privacy.month = (privacy.month % 12);

                if(privacy.month == 0) {
                    privacy.year--;
                    privacy.month = 12;
                }
            }

            System.out.println(privacy.toString());

            if(day.year > privacy.year) {
                list.add(i + 1);
            } else if(day.year == privacy.year && day.month > privacy.month) {
                list.add(i + 1);
            } else if(day.year == privacy.year && day.month == privacy.month && day.day > privacy.day) {
                list.add(i + 1);
            }
        }

        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) answer[i] = list.get(i);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BlindRecruit_2023_1 mc = new BlindRecruit_2023_1();
        
        String[] term = {"A 6", "B 12", "C 3"};
        String[] privacy = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C", "2021.12.03 B"};

        int[] result = mc.solution("2022.05.19", term, privacy);
        for(int i = 0; i < result.length; i++) System.out.print(result[i] + ", ");
        System.out.println();
    }
}
