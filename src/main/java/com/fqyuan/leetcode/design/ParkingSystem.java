package com.fqyuan.leetcode.design;

/**
 *
 */
class ParkingSystem {
    private int bigSeatCnt;
    private int mediumSeatCnt;
    private int smallSeatCnt;

    public ParkingSystem(int big, int medium, int small) {
        bigSeatCnt = big;
        mediumSeatCnt = medium;
        smallSeatCnt = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                return bigSeatCnt-- >= 1;
            case 2:
                return mediumSeatCnt-- >= 1;
            case 3:
                return smallSeatCnt-- >= 1;
            default:
                return false;
        }
    }
}
