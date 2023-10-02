package com.example.gameinwakingtoearn.Object.MyDesignList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.example.gameinwakingtoearn.Game;
import com.example.gameinwakingtoearn.Object.Sprite;
import com.example.gameinwakingtoearn.R;

import java.util.ArrayList;

public class ItemsList {
    private static final int MAX_ITEM_IN_A_PAGE=3;
    private final int distant_between_items=10;

    private int qua_of_item=0;
    private AItemInList[] mylist;

    private int number_of_page=0;
    public ItemsList(){
        mylist=new AItemInList[MAX_ITEM_IN_A_PAGE];
    }

    public void draw(Canvas canvas){

        for(int i=0;i<qua_of_item;i++){
            canvas.drawBitmap(mylist[i].getImage().getBitmap(), null,mylist[i].getImage().getPos(),null);
        }
    }
    public static int getMaxItemInAPage(){
        return  MAX_ITEM_IN_A_PAGE;
    }
    public void setNumber_of_page(int n){
        this.number_of_page=n;
    }
    public int getNumber_of_page(){
        return this.number_of_page;
    }


    public int getQua_of_item(){
        return this.qua_of_item;
    }
    public void addItem(AItemInList item,float x,float y){

        if(this.qua_of_item<MAX_ITEM_IN_A_PAGE) {
            item.getImage().setPos((int) (x+20+qua_of_item*(item.getWidth()*2+this.distant_between_items)),
                    (int) (y/2),
                    (int) (x+10+item.getWidth()*2+qua_of_item*(item.getWidth()*2+this.distant_between_items)),
                    (int) (y/2+item.getHeight()*3));
            this.mylist[this.qua_of_item]=item;
            Log.e("qua of item",this.qua_of_item+"");
            this.qua_of_item++;
        }

    }
}
