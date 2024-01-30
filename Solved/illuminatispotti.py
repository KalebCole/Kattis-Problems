def count_triangles(matrix) -> int:
    triangle_count = 0
    size = len(matrix)

    for i in range(size):
        for j in range(i + 1, size):  # Start j from i+1 to avoid duplicate checks
            for k in range(j + 1, size):  # Start k from j+1 to avoid duplicate checks
                if matrix[i][j] == 1 and matrix[j][k] == 1 and matrix[k][i] == 1:
                    triangle_count += 1

    return triangle_count 


def main() -> None:
    size = int(input())
    adjacency_matrix = [list(map(int, input().split())) for _ in range(size)]
    count = count_triangles(adjacency_matrix)
    print(count)


if __name__ == "__main__":
    main()
