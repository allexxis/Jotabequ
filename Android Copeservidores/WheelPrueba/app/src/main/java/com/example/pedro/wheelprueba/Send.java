package com.example.pedro.wheelprueba;

import android.os.AsyncTask;

/**
 * Created by Pedro on 10/13/2016.
 */
public class Send extends AsyncTask<String,String,String> {
    MainActivity m;
    BlueActivity b;
    String body;
    String correo;
    String numero;
    String cuerpo;
    boolean bool;
    Send(MainActivity m,BlueActivity b,String correo,String numero,String cuerpo,boolean bool){
        this.bool = bool;
        this.m = m;
        this.b=b;
        this.correo=correo;
        this.numero=numero;
        this.cuerpo=cuerpo;
        body="\n" + ""+correo+ "\n" + ""+numero +"\n" +""+cuerpo;
    }
    @Override
    protected String doInBackground(String...params) {

        Mail m = new Mail("pruebasideamedia@gmail.com", "arbolverde");

        String[] toArr = {"op@ideamediacr.com", "pruebasideamedia@gmail.com"};
        m.set_to(toArr);
        m.set_from("pruebasideamedia@gmail.com");
        m.set_subject("Información de cliente copeservidores.");
        m.setBody(body);

        try {
         //   m.addAttachment("/sdcard/filelocation");

            if(m.send()) {
               return  "Se envio con exito";
            } else {
            }
        } catch(Exception e) {
            //Toast.makeText(MailApp.this, "There was a problem sending the email.", Toast.LENGTH_LONG).show();
            return "Error intentelo de nuevo";
        }


        return "Se envio con exito";
    }
    @Override
    protected void onPostExecute(String e) {
        super.onPostExecute(e);
        if (bool) {
            m.cambiar(e);
        }
        else{
            b.cambiar(e);
        }

    }

        }