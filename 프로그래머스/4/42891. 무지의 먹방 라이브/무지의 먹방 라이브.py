import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    # Create a min-heap using (food_time, index)
    heap = []
    for i, time in enumerate(food_times):
        heapq.heappush(heap, (time, i + 1))
    
    total_time = 0  # Total time that has passed
    previous_time = 0  # Time consumed in previous rounds
    len_food = len(food_times)  # Number of foods

    # Process the heap while there is enough time to consume the smallest element
    while total_time + (heap[0][0] - previous_time) * len_food <= k:
        current_time = heapq.heappop(heap)[0]
        total_time += (current_time - previous_time) * len_food
        len_food -= 1
        previous_time = current_time

    # Remaining foods are indexed, and we re-sort them based on their original index
    result = sorted(heap, key=lambda x: x[1])  # Sorting by index which is the second element in the tuple
    return result[(k - total_time) % len_food][1]

