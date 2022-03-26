import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class ParcelService_8980 {
    public int solution(int n, int c, ArrayList<TownBoxes> townboxes) {

        Collections.sort(townboxes);

        int[] boxes = new int[n + 1];
        int boxCount = 0;
        for(TownBoxes town : townboxes) {
            int start = town.start;
            int end = town.end;
            int box = town.boxes;

            int max = 0;
            boolean isLoad = true;
            for(int i = start; i < end; i++) {
                if(boxes[i] >= c) {
                    isLoad = false;
                    break;
                }
                max = Math.max(boxes[i], max);
            }

            if(isLoad) {
                int dropOff = c - max;
                if(dropOff > box) {
                    dropOff = box;
                }
                boxCount += dropOff;

                for(int i = start; i < end; i++) {
                    boxes[i] += dropOff;
                }
            }
        }

        return boxCount;
    }
    public static void main(String[] args) throws IOException {
        ParcelService_8980 mc = new ParcelService_8980();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<TownBoxes> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            boxes.add(new TownBoxes(start, end, box));
        }

        System.out.println(mc.solution(N, C, boxes));
    }
}

class TownBoxes implements Comparable<TownBoxes> {
    int start = 0;
    int end = 0;
    int boxes = 0;
    TownBoxes(int start, int end, int boxes) {
        this.start = start;
        this.end = end;
        this.boxes = boxes;
    }

    @Override
    public int compareTo(TownBoxes box) {
        if(this.end == box.end) return this.start - box.start;
        else return this.end - box.end;
    }
}
