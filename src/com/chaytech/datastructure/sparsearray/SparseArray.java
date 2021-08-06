package com.chaytech.datastructure.sparsearray;

/**
 * 稀疏数组实现
 * 稀疏数组的特点就是列数是固定的，一共有3列，分别是行(row)、列(col)、值(value)这三列，稀疏数组的数组长度 = 原始数组的有效元素个数+1，
 * 为什么要加1呢？因为稀疏数组的第一行是用来记录原始数组的行数、列数、以及有效元素个数。
 * 接下来的每一行是分别来记录原始数组有效元素的行下标、列下标及元素的值。
 *
 * 当一个数组中大部分元素为０，或者为同一个值的数组时，可以使用稀疏数组来保存该数组
 *
 * @author Chency
 * @email chaytech@163.com
 * @Date: 2019/06/17 22:10
 */
public class SparseArray {

    public static void main(String[] args) {
        // 定义一个10*10的二位数组
        System.out.println("原始二维数组：");
        int rowLength = 10;
        int colLength = 10;
        int chessboardOne[][] = new int[rowLength][colLength];

        // 设置二维数组中的值
        chessboardOne[1][2] = 1;
        chessboardOne[2][3] = 2;
        // 输出打印数组
        printArray(chessboardOne);

        /**二维数组转稀疏数组*/
        // 1.遍历二维数组统计数组中不为0的元素个数
        int noZeroElementNum = 0;
        for (int i = 0; i < chessboardOne.length; i++) {
            for (int j = 0; j < chessboardOne[i].length; j++) {
                if (chessboardOne[i][j] != 0) {
                    noZeroElementNum++;
                }
            }
        }
        System.out.println("noZeroElementNum：" + noZeroElementNum);

        // 2.根据前面得到的有效元素个数来创建稀疏数组
        int sparseArray[][] = new int[noZeroElementNum + 1][3];
        // 3.设置稀疏数组首行数据
        sparseArray[0][0] = rowLength; // 行数
        sparseArray[0][1] = colLength; // 列数
        sparseArray[0][2] = noZeroElementNum; // 有效元素个数

        // 4.遍历二维数组的有效数据赋值给稀疏数组
        int indexTemp = 0; // 非0数据下标
        for (int i = 0; i < chessboardOne.length; i++) {
            for (int j = 0; j < chessboardOne[i].length; j++) {
                if (chessboardOne[i][j] != 0) {
                    indexTemp++;
                    sparseArray[indexTemp][0] = i;
                    sparseArray[indexTemp][1] = j;
                    sparseArray[indexTemp][2] = chessboardOne[i][j];
                }
            }
        }

        System.out.println("得到的稀疏数组：");
        System.out.printf("row col value\n");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t %d\t %d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }

        /**稀疏数组转二维数组*/
        // 1.读取稀疏首行数据，得到二维数组的行数和列数并创建一个新的二维数组
        int chessboardTwo[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 2.遍历稀疏数组的后几行数据赋值给新的二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessboardTwo[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        System.out.println("将稀疏数组转换后的二维数组：");

        // 输出打印数组
        printArray(chessboardTwo);
    }

    public static void printArray(int param[][]) {
        for (int[] row : param) {
            for (int val : row) {
                System.out.printf("%d\t", val);
            }
            System.out.println();
        }
    }
}
