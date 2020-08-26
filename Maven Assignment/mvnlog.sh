#!/bin/bash
cd Desktop
cd pjp2_week2
cd MAVEN_GOALS
touch log.txt
mvn clean install>log.txt
echo "done"