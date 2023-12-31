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
    private final int MAX_ITEM_IN_A_PAGE;
    protected final int Max_column;
    protected final int distant_between_items;

    private int qua_of_item=0;
    private AItemInList[] mylist;

    private int number_of_page=0;
    public ItemsList(int MAX_ITEM_IN_A_PAGE,int Max_column, int distant_between_items){

        this.MAX_ITEM_IN_A_PAGE=MAX_ITEM_IN_A_PAGE;
        this.Max_column=Max_column;
        this.distant_between_items=distant_between_items;
        mylist=new AItemInList[this.MAX_ITEM_IN_A_PAGE];

    }

    public void draw(Canvas canvas){

        for(int i=0;i<qua_of_item;i++){
            canvas.drawBitmap(mylist[i].getImage().getBitmap(), null,mylist[i].getImage().getPos(),null);
        }
    }
    public int getMaxItemInAPage(){
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
            Log.e("check :",qua_of_item/Max_column+"");

            // thuật toán xây dựng cơ chế set vij trí cho từng item của list : thay vì dùng if,else => dùng quy tắc hash thông qua phép % hoặc / tùy cơ ứng biến

            item.getImage().setPos((int) (x+20+(qua_of_item % Max_column)*(item.getWidth()+item.getZoom()+this.distant_between_items)),
                    (int) (y/2) + (item.getImage().getBitmap().getHeight()+item.getZoom()+3) * (qua_of_item/Max_column),
                    (int) (x+20+item.getWidth()+item.getZoom()+(qua_of_item % Max_column)*(item.getWidth()+item.getZoom()+this.distant_between_items)),
                    (int) (y/2+item.getHeight()+item.getZoom()) + (item.getImage().getBitmap().getHeight()+item.getZoom()+3) * (qua_of_item/Max_column));


            this.mylist[this.qua_of_item]=item;
            this.qua_of_item++;
        }

    }
    public AItemInList[] getItemList(){
        return this.mylist;
    }
}
