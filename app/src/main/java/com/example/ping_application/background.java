package com.example.ping_application;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class background extends AsyncTask <String, Void, String> {

    private boolean loginSuccess;
    private CurrentUser curruser;

    AlertDialog dialog;
    Context context;
    public background(Context context)
    {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        dialog = new AlertDialog.Builder(context).create();
        dialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.setMessage(s);
        dialog.show();

        if(loginSuccess == true) {
            Intent intent = new Intent(context, MainActivity.class).putExtra("currUser",curruser);;
            context.startActivity(intent);
        }
    }

    @Override
    protected String doInBackground(String... voids) {
        String result = "";
        String user = voids[0];
        String pass = voids[1];
        String[] userinfo = new String[6];

        loginSuccess = false; // Default

        String connstr = "http://100.64.7.226/login.php"; // Replace BLAH with IPv4 address of computer hosting XAMPP server

        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops, "UTF-8"));
            String data = URLEncoder.encode("user", "UTF-8")+"="+URLEncoder.encode(user, "UTF-8")
                    +"&&"+URLEncoder.encode("pass", "UTF-8")+"="+URLEncoder.encode(pass, "UTF-8");

            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips, "ISO-8859-1")); //ENCODING SCHEME (ISO)

            String line = "";
            int linecount = 0;
            while ((line = reader.readLine()) != null)
            {
                if(linecount == 0) {
                    result += line;
                    linecount++;
                }
                else {
                    userinfo[linecount - 1] = line;
                    linecount++;
                }
            }

            curruser = new CurrentUser();

            for(int i = 0; i < 6; i++) {
                if(i == 0) {
                    curruser.setUsername(userinfo[i]);
                }
                else if (i == 1) {
                    curruser.setPassword(userinfo[i]);
                }
                else if (i == 2) {
                    curruser.setFullName(userinfo[i]);
                }
                else if(i == 3) {
                    curruser.setBirthday(userinfo[i]);
                }
                else if(i == 4) {
                    curruser.setPhoneNum(userinfo[i]);
                }
                else if(i == 5) {
                    curruser.setDriverBool(userinfo[i]);
                }
            }

            reader.close();
            ips.close();
            http.disconnect();

            if(result.equals("Login successful!"))
            {
                loginSuccess = true;
            }

            return result;
        }
        catch (MalformedURLException e) {
            result = e.getMessage();
        }
        catch (IOException e) {
            result = e.getMessage();
        }

        return result;
    }
}
