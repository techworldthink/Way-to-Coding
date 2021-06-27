word = input("Enter word : ")
vowels = "aeiouAEIOU"
vowels_list = [each for each in word if each in vowels]
print(vowels_list)
