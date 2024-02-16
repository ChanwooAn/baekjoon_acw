import heapq

# 입력 받기
n = int(input())
tasks = [list(map(int, input().split())) for _ in range(n)]

# 데드라인에 따라 작업 정렬
tasks.sort(key=lambda x: x[0])

# 우선순위 큐 초기화
heap = []
for deadline, cups in tasks:
    # 현재 작업을 힙에 추가
    heapq.heappush(heap, cups)
    # 데드라인을 초과하면, 현재까지 선택한 작업 중 컵라면 수가 가장 적은 작업 제거
    if len(heap) > deadline:
        heapq.heappop(heap)

# 힙에 남아 있는 작업의 컵라면 수의 합이 최대 컵라면 수
answer = sum(heap)
print(answer)