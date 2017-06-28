package com.example.pedro.wheelprueba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    private Button bt;
    private WheelView wheelView;
    public float data;
    ArrayList<Drawable> greenIcons = new ArrayList<>();
    PopupWindow popupWindow;
    RelativeLayout Rl;


    PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPOPUP(21);

            }
        });
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#85B150")));

        wheelView = (WheelView) findViewById(R.id.wheelview);
        createGreenIcons();
        wheelView.getWheelDrawable().setAlpha(0);

        bt = (Button) findViewById(R.id.btn_ahorro);
       Rl= (RelativeLayout)findViewById(R.id.relative);



                // The code below assumes that the root container has an id called 'main'

        wheelView.setAdapter(new WheelAdapter() {


            @Override
            public Drawable getDrawable(int position) {
               /* Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.img2);

                Drawable b = new BitmapDrawable(bmp);
                Drawable[] drawable = new Drawable[]{
                        //createOvalDrawable(getResources().getColor(R.color.cyan_a100)),


                };*/
                return greenIcons.get(position);

            }

           /* private Drawable createOvalDrawable(int color) {
                ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                shapeDrawable.getPaint().setColor(color);
                return shapeDrawable;
            }*/


            @Override
            public int getCount() {
                return 8;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }
        });
        System.out.println("Entro");

        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, Drawable itemDrawable, int position) {


            }
        });

        wheelView.setOnWheelItemClickListener(new WheelView.OnWheelItemClickListener() {
            @Override
            public void onWheelItemClick(WheelView parent, int position, boolean isSelected) {
                switch (position) {
                    case 0:
                        openPOPUP(1);
                        break;
                    case 1:
                        openPOPUP(2);
                        break;
                    case 2:
                        openPOPUP(3);
                        break;
                    case 3:
                        openPOPUP(4);
                        break;
                    case 4:
                        openPOPUP(5);
                        break;

                    case 5:
                        openPOPUP(6);
                        break;
                    case 6:
                        openPOPUP(8);
                        break;
                    case 7:
                        openPOPUP(9);
                        break;




                }

           // Toast.makeText(MainActivity.this,position,Toast.LENGTH_SHORT).show();
            }
        });
        //init();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i = new Intent(getApplicationContext(),BlueActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(i);

                System.gc();



            }
        });



    }





    public void init() {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                wheelView.setAngle(wheelView.getAngle() + 20);
                //wheelView.setMidSelected();
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 5000, 5000);
    }

    public void createGreenIcons() {

        for (int i = 0; i < 8; i++) {
            int res = getResources().getIdentifier("icb" + i, "drawable", this.getPackageName());
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), res);
            Drawable b = new BitmapDrawable(bmp);
            greenIcons.add(b);
        }

    }

    private void openPopUp(){


        final View popUpView = getLayoutInflater().inflate(R.layout.popup6,
                null); // inflating popup6 layout
        popupWindow = new PopupWindow(popUpView,1000,
                500, true); // Creation of popup6

        popupWindow.setAnimationStyle(android.R.style.Animation_Dialog);
        popupWindow.showAtLocation(popUpView, Gravity.CENTER, 0, 0); // Displaying popup6
        Button back = (Button)popUpView.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                System.gc();
            }
        });
            }


    public void openPOPUP(int n){

        switch (n){
            case 0:
                break;
            case 1:
                System.gc();
                final View popUpView1 = getLayoutInflater().inflate(R.layout.popup1, null);
                final PopupWindow mpopup1 = new PopupWindow(popUpView1, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup1.setBackgroundDrawable(new BitmapDrawable());
                mpopup1.setOutsideTouchable(true);
                mpopup1.showAtLocation(popUpView1,Gravity.CENTER,200,0);
                mpopup1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView1.destroyDrawingCache();
                        System.gc();
                    }
                });

                Button h2 = (Button)popUpView1.findViewById(R.id.linea1);
                h2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(56);
                        mpopup1.dismiss();
                    }
                });
                Button h3 = (Button)popUpView1.findViewById(R.id.linea2);
                h3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(57);
                        mpopup1.dismiss();
                    }
                });
                Button h4 = (Button)popUpView1.findViewById(R.id.linea3);
                h4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(58);
                        mpopup1.dismiss();
                    }
                });
                Button h5 = (Button)popUpView1.findViewById(R.id.linea4);
                h5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(60);
                        mpopup1.dismiss();
                    }
                });
                Button h6 = (Button)popUpView1.findViewById(R.id.linea5);
                h6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(61);
                        mpopup1.dismiss();
                    }
                });

                break;
            case 2:
                System.gc();
                final View popUpView2 = getLayoutInflater().inflate(R.layout.popup2, null);
                final PopupWindow mpopup2 = new PopupWindow(popUpView2, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup2.setBackgroundDrawable(new BitmapDrawable());
                mpopup2.setOutsideTouchable(true);
                mpopup2.showAtLocation(popUpView2,Gravity.CENTER,200,0);
                mpopup2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView2.destroyDrawingCache();
                        System.gc();
                    }
                });
                Button g1 = (Button)popUpView2.findViewById(R.id.linea1);
                g1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(53);
                        mpopup2.dismiss();

                    }
                });
                Button g2 = (Button)popUpView2.findViewById(R.id.linea2);
                g2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(54);
                        mpopup2.dismiss();
                    }
                });
                Button g3 = (Button)popUpView2.findViewById(R.id.linea3);
                g3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(55);
                        mpopup2.dismiss();
                    }
                });


                break;
            case 3:
                final View popUpView6 = getLayoutInflater().inflate(R.layout.popup3, null);
                final PopupWindow mpopup6 = new PopupWindow(popUpView6, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup6.setBackgroundDrawable(new BitmapDrawable());
                mpopup6.setOutsideTouchable(true);
                mpopup6.showAtLocation(popUpView6,Gravity.CENTER,200,0);
                mpopup6.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView6.destroyDrawingCache();
                        System.gc();
                    }
                });
                Button btn_3a= (Button)popUpView6.findViewById(R.id.lineapop6a);
                btn_3a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(40);
                        mpopup6.dismiss();
                    }
                });
                Button btn_3b = (Button)popUpView6.findViewById(R.id.lineapop6b);
                btn_3b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(41);
                        mpopup6.dismiss();
                    }
                });
                break;
            case 4:
                System.gc();
                final View popUpView4= getLayoutInflater().inflate(R.layout.popup4, null);
                final PopupWindow mpopup4 = new PopupWindow(popUpView4, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup4.setBackgroundDrawable(new BitmapDrawable());
                mpopup4.setOutsideTouchable(true);
                mpopup4.showAtLocation(popUpView4,Gravity.CENTER,200,0);
                mpopup4.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView4.destroyDrawingCache();
                        System.gc();
                    }
                });
                Button i1 = (Button)popUpView4.findViewById(R.id.linea2);
                i1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(62);
                        mpopup4.dismiss();

                    }
                });
                Button i2 = (Button)popUpView4.findViewById(R.id.linea3);
                i2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(63);
                        mpopup4.dismiss();
                    }
                });
                Button i3 = (Button)popUpView4.findViewById(R.id.linea4);
                i3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(64);
                        mpopup4.dismiss();
                    }
                });
                Button i4 = (Button)popUpView4.findViewById(R.id.linea5);
                i4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(65);
                        mpopup4.dismiss();
                    }
                });
                Button i5 = (Button)popUpView4.findViewById(R.id.linea6);
                i5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(66);
                        mpopup4.dismiss();
                    }
                });
                Button i6 = (Button)popUpView4.findViewById(R.id.linea7);
                i6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(67);
                        mpopup4.dismiss();
                    }
                });
                Button i7 = (Button)popUpView4.findViewById(R.id.linea8);
                i7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(68);
                        mpopup4.dismiss();
                    }
                });
                Button i8 = (Button)popUpView4.findViewById(R.id.linea9);
                i8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(69);
                        mpopup4.dismiss();
                    }
                });
                Button i9 = (Button)popUpView4.findViewById(R.id.linea10);
                i9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(70);
                        mpopup4.dismiss();
                    }
                });
                Button i10 = (Button)popUpView4.findViewById(R.id.linea11);
                i10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(71);
                        mpopup4.dismiss();
                    }
                });
                Button i11 = (Button)popUpView4.findViewById(R.id.linea12);
                i11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(72);
                        mpopup4.dismiss();
                    }
                });
                Button i12 = (Button)popUpView4.findViewById(R.id.linea13);
                i12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(74);
                        mpopup4.dismiss();
                    }
                });
                break;
            case 5:
                System.gc();
                final View popUpView5 = getLayoutInflater().inflate(R.layout.popup5, null);
                final PopupWindow mpopup5 = new PopupWindow(popUpView5, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup5.setBackgroundDrawable(new BitmapDrawable());
                mpopup5.setOutsideTouchable(true);
                mpopup5.showAtLocation(popUpView5,Gravity.CENTER,200,0);
                mpopup5.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView5.destroyDrawingCache();
                        System.gc();
                    }
                });
                Button f1 = (Button)popUpView5.findViewById(R.id.linea1);
                f1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(47);
                        mpopup5.dismiss();

                    }
                });
                Button f2 = (Button)popUpView5.findViewById(R.id.linea2);
                f2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(48);
                        mpopup5.dismiss();
                    }
                });
                Button f3 = (Button)popUpView5.findViewById(R.id.linea3);
                f3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(49);
                        mpopup5.dismiss();
                    }
                });
                Button f4 = (Button)popUpView5.findViewById(R.id.linea4);
                f4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(50);
                        mpopup5.dismiss();
                    }
                });
                Button f5 = (Button)popUpView5.findViewById(R.id.linea5);
                f5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(51);
                        mpopup5.dismiss();
                    }
                });
                Button f6 = (Button)popUpView5.findViewById(R.id.linea6);
                f6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(52);
                        mpopup5.dismiss();
                    }
                });
                break;
            case 6:
                System.gc();
                final View popUpView10 = getLayoutInflater().inflate(R.layout.popup6, null);
                final PopupWindow mpopup10 = new PopupWindow(popUpView10, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup10.setBackgroundDrawable(new BitmapDrawable());
                mpopup10.setOutsideTouchable(true);
                mpopup10.showAtLocation(popUpView10,Gravity.CENTER,200,0);
                mpopup10.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView10.destroyDrawingCache();
                        System.gc();
                    }
                });

                Button c1 = (Button)popUpView10.findViewById(R.id.linea2);
                c1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(32);
                        mpopup10.dismiss();
                    }
                });
                Button c2 = (Button)popUpView10.findViewById(R.id.linea3);
                c2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(73);
                        mpopup10.dismiss();
                    }
                });
                Button c3 = (Button)popUpView10.findViewById(R.id.linea4);
                c3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(33);
                        mpopup10.dismiss();
                    }
                });
                Button c4 = (Button)popUpView10.findViewById(R.id.linea5);
                c4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(34);
                        mpopup10.dismiss();
                    }
                });
                Button c5 = (Button)popUpView10.findViewById(R.id.linea6);
                c5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(35);
                        mpopup10.dismiss();
                    }
                });
                Button c6 = (Button)popUpView10.findViewById(R.id.linea7);
                c6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(36);
                        mpopup10.dismiss();
                    }
                });
                Button c7 = (Button)popUpView10.findViewById(R.id.linea8);
                c7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(37);
                        mpopup10.dismiss();
                    }
                });
                Button c8 = (Button)popUpView10.findViewById(R.id.linea9);
                c8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(38);
                        mpopup10.dismiss();
                    }
                });
                Button c9 = (Button)popUpView10.findViewById(R.id.linea10);
                c9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(39);
                        mpopup10.dismiss();
                    }
                });
                Button c10 = (Button)popUpView10.findViewById(R.id.linea11);
                c10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(42);
                        mpopup10.dismiss();
                    }
                });



                break;
            case 7:
                break;
            case 8:
                System.gc();
                final View popUpView8 = getLayoutInflater().inflate(R.layout.popup8, null);
                final PopupWindow mpopup8= new PopupWindow(popUpView8, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup8.setBackgroundDrawable(new BitmapDrawable());
                mpopup8.setOutsideTouchable(true);
                mpopup8.showAtLocation(popUpView8,Gravity.CENTER,200,0);
                mpopup8.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView8.destroyDrawingCache();
                        System.gc();
                    }
                });
                Button e1 = (Button)popUpView8.findViewById(R.id.linea1);
                e1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(43);
                        mpopup8.dismiss();

                    }
                });
                Button e2 = (Button)popUpView8.findViewById(R.id.linea2);
                e2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(44);
                        mpopup8.dismiss();
                    }
                });
                Button e3 = (Button)popUpView8.findViewById(R.id.linea3);
                e3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(45);
                        mpopup8.dismiss();
                    }
                });
                Button e4 = (Button)popUpView8.findViewById(R.id.linea4);
                e4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(46);
                        mpopup8.dismiss();
                    }
                });
                break;
            case 9:
                System.gc();
                final View popUpView9 = getLayoutInflater().inflate(R.layout.popup9, null);
                final PopupWindow mpopup9 = new PopupWindow(popUpView9, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup9.setBackgroundDrawable(new BitmapDrawable());
                mpopup9.setOutsideTouchable(true);
                mpopup9.showAtLocation(popUpView9,Gravity.CENTER,200,0);
                mpopup9.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView9.destroyDrawingCache();
                        System.gc();
                    }
                });
                Button b1 = (Button)popUpView9.findViewById(R.id.linea2);
                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(22);
                        mpopup9.dismiss();

                    }
                });
                Button b2 = (Button)popUpView9.findViewById(R.id.linea3);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(26);
                        mpopup9.dismiss();
                    }
                });
                Button b3 = (Button)popUpView9.findViewById(R.id.linea4);
                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(27);
                        mpopup9.dismiss();
                    }
                });
                Button b4 = (Button)popUpView9.findViewById(R.id.linea5);
                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(31);
                        mpopup9.dismiss();
                    }
                });
                Button b5 = (Button)popUpView9.findViewById(R.id.linea6);
                b5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(24);
                        mpopup9.dismiss();
                    }
                });
                Button b6 = (Button)popUpView9.findViewById(R.id.linea7);
                b6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(25);
                        mpopup9.dismiss();
                    }
                });
                Button b7 = (Button)popUpView9.findViewById(R.id.linea8);
                b7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mpopup9.dismiss();
                        openPOPUP(23);

                    }
                });
                Button b8 = (Button)popUpView9.findViewById(R.id.linea9);
                b8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(29);
                        mpopup9.dismiss();
                    }
                });
                Button b9 = (Button)popUpView9.findViewById(R.id.linea10);
                b9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(30);
                        mpopup9.dismiss();
                    }
                });
                Button b10 = (Button)popUpView9.findViewById(R.id.linea11);
                b10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(20);
                        mpopup9.dismiss();
                    }
                });


                break;
            case 10:

                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 20:
                System.gc();
                final View popUpView20 = getLayoutInflater().inflate(R.layout.popinfo2_4, null);
                final PopupWindow mpopup20 = new PopupWindow(popUpView20, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup20.setBackgroundDrawable(new BitmapDrawable());
                mpopup20.setOutsideTouchable(true);
                mpopup20.showAtLocation(popUpView20,Gravity.CENTER,200,0);
                Button b  =(Button)popUpView20.findViewById(R.id.backpop9);
                TextView textView20 = (TextView)popUpView20.findViewById(R.id.titulox) ;
                textView20.setText("Tuvo algún accidente y requiere de algún tipo de terapia de rehabilitación para mejorar su condición, no se preocupe COOPESERVIDORES tiene la solución financiera para eso.");

                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(9);
                        mpopup20.dismiss();
                    }
                });
                mpopup20.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView20.destroyDrawingCache();
                        System.gc();
                    }
                });


                break;
            case 21:
                System.gc();
                final View popUpView21= getLayoutInflater().inflate(R.layout.mail, null);
                final PopupWindow mpopup21= new PopupWindow(popUpView21, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);


                final EditText txt_correo = (EditText)popUpView21.findViewById(R.id.txt_correo);
                txt_correo.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        hideKeyboard(txt_correo);
                    }
                });
               // txt_correo.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);


                final EditText txt_telefono = (EditText)popUpView21.findViewById(R.id.txt_telefono1);
                txt_telefono.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        hideKeyboard(txt_telefono);
                    }
                });
              //  txt_telefono.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);

                final EditText txt_info = (EditText)popUpView21.findViewById(R.id.txt_info);
                txt_info.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        hideKeyboard(txt_info);
                    }
                });
               // txt_info.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);

                Button btn_enviar = (Button)popUpView21.findViewById(R.id.enviar_mail);
                btn_enviar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Send s = new Send(MainActivity.this,null,txt_correo.getText().toString(),txt_telefono.getText().toString()
                                ,txt_info.getText().toString(),true);
                        s.execute();
                        mpopup21.dismiss();
                    }
                });
                Button btn_atras = (Button)popUpView21.findViewById(R.id.attras_mail);
                btn_atras.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mpopup21.dismiss();
                    }
                });

                mpopup21.showAtLocation(popUpView21,Gravity.CENTER,200,0);
                mpopup21.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView21.destroyDrawingCache();
                        System.gc();
                    }
                });
                break;
            case 22 :
                System.gc();

                setinfo1("¿Necesita realizarse una cirugía? No se preocupe en la Cooperativa le ayuda a financiarse este procedimiento médico para que usted se lo realice cuanto antes o según las recomendaciones de su médico.");


                break;
            case 23 :
                System.gc();
                final View popUpView23 = getLayoutInflater().inflate(R.layout.popinfo2_2, null);
                final PopupWindow mpopup23 = new PopupWindow(popUpView23, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup23.setBackgroundDrawable(new BitmapDrawable());
                mpopup23.setOutsideTouchable(true);
                mpopup23.showAtLocation(popUpView23,Gravity.CENTER,200,0);
                Button b23  =(Button)popUpView23.findViewById(R.id.backpop9);
                TextView textView23 = (TextView)popUpView23.findViewById(R.id.titulox) ;
                textView23.setText("Exámenes de sangre y otros exámenes de laboratorio que usted requiera realizarse puede también financiarlos con nosotros. ¿Necesita equipar su consultorio médico? Nosotros le financiamos la compra de todo el equipo necesario para que usted pueda atender a sus pacientes de la mejor manera.");

                b23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openPOPUP(9);
                        mpopup23.dismiss();
                    }
                });
                mpopup23.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {

                        popUpView23.destroyDrawingCache();
                        System.gc();
                    }
                });


                break;
            case 24 :
                System.gc();

                setinfo1("Ginecología, ortopedia, neurología, urología… Acceder a los servicios médicos especializados en los casos necesarios es una inversión pensada en su calidad de vida. Con gusto le asesoramos y le financiamos su plan de salud.");


                break;
            case 25 :
                System.gc();
                final View popUpView25= getLayoutInflater().inflate(R.layout.popinfo2_4, null);
                final PopupWindow mpopup25 = new PopupWindow(popUpView25, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup25.setBackgroundDrawable(new BitmapDrawable());
                mpopup25.setOutsideTouchable(true);
                mpopup25.showAtLocation(popUpView25,Gravity.CENTER,200,0);
                Button b25  =(Button)popUpView25.findViewById(R.id.backpop9);
                TextView textView25= (TextView)popUpView25.findViewById(R.id.titulox) ;
                textView25.setText("Tratamientos estéticos como depilaciones permanentes, tratamiento contra manchas en la piel y otros pueden ser también financiados por COOPESERVIDORES.");
                b25.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mpopup25.dismiss();
                        openPOPUP(9);

                    }
                });
                break;
            case 26 :
                System.gc();
                final View popUpView26= getLayoutInflater().inflate(R.layout.popinfo2_4, null);
                final PopupWindow mpopup26 = new PopupWindow(popUpView26, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup26.setBackgroundDrawable(new BitmapDrawable());
                mpopup26.setOutsideTouchable(true);
                mpopup26.showAtLocation(popUpView26,Gravity.CENTER,200,0);
                Button b26  =(Button)popUpView26.findViewById(R.id.backpop9);
                TextView textView26= (TextView)popUpView26.findViewById(R.id.titulox) ;
                textView26.setText("Esos exámenes que le envío con urgencia su médico puede hacérselos sin pensar en la limitante económica gracias a los financiamientos que le ofrece la Cooperativa.");
                b26.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mpopup26.dismiss();
                        openPOPUP(9);
                    }
                });
                break;
            case 27:
                System.gc();
                final View popUpView29 = getLayoutInflater().inflate(R.layout.popinfo2_2, null);
                final PopupWindow mpopup29 = new PopupWindow(popUpView29, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup29.setBackgroundDrawable(new BitmapDrawable());
                mpopup29.setOutsideTouchable(true);
                mpopup29.showAtLocation(popUpView29,Gravity.CENTER,200,0);
                Button b29  =(Button)popUpView29.findViewById(R.id.backpop9);
                TextView textView29= (TextView)popUpView29.findViewById(R.id.titulox) ;
                textView29.setText("Exámenes de sangre y otros exámenes de laboratorio que usted requiera realizarse puede también financiarlos con nosotros. ¿Necesita equipar su consultorio médico? Nosotros le financiamos la compra de todo el equipo necesario para que usted pueda atender a sus pacientes de la mejor manera.");
                b29.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mpopup29.dismiss();
                        openPOPUP(9);

                    }
                });
            case 28:


                break;
            case 29:
                System.gc();

                setinfo1("Para la compra de antibióticos, inyectables y diferentes tratamientos médicos estamos para servirle en COOPESERVIDORES. Nuestros créditos solventan sus necesidades para una mejor calidad de vida.");

                break;
            case 30:
                System.gc();
                setinfo1("Sentirse bien de salud es una condición que todos merecemos. Por ello, acuda a un centro médico de su preferencia y opte por las revisiones y controles que su doctor le indique. Financie esta inversión en su calidad de vida con nosotros.");
                break;
            case 31:
                System.gc();
                final View popUpView31 = getLayoutInflater().inflate(R.layout.popinfo2_2, null);
                final PopupWindow mpopup31 = new PopupWindow(popUpView31, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup31.setBackgroundDrawable(new BitmapDrawable());
                mpopup31.setOutsideTouchable(true);
                mpopup31.showAtLocation(popUpView31,Gravity.CENTER,200,0);
                Button b31  =(Button)popUpView31.findViewById(R.id.backpop9);
                TextView textView31= (TextView)popUpView31.findViewById(R.id.titulox) ;
                textView31.setText("El control ginecológico obstetra así como la compra de pañales y demás cosas que se necesitan para la llegada de un bebé son un gasto significativo para que pueda disfrutar de esta linda etapa de madre la Cooperativa le ofrece financiamiento para que ese bebé y su familia tengan calidad de vida.");
                b31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mpopup31.dismiss();
                        openPOPUP(9);

                    }
                });
                break;
            case 32:

                System.gc();
                final View popUpView32 = getLayoutInflater().inflate(R.layout.popinfo1_2, null);
                final PopupWindow mpopup32 = new PopupWindow(popUpView32, 750,420, true);
                //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
                mpopup32.setBackgroundDrawable(new BitmapDrawable());
                mpopup32.setOutsideTouchable(true);
                mpopup32.showAtLocation(popUpView32,Gravity.CENTER,200,0);
                Button b32  =(Button)popUpView32.findViewById(R.id.backpop9);
                TextView textView32= (TextView)popUpView32.findViewById(R.id.titulox) ;
                textView32.setText("En un mundo competitivo como el de ahora, es fundamental estar actualizado y capacitado en diferentes áreas y el dinero no debe de ser un inconveniente para esto en COOPESERVIDORES puede encontrar soluciones financieras competitivas.");
                b32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mpopup32.dismiss();
                        openPOPUP(6);

                    }
                });
                break;
            case 33:
                System.gc();
                setinfo2(R.layout.popinfo1_2,"Una maestría o un doctorado son grados de profesionalización que ahora está en sus manos alcanzarlos. En COOPESERVIDORES queremos que usted cumpla ese sueño para una mejor calidad de vida futura. Nuestros créditos se lo permitirán.");


                break;
            case 34:
                System.gc();
                setinfo2(R.layout.popinfo1,"¿Desea empezar sus estudios universitarios? En COOPESERVIDORES le ayudamos a que comience esa gran meta que se propuso con el financiamiento que le ofrecemos para el pago de la matrícula en la U de su preferencia.");

                break;
            case 35:
                System.gc();
                setinfo2(R.layout.popinfo1_4,"El costo de cada una de las materias en la Universidad tienen un costo elevado lo que muchas veces limita a los estudiantes que desean llevar una carrera universitaria pero en COOPESERVIDORES le tendemos la mano para que pronto recoja ese título universitario que usted desea.");
                break;
            case 36:
                System.gc();
                setinfo2(R.layout.popinfo1,"Obtener el título de graduación es el premio al esfuerzo de un estudiante, por lo que para que pueda celebrar con tranquilidad la conclusión de su carrera nosotros le financiamos los gastos de la graduación.");
                break;
            case 37:
               System.gc();
                setinfo2(R.layout.popinfo1_3,"Hablar inglés, portugués, francés y demás idiomas cada día es más necesario por lo que si anda en busca de una solución económica aquí le podemos ayudar.");
                break;
            case 38:
                System.gc();

                setinfo2(R.layout.popinfo1_5,"Si irse para el extranjero de intercambio o a realizar una pasantía es su meta, cúmplala con nosotros.");

                break;
            case 39:
                setinfo2(R.layout.popinfo1_3,"La compra de cuadernos, libros, uniformes y demás útiles son un dolor de cabeza para los padres a inicio de año, no deje que esto lo preocupe más de la cuenta pregúntanos por nuestro crédito.");

                break;
            case 40:

                setinfo3("Sueña con irse de viaje al extranjero cumpla ese sueño y viaje con un crédito de COOPESERVIDORES y pague cuotas competitivas y bajos intereses.");
                System.gc();
                break;
            case 41:
                System.gc();
                setinfo3("¿Desea irse de vacaciones? Un fin de semana todo incluido a la playa o la montaña en nuestro país con su familia o amigos ahora es posible gracias a un crédito que le ofrece COOPESERVIDORES.");
                break;
            case 42:
                System.gc();
                setinfo2(R.layout.popinfo1_6,"Hacé realidad tu sueño de estudiar una carrera, iniciá tus estudios y empezá a pagar al graduarte");
                break;
            case 43:
                System.gc();
                setinfo4(R.layout.popinfo4_1,"Desea llantas nuevas, equipo de audio o video, alarmas o demás para su carro aquí se lo financiamos.");
                break;
            case 44:
                System.gc();
                setinfo4(R.layout.popinfo4,"Si su sueño tiene cuatro o dos ruedas, nosotros le brindamos créditos con competitivas tasas de interés y cuotas para que usted pueda estrenar ese vehículo que usted ha soñado.");
                break;
            case 45:
                System.gc();
                setinfo4(R.layout.popinfo4_1,"Su carro necesita pintura, cambio de llantas u otro mantenimiento consulte por nuestras opciones de financiamiento.");
                break;
            case 46:
                System.gc();
                setinfo4(R.layout.popinfo4,"¿Tiene su carro en el taller? No se preocupe por estos gastos de más aquí le ofrecemos soluciones financieras para que usted pueda andar sobre ruedas lo más pronto posible.");
                break;
            case 47:
                System.gc();
                setinfo5(R.layout.popinfo5,"Está interesado en producir gas metano el biodigestor le ayudará a lograrlo a partir de productos orgánicos y la Cooperativa le puede ayudar a adquirirlo con un financiamiento con excelentes condiciones.");
                break;
            case 48:
                System.gc();
                setinfo5(R.layout.popinfo5,"Actualmente el mercado ofrece diferentes opciones de loza sanitaria que ayuda en el ahorro del agua, y con la asesoría financiera que le ofrece COOPESERVIDORES usted podrá realizar estos cambios en su hogar y oficina.");
                break;
            case 49:
                System.gc();
                setinfo5(R.layout.popinfo5_1,"Cambiando el sistema eléctrico puede ahorrarle dinero en sus recibos eléctricos y así proteger al medio ambiente conozca las opciones de financiamiento que le ofrece la Cooperativa para que pueda estrenar sistema eléctrico en su casa u oficina.");
                break;
            case 50:
                System.gc();
                setinfo5(R.layout.popinfo5_2,"Deje de pagar los altos precios de los combustibles y ayude al medio ambiente comprando un vehículo híbrido consulte sobre los financiamientos que ofrece COOPESERVIDORES.");
                break;
            case 51:

                setinfo5(R.layout.popinfo5_3,"Es un crédito pensando en ayudarle adquirir ese sueño de una vivienda con materiales amigables con el ambiente.");


                break;
            case 52:

                setinfo5(R.layout.popinfo5_1,"Sabía usted que con la instalación de paneles solares en su casa podría ahorrar en su factura de servicio eléctrico y además así ayudar al medio ambiente… COOPESERVIDORES le ayuda a que usted pueda contar con un hogar u oficina sostenible ofreciéndole un financiamiento para la instalación de paneles solares.");


                break;
            case 53:
                System.gc();
                setinfo6(R.layout.popinfo6_2,"Pague menos mensualmente por su crédito hipotecario, en la Cooperativa le compramos esas hipotecas y así usted podrá contar con más liquidez mensualmente.");
                break;
            case 54:
                System.gc();
                setinfo6(R.layout.popinfo6,"¿Cuenta usted con varias tarjetas de crédito y con saldos pendientes en estas? En COOPESERVIDORES le compramos todas esas deudas y con ello tendrá que pagar solo una única y más baja cuota mensual.");
                break;
            case 55:
                System.gc();
                setinfo6(R.layout.popinfo6_2,"Si usted tiene varias deudas en diferentes instituciones y le gustaría pagar menos quincenalmente la opción de una refundición de deudas es lo que usted necesita.");
                break;
            case 56:
                System.gc();
                setinfo7(R.layout.popinfo7,"Si su sueño tiene cuatro o dos ruedas, nosotros le brindamos créditos con competitivas tasas de interés y cuotas para que usted compre ese vehículo que desea.");
                break;
            case 57:
                System.gc();
                setinfo7(R.layout.popinfo7_1,"Gastos imprevistos en su casa como reparaciones urgentes o compra de electrodomésticos dañados pueden ser financiados con COOPESERVIDORES. Evite que estas situaciones sean un dolor de cabeza, nosotros le ayudamos.");
                break;
            case 58:
                System.gc();
                setinfo7(R.layout.popinfo7_2,"Refundiciones de deudas, financiamiento para compras de carro, electrodomésticos o vacaciones también pueden ser otorgados en la Cooperativa.");
                break;
            case 60:
                System.gc();
                setinfo7(R.layout.popinfo7_1,"Las emergencias pasan cuando uno menos se lo espera, y porque en COOPESERVIDORES somos gente ayudando gente le brindamos financiamiento para esas urgencias médicas que en ocasiones se presentan.");
                break;
            case 61:
                System.gc();
                setinfo7(R.layout.popinfo7_3,"Ponete al día con la tecnología, acercate a tus metas con un Minicrédito.");


                break;
            case 62:
                System.gc();
                setinfo8(R.layout.popinfo8,"Decorar su casa ahora será más sencillo, obtenga un crédito con condiciones competitivas y así podrá comprar todo lo necesario para sus decoraciones o incluso contratar a un decorador de interiores.");
                break;
            case 63:
                System.gc();
                setinfo8(R.layout.popinfo8_4,"Cocina, refrigeradora, lavadora, secadora, microondas y otros electrodomésticos puede ahora comprarlos con un financiamiento que le ofrece COOPESERVIDORES.");
                break;
            case 64:
                System.gc();

                setinfo8(R.layout.popinfo8_3,"Una casa nueva necesita muebles, electrodomésticos nuevos también y si eso lo tiene preocupado COOPESERVIDORES le ayuda a amueblar su nuevo hogar ofrece financiamiento con tasas e intereses competitivos para que no se quede sin el menaje necesario para disfrutar y compartir con su familia.");

                break;
            case 65:
                System.gc();
                setinfo8(R.layout.popinfo8_5,"Si sus muebles se encuentran en mal estado o ya están muy antiguos, pero no tiene los medios económicos para cambiarlos, en COOPESERVIDORES le ofrecemos créditos en pequeñas cuotas quincenales y tasas de interés competitivas. Consúltenos.");
                break;
            case 66:
                System.gc();
                setinfo8(R.layout.popinfo8_2,"Es un crédito pensando en ayudarle adquirir ese sueño de una vivienda, le damos facilidad de adquirir un crédito con la finalidad de comprar su vivienda bajo condiciones aceptables para que usted pueda disfrutar su vivienda.");
                break;
            case 67:
                System.gc();
                setinfo8(R.layout.popinfo8_4,"Pague menos mensualmente por su crédito hipotecario, en la Cooperativa se le compramos esas hipotecas y así usted podrá contar con más liquidez mensualmente.");
                break;
            case 68:
                System.gc();
                setinfo8(R.layout.popinfo8_4,"Este crédito tiene la finalidad de brindarle el soporte necesario para adquirir ese lote que siempre ha soñado y el cual tiene como una meta personal.");
                break;
            case 69:
                System.gc();
                setinfo8(R.layout.popinfo8_6,"Este crédito tiene la finalidad de brindarle el soporte necesario para adquirir ese lote y construir la casa de sus sueños.");
                break;
            case 70:
                System.gc();
                setinfo8(R.layout.popinfo8_4,"Es un crédito pensando en ayudarle adquirir ese sueño de una vivienda, le damos la oportunidad de tenernos como el soporte necesario para alcanzar ese gran objetivo que es su vivienda.");
                break;
            case 71:
                System.gc();
                setinfo8(R.layout.popinfo8_5,"Siempre habrá que darle un chineo a su casa… Una reparación por acá, una remodelación por allá, o esa ampliación que ya es urgente. Cuente con nuestra asesoría financiera, en COOPESERVIDORES somos gente ayudando gente.");
                break;
            case 72:
                System.gc();
                setinfo8(R.layout.popinfo8_5,"En COOPESERVIDORES somos una entidad autorizada por el Banco Hipotecario de la Vivienda (Banhvi) para el trámite del bono. Abrimos nuestro brazo social para ayudarles a familias en condición socioeconómica difícil a cumplir su sueño de tener casa propia.");
                break;
            case 73: // Educacion
                setinfo2(R.layout.popinfo1_3,"Computadoras y demás equipo tecnológico necesario para su desempeño profesional ahora puede ser financiado por COOPESERVIDORES.");
                break;
            case 74:
                setinfo8(R.layout.popinfo8_7,"");
                break;
        }

    }
    public void cambiar(String e){
        Toast.makeText(MainActivity.this,e,Toast.LENGTH_SHORT).show();

    }
    void setinfo2_1(String titulo){

        final View popUpView36 = getLayoutInflater().inflate(R.layout.popinfo1_2, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(6);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }

    void setinfo2(int id,String titulo){

        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(6);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo1(String titulo){
        final View popUpView29 = getLayoutInflater().inflate(R.layout.popinfo2, null);
        final PopupWindow mpopup29 = new PopupWindow(popUpView29, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup29.setBackgroundDrawable(new BitmapDrawable());
        mpopup29.setOutsideTouchable(true);
        mpopup29.showAtLocation(popUpView29,Gravity.CENTER,200,0);
        Button b29  =(Button)popUpView29.findViewById(R.id.backpop9);
        TextView textView29= (TextView)popUpView29.findViewById(R.id.titulox) ;
        textView29.setText(titulo);
        b29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mpopup29.dismiss();
                openPOPUP(9);

            }
        });
        mpopup29.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView29.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo3(String titulo){

        final View popUpView = getLayoutInflater().inflate(R.layout.popinfo3, null);
        final PopupWindow mpopup = new PopupWindow(popUpView, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup.setBackgroundDrawable(new BitmapDrawable());
        mpopup.setOutsideTouchable(true);
        mpopup.showAtLocation(popUpView,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(3);
                mpopup.dismiss();
            }
        });
        mpopup.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo4(int id,String titulo){

        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(8);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo5(int id,String titulo){

        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(5);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo6(int id ,String titulo){

        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(2);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo7(int id ,String titulo){

        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(1);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }
    void setinfo8(int id ,String titulo){

        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36,Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(4);
                mpopup36.dismiss();
            }
        });
        mpopup36.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView36.destroyDrawingCache();
                System.gc();
            }
        });
    }

    void setuin(int i){
        final View popUpView9 = getLayoutInflater().inflate(i, null);
        final PopupWindow mpopup9 = new PopupWindow(popUpView9, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup9.setBackgroundDrawable(new BitmapDrawable());
        mpopup9.setOutsideTouchable(true);
        mpopup9.showAtLocation(popUpView9,Gravity.CENTER,200,0);
        mpopup9.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

                popUpView9.destroyDrawingCache();
                System.gc();
            }
        });
        Button d1 = (Button)popUpView9.findViewById(R.id.linea1);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(20);
                mpopup9.dismiss();

            }
        });
        Button d2 = (Button)popUpView9.findViewById(R.id.linea2);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(22);
                mpopup9.dismiss();
            }
        });
        Button d3 = (Button)popUpView9.findViewById(R.id.linea3);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(23);
                mpopup9.dismiss();
            }
        });
        Button d4 = (Button)popUpView9.findViewById(R.id.linea4);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(24);
                mpopup9.dismiss();
            }
        });
        Button d5 = (Button)popUpView9.findViewById(R.id.linea5);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(25);
                mpopup9.dismiss();
            }
        });
        Button d6 = (Button)popUpView9.findViewById(R.id.linea6);
        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(26);
                mpopup9.dismiss();
            }
        });
        Button d7 = (Button)popUpView9.findViewById(R.id.linea7);
        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(27);
                mpopup9.dismiss();
            }
        });
        Button d8 = (Button)popUpView9.findViewById(R.id.linea8);
        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(28);
                mpopup9.dismiss();
            }
        });
        Button d9 = (Button)popUpView9.findViewById(R.id.linea9);
        d9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(29);
                mpopup9.dismiss();
            }
        });
        Button d10 = (Button)popUpView9.findViewById(R.id.linea10);
        d10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPOPUP(30);
                mpopup9.dismiss();
            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    private void hideKeyboard(EditText e) {
        InputMethodManager imm = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(e.getWindowToken(), 0);
    }
}


