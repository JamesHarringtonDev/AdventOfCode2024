#!/usr/bin/env bash 

if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
    exit 1 
fi

if ! [[ "$1" =~ ^[0-9]+$ ]]
    then
        echo "Sorry integers only"
        exit 1 
fi

inline_variable=$1

if (($((inline_variable)) >= 1 && $((inline_variable)) <= 24)); then
  echo "Day is a valid input for advent of code"
  
else
    echo "Day Not a valid input for advent of code"

fi


