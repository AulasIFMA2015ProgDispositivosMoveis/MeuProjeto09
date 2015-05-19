package com.aula.meuprojeto09;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class Principal extends Activity implements OnClickListener {
	
	private Button btnAtivar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        btnAtivar = (Button) findViewById(R.id.btnAtivar);
        btnAtivar.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		BluetoothAdapter adaptador = BluetoothAdapter.getDefaultAdapter();
		if (adaptador == null) {
			Toast.makeText(this, "Não há Bluetooth", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(this, "Tem Bluetooth", Toast.LENGTH_SHORT).show();
			Intent ativarbluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(ativarbluetooth, 0);
		}
	}
}
