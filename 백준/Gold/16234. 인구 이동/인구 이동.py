from collections import deque
import sys
input = sys.stdin.read

def main():
    data = input().split()
    n = int(data[0])
    l = int(data[1])
    r = int(data[2])

    population_map = []
    index = 3
    for _ in range(n):
        population_map.append(list(map(int, data[index:index+n])))
        index += n

    answer = 0

    while True:
        visit = [[False] * n for _ in range(n)]
        flag = False

        for y in range(n):
            for x in range(n):
                if not visit[y][x]:
                    countries = bfs(y, x, n, l, r, visit, population_map)
                    if len(countries) > 1:
                        new_population = sum(population_map[cy][cx] for cy, cx in countries) // len(countries)
                        for cy, cx in countries:
                            population_map[cy][cx] = new_population
                        flag = True
        
        if flag:
            answer += 1
        else:
            break

    print(answer)

def bfs(y, x, n, l, r, visit, population_map):
    queue = deque([(y, x)])
    visit[y][x] = True
    countries = [(y, x)]
    directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

    while queue:
        current_y, current_x = queue.popleft()

        for dy, dx in directions:
            ny, nx = current_y + dy, current_x + dx
            if 0 <= ny < n and 0 <= nx < n and not visit[ny][nx]:
                if l <= abs(population_map[current_y][current_x] - population_map[ny][nx]) <= r:
                    visit[ny][nx] = True
                    queue.append((ny, nx))
                    countries.append((ny, nx))

    return countries

if __name__ == "__main__":
    main()
