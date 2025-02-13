#!/bin/bash

./mvnw install
./mvnw exec:java -Dexec.mainClass="MainKT" -Dexec.classpathScope=runtime