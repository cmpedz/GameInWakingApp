package com.example.gameinwakingtoearn.Object.StoreManagement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.example.gameinwakingtoearn.Game;
import com.example.gameinwakingtoearn.Object.MyDesignList.AItemInList;
import com.example.gameinwakingtoearn.Object.MyDesignList.ItemsList;
import com.example.gameinwakingtoearn.Object.MyDesignList.MyListManagement;
import com.example.gameinwakingtoearn.R;

public class StoreItemList extends MyListManagement {
    private Paint paint;
    private static final String StoreName="Cửa Hàng";
    public StoreItemList(Context context, float x, float y) {
        super(context, x, y,5,4,3,5,
                50,200, Game.getScreenWidth()-50,Game.getScreenHeight()-200);
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);
        for(int i=0;i<5;i++) {
            this.addNewItem(new AItemInList(this.background.left, this.background.top, context, R.drawable.icon_item_in_myteam, 100));
        }
    }
    @Override
    public void draw(Canvas canvas){
        super.draw(canvas);
        canvas.drawText(StoreName,(this.background.right-this.background.left)/2-50,
                this.background.top+paint.getTextSize(),paint);
    }
   
}
