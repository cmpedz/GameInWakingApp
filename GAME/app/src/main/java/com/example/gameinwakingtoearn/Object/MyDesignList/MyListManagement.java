package com.example.gameinwakingtoearn.Object.MyDesignList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import com.example.gameinwakingtoearn.Game;
import com.example.gameinwakingtoearn.Object.GameObject;
import com.example.gameinwakingtoearn.R;

public class MyListManagement {

     private  int count_page=0;
     private boolean is_quit=false;
     private int current_index_page=0;
     private final int Max_page_of_store=5;
     protected Rect background;
     private Paint paint=new Paint();
     private ItemsList[] menuItem;
     private GameObject preButton;
     private GameObject quitButton;
     private GameObject nextButton;
     private final int Distance_between_next_and_pre_button=20;
     public MyListManagement(Context context,float x,float y){
          paint.setColor(Color.YELLOW);
          this.background=new Rect((int)x,(int)y, Game.getScreenWidth()-(int)x,Game.getScreenHeight()-(int)y);
          this.menuItem=new ItemsList[Max_page_of_store];
          this.menuItem[current_index_page]=new ItemsList();

          preButton =new GameObject(0,0,context, R.drawable.back_button,0,-20);
          preButton.getImage().setPos((this.background.right-this.background.left)/2-this.preButton.getImage().getBitmap().getWidth()-Distance_between_next_and_pre_button,
                  background.bottom-preButton.getHeight()-50,
                  (this.background.right-this.background.left)/2-this.Distance_between_next_and_pre_button,
                  background.bottom-50);


          nextButton=new GameObject(0,0,context, R.drawable.next_button,0,0);
          nextButton.getImage().setPos((this.background.right-this.background.left)/2+this.Distance_between_next_and_pre_button,
                  background.bottom-preButton.getHeight()-50,
                  (this.background.right-this.background.left)/2+nextButton.getImage().getBitmap().getWidth()+this.Distance_between_next_and_pre_button,
                  background.bottom-50);

          quitButton=new GameObject(0,0,context,R.drawable.nosign,0,0);
          quitButton.getImage().setPos(background.right-quitButton.getWidth(),
                  background.top, background.right,background.top+ quitButton.getHeight());




     }
     public void drawText(Canvas canvas,int number){
          Paint textpaint=new Paint();
          textpaint.setColor(Color.GRAY);
          textpaint.setTextSize(50);
          canvas.drawText(String.valueOf(number),
                  this.preButton.getImage().getPos().right+5,
                  this.preButton.getImage().getPos().top+50,textpaint);
     }

     public void draw(Canvas canvas){
          canvas.drawRect(background,paint);
          menuItem[count_page].draw(canvas);
          nextButton.draw(canvas);
          preButton.draw(canvas);
          quitButton.draw(canvas);
          drawText(canvas,menuItem[count_page].getNumber_of_page());
     }
     public void checkIsClicked(float x,float y){

          nextButton.check_is_clicked(x,y);
          if(nextButton.get_is_clicked() && this.count_page<this.current_index_page){
               this.count_page++;
          }
          preButton.check_is_clicked(x,y);
          if(preButton.get_is_clicked() && this.count_page>0){
               this.count_page--;
          }

          quitButton.check_is_clicked(x,y);
          if(quitButton.get_is_clicked()){
               this.is_quit=true;
          }

     }
     public void addNewItem(AItemInList item){
          if(menuItem[current_index_page].getQua_of_item()>=ItemsList.getMaxItemInAPage()){
               current_index_page++;
               menuItem[current_index_page]=new ItemsList();
          }

          menuItem[current_index_page].addItem(item,this.background.left+10,
                  this.background.bottom-this.background.top);
          menuItem[current_index_page].setNumber_of_page(current_index_page+1);
     }
     public boolean getIs_quit(){
          return this.is_quit;
     }
     public void setIs_quit(boolean b){
          this.is_quit=b;
     }
}
