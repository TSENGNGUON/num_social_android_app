package com.example.num_social.core.util.common

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.autofill.ContentType
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentType
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.num_social.core.ui.theme.BlueText
import com.example.num_social.core.ui.theme.GreyText

@Composable
fun OtpInput(){
    val otpState = rememberTextFieldState()
    BasicTextField(
        state = otpState,
        modifier = Modifier.semantics{
            contentType = ContentType.SmsOtpCode
        },
        inputTransformation = InputTransformation.maxLength(6),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        lineLimits = TextFieldLineLimits.SingleLine,
        decorator = {innerTextField ->
            val otpText = otpState.text.toString()
            Log.d("length", "${otpText.length}")
            val currentLength = otpText.length - 1
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                repeat(6){ index ->
                    val char = otpText.getOrElse(index) { ' ' }
                    val isFilled = index < currentLength
                    val isNext  = index == currentLength
                    val highlight = isFilled || isNext

                    Digit(
                        number = char,
                        isHighlighted = highlight
                    )

                }
            }


        }
    )
}


// Digit
@Composable
fun Digit(
    number: Char,
    isHighlighted: Boolean,
){

    val borderColor by animateColorAsState(
        targetValue = if (isHighlighted) BlueText else GreyText
    )
    val borderWidth by animateDpAsState(
        targetValue = if (isHighlighted) 2.dp else 1.dp
    )


    Box(
        modifier = Modifier
            .size(48.dp)
            .border(borderWidth, borderColor, RoundedCornerShape(12.dp))
            .background(Color.White, RoundedCornerShape(12.dp))
    ){
        Text(
            text = number.toString(),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}