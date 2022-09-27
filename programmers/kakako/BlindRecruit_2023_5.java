package kakako;

import java.io.IOException;
import java.util.ArrayList;

public class BlindRecruit_2023_5 {

    class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    class Cell {
        String value;
        ArrayList<Point> link;
        Cell(String value) {
            this.value = value;
            link = new ArrayList<Point>();
        }
    }

    public String[] solution(String[] commands) {
        String[] answer = {};
        ArrayList<String> answerList = new ArrayList<String>();
        Cell[][] cells = new Cell[51][51];

        for(int i = 0; i < 51; i++) {
            for(int j = 0; j < 51; j++) {
                cells[i][j] = new Cell("");
            }
        }

        for(String com : commands) {
            String[] comArr = com.split(" ");
            int r = Integer.parseInt(comArr[1]);
            int c = Integer.parseInt(comArr[2]);
            if(comArr[0].equals("UPDATE")) {
                cells[r][c].value = comArr[3];
                if(cells[r][c].link.size() > 0) {
                    for(int i = 0; i < cells[r][c].link.size(); i+=2) {
                        Point p = cells[r][c].link.get(i);
                        cells[p.r][p.c].value = comArr[3];
                    }
                }
            } else if(comArr[0].equals("MERGE")) {
                int r2 = Integer.parseInt(comArr[3]);
                int c2 = Integer.parseInt(comArr[4]);
                for(int i = r + 1; i <= r2; i++) {
                    for(int j = c + 1; j <= c2; j++) {
                        cells[r][c].link.add(new Point(i, j));
                        cells[i][j].link.add(new Point(r, c));
                        cells[i][j].value = cells[r][c].value;
                    }
                }
            } else if(comArr[0].equals("UNMERGE")) {
                if(cells[r][c].link.size() > 0) {
                    for(int i = 0; i < cells[r][c].link.size(); i+=2) {
                        Point p = cells[r][c].link.get(i);
                        cells[p.r][p.c].value = comArr[3];
                    }
                }
            } else if(comArr[0].equals("PRINT")) {
                answerList.add(cells[r][c].value);
            }
        }

        answer = new String[answerList.size()];
        for(int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BlindRecruit_2023_5 mc = new BlindRecruit_2023_5();

        String[] commands = {
            "UPDATE 1 1 menu",
            "UPDATE 1 2 category",
            "UPDATE 2 1 bibimbap",
            "UPDATE 2 2 korean",
            "UPDATE 2 3 rice",
            "UPDATE 3 1 ramyeon",
            "UPDATE 3 2 korean",
            "UPDATE 3 3 noodle",
            "UPDATE 3 4 instant",
            "UPDATE 4 1 pasta",
            "UPDATE 4 2 italian",
            "UPDATE 4 3 noodle",
            "MERGE 1 2 1 3",
            "MERGE 1 3 1 4",
            "UPDATE korean hansik",
            "UPDATE 1 3 group",
            "UNMERGE 1 4",
            "PRINT 1 3",
            "PRINT 1 4"
        };
        String[] result = mc.solution(commands);
        for (String command : result)
            System.out.print(command + " ");
        System.out.println();
    }
}
