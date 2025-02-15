#!/bin/bash

./mvnw clean package
./mvnw exec:java -Dexec.mainClass="Main" -Dexec.classpathScope=runtime

