package iam.example.socialservice.ui.screens.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import iam.example.socialservice.R
import iam.example.socialservice.Screen
import iam.example.socialservice.ui.theme.GrayPrimary
import iam.example.socialservice.ui.theme.Primary

@Composable
fun ChoseMethodScreen(
    navController: NavHostController,
){

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(it)
                .padding(horizontal = 15.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.signin_illustration_1),
                        contentDescription = null
                    )
                    Text(
                        text = "Let's you in", style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold
                    )
                }
            }
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                SSOButton(icon = painterResource(id = R.drawable.facebook_logo), text = "Continue with Facebook"){}
                Spacer(modifier = Modifier.height(16.dp))
                SSOButton(icon = painterResource(id = R.drawable.google_logo), text = "Continue with Google"){}
                Spacer(modifier = Modifier.height(16.dp))
                SSOButton(icon = painterResource(id = R.drawable.apple_logo), text = "Continue with Apple"){}
                Spacer(modifier = Modifier.height(32.dp))
                SeparatorWithText(text = "Or")
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .sizeIn(minHeight = 50.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Sign in with password")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Don't have an account?", style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.5.sp,
                        color = GrayPrimary
                    ))
                    Text(text = "Sign Up", style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 0.5.sp,
                        color = Primary
                    ),
                        modifier = Modifier.clickable {
                            navController.navigate(Screen.InputEmailScreen.route)
                        }
                    )
                }
            }
        }
    }

}

@Composable
fun SSOButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    text: String,
    onClick: () -> Unit
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.sizeIn(minHeight = 50.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painter = icon, contentDescription = "button icon", tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between icon and text
            Text(text = text, color = Color.Black)
        }
    }
}

@Composable
fun SeparatorWithText(
    modifier: Modifier = Modifier,
    text: String,
    lineColor: Color = Color.LightGray,
    textColor: Color = Color.Black,
    lineHeight: Dp = 1.dp
) {
    Box(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(lineHeight)
                .background(lineColor)
        ) {
        }

        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.Center)
                .offset(y = -10.dp) // Move text below line center
                .background(Color.White)
                .padding(horizontal = 5.dp),
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            color = textColor
        )
    }
}
