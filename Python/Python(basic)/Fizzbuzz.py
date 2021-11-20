for fizzBuzz in range(61):
    if fizzBuzz % 3 == 0 and fizzBuzz % 5 == 0:
        print('FizzBuzz')
        continue
    elif fizzBuzz % 3 == 0:
        print('Fizz')
        continue
    elif fizzBuzz % 5 == 0:
        print('Buzz')
        continue
    print(fizzBuzz)