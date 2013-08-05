package net.cs.jimisthebest.t4rge7.bstdictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Random;
import java.util.Scanner;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private BSTDictionary dictionary;
	private final String[] partOfSpeech = {"Select a Part of Speech","noun","verb","pronoun","adjective","adverb","preposition","conjunction","interjection"};
/*	<item>noun</item>
    <item>verb</item>
    <item>pronoun</item>
    <item>adjective</item>
    <item>adverb</item>
    <item>preposition</item>
    <item>conjunction</item>
    <item>interjection</item>*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		this.loadDictionary();
		
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		final Button search = (Button)this.findViewById(R.id.searchButton);
		final Button clear = (Button)this.findViewById(R.id.clearButton);
		Button remove = (Button)this.findViewById(R.id.remove);
		Button add = (Button)this.findViewById(R.id.add);
		
		search.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				searchButton(v);
			}
		});
		
		clear.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				clearButton(v);
			}
			
		});
		
		add.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				addButton(v);
			}
		});
		
		remove.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				removeButton(v);
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void removeButton(View v) {
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		Button add = (Button)this.findViewById(R.id.add);
		Button remove = (Button)this.findViewById(R.id.remove);
		
		pOS.setClickable(true);
		String wordToRemove = word.getText().toString();
		if(this.dictionary.contains(new Word(wordToRemove,null,null))) {
			try {
				this.dictionary.remove(new Word(wordToRemove,null,null));
				pOS.setSelection(0);
				pOS.setVisibility(-1);
				definition.setText("");
				definition.setVisibility(-1);
				add.setVisibility(-1);
				pOS.setClickable(true);
				remove.setVisibility(-1);
				word.setText(wordToRemove + " removed successfully!");
				this.saveDictionary();
			} catch (EmptyTreeException e) {
				word.setTextColor(Color.RED);
				word.setText(e.getMessage());
			}
			
		} else {
			word.setTextColor(Color.RED);
			word.setText(wordToRemove + " not found in dictionary");
			pOS.setSelection(0);
			pOS.setVisibility(-1);
			definition.setText("");
			definition.setVisibility(-1);
			add.setVisibility(-1);
			pOS.setClickable(true);
			remove.setVisibility(-1);
		}
	}
	
	public void clearButton(View v) {
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		Button add = (Button)this.findViewById(R.id.add);
		Button remove = (Button)this.findViewById(R.id.remove);
		pOS.setClickable(true);
		remove.setVisibility(-1);
		word.setText("");
		pOS.setSelection(0);
		pOS.setVisibility(-1);
		definition.setText("");
		definition.setVisibility(-1);
		add.setVisibility(-1);
		pOS.setClickable(true);
		word.setTextColor(Color.BLACK);
	}
	
	public void addButton(View v) {
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		Button add = (Button)this.findViewById(R.id.add);
		
		String wordToAdd = word.getText().toString();
		String definitionToAdd = definition.getText().toString();
		pOS.setClickable(true);
		if(wordToAdd.matches("[A-Z]?[a-z A-Z \\- ']*") && definitionToAdd.length() > 0 && pOS.getSelectedItemPosition() > 0) {
			this.dictionary.add(new Word(wordToAdd, pOS.getSelectedItem().toString(), definitionToAdd));
			this.saveDictionary();
			word.setText(wordToAdd + " Added Successfully!");
			word.setSelection(word.getText().length() - 1);
			pOS.setSelection(0);
			pOS.setVisibility(-1);
			definition.setText("");
			definition.setVisibility(-1);
			add.setVisibility(-1);
			pOS.setClickable(true);
			Button remove = (Button)this.findViewById(R.id.remove);
			remove.setVisibility(-1);
		}
	}
	
	public void searchButton(View v) {
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		EditText definition = (EditText)this.findViewById(R.id.definition);
		Spinner pOS = (Spinner)this.findViewById(R.id.pOSSpinner);
		Button add = (Button)this.findViewById(R.id.add);
		Button remove = (Button)this.findViewById(R.id.remove);
		
		Word temp = new Word(word.getText().toString(), "", "");
		
		definition.setVisibility(0);
		pOS.setVisibility(0);
		add.setVisibility(0);
		
		if(this.dictionary.contains(temp)) {
			temp = this.dictionary.containsGet(temp.getWord());
			String part = "";
			int i = 1;
			for(; i < this.partOfSpeech.length && !part.equalsIgnoreCase(this.partOfSpeech[i]); i++, part = this.partOfSpeech[i]);
			pOS.setSelection(i-1);
			definition.setText(temp.getDefinition());
			add.setVisibility(-1);
			pOS.setClickable(false);
			definition.setClickable(false);
			remove.setVisibility(0);
		} else {
			definition.setText("");
			pOS.setSelection(0);
			pOS.setClickable(true);
			definition.setClickable(true);
			remove.setVisibility(-1);
		}
		
	}
	
	private void loadDictionary() {
		AssetManager am = this.getAssets();
		Scanner temp = null;
		ObjectInputStream oIS = null;
		EditText word = (EditText)this.findViewById(R.id.wordBox);
		try {
			InputStream is = am.open("dictionary.txt");
			temp = new Scanner(is);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			oIS = new ObjectInputStream(new FileInputStream(new File("mnt/sdcard/dictionary/dictionary.dat")));
		} catch (StreamCorruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (oIS != null) {
				this.dictionary = (BSTDictionary) oIS.readObject();
				this.dictionary.contains(new Word("help", null, null));
				word.setText((this.dictionary.contains(new Word("help", null, null))) ? "true" : "false");
				oIS.close();
			} else {
				throw new IOException();
			}
		} catch (IOException e) {
			word.setText("gah");
			this.dictionary = new BSTDictionary();
			while(temp.hasNextLine()) {
				String line = temp.nextLine();
				String split[] = line.split("%");
				this.dictionary.add(new Word(split[0], split[1], split[2]));
			}
			temp.close();
			this.saveDictionary();
		} catch (ClassNotFoundException e) {
			this.dictionary = new BSTDictionary();
			while(temp.hasNextLine()) {
				String line = temp.nextLine();
				String split[] = line.split("%");
				this.dictionary.add(new Word(split[0], split[1], split[2]));
			}
			temp.close();
			this.saveDictionary();
		}
		
		//this.saveDictionary();
		
	}
	
	private void saveDictionary() {
		File myDir = new File("mnt/sdcard/dictionary");    
	    myDir.mkdirs();
	    File dictionary = new File(myDir, "dictionary.dat");
	    File dictionary2 = new File(myDir, "dictionary.txt");
	    if(this.dictionary == null) {
	    	return;
//	    	try {
//				throw new Exception("ARH");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	    }
	    
	    try {
			ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(dictionary));
//			FileOutputStream fOS = new FileOutputStream(dictionary2);
//			fOS.write(this.dictionary.toString().getBytes());
//			fOS.flush();
//			fOS.close();
			oOS.writeObject(this.dictionary);
			oOS.flush();
			oOS.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
