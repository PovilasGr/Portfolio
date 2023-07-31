#!/usr/bin/env python

from genericpath import getsize
import re
from collections import Counter
from collections import defaultdict
from typing import List
import os.path
import sys

def reader(filename):
    with open(filename, 'r') as logfile:
        if os.path.getsize(filename) != 0:
            log = logfile.read()

            regex = '([(\d\.)]+) - - \[(.*?)\] "(.*?)" (\d+) (\d+)'
            list = re.findall(regex, log)

            return list
        else:
            sys.exit("Error: the given file is empty")

def takeSecond(elem):
    return elem[1]

def count(lst, splited):
    total_count = len(lst)
    grouped = dict(Counter(lst))
    value = int(input("Input (1) to calculate IP address request count, (2) to Request count percentage of all logged requests, (3) to calculate Total number of bytes transferred"))
    if(value == 1):
        limit = int(input("Choose an amount of results:"))
        result = print(sorted(grouped.items(), key=takeSecond, reverse=True)[0:limit])
        for i, j in result:
            print(i, " : ",j)

    elif(value == 2):
        limit = int(input("Choose an amount of results:"))
        temp = sorted(grouped.items(), key=takeSecond, reverse=True)
        new_list = [(i[0], round(i[1]/total_count*100, 2)) for i in temp]
        result = new_list[0:limit]
        for i, j in result:
            print(i, " : ",j)

    elif(value == 3):
        limit = int(input("Choose an amount of results:"))
        byte_list = splited[7::8]
        integer_map = map(int, byte_list)
        byte_list = list(integer_map)
        new_list = list(zip(lst, byte_list))
        temp = defaultdict(int)

        for x, y in new_list:
            temp[x] += y
        result = list(temp.items())
        final = sorted(result, key=takeSecond, reverse=True)[0:limit]
        for i, j in final:
            print(i, " : ". j)
    else:
        print("Error: You've entered an incorrect number")

if __name__ == '__main__':
        val = (input("Input file name:"))
        if os.path.exists(val):
            a = reader(val)
            str = ' '.join([i for sub in a for i in sub])
            splited = str.split()
            value = int(input("Input (1) if you want to group the log by IP, (2) if you want to group by HTTP status code"))
            if(value == 1):
                ip_list = splited[0::8]
                count(ip_list, splited)
            elif(value == 2):
                status_list = splited[6::8]
                count(status_list, splited)
            else:
                print("Error: You've entered an incorrect number")
        else:
            print("Error: The file doesn't exist")
