//
// Created by Anonymous_HF on 03-Sep-24.
//

#ifndef CPP_GAMEENTRY_H
#define CPP_GAMEENTRY_H
#include "bits/stdc++.h"

using namespace std;

class GameEntry {
private:
    string name;
    int score;

public:
    GameEntry(string name, int score) {
        this->name = name;
        this->score = score;
    }

    string getName() {
        return name;
    }

    int getScore() {
        return score;
    }

    friend ostream& operator << (ostream &strm, const GameEntry &entry) {
        return strm << "(" << entry.name << " " << entry.score << ")\n";
    }
};

#endif //CPP_GAMEENTRY_H
