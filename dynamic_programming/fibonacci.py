# fibonacci sequence given an input value n
# fib(n) -> nth in fibonacci
# n = 50
# O(2^n)
# fibonacci 1,1,2,3,5,8,13...

def fib(n, m, memo):
    key = str(n) + ", " + str(m)
    if n == 1 and m == 1:
        return 1
    if n == 0 or m == 0:
        return 0
    if key in memo:
        return memo[key]
    memo[key] = fib(n-1, m, memo) + fib(n, m-1, memo)
    return memo[key]


memo = {}
print(fib(18, 18, memo))


# 2,3

###
###
# down and right = 3

# # # #
# # # #
# # # #
