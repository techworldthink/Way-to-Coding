
# exception handling
try:
    file = open('file','r')
except Exception as e:
    # If there is a exception then execute this block.
    print(e)
else:
    # If there is no exception then execute this block.
    file.close()
finally:
    # finally execute these statements
    print("Done!")


# try + except
try:
    a,b = 1
except:
    print("Exception!")


# try + finally
try:
    a = 1
finally:
    print("Done!")


# raising an exception
try:
    raise IOError("Demo error")
except Exception as e:
    print(e)

## Standard exceptions
#  SyntaxError
#  ZeroDivisionError
#  ValueError
#  KeyboardInterrupt
#  NameError
