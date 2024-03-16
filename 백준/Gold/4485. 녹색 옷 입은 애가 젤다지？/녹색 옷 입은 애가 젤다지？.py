from queue import Queue

dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]

def bfs(n, arr):
    dist = [[float('inf')] * n for _ in range(n)]
    q = Queue()

    # Starting position
    q.put((0, 0))
    dist[0][0] = arr[0][0]

    while not q.empty():
        y, x = q.get()

        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]

            if 0 <= ny < n and 0 <= nx < n:
                if dist[ny][nx] > dist[y][x] + arr[ny][nx]:
                    dist[ny][nx] = dist[y][x] + arr[ny][nx]
                    q.put((ny, nx))

    return dist[n-1][n-1]

def main():
    cnt = 1

    while True:
        n = int(input())
        if n == 0:
            break

        arr = [list(map(int, input().split())) for _ in range(n)]
        print(f"Problem {cnt}: {bfs(n, arr)}")
        cnt += 1

if __name__ == "__main__":
    main()
