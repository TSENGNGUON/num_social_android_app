package com.example.num_social.feature.auth.forgot_password

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.num_social.R
import com.example.num_social.core.ui.theme.BlueText
import com.example.num_social.core.ui.theme.GreyText
import com.example.num_social.core.util.common.OtpInput

@Composable
fun ForgotPasswordScreen(
    popBackStack: () -> Unit,
    toResetPassword: (String) -> Unit
)
{
    var email by remember { mutableStateOf("")}
    val isEnter = email.isNotEmpty()
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .background(color = Color.White)
    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
        ){
            Box(
                modifier = Modifier
                    .clickable(
                        onClick = {popBackStack()},
                        indication = null,
                        interactionSource = interactionSource
                    )
                    .background(color = GreyText, shape = RoundedCornerShape(500.dp)
                    ),
                contentAlignment = Alignment.Center,
            ){
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier.padding(all = 16.dp).size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Forgot password",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(18.dp))
            // Sub title
            Text(text = "Enter your email for reset your password",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = GreyText
            )

            Spacer(modifier = Modifier.height(25.dp))
            // Email
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Your Email", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = email,
                    onValueChange = {email = it},
                    placeholder = {
                        Text(
                            text = "Enter your email",
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

            //Login Button
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    toResetPassword(email)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueText
                ),
                shape = RoundedCornerShape(12.dp),
                enabled = isEnter
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = "Reset Password",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }



            }

        }
}



// Verify OTP or Check Email
@Composable
fun ResetPasswordScreen(
    popBackStack: () -> Unit,
    toSetNewPassword: () -> Unit,
    email: String
){
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .background(color = Color.White)

    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
        ){
            Box(
                modifier = Modifier
                    .clickable(
                        onClick = {popBackStack()},
                        indication = null,
                        interactionSource = interactionSource
                    )
                    .background(color = GreyText, shape = RoundedCornerShape(500.dp)
                    ),
                contentAlignment = Alignment.Center,
            ){
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier.padding(all = 16.dp).size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Check your email",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(18.dp))
            // Sub title
            Text(text = "We sent a reset link to $email enter 5 digit code that mentioned in the email",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = GreyText
            )

            Spacer(modifier = Modifier.height(25.dp))
            // Email
            Column(modifier = Modifier.fillMaxWidth()) {
                // Enter OTP Code

            }

            OtpInput()

            //Verify Button
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    toSetNewPassword()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueText
                ),
                shape = RoundedCornerShape(12.dp),
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = "Verify Code",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = GreyText,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                    ){
                        append(
                            "Haven't got the email yet? ",
                        )
                    }

                    withStyle(
                        style = SpanStyle(
                            color = BlueText,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp
                        )
                    ){
                        Row(modifier = Modifier.clickable(onClick = {
                            // Resend email logic
                            Log.d("Click", "The Resend button is clicked!!!")
                        })){
                            append("Resend email")
                        }
                    }

                }
            )



        }

    }
}

// Set New Password Screen

@Composable
fun SetNewPasswordScreen(
    popBackStack: () -> Unit,
    toLoginScreen: () -> Unit
){
    val interactionSource = remember { MutableInteractionSource() }
    // State for password
    var password by remember { mutableStateOf("") }
    var isShowPassword by remember { mutableStateOf(false) }
    // confirm Password state
    var isShowCfPassword by remember { mutableStateOf(false) }
    var confirmPassword by remember { mutableStateOf("") }
    // Check Update Password Button is not empty or not
    val isCfPasswordEmpty =
        confirmPassword.isNotEmpty()
            && password.isNotEmpty()
            && password == confirmPassword

    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .systemBarsPadding()
                .background(color = Color.White)

    ) {
        Column(
            modifier = Modifier
                .padding(24.dp),
        ){
            Box(
                modifier = Modifier
                    .clickable(
                        onClick = {popBackStack()},
                        indication = null,
                        interactionSource = interactionSource
                    )
                    .background(color = GreyText, shape = RoundedCornerShape(500.dp)
                    ),
                contentAlignment = Alignment.Center,
            ){
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = null,
                    modifier = Modifier.padding(all = 16.dp).size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Set New Password",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(18.dp))
            // Sub title
            Text(text = "Create a new password. Ensure it differs from previous ones for security",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = GreyText
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Password
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Password", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = password,
                    onValueChange = {password = it},
                    placeholder = {
                        Text(
                            text = "Enter your new password",
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
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Confirm Password", fontSize = 16.sp, fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = confirmPassword,
                    onValueChange = {confirmPassword = it},
                    placeholder = {
                        Text(
                            text = "Re-enter password",
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
                    visualTransformation = if (isShowCfPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val eyeIcon = if (isShowCfPassword) R.drawable.open_eye  else R.drawable.eye
                        IconButton(
                            onClick = {
                                isShowCfPassword = !isShowCfPassword
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

            //Update Password Button
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    toLoginScreen()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueText
                ),
                shape = RoundedCornerShape(12.dp),
                enabled = isCfPasswordEmpty
            ) {
                Text(
                    modifier = Modifier.padding(vertical = 14.dp),
                    text = "Update Password",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}