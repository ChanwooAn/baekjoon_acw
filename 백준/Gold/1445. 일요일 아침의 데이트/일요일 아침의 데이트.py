from heapq import heappush, heappop

# 상수 정의
INFINITY = 100000000
GARBAGE_COST = 10000
AROUND_GARBAGE_COST = 1

# 방향 정의: 위, 왼쪽, 아래, 오른쪽
DIRECTIONS = ((-1, 0), (0, -1), (1, 0), (0, 1))

def initialize_map():
    """맵 초기화 및 시작점과 도착점, 쓰레기 위치 설정"""
    maps = [[0] * m for _ in range(n)]
    start, finish = None, None

    for i in range(n):
        line = input()
        for j, char in enumerate(line):
            if char == 'S':
                start = (i, j)
            elif char == 'F':
                finish = (i, j)
            elif char == 'g':
                maps[i][j] = GARBAGE_COST
                for dr, dc in DIRECTIONS:
                    nr, nc = i + dr, j + dc
                    if 0 <= nr < n and 0 <= nc < m and maps[nr][nc] == 0:
                        maps[nr][nc] = AROUND_GARBAGE_COST

    # 시작점과 도착점을 0으로 설정
    maps[start[0]][start[1]], maps[finish[0]][finish[1]] = 0, 0
    return maps, start, finish

def find_path(maps, start, finish):
    """최단 경로 찾기"""
    values = [[INFINITY] * m for _ in range(n)]
    visited = [[False] * m for _ in range(n)]
    heap = [(0, start)]

    while heap:
        score, (x, y) = heappop(heap)
        if visited[x][y]: continue
        if (x, y) == finish: return score
        visited[x][y] = True

        for dr, dc in DIRECTIONS:
            nx, ny = x + dr, y + dc
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                new_score = score + maps[nx][ny]
                if values[nx][ny] > new_score:
                    values[nx][ny] = new_score
                    heappush(heap, (new_score, (nx, ny)))

    return INFINITY  # 경로를 찾지 못한 경우

# 메인 함수
if __name__ == "__main__":
    n, m = map(int, input().split())
    maps, start, finish = initialize_map()
    score = find_path(maps, start, finish)

    # 최종 결과 출력: 쓰레기를 지나간 횟수, 쓰레기 주변을 지나간 횟수
    print(score // GARBAGE_COST, score % GARBAGE_COST)
