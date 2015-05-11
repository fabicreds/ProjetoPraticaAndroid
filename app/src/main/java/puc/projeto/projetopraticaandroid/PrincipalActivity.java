package puc.projeto.projetopraticaandroid;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class PrincipalActivity extends ActionBarActivity {

    private Spinner spMaterias;
    private ListView lvHorarios;
    private RadioButton rbMatutino;
    private RadioButton rbVespertino;
    private RadioButton rbNoturno;
    private Button btnSair;
    private Button btnFechar;

    private SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        spMaterias = (Spinner) this.findViewById(R.id.spMaterias);
        lvHorarios = (ListView) this.findViewById(R.id.lvHorarios);
        rbMatutino = (RadioButton) this.findViewById(R.id.rbMatutino);
        rbVespertino = (RadioButton) this.findViewById(R.id.rbVespertino);
        rbNoturno = (RadioButton) this.findViewById(R.id.rbNoturno);

        btnSair = (Button) this.findViewById(R.id.btnSair);
        btnFechar = (Button) this.findViewById(R.id.btnFechar);

        ArrayAdapter<CharSequence> adapterMaterias = ArrayAdapter.createFromResource(this, R.array.lista_materias, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_noturno, android.R.layout.simple_selectable_list_item);

        if(rbMatutino.isChecked()){
            adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_matutino, android.R.layout.simple_selectable_list_item);
        }else if(rbVespertino.isChecked()){
            adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_vespertino, android.R.layout.simple_selectable_list_item);
        }

        spMaterias.setAdapter(adapterMaterias);
        lvHorarios.setAdapter(adapterHorarios);
    }


    public void onClick(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        ArrayAdapter<CharSequence> adapterHorarios;

        switch (view.getId()){
            case R.id.rbMatutino:
                if(checked){
                    adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_matutino, android.R.layout.simple_selectable_list_item);
                    lvHorarios.setAdapter(adapterHorarios);
                }
                break;
            case R.id.rbVespertino:
                if(checked){
                    adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_vespertino, android.R.layout.simple_selectable_list_item);
                    lvHorarios.setAdapter(adapterHorarios);
                }
                break;
            case R.id.rbNoturno:
                    if(checked) {
                        adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_noturno, android.R.layout.simple_selectable_list_item);
                        lvHorarios.setAdapter(adapterHorarios);
                    }
                    break;
            default:
                adapterHorarios = ArrayAdapter.createFromResource(this, R.array.lista_horarios_noturno, android.R.layout.simple_selectable_list_item);
                lvHorarios.setAdapter(adapterHorarios);
                break;
        }

    }

    public void onClickButton(View v) {
        switch (v.getId()){
            case R.id.btnSair:
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("keepConnected", false);
                editor.commit();
                this.finish();
                break;
            case R.id.btnFechar:
                this.finish();
        }
    }
}
