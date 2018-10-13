#!/usr/bin/env bash
ASPECTJ_WEAVER=/Users/cook/.m2/repository/org/aspectj/aspectjweaver/1.9.1/aspectjweaver-1.9.1.jar
ASPECTJ_RT=/Users/cook/.m2/repository/org/aspectj/aspectjrt/1.9.1/aspectjrt-1.9.1.jar
ASPECTJ_TOOLS=/Users/cook/.m2/repository/org/aspectj/aspectjtools/1.9.1/aspectjtools-1.9.1.jar

# java -jar $ASPECTJ_TOOLS -cp $ASPECTJ_RT -source 1.5 -sourceroots src/main/java/ -d target/classes

# run
java -cp $ASPECTJ_RT:./target/classes org.cook.rpc.aspectj.TestAspectjModel

# -javaagent:/Users/cook/.m2/repository/org/aspectj/aspectjweaver/1.9.1/aspectjweaver-1.9.1.jar