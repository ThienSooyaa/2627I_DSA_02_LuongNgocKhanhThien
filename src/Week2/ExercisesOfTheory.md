
### **COS226, Midterm f25, 1c**

**Đề bài:** Hàm `op()` được gọi bao nhiêu lần (tính theo $n$)?
```java
for (int i = 0; i < n*n; i++)
    for (int j = i+1; j < n*n; j++)
        for (int k = 1; k <= n*n; k = k*2) 
            op();
```

**Phân tích:**
1. **Hai vòng lặp ngoài (`i` và `j`):**
    - Đếm số cặp $(i, j)$ thỏa mãn $0 \le i < j < n^2$.
    - Tương đương chọn $2$ phần tử từ $n^2$ phần tử: $\binom{n^2}{2} = \frac{n^2(n^2 - 1)}{2} \sim \frac{1}{2}n^4$.
2. **Vòng lặp trong (`k`):**
    - Chạy theo cấp số nhân $1, 2, 4, 8, \dots \le n^2$.
    - Số lần lặp là $\lfloor \log_2(n^2) \rfloor + 1 = 2 \log_2 n + 1 \sim 2 \log_2 n$.
3. **Tổng số lần gọi `op()`:**
   $$ \text{Số lần} \sim \left( \frac{1}{2} n^4 \right) \cdot (2 \log_2 n) = n^4 \log_2 n $$

**Đáp án đúng:**  
$$\mathbf{\sim n^4 \log_2 n}$$

---

### **COS226, Midterm f25, 1d**

**Đề bài:** Biểu thức nào mô tả đúng về hàm $f(n) = 2n^2 + 2n + 6 \log_2 n$?

**Phân tích:**
- Bậc tăng trưởng cao nhất của $f(n)$ là $n^2$.
- Theo định nghĩa độ phức tạp thuật toán:
    - Tất cả các biểu thức $O(g(n))$ với $g(n) \ge \Omega(n^2)$ đều đúng: **$O(n^2)$** và **$O(n^3)$** là các độ phức tạp chuẩn chính xác trong trắc nghiệm.
    - Tất cả các biểu thức $\Omega(g(n))$ với $g(n) \le O(n^2)$ đều đúng: **$\Omega(\log n)$**, **$\Omega(n)$**, và **$\Omega(n^2)$**.

**Đáp án đúng (khoanh tròn các mục tương ứng):**
- Đánh giá Chặn trên ($O$): **$O(n^2)$** và **$O(n^3)$**
- Đánh giá Chặn dưới ($\Omega$): **$\Omega(\log n)$**, **$\Omega(n)$**, và **$\Omega(n^2)$**

---

### **COS226, Midterm s25, 1**

**Đề bài:** Tính tổng bộ nhớ (tính bằng byte) mà đối tượng `BST` cấp phát theo $n$ (sử dụng mô hình chi phí bộ nhớ 64-bit Java, ký hiệu $\sim$).

**Phân tích bộ nhớ 64-bit trong Java:**

1. **Lớp ngoài `BST`:**
    - Overhead của Object: 16 bytes.
    - Tham chiếu `root`: 8 bytes.
    - Biến `n` (primitive `int`): 4 bytes + 4 bytes padding = 8 bytes.
    - *Tổng lớp `BST`: 32 bytes (chi phí hằng số $O(1)$).*

2. **Cấu trúc mỗi Node trong `Node` (gồm $n$ node):**
    - **Object Overhead:** 16 bytes.
    - **Tham chiếu Inner Class Pointer** (trỏ tới `BST` cha): 8 bytes.
    - **Các tham chiếu:** `key` (8b), `value` (8b), `parent` (8b), `left` (8b), `right` (8b) $\rightarrow 5 \times 8 = 40$ bytes.
    - **Biến `count` (`int`):** 4 bytes.
    - **Padding:** 4 bytes (để đạt bội số 8 bytes: $16 + 8 + 40 + 4 + 4 = 72$ bytes).
    - **Tổng cho 1 Node:** $72$ bytes.

3. **Tổng dung lượng bộ nhớ cho cây $n$ nút:**
   $$\text{Bộ nhớ} = 32 + 72n \sim 72n \text{ bytes}$$

**Đáp án đúng:**  
$$\mathbf{\sim 72n \text{ bytes}}$$

---

### **COS226, Midterm f24, 2a**

**Đề bài:** Đoạn code dưới đây in từ `hello` bao nhiêu lần? Giả sử $n$ chia hết cho 100.
```java
for (int i = 1; i <= n; i++)
    for (int j = n; j >= i; j--)
        for (int k = 1; k <= n; k = k + n/100)
            System.out.println("hello");
```

**Phân tích:**
1. **Hai vòng lặp ngoài (`i` và `j`):**
    - Vòng `i` chạy từ $1$ tới $n$.
    - Vòng `j` chạy từ $n$ lùi xuống $i$ (có $n - i + 1$ lần lặp).
    - Tổng số lần lặp của 2 vòng ngoài:
      $$ \sum_{i=1}^{n} (n - i + 1) = \frac{n(n+1)}{2} \sim \frac{1}{2}n^2 $$
2. **Vòng lặp trong cùng (`k`):**
    - Bước tăng: $\frac{n}{100}$.
    - Số lần lặp: $\frac{n}{n/100} = 100$ lần.
3. **Tổng số lần in:**
   $$ \text{Số lần} \sim \left(\frac{1}{2}n^2\right) \times 100 = 50n^2 $$

**Đáp án đúng:**  
$$\mathbf{\sim 50n^2}$$

---
