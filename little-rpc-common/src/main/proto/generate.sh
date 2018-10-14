#!/usr/bin/env bash

cd /work/orange/little-rpc/little-rpc-common

protoc src/main/proto/PBInputParameter.proto --java_out=/work/orange/little-rpc/little-rpc-common/src/main/java

protoc src/main/proto/PBHeartbeatModel.proto --java_out=/work/orange/little-rpc/little-rpc-common/src/main/java
