package uk.co.phoebemurphy.apps.calculator;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener{
	public final static String EXTRA_MESSAGE = "uk.co.phoebemurphy.apps.calculator.MESSAGE";
	String operator;
	Spinner spinner;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, 
				R.array.operators_array, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayResultActivity.class);
		String noOne, noTwo, message;
		EditText editText = (EditText) findViewById(R.id.number_one);
		noOne = editText.getText().toString();
		editText = (EditText) findViewById(R.id.number_two);
		noTwo = editText.getText().toString();
		
		
		message = calculate(noOne, noTwo, operator);
		intent.putExtra(EXTRA_MESSAGE, message);
		startActivity(intent);
	}

	public String calculate(String noOne, String noTwo, String operator) {
		String result;
		
		try {
			double noOneD = Double.parseDouble(noOne);
			double noTwoD = Double.parseDouble(noTwo);
			double resultD;
			if (operator.equals("+")) {
				resultD = noOneD + noTwoD;
				result = Double.toString(resultD);
			} else if (operator.equals("-")) {
				resultD = noOneD - noTwoD;
				result = Double.toString(resultD);
			}
			else if (operator.equals("x")) {
				resultD = noOneD * noTwoD;
				result = Double.toString(resultD);
			}
			else if (operator.equals("/")) {
				resultD = noOneD / noTwoD;
				result = Double.toString(resultD);
			}
			else {
				result = "Operator not recognised, please enter + or -";
			}

		} catch (NumberFormatException e) {
			result = "Sum invalid, please enter numbers only";
		}
		return result;

	}

	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		operator=(String) parent.getItemAtPosition(pos);
		
	}

	public void onNothingSelected(AdapterView<?> parent) {
		operator = null;
		
	}
}
