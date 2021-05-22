n = int(input())
cities = {}
for _ in range(n):
    line = input().split()
    for city in line[1:]:
        cities[city] = line[0]

for _ in range(int(input())):
    print(cities[input()])

# developers solution
# motherland = {}
# for i in range(int(input())):
#     country, *cities = input().split()
#     for city in cities:
#         motherland[city] = country
        
# for i in range(int(input())):
#     print(motherland[input()])