package d3;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Solution {
    static BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    
    static int t;
    static int[][] tcase;
    static int[][] map;
    
    static String[] s;
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        s = bfr.readLine().split(" ");
        t = Integer.parseInt(s[0]);
        
        tcase = new int[t][2];
        map = new int[t][];
        
        for(int i = 0; i < t; i ++) {
            s = bfr.readLine().split(" ");
            tcase[i][0] = Integer.parseInt(s[0]);
            tcase[i][1] = Integer.parseInt(s[1]);
            map[i] = new int[tcase[i][0]];
            s = bfr.readLine().split(" ");
            for(int j = 0; j < tcase[i][0]; j++)
                map[i][j] = Integer.parseInt(s[j]);
        }
        
        // for문 안에서 문을 세우기전과 후의 개수를 비교해서 차를 구합니다
        for(int i = 0; i < t; i++) {
            int acnt = 0;
            int bcnt = 0;
            
            for(int j = 0; j < map[i].length; j++)
                if(map[i][j]==1)
                    bcnt++;
            
            arch(i, tcase[i][1], -1);
            
            for(int j = 0; j < map[i].length; j++)
                if(map[i][j]==1)
                    acnt++;
            
            System.out.println("#" + (i+1) + " " + (acnt-bcnt));
        }
        
    }
    //여기서 범위 안에서 문을 만나면 재귀하고 만나지 못하면 범위끝에 문을 세우고 재귀
    static void arch(int tn, int d, int start) {
        if((start+d) >= map[tn].length)
            return;
        else {
            for(int i = 1; i <= d; i++) {
                if(map[tn][start+i]==1) {
                    arch(tn, d, start+i);
                    return;
                }
            }
            
            map[tn][start+d] = 1;
            arch(tn, d, start+d);
        }
        
    }

}