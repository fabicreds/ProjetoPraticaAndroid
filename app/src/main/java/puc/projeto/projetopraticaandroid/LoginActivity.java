package puc.projeto.projetopraticaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Context;


public class LoginActivity extends ActionBarActivity implements View.OnClickListener{

    private EditText etUser;
    private EditText etPassword;
    private CheckBox cbKeepConnected;
    private Button btnLogin;
    private Context context;
    private SharedPreferences sharedPreferences;
    private Boolean keepConnected = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText)this.findViewById(R.id.etUser);
        etPassword = (EditText)this.findViewById(R.id.etPassword);
        cbKeepConnected = (CheckBox)this.findViewById(R.id.cbKeepConnected);
        btnLogin = (Button)this.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);

        context = this;
        sharedPreferences = context.getSharedPreferences("configs", Context.MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

        if( etUser.getText().toString().contains("@")) {

            if (cbKeepConnected.isChecked()) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("keepConnected", true);
                editor.putString("username", etUser.getText().toString());
                editor.commit();
            }
            Intent iPrincipal = new Intent(LoginActivity.this, PrincipalActivity.class);
            LoginActivity.this.startActivity(iPrincipal);
            this.finish();
        }
    }
}
