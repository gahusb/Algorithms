package kakako;

import java.util.Map;
import java.util.TreeMap;

// 주차 요금 계산
public class BlindRecruit_2022_3 {
    class Car {
        int inout, intime, accum;
        public Car(int inout, int intime, int accum) {
            this.inout = inout; // 0 : out, 1 : in
            this.intime = intime;
            this.accum = accum;
        }

        public int getInout() { return this.inout; }
        public int getInTime() { return this.intime; }
        public int getAccum() { return this.accum; }
        public void setInout(int inout) { this.inout = inout; }
        public void setInTime(int intime) { this.intime = intime; }
        public void setAccum(int accum) { this.accum = accum; }
    }
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, Car> map = new TreeMap<String, Car>();

        for(int i = 0; i < records.length; i++) {
            String[] tmp = records[i].split(" ");
            if(tmp[2].equals("IN")) {
                String[] time = tmp[0].split(":");
                int inTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);

                if(map.containsKey(tmp[1])) {
                    Car car = map.get(tmp[1]);
                    car.setInout(1);
                    car.setInTime(inTime);
                    map.put(tmp[1], car);
                } else {
                    map.put(tmp[1], new Car(1, inTime, 0));
                }
            } else {
                if(map.containsKey(tmp[1])) {
                    Car car = map.get(tmp[1]);
                    String[] time2 = tmp[0].split(":");
                    int out_time = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);

                    car.setInout(0);
                    car.setAccum(car.getAccum() + (out_time - car.getInTime()));
                    car.setInTime(0);
                    // map.put(tmp[1], car);
                }
            }
        }

        answer = new int[map.size()];
        // fee : 기본 시간, 기본 요금, 단위 시간, 단위 요금
        int idx = 0;
        for(String key : map.keySet()) {
            Car car = map.get(key);
            if(car.getInout() != 0) {
                int out_time = 23 * 60 + 59;
                car.setAccum(car.getAccum() + (out_time - car.getInTime()));
            }

            int accum = car.getAccum();
            if(fees[0] >= car.getAccum()) {
                answer[idx] = fees[1];
            } else {
                answer[idx] = fees[1] + (int)Math.ceil((double) (accum - fees[0]) / fees[2]) * fees[3];
            }
            idx++;
        }

        return answer;
    }
    public static void main(String[] args) throws Exception {
        BlindRecruit_2022_3 mc = new BlindRecruit_2022_3();

        int[] fee1 = {180, 5000, 10, 600};
        int[] fee2 = {120, 0, 60, 591};
        int[] fee3 = {1, 461, 1, 10};

        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        String[] records3 = {"00:00 1234 IN"};

        int[] result1 = mc.solution(fee1, records1);
        int[] result2 = mc.solution(fee2, records2);
        int[] result3 = mc.solution(fee3, records3);

        for(int i = 0; i < result1.length; i++) {
            System.out.print(result1[i] + ", ");
        }
        System.out.println();
        for(int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + ", ");
        }
        System.out.println();
        for(int i = 0; i < result3.length; i++) {
            System.out.print(result3[i] + ", ");
        }
        System.out.println();
    }
}
