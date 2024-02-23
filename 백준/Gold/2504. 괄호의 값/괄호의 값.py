character_stack = []
num_stack_list = [[]]


def calculate(problem):
    before = None
    for c in problem:
        if c == "(" or c == "[":
            character_stack.append(c)
            num_stack_list.append([])

        elif c == "]":
            if not character_stack or character_stack.pop() != "[":
                return False
            if before == "[":
                num_stack_list.pop()
                num_stack_list[-1].append(3)
            else:
                inner_num = sum(num_stack_list.pop())
                num_stack_list[-1].append(3 * inner_num)
        else:
            if not character_stack or character_stack.pop() != "(":
                return False
            if before == "(":
                num_stack_list.pop()
                num_stack_list[-1].append(2)
            else:
                inner_num = sum(num_stack_list.pop())
                num_stack_list[-1].append(2 * inner_num)

        before = c

    return True


def solution():
    problem = input()
    if not calculate(problem):
        print(0)
        return
    else:
        print(sum(num_stack_list[0]))


solution()