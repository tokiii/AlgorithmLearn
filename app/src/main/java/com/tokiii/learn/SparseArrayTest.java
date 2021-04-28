package com.tokiii.learn;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 稀疏数组测试
 */
public class SparseArrayTest {
    public static void main(String[] args) {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        System.out.println("原始二维数组");
        for (int[] rows : chessArr1) {
            for (int val : rows) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }

        // 遍历数组 取得非0个数
        int sum = 0;
        for (int[] rows : chessArr1) {
            for (int val : rows) {
                if (val != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum--->" + sum);

        // 创建对应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历二维数组，将非0的值存放到稀疏数组中

        int count = 0;// 用于记录是第几个非0数组
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        // 输出稀疏数组
        System.out.println();
        System.out.println("得到的稀疏数组为");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        System.out.println();
        // 将稀疏数组恢复成二维数组

        int row = sparseArray[0][0];
        int col = sparseArray[0][1];
        int[][] cherry2 = new int[row][col];

        for (int i = 1; i < sparseArray.length; i++) {
            cherry2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("恢复二维数组");
        for (int[] rows : cherry2) {
            for (int val : rows) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }
        saveSparseArrayToDisk(sparseArray);
    }


    public static void saveSparseArrayToDisk(int[][] sparseArray){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/lost/array.txt"));
            for (int[] rows : sparseArray){
                for (int data: rows){
                    bw.write(data + "\t");
                }
                bw.newLine();
            }
            bw.close();
            System.out.println("文件写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  static int[][] getSparseArrayFromDisk(){
        int[][] s = new int[10][10];
        return s;
    }

}
