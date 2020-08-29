package interview.农业银行;

import org.junit.Test;

import java.util.ArrayList;
import java.lang.Integer;

public class Question2 {
    public static void main(String[] args) {
        String[] points = {"1,1", "1,3", "2,2", "1,2"};
        int index = new Question2().getIndex(points);
        System.out.println(index);
    }

    public int getIndex(String[] points) {
        ArrayList<Integer> x = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();
        //求出其质点
        for (String point : points) {
            String[] split = point.split(",");
            x.add(Integer.parseInt(split[0]));
            y.add(Integer.parseInt(split[1]));
        }
        //遍历集合求平均值
        int sum = 0;
        for (Integer xVal : x) {
            sum += xVal;
        }
        double xAvg = sum / (double) x.size();

        sum = 0;
        for (Integer yVal : y) {
            sum += yVal;
        }
        double yAvg = sum / (double) y.size();

        //找到离质点最近的点
        double minJuli = Math.pow(xAvg - x.get(0), 2) + Math.pow(yAvg - y.get(0), 2);
        int minIndex = 0;

        for (int i = 0; i < x.size(); i++) {
            double pointX = x.get(i);
            double pointY = y.get(i);
            double temp = Math.pow(xAvg - pointX, 2) + Math.pow(yAvg - pointY, 2);
            if (temp < minJuli) {
                minJuli = temp;
                minIndex = i;
            }
        }
        return minIndex;
    }

    @Test
    public void test1() {
        System.out.println((1 - 2) * (1 - 2));
    }
}
