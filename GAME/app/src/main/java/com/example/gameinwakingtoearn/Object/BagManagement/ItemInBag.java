package com.example.gameinwakingtoearn.Object.BagManagement;

import android.content.Context;

import com.example.gameinwakingtoearn.Object.MyDesignList.AItemInList;
import com.example.gameinwakingtoearn.R;

public class ItemInBag extends AItemInList {
    public ItemInBag(float x, float y, Context context) {
        super(x, y, context, R.drawable.icon_item_in_myteam, 10);
    }

    @Override
    public void check_is_clicked(float x,float y){

        super.check_is_clicked(x,y);
        if(this.is_clicked){
            //get item from bag

        }

    }
}
