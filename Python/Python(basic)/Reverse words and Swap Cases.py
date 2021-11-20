import os


def reverse_words_and_swap_cases(sentence):
    words_list = sentence.split()
    words = words_list[::-1]
    reverse_sentence = " ".join(words)
    return reverse_sentence.swapcase()


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    sentence = input()
    result = reverse_words_and_swap_cases(sentence)
    fptr.write()
    fptr.close()
