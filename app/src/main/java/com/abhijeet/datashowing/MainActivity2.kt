package com.abhijeet.datashowing

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.abhijeet.datashowing.databinding.ActivityMain2Binding
import com.abhijeet.datashowing.databinding.ActivityMainBinding
import com.abhijeet.datashowing.databinding.CustomdialogboxBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:  ActivityMain2Binding
    lateinit var customdialogboxBinding: CustomdialogboxBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnupdate.setOnClickListener {
            var dialogBinding=CustomdialogboxBinding.inflate(layoutInflater)
            var dialog=Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout( WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT)
            dialogBinding.etname2.setText(binding.tvname.text.toString())
            dialogBinding.etemail2.setText(binding.tvEmail.text.toString())
            dialogBinding.etphone2.setText(binding.tvphonenumber.text.toString())
            if(binding.tvGender.text.toString().equals(dialogBinding.rdmale.text.toString())){
                dialogBinding.rdmale.isChecked=true
            }
            else if(binding.tvGender.text.toString().equals(dialogBinding.rdfemale.text.toString())){
                dialogBinding.rdfemale.isChecked=true
            }
            else if(binding.tvGender.text.toString().equals(dialogBinding.rdothers.text.toString()))
            {
                dialogBinding.rdothers.isChecked=true
                dialogBinding.etothers.visibility=View.VISIBLE
                dialogBinding.etothers.setText(binding.tvvariety.text.toString())
            }




            dialogBinding.rdgroup.setOnCheckedChangeListener { radioGroup, id ->
                when(id){
                    R.id.rdothers->{
                        dialogBinding.etothers.visibility=View.VISIBLE
                    }else ->{
                    dialogBinding.etothers.visibility=View.GONE
                }
                }
            }

            dialogBinding.btnupdate2.setOnClickListener {
                if (dialogBinding.etname2.text.toString().isNullOrEmpty()){
//                 Toast.makeText(this, "Enter your Name", Toast.LENGTH_SHORT).show()
                }
                else{
                    binding.tvname.setText(dialogBinding.etname2.text.toString())
                    dialog.dismiss()
                }
                if (dialogBinding.etemail2.text.toString().isNullOrEmpty()){
//                    Toast.makeText(this, "Enter your  Email", Toast.LENGTH_SHORT).show()
                }
                else{
                    binding.tvEmail.setText(dialogBinding. etemail2.text.toString())
                    dialog.dismiss()
                }
                if (dialogBinding.etphone2.text.toString().isNullOrEmpty()){
//                 Toast.makeText(this, "Enter your  Email", Toast.LENGTH_SHORT).show()
                }
                else{
                    binding. tvphonenumber.setText(dialogBinding.etphone2.text.toString())
                    dialog.dismiss()
                }
                if (dialogBinding.rdmale.isChecked){
                        binding.tvGender.setText(dialogBinding.rdmale.text.toString())
                        dialog.dismiss()

                    }
                else if (dialogBinding.rdfemale.isChecked){
                    binding.tvGender.setText(dialogBinding.rdfemale.text.toString())
                    dialog.dismiss()
                }
                 else {
                    binding.tvGender.setText(dialogBinding.rdothers.text.toString())
                    binding.tvvariety.setText((dialogBinding.etothers.text.toString()))
                    dialog.dismiss()
                }
                dialogBinding.selectcalender.setOnClickListener {
                    dialogBinding.datepicker.visibility=View.VISIBLE
//                    dialogBinding.enterdate.setText(dialogBinding.datepicker.dayOfMonth.toString(),dialogBinding.datepicker.month.toString(),dialogBinding.datepicker.year.toString())
                }

            }
            dialog.show()
        }
    }
}