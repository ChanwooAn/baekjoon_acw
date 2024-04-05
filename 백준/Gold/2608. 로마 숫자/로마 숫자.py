def roman_to_arabic(roman):
    roman_numerals = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    exceptions = {'IV': 4, 'IX': 9, 'XL': 40, 'XC': 90, 'CD': 400, 'CM': 900}

    arabic = 0
    i = 0
    while i < len(roman):
        if i + 1 < len(roman) and roman[i:i + 2] in exceptions:
            arabic += exceptions[roman[i:i + 2]]
            i += 2
        else:
            arabic += roman_numerals[roman[i]]
            i += 1
    return arabic


def arabic_to_roman(number):
    numeral_map = [
        (1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'),
        (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'),
        (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')
    ]

    result = ""
    for value, numeral in numeral_map:
        while number >= value:
            result += numeral
            number -= value
    return result

if __name__ == "__main__":
    num1=input()
    num2=input()
    arabic1 = roman_to_arabic(num1)
    arabic2 = roman_to_arabic(num2)
    total_arabic = arabic1 + arabic2
    total_roman = arabic_to_roman(total_arabic)

    print(total_arabic)
    print(total_roman)
