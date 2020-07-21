package top.humg.a01_sparsearray;


public class SparseArray {
    public static void main(String[] args) {
        int[][] arr = new int[11][11];
        //0表示无子，1表示黑子，2表示蓝子
        arr[1][2] = 1;
        arr[2][3] = 2;
        for (int[] row : arr) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

        //二维数组转稀疏数组
        //遍历二维数组得到非0数据的个数
        int count = 0;
        for (int[] row : arr) {
            for (int data : row) {
                if (data != 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        //将有效数据存入数组中
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = count;

        int rowIndex = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArr[rowIndex][0] = i;
                    sparseArr[rowIndex][1] = j;
                    sparseArr[rowIndex][2] = arr[i][j];
                    rowIndex++;
                }
            }
        }

        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将稀疏数组恢复成原始二维数组
        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }

        for (int[] row : arr2) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}
