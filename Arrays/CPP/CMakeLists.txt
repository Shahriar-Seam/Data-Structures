cmake_minimum_required(VERSION 3.27)
project(CPP)

set(CMAKE_CXX_STANDARD 17)

add_executable(CPP
        ScoreBoard/GameEntry.h
        ScoreBoard/ScoreBoard.h
        ScoreBoard/main.cpp)
