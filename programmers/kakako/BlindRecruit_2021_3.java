package kakako;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

// 순위 검색
public class BlindRecruit_2021_3 {
    class Rank implements Comparable<Rank> {
        String lang, tech, career, food;
        int score;
        Rank(String lang, String tech, String career, String food, int score) {
            this.lang = lang;
            this.tech = tech;
            this.career = career;
            this.food = food;
            this.score = score;
        }

        @Override
        public int compareTo(Rank o) {
            return o.score - this.score;
        }

        public String toString() {
            return "Rank(lang : " + lang + ", tech : " + tech + ", career : " + career + ", food : " + food + ", score : " + score + ")";
        }
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        ArrayList<Rank> applyer = new ArrayList<>();
        ArrayList<Rank> qu = new ArrayList<>();

        for(int i = 0; i < info.length; i++) {
            String[] sArr = info[i].split(" ");
            applyer.add(new Rank(sArr[0], sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4])));
        }
        Collections.sort(applyer);

        for(int i = 0; i < query.length; i++) {
            String tmp = query[i].replaceAll("and", "");
            tmp = tmp.replaceAll("  ", " ");
            String[] sArr = tmp.split(" ");
            qu.add(new Rank(sArr[0], sArr[1], sArr[2], sArr[3], Integer.parseInt(sArr[4])));
        }

        for(int i = 0; i < qu.size(); i++) {
            Rank rank = qu.get(i);

            for(int j = 0; j < applyer.size(); j++) {
                if(rank.score > applyer.get(j).score) continue;
                int cnt = 1;
                if(rank.lang.equals("-") || rank.lang.equals(applyer.get(j).lang)) cnt++;
                if(rank.tech.equals("-") || rank.tech.equals(applyer.get(j).tech)) cnt++;
                if(rank.career.equals("-") || rank.career.equals(applyer.get(j).career)) cnt++;
                if(rank.food.equals("-") || rank.food.equals(applyer.get(j).food)) cnt++;

                if(cnt >= 5) answer[i]++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        BlindRecruit_2021_3 mc = new BlindRecruit_2021_3();

        String[] info = {
            "java backend junior pizza 150",
            "python frontend senior chicken 210",
            "python frontend senior chicken 150",
            "cpp backend senior pizza 260",
            "java backend junior chicken 80",
            "python backend senior chicken 50"
        };

        String[] query = {
            "java and backend and junior and pizza 100",
            "python and frontend and senior and chicken 200",
            "cpp and - and senior and pizza 250",
            "- and backend and senior and - 150",
            "- and - and - and chicken 100",
            "- and - and - and - 150"
        };

        int[] result = mc.solution(info, query);

        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
