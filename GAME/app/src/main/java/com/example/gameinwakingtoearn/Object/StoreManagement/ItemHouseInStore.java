package com.example.gameinwakingtoearn.Object.StoreManagement;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import com.example.gameinwakingtoearn.Object.BagManagement.BagList;
import com.example.gameinwakingtoearn.Object.BagManagement.ItemHouseInBag;
import com.example.gameinwakingtoearn.Object.BagManagement.MyBag;
import com.example.gameinwakingtoearn.Object.MyDesignList.AItemInList;
import com.example.gameinwakingtoearn.R;

public class ItemHouseInStore extends ItemInStore {

    public ItemHouseInStore(float x, float y, Context context,MyBag b) {
        super(x, y, context,b);
        this.addItem(x,y, R.drawable.houseonefloor,0);
    }


}
