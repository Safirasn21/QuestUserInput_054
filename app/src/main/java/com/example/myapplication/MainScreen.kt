package com.example.myapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
){
    var nama by rememberSaveable { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var noHp by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("") }
    
    val jenisKelamin = listOf("Laki-Laki", "Perempuan")
    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by remember { mutableStateOf("") }
    var alamatUser by remember { mutableStateOf("") }
    var noHpUser by remember { mutableStateOf("") }
    var selectedGenderUser by remember { mutableStateOf("") }
    
    Column (
        Modifier
            .fillMaxSize()
            .padding(16.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = nama,
            onValueChange = {nama = it},
            placeholder = { Text(text = "Masukkan nama lengkap anda: ")},
            label = { Text(text = "Nama")},
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp))
        Row (){
            jenisKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = selectedGender == item,
                        onClick = {
                        selectedGender = item
                        })
                    Text(item)
                }
            }
        }

        OutlinedTextField(value = email,
            onValueChange = {email = it},
            placeholder = { Text(text = "Masukkan Email anda: ")},
            label = { Text(text = "Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp))

        OutlinedTextField(value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text(text = "Masukkan Alamat lengkap anda: ")},
            label = { Text(text = "Alamat")},
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp))

        OutlinedTextField(value = noHp,
            onValueChange = {noHp = it},
            placeholder = { Text(text = "Masukkan nomor HP anda: ")},
            label = { Text(text = "Nomor HP")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp))


        Button(onClick = {
            namaUser = nama
            emailUser = email
            alamatUser = alamat
            noHpUser = noHp
            selectedGenderUser = selectedGender
        }) { Text(text = "Save")}

        Card (modifier.size(height = 50.dp, width = 100.dp)){
            CardSection(judulParam = "Nama", isiParam = namaUser)
            CardSection(judulParam = "Email", isiParam = emailUser)
            CardSection(judulParam = "Alamat", isiParam = alamatUser)
            CardSection(judulParam = "No Hp", isiParam = noHpUser)
            CardSection(judulParam = "Gender", isiParam = selectedGenderUser)
        }
    }
}

@Composable
fun CardSection(judulParam: String, isiParam:String){
    Column (){
        Row (modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
          Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = " = ", modifier = Modifier.weight(0.2f))
            Text(text = "$isiParam",
                modifier = Modifier.weight(2f))
        }
    }
}