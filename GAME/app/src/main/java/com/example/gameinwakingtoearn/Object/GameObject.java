package com.example.gameinwakingtoearn.Object;



import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;

public class GameObject {
    protected float x=0;
    protected float y=0;
    protected final int height;
    protected final int width;
    protected final Sprite image;
    protected boolean is_clicked=false;
    protected final int zoom;

    public GameObject(float x, float y, Context context, int id, int quatities_frame,int zoom){
        this.x=x;
        this.y=y;
        this.image=new Sprite(context,id,quatities_frame);
        this.height=image.getBitmap().getHeight();
        this.width=image.getBitmap().getWidth();
        image.setPos((int) this.x, (int) this.y, (int) this.x+width, (int) this.y+height);
        this.zoom=zoom;

    }


    public  void draw(Canvas canvas){
        canvas.drawBitmap(this.image.getBitmap(),null,this.image.getPos(),null);
    };
    public void check_is_clicked(float x,float y){
         if(x>=this.image.getPos().left && x<=this.image.getPos().right &&
                 y>=this.image.getPos().top && y<=this.image.getPos().bottom){
             this.is_clicked=true;
         }
         else{
             this.is_clicked=false;
         }
    };
    public void update(){};
    public void update(int x,int y){
        this.image.setPos(x-this.zoom, y-zoom, x+width+zoom, y+height+zoom);
        this.x=x-this.zoom;
        this.y=y-zoom;
    }
    public boolean get_is_clicked(){
        return this.is_clicked;
    }
    public void set_is_clicked(boolean b){

        this.is_clicked=b;

    }
    public Rect getPos(){
        return this.image.getPos();
    }
    public void setPos(float x,float y){
        if(is_clicked) {
            this.x=x;
            this.y=y;
        }

    }
    public Rect getFrame(int i){
        return this.image.getFrame(i);
    }
    public int getHeight(){return height;}
    public int getWidth(){return width;}
    public Sprite getImage(){
        return this.image;
    }

}

