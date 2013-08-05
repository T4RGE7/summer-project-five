package net.cs.jimisthebest.t4rge7.bstdictionary;

import net.cs.jimisthebest.t4rge7.xfixcalc.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		final Button search = (Button)this.findViewById(R.id.searchButton);
		final Button add = (Button)this.findViewById(R.id.add);
		
		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				searchButton();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void searchButton() {
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		final Button search = (Button)this.findViewById(R.id.searchButton);
		final Button add = (Button)this.findViewById(R.id.add);
		
		
	}

}
