data = []
FC = []
NS = []

def create_node(x):
    data.append(x)
    FC.append(-1)
    NS.append(-1)
    return len(data) - 1


def add_child(parent, child):
    if FC[parent] == -1:
        FC[parent] = child
    else:
        p = FC[parent]

        while NS[p] != -1:
            p = NS[p]

        NS[p] = child


def find_parent(x):
    for i in range(len(data)):
        child = FC[i]

        while child != -1:
            if child == x:
                return i
            child = NS[child]

    return -1

# 1. Tạo các nút
for x in "ABCDEFG":
    create_node(x)

# 2. Xây dựng cây
add_child(0, 1)  # A -> B
add_child(0, 2)  # A -> C
add_child(0, 3)  # A -> D

add_child(1, 4)  # B -> E
add_child(1, 5)  # B -> F

add_child(3, 6)  # D -> G

# 3. In các mảng
print("Data:", data)
print("FC:  ", FC)
print("NS:  ", NS)

# 4. Tìm cha của F (chỉ số 5)
p = find_parent(5)

if p != -1:
    print("Cha cua F:", data[p])
else:
    print("Khong tim thay cha")