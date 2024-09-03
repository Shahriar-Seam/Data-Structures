//
// Created by Anonymous_HF on 03-Sep-24.
//

#ifndef CPP_SCOREBOARD_H
#define CPP_SCOREBOARD_H

#include "GameEntry.h"

using namespace std;

class ScoreBoard {
private:
    GameEntry *board;
    int capacity = 3;
    int numEntries = 0;

public:
    ScoreBoard(int capacity) {
        board = (GameEntry *) calloc(capacity, sizeof(GameEntry));

        if (board == NULL) {
            cout << "Couldn't create scoreboard object\n";
        }

        this->capacity = capacity;
    }

    ScoreBoard() {
        board = (GameEntry *) calloc(capacity, sizeof(GameEntry));

        if (board == NULL) {
            cout << "Couldn't create scoreboard object\n";
        }
    }

    void add(GameEntry entry) {
        int newScore = entry.getScore();

        if (numEntries < capacity || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < capacity) {
                numEntries++;
            }

            int j = numEntries - 1;

            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }

            board[j] = entry;
        }
    }

    GameEntry remove(int i) {
        if (i < 0 || i >= numEntries) {
            throw out_of_range("Invalid Index");
        }

        GameEntry entry = board[i];

        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }

        numEntries--;

        return entry;
    }

    void showBoard() {
        for (int i = 0; i < numEntries; i++) {
            cout << board[i];
        }
    }
};


#endif //CPP_SCOREBOARD_H
