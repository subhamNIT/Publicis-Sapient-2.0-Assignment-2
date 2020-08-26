#!/bin/bash
echo welcome
cd Desktop
mkdir pjp2_week2
cd pjp2_week2
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=MAVEN_GOALS -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
cd MAVEN_GOALS
echo "project is created"
mvn validate
echo "project is validated"
mvn compile
echo "Class file genrated for src java files"
mvn  test
echo "testing done and .class file of all test files created in target"
mvn package
echo "jar files genrated"
mvn integration-test
echo "integration testing done"
mvn verify
echo "verified"
mvn install
echo "Dependencies downloaded to local 