package my.chapter4.item18;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

// 上层客户端使用的包装类 使用组合扩展类
// 将客户请求通过中间转发类传递到底层实现类 实现包装类和底层类的解耦
// 同时包装类中的逻辑不会受到底层类的影响
public class WapperSet<E>  extends ForwardingSet<E>{
    private int addCount;
    public WapperSet(Set<E> s) {
        super(s);
    }

    // add() 逻辑不会与底层类冲突
    @Override public boolean add(E e) { 
        addCount++;
        return super.add(e);
    }

    @Override public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() { return addCount; }

    public static void main(String[] args) {
        WapperSet<Integer> set = new WapperSet<>(new HashSet<>());
        set.addAll(List.of(1, 2, 3));
        System.out.println(set.getAddCount());
        char[][] ch = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        solve(ch);
    }

    public static void solve(char[][] board) {
        // dfs
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O')
                    dfs(board, i, j, row, col);
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '0')
                    board[i][j] = 'X';
                if (board[i][j] == '1')
                    board[i][j] = 'O';
            }
        }
    }

    public static void dfs(char[][] a, int i, int j, int row, int col) {
        if (i < 0 || j < 0 || i == row || j == col)
            return ;
        // 边界重置
        if (a[i][j] == 'O' && (i == 0 || i == row - 1 || 
            j == 0 || j == col - 1)) {
            a[i][j] = '1';
            dfs(a, i-1, j, row, col);
            dfs(a, i+1, j, row, col);
            dfs(a, i, j-1, row, col);
            dfs(a, i, j+1, row, col);
        }
        // 正常情况
        else if (a[i][j] == 'O') {
            // 标记
            a[i][j] = '0';
            dfs(a, i-1, j, row, col);
            dfs(a, i+1, j, row, col);
            dfs(a, i, j-1, row, col);
            dfs(a, i, j+1, row, col);
        }
    }
}
