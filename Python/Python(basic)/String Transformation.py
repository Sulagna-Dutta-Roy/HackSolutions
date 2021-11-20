import os


def transformSentence(sentence):
    words = sentence.split()
    word = ""
    for i in words:
        word += i[0]
        for j in range(1, len(i)):
            if j[i-1].lower() < i[j]:
                word += i[j].upper()
            elif i[j-1].lower() > i[j].lower():
                word += i[j].lower()
            else:
                word += i[j]
    return word [:-1:]


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')
    sentence = input()
    result = transformSentence(sentence)
    fptr.write()
    fptr.close()
