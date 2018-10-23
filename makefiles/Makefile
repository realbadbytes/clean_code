# -*- MakeFile -*-
# This comment tells the editor to use proper Makefile spacing (tabs vs personal settings, like 4 spaces)
# Make just follows dependency trees. Only rebuilds targets if needed
# Each chunk is a recipe
# Each recipe has a target, dependencies, and commands
# MUST USE A TAB CHARACTER BEFORE THE ACTION (sounds like Make has shit code somewhere)
#
#target: dependencies
#	action

all: geom tip

geom: geom.o gd.o
	clang geom.o gd.o -o geom -lm

geom.o: geom.c gd.h
	clang -c geom.c

gd.o: gd.c
	clang -c gd.c

tip: tip.o gd.o
	clang tip.o gd.o -o tip

tip.o: tip.c gd.h
	clang -c tip.c

clean:
	rm *.o tip geom
