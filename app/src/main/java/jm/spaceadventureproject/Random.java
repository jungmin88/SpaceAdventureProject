package jm.spaceadventureproject;

/**
 * Created by jm on 2017-06-02.
 */

public class Random {
    public static int get(int min, int max){
        if(min > max){
            return -1;
        }

        // 최대값과 최소값의 차이
        int diffrerence = max - min + 1;

        // 차이값의 범위만큼 랜덤값 생성
        int value = (int)(Math.random()*diffrerence);

        // 차이값의 랜덤값을 최소값을 더하여 원래 범위내의 랜덤값 생성
        int result = min + value;

        return value;
    }
}
