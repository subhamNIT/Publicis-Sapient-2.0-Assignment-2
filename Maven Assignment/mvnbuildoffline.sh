#!/bin/bash
echo Welcome
cd Desktop
cd pjp2_week2
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=MAVEN_OFFLINE_BUILD -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
cd MAVEN_OFFLINE_BUILD
echo "MAVEN_OFFLINE_BUILD" is created
mvn dependency:go-offline 
echo "building project in offline mode" 
mvn -o clean install