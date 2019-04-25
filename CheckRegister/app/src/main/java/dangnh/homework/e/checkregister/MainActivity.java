package dangnh.homework.e.checkregister;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtFirstName;
    EditText edtLastName;
    RadioGroup radioGroup;
    EditText edtBirthday;
    Button btnSelectBirthday;
    EditText edtAddress;
    EditText edtEmail;
    CheckBox checkTerm;
    Button btnRegister;

    //Inner static class to show date picker
    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        EditText edt;

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            edt = (EditText) getActivity().findViewById(R.id.birthday);
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            edt.setText(format.format(new Date(year - 1900, month, day)));
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtFirstName = (EditText) findViewById(R.id.edtfirstname);
        edtLastName = (EditText) findViewById(R.id.edtlastname);
        radioGroup = (RadioGroup) findViewById(R.id.gender);
        edtBirthday = (EditText) findViewById(R.id.birthday);
        btnSelectBirthday = (Button) findViewById(R.id.selectbirthday);
        edtAddress = (EditText) findViewById(R.id.address);
        edtEmail = (EditText) findViewById(R.id.email);
        checkTerm = (CheckBox) findViewById(R.id.agree);
        btnRegister = (Button) findViewById(R.id.register);
        btnSelectBirthday.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //if user enter select birthday, show a date picker dialog
        if (view.getId() == btnSelectBirthday.getId()) {
            DialogFragment newFragment = new DatePickerFragment();
            newFragment.show(getSupportFragmentManager(), "Select your birthday");
        }
        //if user click button Register, check whether the infomation provided
        //if any is missing or invalid, show a toast msg to warning
        else if (view.getId() == btnRegister.getId()) {
            //Check if user entered firstname
            String firstname = edtFirstName.getText().toString().replaceAll("\\s", "");
            if (firstname.isEmpty()) {
                Toast.makeText(this, "Please enter your firstname!", Toast.LENGTH_SHORT).show();
                return;
            }
            char[] firstname_arr = firstname.toCharArray();
            for (char c : firstname_arr) {
                if (!Character.isLetter(c) && c != ' ') {
                    Toast.makeText(this, "Invalid Firstname!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            //Check if user entered lastname
            String lastname = edtLastName.getText().toString().replaceAll("\\s", "");
            if (lastname.isEmpty()) {
                Toast.makeText(this, "Please enter your lastname!", Toast.LENGTH_SHORT).show();
                return;
            }
            char[] lastname_arr = lastname.toCharArray();
            for (char c : lastname_arr) {
                if (!Character.isLetter(c) && c != ' ') {
                    Toast.makeText(this, "Invalid Lastname!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
            //Check the gender
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Please choose your Gender!", Toast.LENGTH_SHORT).show();
                return;
            }
            //Check the birthday
            String birthday = edtBirthday.getText().toString().replaceAll("\\s", "");
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            if (dateFormat.parse(birthday, new ParsePosition(0)) == null) {
                Toast.makeText(this, "Invalid Birthday!", Toast.LENGTH_SHORT).show();
                return;
            }
            //Check the address
            if (edtAddress.getText().toString().replaceAll("\\s", "").isEmpty()) {
                Toast.makeText(this, "Please enter your Address!", Toast.LENGTH_SHORT).show();
                return;
            }
            //Check the email
            String email = edtEmail.getText().toString();
            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show();
            }
            int idx = email.indexOf("@");
            if (email.contains("\\s") || idx < 1 || idx > email.length() - 2) {
                Toast.makeText(this, "Invalid Email!", Toast.LENGTH_SHORT).show();
                return;
            }
            //Check the terms of use
            if (!checkTerm.isChecked()) {
                Toast.makeText(this, "You have not accepted the Terms of Use! ", Toast.LENGTH_SHORT).show();
                return;
            }
            Toast.makeText(this, "REGISTER SUCCESSFULLY!", Toast.LENGTH_LONG).show();
        }
    }
}
