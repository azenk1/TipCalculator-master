package css3334.zenk.tipcalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare component variables.
    TextView titleTextView;
    TextView billTextView;
    EditText amountEditText;
    TextView partyTextView;
    EditText partyEditText;
    Button calculateButton;
    TextView totalTipTextView;
    TextView tipPersonTextView;
    CheckBox poorCB;
    CheckBox goodCB;
    CheckBox greatCB;

    //Parameters for toast to handle null text for bill amount.
    Context amountContext;
    CharSequence amountText;
    int amountDuration;

    //Toast for empty bill amount
    Toast amountToast;

    //@params for empty per person
    Context perPersonContext;
    CharSequence perPersonText;
    int perPersonDuration;

    //Toast for empty per person
    Toast perPersonToast;

    //Parameters for toast displaying tip percent
    Context percentContext;
    CharSequence percentText;
    int percentDuration;

    //Toast for percent
     Toast percentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing parameters for amountToast
        amountContext = getApplicationContext();
        amountText = "Please enter an amount for the bill.";
        amountDuration = Toast.LENGTH_SHORT;

        //call to makeText to create toast for null text for bill amount
        amountToast = Toast.makeText(amountContext, amountText, amountDuration);

        //Initializing params for per person
        perPersonContext = getApplicationContext();
        perPersonText = "Enter number greater than one in party for tip amount per person";
        perPersonDuration = Toast.LENGTH_SHORT;

        //call to makeText for null per person field
        perPersonToast = Toast.makeText(perPersonContext, perPersonText, perPersonDuration);


        //Initializing params for percent toast
        percentContext = getApplicationContext();
        percentText = " ";
        percentDuration = Toast.LENGTH_SHORT;




        //Initialize component variables
        titleTextView = (TextView)findViewById(R.id.tipTextView);
        billTextView = (TextView)findViewById(R.id.billAmountTextView);
        amountEditText = (EditText)findViewById(R.id.billAmountNumberEditText);
        partyTextView = (TextView)findViewById(R.id.numberInPartyTextView);
        partyEditText = (EditText)findViewById(R.id.numberInPartyNumberEditText);
        calculateButton = (Button)findViewById(R.id.calculateButton);
        totalTipTextView = (TextView)findViewById(R.id.totalTipTextView);
        tipPersonTextView = (TextView)findViewById(R.id.tipPerPersonTextView);
        poorCB = (CheckBox) findViewById(R.id.poorCheckBox);
        goodCB = (CheckBox) findViewById(R.id.goodCheckBox);
        greatCB = (CheckBox) findViewById(R.id.greatCheckBox);

    }

    public void calculateClick(View view)
    {
        Double tip = 0.0;
        Double tipRate = 0.0;
        Double tipPerPersonAmount;


        if(poorCB.isChecked())
        {
            tipRate = .10;

            //Uncheck other boxes.
            goodCB.setChecked(false);
            greatCB.setChecked(false);

        }
        else if(goodCB.isChecked())
        {
            tipRate = .15;

            //Uncheck other boxes
            greatCB.setChecked(false);

        }
        else if(greatCB.isChecked())
        {
            tipRate = .20;


        }

        //CharSequence is set and makeText is called now that CharSequence has been correctly set.
        percentText = "Tip Percent: " + Double.toString(tipRate * 100);

        percentToast = Toast.makeText(percentContext, percentText, percentDuration);


        if(TextUtils.isEmpty(amountEditText.getText().toString()))
        {
            amountToast.show();
        }
        else
        {
            tip = Double.parseDouble(amountEditText.getText().toString());
            tip = tip * tipRate;

            percentToast.show();

        }
        totalTipTextView.setText(String.format("Total Tip: $%.2f", tip));

        if(TextUtils.isEmpty(partyEditText.getText().toString()) || Integer.parseInt(partyEditText.getText().toString()) < 2)
        {
            perPersonToast.show();

        }
        else
        {
            tipPerPersonAmount = tip / Double.parseDouble(partyEditText.getText().toString());
            tipPersonTextView.setText(String.format("Tip per Person: $%.2f", tipPerPersonAmount));

        }



    }
}
