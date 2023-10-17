package com.example.gameinwakingtoearn.Object.BagManagement;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

import com.example.gameinwakingtoearn.Game;
import com.example.gameinwakingtoearn.Object.MyDesignList.AItemInList;
import com.example.gameinwakingtoearn.Object.MyDesignList.ItemsList;
import com.example.gameinwakingtoearn.Object.MyDesignList.MyListManagement;

public class BagList extends MyListManagement {
    private final String label="túi đồ";
    private Paint paint;
    public BagList(Context context, float x, float y) {
        super(context, x, y, 2, 40, 5, 3,
                50,100, Game.getScreenWidth()-50,Game.getScreenHeight()-100);
        paint=new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(50);
    }
    @Override
    public void draw(Canvas canvas){
         super.draw(canvas);
         canvas.drawText(this.label,(this.background.left+this.background.right)/2-50,
                 this.background.top+paint.getTextSize(),paint);
    }

    @Override
    public void checkIsClicked(float x,float y){
          super.checkIsClicked(x,y);
              Log.e("check item in bag","ok");
              AItemInList[] currentPage = this.getCurrentPage().getItemList();
              for (int i = 0; i < this.getCurrentPage().getQua_of_item(); i++) {
                  Log.e("current page length : ", this.getCurrentPage().getQua_of_item()+"");
                  currentPage[i].check_is_clicked(x, y);


                  if (currentPage[i].get_is_clicked()) {

                      //delete item from bag by replace the last item with the item need to be deleted
                      Log.e("delete item from bag", "ok");

                      currentPage[i] = this.getLastPage().getItemList()[this.getLastPage().getQua_of_item()-1];

                      this.getLastPage().getItemList()[this.getLastPage().getQua_of_item()-1] = null;

                      this.getLastPage().setQua_of_item(this.getLastPage().getQua_of_item() - 1);
                  }

              }

    }
}
