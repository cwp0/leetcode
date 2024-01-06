#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @File: debug_test.py
# @Description: 浅浅学习一下debug
# @Author: cwp0
# @Time: 2024/1/4 21:39
# @Version: 1.0

# https://www.bilibili.com/video/BV1q54y1X7LL/?spm_id_from=333.337.search-card.all.click&vd_source=2315114d8590f3035b124f860ef6421c

def test1(a, b):
    c = a / b
    return True

def test2(a, b):
    c = a / b
    return True

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    a = 1
    b = 1
    test1(a, b)
    b = 0
    test2(a, b)
    print("end")
