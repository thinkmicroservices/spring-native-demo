# multi-stage build composite image
# containing the GraalVM
# native image executable
# AND the 'bash' shell.

# Spring-Native generated image
FROM demo:0.0.1-SNAPSHOT AS spring-native

# generic ubuntu bionic image
FROM ubuntu:bionic
 
# make sure we are up to date
RUN apt-get update

# Install BASH.
 
RUN apt-get install bash

# create a workspace directory
RUN mkdir /workspace

# copy the workspace folder from 
COPY --from=spring-native /workspace /workspace

# start with the bash shell
CMD bin/bash
 

