package algorithm01_recursion;

/**
 * 迷宫问题
 */
public class Maze {
    private static int[][] map = new int[8][7]; //初始化一个二维迷宫

    //设置迷宫
    static {
        //使用元素1表示墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1; //第1行所有元素为1
            map[7][i] = 1; //第8行所有元素为1
        }
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;    //第1列所有元素为1
            map[i][6] = 1;    //第7列所有元素为1
        }
        //设置障碍物
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;
    }

    public static void main(String[] args) {
        //输出地图
        viewOfMap();
        System.out.println("-------------");
        setWay2(1, 1);
        viewOfMap();
    }

    /**
     * 在控制台输出地图视图
     */
    public static void viewOfMap() {
        //输出地图
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t", map[i][j]);    //输出每行元素
            }
            System.out.println();   //每行输出结束后换行
        }
    }

    /**
     * 使用递归回溯给小球找路
     * 递归头：小球位置到达 map[6][5]递归结束
     * 当map[i][j]为0时表示该点没有走过
     * 当map[i][j]为1时表示障碍物
     * 当map[i][j]为2时表示通路可以走
     * 当map[i][j]为3时表示该点走过，但是走不通
     * 基本寻路策略：下->右->上->左，如果该点走不通再回溯
     *
     * @param i 起点
     * @param j 起点
     * @return 找到通路返回true
     */
    public static boolean setWay(int i, int j) {
        //设置递归头
        if (map[6][5] == 2) {
            return true;
        }
        //如果当前位置还未走过
        if (map[i][j] == 0) {
            map[i][j] = 2;    //先假定该点可以走通
            //寻路策略
            if (setWay(i + 1, j)) { //向下走
                return true;
            } else if (setWay(i, j + 1)) {   //向右走
                return true;
            } else if (setWay(i - 1, j)) {   //向上走
                return true;
            } else if (setWay(i, j - 1)) {   //向左走
                return true;
            } else {
                map[i][j] = 3;    //此节点已走过，但是无法走通
                return false;
            }
        } else {
            //如果该节点的值为1,2,3。说明下个节点的状态已知，不需要再进行判断，返回false
            return false;
        }
    }

    /**
     * 修改寻路策略
     * 上右下左
     *
     * @param i
     * @param j
     * @return
     */
    public static boolean setWay2(int i, int j) {
        //设置递归头
        if (map[6][5] == 2) {
            return true;
        }
        //如果当前位置还未走过
        if (map[i][j] == 0) {
            map[i][j] = 2;    //先假定该点可以走通
            //寻路策略
            if (setWay2(i - 1, j)) { //向上走
                return true;
            } else if (setWay2(i, j + 1)) {   //向右走
                return true;
            } else if (setWay2(i + 1, j)) {   //向上走
                return true;
            } else if (setWay2(i, j - 1)) {   //向左走
                return true;
            } else {
                map[i][j] = 3;    //此节点已走过，但是无法走通
                return false;
            }
        } else {
            //如果该节点的值为1,2,3。说明下个节点的状态已知，不需要再进行判断，返回false
            return false;
        }
    }
}
