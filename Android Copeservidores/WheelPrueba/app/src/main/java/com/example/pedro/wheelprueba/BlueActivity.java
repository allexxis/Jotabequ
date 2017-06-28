package com.example.pedro.wheelprueba;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ContainerDrawerItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class BlueActivity extends AppCompatActivity {

    private Button bt;

    private WheelView wheelView;
    public float data;
    ArrayList<Drawable> blueIcons = new ArrayList<>();
    Canvas canvas;

    @Override
    protected void onCreate(final Bundle savedInstanceState)    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blue);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendmail();;

            }
        });
        fab.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#009BDB")));
        wheelView = (WheelView) findViewById(R.id.wheelview1);
        wheelView.getWheelDrawable().setAlpha(0);
        bt = (Button) findViewById(R.id.btn_credito);
        canvas = new Canvas();
        createBlueIcons();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(i);
                System.gc();
            }
        });
        wheelView.setAdapter(new WheelAdapter() {


            @Override
            public Drawable getDrawable(int position) {
               /* Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.img2);

               Drawable b = new BitmapDrawable(bmp);
                Drawable[] drawable = new Drawable[]{
                        //createOvalDrawable(getResources().getColor(R.color.cyan_a100)),


                };*/
                return blueIcons.get(position);
            }

            /*private Drawable createOvalDrawable(int color) {
                ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                shapeDrawable.getPaint().setColor(color);
                return shapeDrawable;
            }*/


            @Override
            public int getCount() {
                return 10;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }
        });


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
                        showpop(R.layout.blue0,"Sistema de ahorro que se constituye con base en cuotas mensuales y consecutivas a un año plazo máximo y con interés capitalizable mensualmente.");
                        break;
                    case 1:
                        showpop(R.layout.blue1,"Si usted tiene hijos en etapa estudiantil, este ahorro puede ayudarle a solventar la dura entrada a clases,  le permite contar con el dinero necesario para pagar los mejores útiles o bien esa matrícula que tanto necesita."
                                );
                        break;
                    case 2:
                        showpop(R.layout.blue2,"Obtenga ese dinero extra para las compras de navidad y fin de año, con este ahorro usted podrá obtener el beneficio perfecto en el fin de año.");

                        break;
                    case 3:
                        showpop(R.layout.blue3,"Uno de los gastos más incómodos del año es el permiso de circulación vehicular o marchamo, cree su ahorro marchamo con CS y disponga de un dinero exclusivo para que pueda pagar sin tener que tocar el dinero de sus gastos comunes.");
                        break;
                    case 4:
                        showpop(R.layout.blue4,"El ahorro vacacional tiene la función de brindarle el dinero necesario para disfrutar de ese viaje que soñó disfrutar sin preocupaciones y libre de estrés de unas vacaciones familiares.Viaje, disfrute y conozca gracias al  ahorro vacacional de CS.");
                        break;
                    case 5:
                        showpop(R.layout.blue5,"Este tipo de ahorro nos permite tener un fondo de efectivo para los periodos universitarios o bien para pagar mis gastos de una graduación, este ahorro tiene la finalidad de ayudar a tener una vía de pago en momentos donde el estudio lo amerita."
                               );
                        break;
                    case 6:
                        showpop(R.layout.blue6,"Son ahorros con plazos extendidos en los cuales se permite el aporte de cuotas extraordinarias, brinda tasas de interés competitivas, se adquiere por un contrato con un plazo establecido para mejorar sus dividendos."
                                );
                        break;
                    case 7:
                        showpop(R.layout.blue7,"Es un ahorro a la vista diferenciado, que tiene la particularidad de reconocer una tasa de interés escalonada hasta 90 días, de acuerdo con el plazo de permanencia de la inversión, por tanto, a mayor plazo, mayor rendimiento."
                                );
                        break;
                    case 8:
                        showpop(R.layout.blue8,"Este es un ahorro con el fin de generar buenos dividendos a su dinero, el contrato de este ahorro le permite tener su dinero generando intereses como si fuera un Certificado pero con la facilidad de definir un monto de aporte fijo durante el periodo establecido."
                                );
                        break;
                    case 9:
                        showpop(R.layout.blue9,"Sistema de ahorro que se constituye con base en cuotas mensuales y consecutivas a un año plazo máximo y con interés capitalizable mensualmente."
                                );
                        break;


                }
               //Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();

            }
        });
        //init();



    }


      /*  new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                wheelView.setSelectionAngle(-wheelView.getAngleForPosition(5));
                wheelView.setMidSelected();
            }
        }, 1000);*/


    public void init() {
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                wheelView.setAngle(wheelView.getAngle() + 40);
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

    public void createBlueIcons() {
        for (int i = 0; i < 10; i++) {

            int res = getResources().getIdentifier("icg" + i, "drawable", this.getPackageName());
            Bitmap bmp = BitmapFactory.decodeResource(getResources(), res);
            Drawable b = new BitmapDrawable(bmp);
            blueIcons.add(b);
        }
    }
    void showpop(int id ,String titulo){
        final View popUpView36 = getLayoutInflater().inflate(id, null);
        final PopupWindow mpopup36 = new PopupWindow(popUpView36, 750,420, true);
        //*mpopup.setAnimationStyle(R.style.Animations_GrowFromBottom);
        mpopup36.setBackgroundDrawable(new BitmapDrawable());
        mpopup36.setOutsideTouchable(true);
        mpopup36.showAtLocation(popUpView36, Gravity.CENTER,200,0);
        Button b36  =(Button)popUpView36.findViewById(R.id.backpop9);
        TextView textView36= (TextView)popUpView36.findViewById(R.id.titulox) ;
        textView36.setText(titulo);
        b36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    @Override
    public void onBackPressed() {

    }
    void sendmail(){
        System.gc();
        final View popUpView21= getLayoutInflater().inflate(R.layout.mail1, null);
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
                Send s = new Send(null,BlueActivity.this,txt_correo.getText().toString(),txt_telefono.getText().toString()
                        ,txt_info.getText().toString(),false);
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
    }
    public void cambiar(String e){
        Toast.makeText(BlueActivity.this,e,Toast.LENGTH_SHORT).show();

    }
    private void hideKeyboard(EditText e) {
        InputMethodManager imm = (InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(e.getWindowToken(), 0);
    }
}