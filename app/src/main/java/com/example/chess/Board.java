package com.example.chess;


public class Board {
    Knight blueKnight,greenKnight;
    IMeetingListener meetingListener;
    public Board(IMeetingListener meetingListener, int horizontalBlue,int verticalBlue, int horizontalGreen,int verticalGreen){
        this.meetingListener = meetingListener;
        blueKnight=new Knight(horizontalBlue,verticalBlue);
        greenKnight=new Knight(horizontalGreen,verticalGreen);
        if (blueKnight.getHorizontal() == greenKnight.getHorizontal() &
                blueKnight.getVertical() == greenKnight.getVertical()) {
            meetingListener.knightsMeeting();
        }
    }
}