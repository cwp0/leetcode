#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File: q_2.py
# @Description: 
# @Author: cwp0
# @Time: 2023/10/29 12:47
# @Version: 1.0

n, m = input().split(' ')
n, m = int(n), int(m)
# thoughts = [0] * (n + 1)
quans = []
t_quans = []

roads = []
for i in range(m):
    roads.append([int(i) for i in input().split(' ')])
for i in range(m):
    if i == 0:
        quans.append(roads[i])
    else:
        for j in quans:
            if roads[i][0] in j:
                if roads[i][1] in j:
                    continue
                else:
                    j.append(roads[i][1])
            elif roads[i][1] in j:
                if roads[i][0] in j:
                    continue
                else:
                    j.append(roads[i][0])
            else:
                quans.append(roads[i])
# # del(roads)
k = int(input())
# for i in range(k):
#     c1 ,c2 = input().split(' ')
#     c1, c2 = int(c1), int(c2)
#     for j in quans:
#         if c1 in j or c2 in j:
#             for i in j:
#                 thoughts[i] += 1
#             break

roads = []
for i in range(k):
    roads.append([int(i) for i in input().split(' ')])
for i in range(k):
    if i == 0:
        t_quans.append(roads[i])
    else:
        for j in t_quans:
            if roads[i][0] in j:
                if roads[i][1] in j:
                    continue
                else:
                    j.append(roads[i][1])
            elif roads[i][1] in j:
                if roads[i][0] in j:
                    continue
                else:
                    j.append(roads[i][0])
            else:
                t_quans.append(roads[i])

for i in quans:
    for j in t_quans:
        maxv = len([x for x in i if x in j]) if len([x for x in i if x in j]) > maxv else maxv
        # maxv = len([x for x in i if x in j]) > max ? len([x for x in i if x in j]) : maxv
        # minv = len([x for x in i if x in j]) < min ? len([x for x in i if x in j]) : minv
s = sum(len(i) for i in t_quans)
if s < n:
    minv = 1
else:
    minv = min(len(i) for i in t_quans)
# maxv = max(thoughts)
# minv = min(thoughts)
print(str(maxv) + ' ' + str(minv))