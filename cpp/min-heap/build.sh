#!/bin/bash

rm -rf target/
mkdir target/
g++ -std=c++20 -o target/main src/main.cpp src/heap.c