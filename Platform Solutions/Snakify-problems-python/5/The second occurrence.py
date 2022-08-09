s=input()
occurrence1=s.find("f")
occurrence2=s.find("f",occurrence1+1)
if s.count("f")>=2:
    print(occurrence2)
elif s.count("f")==1:
    print(-1)
else:
    print(-2)