#!/bin/bash

rm -rf target/
mkdir target/
gcc stack.h stack.c main.c -o target/main
