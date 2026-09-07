package edu.princeton.cs.algs4;

public class QuickFindUF {
    private int[] id;    // id[i] = component id of i
    private int count;   // number of components

    // Khởi tạo N phần tử (0 đến N-1)
    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    // Trả về số lượng thành phần liên thông
    public int count() {
        return count;
    }

    // Trả về ID thành phần của p
    public int find(int p) {
        validate(p);
        return id[p];
    }

    // Kiểm tra p và q có cùng thành phần liên thông không
    public boolean connected(int p, int q) {
        validate(p);
        validate(q);
        return id[p] == id[q];
    }

    // Hợp nhất hai thành phần chứa p và q
    public void union(int p, int q) {
        validate(p);
        validate(q);
        int pID = id[p];
        int qID = id[q];

        // Nếu đã cùng thành phần thì không cần hợp nhất
        if (pID == qID) return;

        for (int i = 0; i < id.length; i++)
            if (id[i] == pID) id[i] = qID;
        count--;
    }

    private void validate(int p) {
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFindUF uf = new QuickFindUF(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.find(p) == uf.find(q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}