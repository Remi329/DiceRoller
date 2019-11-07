package com.example.diceroller;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;//These will have to be imported if the ativity is empty initially
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    public static String EXTRA_MESSAGE;
    public static ArrayList<String> stringArrayList = new ArrayList<String>();
    //Created variables here instead of in the method so that it wouldnt mess with the rest of the program
    TextView tv, message, counter;
    EditText input;
    Button b1;
    int count = 0;
    TextView questionGenerated;
    int RandomNoGenerated = -1;//lets computer know no value has been drawn



    //EditText editText;

    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class);//Intent takes 2 parameters Context and Class The DisplayMessage is the class that shows the new creen
        //Context is used because aActivity is a subclass of Context
        startActivity(intent);//opens the activity The startActivity() method starts an instance of the DisplayMessageActivity that's specified by the Intent
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {//acts as the mains string args on here

        if (stringArrayList!=null && stringArrayList.size()==0) {//This will stop the arraylist from adding the questions already in the array list twice
            InitializeArray();
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv = findViewById(R.id.number);
        b1 = findViewById(R.id.rollbutton);
        input = findViewById(R.id.userinput);
        message = findViewById(R.id.Message);
        counter = findViewById(R.id.points);
        questionGenerated = findViewById(R.id.Qgenerated);



       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void InitializeArray(){
        stringArrayList.add("If you could go anywhere in the world, where would you go?");
        stringArrayList.add("If you were stranded on a desert island, what three things would you want to take with you?");
        stringArrayList.add("If you could eat only one food for the rest of your life, what would that be?");
        stringArrayList.add("If you won a million dollars, what is the first thing you would buy?");
        stringArrayList.add("If you could spend the day with one fictional character, who would it be?");
        stringArrayList.add("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
    }

    public void on_button_click(View view){

        Random r = new Random();
        int number = r.nextInt(7-1)+1;//generates any random number between the bounds inclusive of 1
        RandomNoGenerated = number;
        tv.setText(Integer.toString(number));// when outputting a number you always have to convert it to string

        if(input.getText().toString().equals(tv.getText().toString())){
            message.setText("Congratulations");
            Toast.makeText(MainActivity.this, "Congratulations", LENGTH_SHORT).show();//pops up message
            count++;
            counter.setText(Integer.toString(count));//count is incremented and set to display the incremented score/count
        }
        else {
            message.setText("Wrong");
        }
    }

    public void on_button_click1(View view){
        Random r = new Random();
        String random = stringArrayList.get(r.nextInt(stringArrayList.size()));//selects a random index within the arraysize
        int arrayNum = stringArrayList.indexOf(random)+1;//this d]goes to the index generated by the random variable
        questionGenerated.setText(random);//displays the question in the arraylist
        tv.setText(Integer.toString(arrayNum));//This is connected to the view that displays rolled number

    }


    //Useful code
        //        Collections.shuffle(stringArrayList);//shuffles the elements in the array
        //       if(RandomNoGenerated != -1)
        //     questionGenerated.setText((stringArrayList.get(RandomNoGenerated)));
     //  if(NewIcebreakerInput.getText().toString().isEmpty()){


//        else {
//           // NewIcebreakerInput.getText().toString();
//            stringArrayList.add(NewIcebreakerInput.getText().toString());
//        }

        // Log.d(TAG, "on_button_click1: " + Collections.shuffle(stringArrayList));
        /* srting.setText((CharSequence) stringArrayList);
        Toast.makeText(MainActivity.this, (CharSequence) stringArrayList, LENGTH_SHORT);*/

        //ArrayList to randomise the elements in array list
     /*  Random ArrayRand = new Random();
       for (int i = 0; i<stringArrayList.size(); i++){
            int Rindex = ArrayRand.nextInt(stringArrayList.size());
            String temp = stringArrayList.get(i);
           stringArrayList.get(i) = stringArrayList.get(Rindex);
            stringArrayList.get(Rindex) = temp;
           // myTextView.append(stringArrayList.get(i));
       }
       System.out.println(stringArrayList.get(i));*/


    /*  arr[0] = "If you could go anywhere in the world, where would you go?";
       arr[1] = "If you were stranded on a desert island, what three things would you want to take with you?";
       arr[2] = "If you could have any food in the world what would it be";
       arr[3] = "If you won a million dollars, what is the first thing you would buy?";
       arr[4] = "If you could spend the day with one fictional character, who would it be?";
       arr[5] = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";

       Random ArrayRand = new Random();

       for(int i = 0; i<arr.length; i++){
           int Rindex = ArrayRand.nextInt(arr.length);
           String temp = arr[i];
           arr[i] = arr[Rindex];
           arr[Rindex] = temp;
           myTextView.append(arr[i]);
       }
       message.setText(arr);*/


        //displays text without an array
        /*message.setText("If you could have any food in the world what would it be");
        Toast.makeText(MainActivity.this, "If you could have any food in the world what would it be", LENGTH_SHORT).show();*/





    public void on_button_click2(View view){


    }


}
