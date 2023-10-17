package com.example.gameinwakingtoearn.Object.BagManagement;

import android.content.Context;

import com.example.gameinwakingtoearn.Object.MyDesignList.AItemInList;
import com.example.gameinwakingtoearn.R;

public class ItemHouseInBag extends ItemInBag {
    public ItemHouseInBag(float x, float y, Context context) {
        super(x, y, context);
        this.addItem(x,y, R.drawable.houseonefloor,zoom);
    }


}
