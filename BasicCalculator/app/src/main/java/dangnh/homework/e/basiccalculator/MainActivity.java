package dangnh.homework.e.basiccalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView txtDisplay;
    Button btnCE;
    Button btnC;
    Button btnBS;
    Button btnDivide;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnMulti;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btnSub;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btnPlus;
    Button btnSign;
    Button btn0;
    Button btnPoint;
    Button btnEqual;
    /*
     flag indicate whether the screen will be clear or not
     after user press "=" to receive the result, this flag switch to true
     the next time user press a digit, the screen will clear for a new expression.
     if user press a operator(+,-,/,..), the screen will not clear, continuously
     append to the end of the expression
     */
    private boolean reset_flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCE = (Button) findViewById(R.id.btnCE);
        btnC = (Button) findViewById(R.id.btnC);
        btnBS = (Button) findViewById(R.id.btnBS);
        btnDivide = (Button) findViewById(R.id.btnDivide);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnMulti = (Button) findViewById(R.id.btnMulti);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btnSub = (Button) findViewById(R.id.btnSub);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnSign = (Button) findViewById(R.id.btnSign);
        btn0 = (Button) findViewById(R.id.btn0);
        btnPoint = (Button) findViewById(R.id.btnPoint);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        txtDisplay = (TextView) findViewById(R.id.txtDisplay);
        txtDisplay.

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnSign.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        txtDisplay.setTextColor("#FF0000");
        txtDisplay.setTextSize("18");
    }

    @Override
    public void onClick(View view) {
        //onClick handler for digit button(0 to 9)
        if (view.getId() == btn0.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
                txtDisplay.setTex
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("0");
        } else if (view.getId() == btn1.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("1");
        } else if (view.getId() == btn2.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("2");
        } else if (view.getId() == btn3.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("3");
        } else if (view.getId() == btn4.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("4");
        } else if (view.getId() == btn5.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("5");
        } else if (view.getId() == btn6.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("6");
        } else if (view.getId() == btn7.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("7");
        } else if (view.getId() == btn8.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("8");
        } else if (view.getId() == btn9.getId()) {
            if (reset_flag) {
                txtDisplay.setText("");
                reset_flag = false;
            }
            if (txtDisplay.getText().toString().equals("0")) txtDisplay.setText("");
            txtDisplay.append("9");
        }
        //if user presses "C" button, clear all content on screen
        else if (view.getId() == btnC.getId()) {
            txtDisplay.setText("0");
        }
        //if user presses "BS" button, backspace 1 character in the expression
        else if (view.getId() == btnBS.getId()) {
            String str = txtDisplay.getText().toString();
            if (!str.equals("0"))
                txtDisplay.setText(str.substring(0, str.length() - 1));
        }
        //if user presses "CE" button, clear one element from the expression
        //element can be either an operand or an operator
        else if (view.getId() == btnCE.getId()) {
            String str = txtDisplay.getText().toString();
            int operator_index = -1;
            if (str.contains("+")) operator_index = str.indexOf("+");
            else if (str.contains("−")) operator_index = str.indexOf("−");
            else if (str.contains("/")) operator_index = str.indexOf("/");
            else if (str.contains("×")) operator_index = str.indexOf("×");
            else {
            }
            if (operator_index == -1) {
                txtDisplay.setText("0");
            } else if (operator_index == str.length() - 1) {
                txtDisplay.setText(str.substring(0, str.length() - 1));
            } else txtDisplay.setText(str.substring(0, operator_index + 1));
        }
        //if add a point character for floating point number representation
        //one operand can contain maximum 1 point character "."
        else if (view.getId() == btnPoint.getId()) {
            if (reset_flag) {
                txtDisplay.setText("0");
                reset_flag = false;
            }
            String str = txtDisplay.getText().toString();
            int operator_index = -1;
            if (str.contains("+")) operator_index = str.indexOf("+");
            else if (str.contains("−")) operator_index = str.indexOf("−");
            else if (str.contains("/")) operator_index = str.indexOf("/");
            else if (str.contains("×")) operator_index = str.indexOf("×");
            else {
            }
            if (operator_index == -1 && !str.contains("."))
                txtDisplay.append(".");
            if (operator_index != -1 && !txtDisplay.getText().toString().substring(operator_index).contains(".")) {
                txtDisplay.append(".");
            }
        }
        //Operator for calculating
        //One expression contains maximum one operator
        else if (view.getId() == btnDivide.getId()) {
            if (reset_flag) reset_flag = false;
            String str = txtDisplay.getText().toString();
            if (!(str.contains("+") || str.contains("−") || str.contains("×") || str.contains("/"))) {
                txtDisplay.append("/");
            }
        } else if (view.getId() == btnMulti.getId()) {
            if (reset_flag) reset_flag = false;
            String str = txtDisplay.getText().toString();
            if (!(str.contains("+") || str.contains("−") || str.contains("×") || str.contains("/"))) {
                txtDisplay.append("×");
            }
        } else if (view.getId() == btnSub.getId()) {
            if (reset_flag) reset_flag = false;
            String str = txtDisplay.getText().toString();
            if (!(str.contains("+") || str.contains("−") || str.contains("×") || str.contains("/"))) {
                txtDisplay.append("−");
            }
        } else if (view.getId() == btnPlus.getId()) {
            if (reset_flag) reset_flag = false;
            String str = txtDisplay.getText().toString();
            if (!(str.contains("+") || str.contains("−") || str.contains("×") || str.contains("/"))) {
                txtDisplay.append("+");
            }
        }
        //If user presses "+/-" button, switch the sign of the current operand
        else if (view.getId() == btnSign.getId()) {
            if (reset_flag) reset_flag = false;
            String str = txtDisplay.getText().toString();
            int operator_index = -1;
            if (str.contains("+")) operator_index = str.indexOf("+");
            else if (str.contains("−")) operator_index = str.indexOf("−");
            else if (str.contains("/")) operator_index = str.indexOf("/");
            else if (str.contains("×")) operator_index = str.indexOf("×");
            else {
            }
            if (operator_index == -1) {
                if (str.charAt(0) == '-') txtDisplay.setText(str.substring(1));
                else txtDisplay.setText("-" + str);
            } else {
                if (operator_index == str.length() - 1) txtDisplay.append("-");
                else if (str.charAt(operator_index + 1) == '-')
                    txtDisplay.setText(str.substring(0, operator_index + 1)
                            + str.substring(operator_index + 2));
                else
                    txtDisplay.setText(str.substring(0, operator_index + 1) + "-" + str.substring(operator_index + 1));
            }
        }
        //Calculating the result when user press "=" button
        else if (view.getId() == btnEqual.getId()) {
            String str = txtDisplay.getText().toString();
            int operator_index = -1;
            if (str.contains("+")) operator_index = str.indexOf("+");
            else if (str.contains("−")) operator_index = str.indexOf("−");
            else if (str.contains("/")) operator_index = str.indexOf("/");
            else if (str.contains("×")) operator_index = str.indexOf("×");
            else {
            }
            if (operator_index != -1) {
                try {
                    double operand1 = Double.parseDouble(str.substring(0, operator_index));
                    char operator = str.charAt(operator_index);
                    double operand2 = Double.pars
                    ,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,eDouble(str.substring(operator_index + 1));
                    txtDisplay.setText(Double.toString(calculateResult(operand1, operand2, operator)));
                    reset_flag = true;
                } catch (NullPointerException | NumberFormatException e) {
                    Toast.makeText(this, "SYNTAX ERROR", Toast.LENGTH_SHORT).show();
                } catch (ArithmeticException e) {
                    Toast.makeText(this, "ERROR: DIVIDE BY 0", Toast.LENGTH_SHORT).show();
                }
            } else {
                txtDisplay.setText(Double.toString(Double.parseDouble(str)));
                reset_flag = true;
            }

    /**
     * @param operand1
     * @param operand2
     * @param operator
     * @return result of the expression <operand1><operator><operand2>
     * @throws ArithmeticException
     */
    public double calculateResult(double operand1, double operand2, char operator)
            throws ArithmeticException {
        switch (operator) {
            case '−':
                return operand1 - operand2;
            case '+':
                return operand1 + operand2;
            case '×':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("ERROR: DIVIDE BY ZERO");
                } else return operand1 / operand2;
            default:
                throw new ArithmeticException();
        }
    }
}
