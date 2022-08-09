alfa = float(input())
sec = alfa/360*12*60*60
hours = sec//3600
speed = 360/60/60 # minit arrow per second
print((sec-hours*3600)*speed)

# solution from developers
# alpha = float(input())
# print(alpha % 30 * 12)
