package com.leet.day12;

import com.sun.imageio.plugins.common.I18N;

import java.util.HashMap;

public class Number14 {
    /*
    2.1.14 有效数独  中等

    判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

                        5 3 0 0 7 0 0 0 0
                        6 0 0 1 9 5 0 0 0
                        0 9 8 0 0 0 0 6 0
                        8 0 0 0 6 0 0 0 3
                        4 0 0 8 0 3 0 0 1
                        7 0 0 0 2 0 0 0 6
                        0 6 0 0 0 0 2 8 0
                        0 0 0 4 1 9 0 0 5
                        0 0 0 0 8 0 0 7 9

    上图是一个部分填充的有效的数独。
    数独部分空格内已填入了数字，空白格用 '.' 表示。

    示例 1:
    输入:
    [
      ["5","3",".",".","7",".",".",".","."],
      ["6",".",".","1","9","5",".",".","."],
      [".","9","8",".",".",".",".","6","."],
      ["8",".",".",".","6",".",".",".","3"],
      ["4",".",".","8",".","3",".",".","1"],
      ["7",".",".",".","2",".",".",".","6"],
      [".","6",".",".",".",".","2","8","."],
      [".",".",".","4","1","9",".",".","5"],
      [".",".",".",".","8",".",".","7","9"]
    ]
    输出: true
    */

    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {  //位运算双百
        if (board == null)
            return false;
        if (board.length != 9)
            return false;
        int[] map = new int[9];
        for (int y = 0; y < 9; y++) {
            if (board[y] == null || board[y].length != 9)
                return false;
            for (int x = 0; x < 9; x++) {
                int key = board[y][x] - '1'; //key:数字
                if (key >= 0 && key <= 8) {  //1~9有效数字
                    int index = (1 << x)     //Value:位置编码，最低9位存放列号
                            | (1 << (y + 9))    //中间9位存放行号
                            | (1 << (x / 3 + y / 3 * 3 + 18));  // z为9宫格区域序号
                    int old = map[key];
                    if ((old & index) == 0) //无重复，则按位或，加入位置集合
                        map[key] = old | index;
                    else    //有重复
                        return false;
                }
            }
        }
        return true;
    }



    public static boolean isValidSudokuHash(char[][] arr) {
        int size = 9;
        HashMap<Integer, Integer>[] rows = new HashMap[size];
        HashMap<Integer, Integer>[] clo = new HashMap[size];
        HashMap<Integer, Integer>[] boxes = new HashMap[size];


        for (int i = 0; i < size; i++) {
            rows[i] = new HashMap<>();
            clo[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }

        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                int num = (int) arr[j][i];

                if (num != '.') {
                    int boxes_index = (j / 3) * 3 + i / 3;
                    int rowsNum;
                    int cloNum;
                    int boxNum;
                    rows[i].put(num, (rowsNum = rows[i].getOrDefault(num, 0) + 1));
                    clo[j].put(num, (cloNum = clo[j].getOrDefault(num, 0) + 1));
                    boxes[boxes_index].put(num, (boxNum = (boxes[boxes_index].getOrDefault(num, 0) + 1)));

                    if (rowsNum > 1 || cloNum > 1 || boxNum > 1) {
                        return false;
                    }

                }
            }
        }

        return true;
    }
}
