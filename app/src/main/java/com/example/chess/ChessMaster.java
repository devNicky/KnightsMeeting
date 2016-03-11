package com.example.chess;


import java.util.ArrayList;
import java.util.Arrays;

public class ChessMaster implements IMeetingListener {
    final String[] boardWords = {"a","b","c","d","e","f","g","h"};
    int[][] knightTurns ={{1,-2},{1,2},{2,-1},{2,1},{-1,2},{-2,1},{-2,-1},{-1,-2}};
    IBirthday birthday;
    ArrayList<Board> newBoards;
    ArrayList<Board> listOfVariants;
    int moves=0;
    boolean knightsOnTheWay = true;

//   This constructor get`s positions of knight, cheks is input positions is correct, is meeting of knights is availible.

public ChessMaster(IBirthday birth, String blueKnightPosition, String greenKnightPosition){
    this.birthday =birth;
    if('a'<=blueKnightPosition.charAt(0)&blueKnightPosition.charAt(0)<='h'&1<=Character.getNumericValue(blueKnightPosition.charAt(1))
                    &Character.getNumericValue(blueKnightPosition.charAt(1))<=8&'a'<=greenKnightPosition.charAt(0)&greenKnightPosition.charAt(0)<='h'
            & 1<=Character.getNumericValue(greenKnightPosition.charAt(1))&Character.getNumericValue(greenKnightPosition.charAt(1))<=8){
        int[] knightsPositions ={getIndex(String.valueOf(blueKnightPosition.charAt(0))),Character.getNumericValue(blueKnightPosition.charAt(1))-1,
                getIndex(String.valueOf(greenKnightPosition.charAt(0))),Character.getNumericValue(greenKnightPosition.charAt(1))-1};
        double i = (knightsPositions[0]+ knightsPositions[1]+ knightsPositions[2]+ knightsPositions[3]);
        listOfVariants = new ArrayList<>();
        double j = i/2;
        int res = (int)j;
        double res2 = j- res;
        if(blueKnightPosition.equals(greenKnightPosition)){
                    birthday.birthday(100);
        }
        else if(res2==0){
            newBoards = new ArrayList<>();
            listOfVariants.add(new Board(this, knightsPositions[0], knightsPositions[1], knightsPositions[2], knightsPositions[3]));
            do{
                moveAllBoards();
                moves++;
                if(knightsOnTheWay==false){
                    birthday.birthday(moves);
                }
            }while (knightsOnTheWay==true);
        }
        else  birthday.birthday(0);
    }
    else birthday.unexpectedToken();
}
    // This method calls method "nextMove" on all boards and add them to array

    void moveAllBoards(){
            for(Board b: listOfVariants){
                nextMoves(b);
            }
        listOfVariants.clear();
        listOfVariants.addAll(newBoards);
    }

    // This method makes an array of boards with all availible knights moves

    void nextMoves(Board b) {
            newBoards.clear();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (inArray(b.blueKnight.getHorizontal() + knightTurns[i][0], b.blueKnight.getVertical() + knightTurns[i][1],
                            b.greenKnight.getHorizontal() + knightTurns[j][0], b.greenKnight.getVertical() + knightTurns[j][1])) {
                        Board board = new Board(this, b.blueKnight.getHorizontal() + knightTurns[i][0], b.blueKnight.getVertical() + knightTurns[i][1],
                                b.greenKnight.getHorizontal() + knightTurns[j][0], b.greenKnight.getVertical() + knightTurns[j][1]);
                                newBoards.add(board);
                    }
                }
            }
    }
    @Override
    public void knightsMeeting() {
        knightsOnTheWay =false;
    }

    // This method cheks is move possible

    boolean inArray(int horizontalBlue,int verticalBlue, int horizontalGreen,int verticalGreen){
        boolean is=false;
        if(0<=horizontalBlue&horizontalBlue<=7&0<=verticalBlue&verticalBlue<=7&
                0<=horizontalGreen&horizontalGreen<=7&0<=verticalGreen&verticalGreen<=7){
            is=true;
        }
        return is;
    }

    // This method returns an index in array of a char

    int getIndex(String s){
        return Arrays.asList(boardWords).indexOf(s);
    }
}