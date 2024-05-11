from itertools import combinations

n = int(input())  # 방의 크기 N
board = []  # 방 상태 정보(N x N)
teachers = []  # 모든 선생님 위치 저장
spaces = []  # 모든 빈 공간 위치 저장

for i in range(n):
    board.append(list(input().split()))
    for j in range(n):
        # 선생님의 좌표는 여기서 저장
        if board[i][j] == 'T':
            teachers.append((i, j))
        # 장애물을 설치할 수 있는 (빈 공간) 위치 저장
        if board[i][j] == 'X':
            spaces.append((i, j))

def watch(x, y, direction):
    # 동쪽 방향으로 감시 (왼쪽 -> 오른쪽)
    if direction == 0:
        while y < n:
            if board[x][y] == 'S':  # 학생이 있는 경우
                return True
            if board[x][y] == 'O':  # 장애물이 있는 경우
                return False
            y += 1

    # 서쪽 방향으로 감시
    if direction == 1:
        while y >= 0:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            y -= 1

    # 남쪽 방향으로 감시
    if direction == 2:
        while x < n:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            x += 1

    # 북쪽 방향으로 감시
    if direction == 3:
        while x >= 0:
            if board[x][y] == 'S':
                return True
            if board[x][y] == 'O':
                return False
            x -= 1

    return False

def process():
    # 모든 선생님이 학생을 감시할 수 없도록 감시 회피를 검사
    for x, y in teachers:
        # 4방향 감시를 통해 학생을 감시할 수 있는지 확인
        for i in range(4):
            if watch(x, y, i):
                return True
    return False

find = False  # 학생이 한 명도 감시되지 않도록 설치할 수 있는지 여부
# 벽 3개로 장애물을 모든 조합으로 설치
for data in combinations(spaces, 3):
    # 장애물 설치
    for x, y in data:
        board[x][y] = 'O'
    # 설치된 장애물을 통해 감시 회피가 가능한지 검사
    if not process():
        find = True
        break
    # 설치한 장애물을 다시 없애기
    for x, y in data:
        board[x][y] = 'X'

if find:
    print('YES')
else:
    print('NO')
