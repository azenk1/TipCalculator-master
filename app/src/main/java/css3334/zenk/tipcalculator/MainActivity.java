package css3334.zenk.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Double tip;
        Double tipRate = 0.0;
        Double tipPerPersonAmount;

        if(poorCB.isChecked())
        {
            tipRate = .10;
        }
        else if(goodCB.isChecked())
        {
            tipRate = .15;
        }
        else if(greatCB.isChecked())
        {
            tipRate = .20;
        }

        tip = Double.parseDouble(amountEditText.getText().toString());
        tip = tip * tipRate;
        totalTipTextView.setText("Total Tip: " + tip.toString());


        tipPerPersonAmount = tip / Double.parseDouble(partyEditText.getText().toString());
        tipPersonTextView.setText("Tip per Person: " + tipPerPersonAmount.toString());
    }
}
