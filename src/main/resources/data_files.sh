#!/bin/bash

DFS=(
	https://algs4.cs.princeton.edu/15uf/tinyUF.txt
	https://algs4.cs.princeton.edu/15uf/mediumUF.txt
	https://algs4.cs.princeton.edu/15uf/largeUF.txt
)

for url in ${DFS[@]}
do
	target=`echo $url | cut -d/ -f4-`
	wget $url -O $target
done
