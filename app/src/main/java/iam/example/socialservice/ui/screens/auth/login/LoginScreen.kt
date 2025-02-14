package iam.example.socialservice.ui.screens.auth.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import iam.example.socialservice.Screen
import iam.example.socialservice.R
import iam.example.socialservice.ui.screens.auth.composables.CustomTextField
import iam.example.socialservice.ui.screens.auth.register.TopBarAuthentication
import iam.example.socialservice.ui.theme.GrayPrimary
import iam.example.socialservice.ui.theme.Primary

@Composable
fun LoginScreen(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarAuthentication(navController = navController)
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Sign In", style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.None
                    ))
                    Spacer(modifier = Modifier.height(32.dp))
                    LoginForm(navController = navController)
                }
            }
        }
    }
}

@Composable
fun LoginForm(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            CustomTextField(
                modifier = modifier.fillMaxWidth(),
                placeholder = "Email",
                value = email,
                icon = painterResource(id = R.drawable.email)
            ) {
                email = it
            }
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                modifier = modifier.fillMaxWidth(),
                value = password,
                type = "password",
                icon = painterResource(id = R.drawable.lock),
                placeholder = "Password"
            ) {
                password = it
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Forgot password?",
                Modifier
                    .align(Alignment.End)
                    .clickable {
                        navController.navigate(Screen.ForgetPasswordScreen.route)
                    })
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {
            Column {
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Primary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .sizeIn(minHeight = 50.dp),
                    onClick = { /*TODO*/ }) {
                    Text(text = "Sign In")
                }
                Spacer(modifier = Modifier.height(16.dp))
                RegisterOption(navController = navController)
            }
        }
    }

}

@Composable
fun RegisterOption(
    navController: NavHostController
) {
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

