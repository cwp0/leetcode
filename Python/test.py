#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @File: test.py
# @Description: 
# @Author: cwp0
# @Time: 2024/1/4 21:46
# @Version: 1.0



tinydict = {'Name': 'Runoob', 'Age': 7, 'Class': 'First'}

del tinydict['Name']  # 删除键 'Name'
tinydict.clear()  # 清空字典
del tinydict  # 删除字典

print("tinydict['Age']: ", tinydict['Age'])
print("tinydict['School']: ", tinydict['School'])