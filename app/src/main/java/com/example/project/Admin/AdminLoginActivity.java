package com.example.project.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.LoginActivity;
import com.example.project.Model.Users;
import com.example.project.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingbar;
    private TextView UserLink;
    private String PasswordHolder, MobileHolder;
    private String finalResult ;
    private String HttpURL = "https://akarfurniture.000webhostapp.com/admin/login.php";
    private HashMap<String,String> hashMap = new HashMap<>();
    HttpParse httpParse = new HttpParse();
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        LoginButton=(Button)findViewById(R.id.admin_login_btn);
        InputPassword=(EditText)findViewById(R.id.admin_login_password_input);
        InputPhoneNumber=(EditText)findViewById(R.id.admin_login_phone_input);
        UserLink=(TextView)findViewById(R.id.user_panel_link);
        loadingbar=new ProgressDialog(this);

        LoginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                PasswordHolder = InputPassword.getText().toString();
                MobileHolder = InputPhoneNumber.getText().toString();
                LoginFunction(MobileHolder, PasswordHolder);;
            }
        });

        UserLink.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(AdminLoginActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void LoginFunction(final String mobile, final String password) {

        if (TextUtils.isEmpty(mobile))
        {
            Toast.makeText(this,"Please write your Phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(this,"Please write your Password...", Toast.LENGTH_SHORT).show();
        }
        else if (!InputPhoneNumber.getText().toString().matches("[0-9]{10}")){
            Toast.makeText(this,"Enter Valid Mobile Number...", Toast.LENGTH_SHORT).show();
            //InputPhoneNumber.setError("Enter Valid Mobile Number.");
        }
        else
        {
            class LoginClass extends AsyncTask<String,Void,String> {

                @Override
                protected void onPreExecute() {
                    super.onPreExecute();

                    loadingbar.setTitle("Login Admin Account");
                    loadingbar.setMessage("Please wait, While we are checking the credentials.");
                    loadingbar.setCanceledOnTouchOutside(false);
                    loadingbar.show();
                }

                @Override
                protected void onPostExecute(String httpResponseMsg) {

                    super.onPostExecute(httpResponseMsg);

                    loadingbar.dismiss();

                    if(httpResponseMsg.equalsIgnoreCase("Data Matched")){

                        finish();

                        Intent intent = new Intent(AdminLoginActivity.this, AdminCategoryActivity.class);

                        startActivity(intent);

                    }
                    else{

                        Toast.makeText(AdminLoginActivity.this,httpResponseMsg,Toast.LENGTH_LONG).show();
                    }

                }

                @Override
                protected String doInBackground(String... params) {

                    hashMap.put("mobile",params[0]);

                    hashMap.put("password",params[1]);

                    finalResult = httpParse.postRequest(hashMap, HttpURL);

                    return finalResult;
                }
            }

            LoginClass loginClass = new LoginClass();

            loginClass.execute(mobile,password);
        }
    }
}