
def to_uppercase(function):
    def wrapper(name):
        return function(name.upper())
    return wrapper

@to_uppercase
def print_name(name):
    print(name)

print_name("techworldthink")
