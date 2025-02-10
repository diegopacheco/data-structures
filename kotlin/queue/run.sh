#!/bin/bash

./mvnw install
./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime

