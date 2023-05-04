class Animal:
    def make_sound(self):
        print("Generic animal sound")

class Dog(Animal):
    def make_sound(self):
        print("Woof!")

class Cat(Animal):
    def make_sound(self):
        print("Meow!")

def animal_sound(animal):
    animal.make_sound()

animal = Animal()
dog = Dog()
cat = Cat()

animal_sound(animal) # Output: "Generic animal sound"
animal_sound(dog)    # Output: "Woof!"
animal_sound(cat)    # Output: "Meow!"
