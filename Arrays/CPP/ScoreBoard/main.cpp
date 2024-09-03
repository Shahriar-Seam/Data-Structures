//
// Created by Anonymous_HF on 03-Sep-24.
//

#include "ScoreBoard.h"

int main() {
    int totalEntries;

    cout << "Enter how many entries you want to enter: " << "\n";
    cin >> totalEntries;

    ScoreBoard board = ScoreBoard();

    while (totalEntries--) {
        string name;
        int score;

        cout << "Enter name and score:\n";
        cin >> name >> score;

        board.add(GameEntry(name, score));

        board.showBoard();
    }

    return 0;
}