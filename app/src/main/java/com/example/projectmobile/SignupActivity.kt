package com.example.projectmobile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.SpinnerAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectmobile.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        Spinner content
        val countries = arrayOf("Nepal","China","India","Bhutan","USA","Sri Lanka","Croatia","France","Spain","Brazil")
        val spinnerAdapter= ArrayAdapter(this@SignupActivity,android.R.layout.simple_list_item_1,countries)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1)
        binding.spinner.adapter=spinnerAdapter

//        Auto complete text View
        val cities = arrayOf("Kathmandu","Bhaktapur","Lalitpur","Dhading","Hetauda")
        val autoCompleteAdapter= ArrayAdapter(this@SignupActivity,android.R.layout.simple_dropdown_item_1line,cities)
        binding.autoCompleteTextView.setAdapter(autoCompleteAdapter)
        binding.autoCompleteTextView.threshold=1

//        Button
        binding.button.setOnClickListener{
            val name: String = binding.usernameText.text.toString()
            val email: String = binding.emailText.text.toString()
            val password: String = binding.passwordText.text.toString()
            val selectedGenderId = binding.genderbtn.checkedRadioButtonId
            val gender = if (selectedGenderId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedGenderId)
                selectedRadioButton.text.toString()
            } else {
                null
            }
            val countriesSpinner: String = binding.spinner.selectedItem.toString()
            val citiesAutoComplete: String = binding.autoCompleteTextView.text.toString()
            val checkbox = binding.agreeCheckBox.isChecked

            if(name.isEmpty()){
                binding.usernameText.error="Fill up the details"
            }else if(email.isEmpty()){
                binding.emailText.error="Fill up the details"
            }else if(password.isEmpty()){
                binding.passwordText.error="Enter ur passcode"
            }else if(!checkbox){
                Toast.makeText(this@SignupActivity,"Click on agree",Toast.LENGTH_LONG).show()
            }else{
                val intent= Intent(this@SignupActivity,DashboardActivity::class.java).apply {
                    putExtra("name",name)
                    putExtra("email",email)
                    putExtra("gender",gender)
                    putExtra("country",countriesSpinner)
                    putExtra("city",citiesAutoComplete)
                }
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}