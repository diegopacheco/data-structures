#!/bin/bash

rm -rf target/
mkdir target/
g++ -std=c++20 src/main.cpp src/queue.cpp -o target/main
