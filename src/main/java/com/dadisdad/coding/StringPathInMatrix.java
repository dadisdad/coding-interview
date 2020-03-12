package com.dadisdad.coding;

/**
 * 矩阵中的路径
 *
 * @author 10308
 * @date 2020/3/11
 */
public class StringPathInMatrix {

    public static boolean exist(char[][] board, String word) {
        if (board == null || board[0] == null || board.length == 0 || board[0].length == 0 || word == null || word.isEmpty()) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        char[] chs = word.toCharArray();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == chs[0]) {
                    if (bfs(board, i, j, visited, chs, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean bfs(char[][] board, int i, int j, boolean[][] visited, char[] chs, int index) {
        if (index == chs.length) {
            return true;
        }
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || visited[i][j] || board[i][j] != chs[index]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = bfs(board, i - 1, j, visited, chs, index + 1)
                || bfs(board, i + 1, j, visited, chs, index + 1)
                || bfs(board, i, j - 1, visited, chs, index + 1)
                || bfs(board, i, j + 1, visited, chs, index + 1);
        visited[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'F'}
        };
        String word = "ABCCED";
        String word1 = "BFCE";
        System.out.println(exist(board, word));
        System.out.println(exist(board, word1));

        char[][] board2 = {
                {'a', 'b'},
                {'c', 'd'}
        };
        String word2 = "abcd";
        System.out.println(exist(board2, word2));


    }
}
