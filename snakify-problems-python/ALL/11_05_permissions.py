# nice developers solution
ACTION_PERMISSION = {
    'read': 'R',
    'write': 'W',
    'execute': 'X',
}

file_permissions = {}
for i in range(int(input())):
    file, *permissions = input().split()
    file_permissions[file] = set(permissions)

for i in range(int(input())):
    action, file = input().split()
    if ACTION_PERMISSION[action] in file_permissions[file]:
        print('OK')
    else:
        print('Access denied')


# my solution
# permissions = {}
# n = int(input())
# for _ in range(n):
#     s = input().split()
#     permissions[s[0]] = set(s[1:])
# for _ in range(int(input())):
#     perm, file = input().split()
#     if perm == 'read':
#         perm = 'R'
#     if perm == 'write':
#         perm = 'W'
#     if perm == 'execute':
#         perm = 'X'
#     if perm in permissions[file]:
#         print('OK')
#     else:
#         print('Access denied')