package com.example.num_social.feature.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.num_social.R
import com.example.num_social.core.ui.theme.BlueText
import com.example.num_social.core.ui.theme.FbColor
import com.example.num_social.core.ui.theme.GreyText

@Composable
fun RegisterScreen(navigateToLogin: () -> Unit){
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    Box(
        modifier =
            Modifier
                .fillMaxSize()
                .imePadding()
                .background(color = Color.White)
                .systemBarsPadding()
        ,
    ){
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.8f),
        ){
            // User name
            Column {
                Text(text = "Your Name", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = username,
                    onValueChange = { username = it },
                    placeholder = {
                        Text(
                            text = "user name",
                            color = GreyText
                        )},
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor =  GreyText,
                            focusedBorderColor = GreyText
                        ),
                    shape = RoundedCornerShape(12.dp),
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            // Email
            Column {
                Text(text = "Your Email", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = {email = it},
                    placeholder = {
                        Text(
                            text = "example@gmail.com",
                            color = GreyText
                        )},
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor =  GreyText,
                            focusedBorderColor = GreyText
                        ),
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            // Password
            Column {
                Text(text = "Password", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = {password = it},
                    placeholder = {
                        Text(
                            text = "password",
                            color = GreyText
                        )},
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults
                        .colors(
                            unfocusedBorderColor =  GreyText,
                            focusedBorderColor = GreyText
                        ),
                    shape = RoundedCornerShape(12.dp),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (isShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val eyeIcon = if (isShowPassword) R.drawable.open_eye  else R.drawable.eye
                        IconButton(
                            onClick = {
                                isShowPassword = !isShowPassword
                            }
                        ){
                            Icon(
                                painter = painterResource(id = eyeIcon),
                                contentDescription = "Password Icon",
                                tint = GreyText
                            )
                        }

                    }
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            //Login Button
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueText
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = "Register",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            // OAuth
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.7f),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.height(2.dp).weight(1f).background(color = GreyText))
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "Or", color = GreyText)
                    Spacer(modifier = Modifier.width(16.dp))
                    Spacer(modifier = Modifier.height(2.dp).weight(1f).background(color = GreyText))
                }
            }
            // OAuth Login Options
            // login with facebook
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    //login with fb
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(2.dp, GreyText)
            )
            {
                Row(
                    modifier = Modifier.padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        imageVector = Icons.Filled.Facebook,
                        tint = FbColor,
                        contentDescription = null, modifier = Modifier.size(30.dp))
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Continue with Facebook",
                        color = Color.Black, fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold)
                }
            }

            //login with google
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    //login with google
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(2.dp, GreyText)
            )
            {
                Row(
                    modifier = Modifier.padding(vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        painter = painterResource(id = R.drawable.google_logo),
                        contentDescription = null, modifier = Modifier.size(30.dp))
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = "Continue with Google",
                        color = Color.Black, fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold)
                }
            }
            // To register
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(text = "Already have an account? ",color = GreyText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                Text(text = "Login", color = BlueText, fontSize = 12.sp, fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.clickable(
                        onClick = {
                            // navigate to login screen
                            navigateToLogin()
                        },
                        indication = null,
                        interactionSource = interactionSource
                    )
                )
            }
        }
    }
}