punctuations = '''!()-[]{};:'"\,<>./?@#$%^&*_~'''
name = input("Enter a string : ")
name_w = [each for each in name if each not in punctuations]
print(''.join(map(str, name_w)))
