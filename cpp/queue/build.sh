#!/bin/bash

rm -rf target/
mkdir target/
g++ -std=c++20 src/*.cpp -o target/main
