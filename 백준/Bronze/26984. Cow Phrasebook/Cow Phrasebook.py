def add_word(root, word):
    node = root
    for c in word:
        if c not in node:
            node[c] = {}
        node = node[c]

def count_prefixes(root, messages):
    count = 0
    for message in messages:
        node = root
        flag = True
        for c in message:
            if c not in node:
                flag = False
                break
            node = node[c]
        if flag:
            count += 1
    return count

m, n = map(int, input().split())
root = {}
for i in range(m):
    add_word(root, input().strip())
messages = [input().strip() for i in range(n)]
print(count_prefixes(root, messages))
