package iam.example.socialservice.ui.screens.auth.register

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import iam.example.socialservice.Screen
import iam.example.socialservice.ui.theme.GraySecondary
import iam.example.socialservice.R
import iam.example.socialservice.ui.screens.auth.SeparatorWithText
import iam.example.socialservice.ui.screens.auth.composables.CustomTextField
import iam.example.socialservice.ui.theme.GrayPrimary
import iam.example.socialservice.ui.theme.Primary

@Composable
fun InputEmailScreen(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBarAuthentication(navController = navController)
        }
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Input Your", style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.None
                    ))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Email", style = TextStyle(
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        textDecoration = TextDecoration.None
                    ))
                    Spacer(modifier = Modifier.height(32.dp))
                    InputEmailForm(navController = navController)
                    SSOOption(navController = navController)
                    Spacer(modifier = Modifier.height(32.dp))
                    LoginOption(navController = navController)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarAuthentication(
    navController: NavHostController
) {
    LargeTopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(
            titleContentColor = Color.Black,
        ),
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.ChoseMethodScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Localized description"
                )
            }
        }
    )
}

@Composable
fun InputEmailForm(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var email by remember {
        mutableStateOf("")
    }

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
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = Primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 50.dp),
            onClick = { /*TODO*/ }) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.height(48.dp))
        SeparatorWithText(text = "or continue with")
        Spacer(modifier = Modifier.height(64.dp))
    }
}

@Composable
fun SSOOption(
    navController: NavHostController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = GraySecondary,
                    shape = CircleShape
                )
                .padding(12.dp)
                .clickable {

                },
            imageVector = ImageVector.vectorResource(id = R.drawable.facebook_logo),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            modifier = Modifier
                .size(48.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = GraySecondary,
                    shape = CircleShape
                )
                .padding(8.dp)
                .clickable {

                },
            imageVector = ImageVector.vectorResource(id = R.drawable.google_logo),
            contentDescription = null,
            tint = Color.Unspecified,
        )
        Spacer(modifier = Modifier.width(16.dp))
        Icon(
            modifier = Modifier
                .size(48.dp)
                .aspectRatio(1f, matchHeightConstraintsFirst = true)
                .border(
                    width = 1.dp,
                    color = GraySecondary,
                    shape = CircleShape
                )
                .padding(12.dp)
                .clickable {

                },
            imageVector = ImageVector.vectorResource(id = R.drawable.apple_logo),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Composable
fun LoginOption(
    navController: NavHostController
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Already have an account?", style = TextStyle(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp,
            color = GrayPrimary
        ))
        Text(text = "Sign In", style = TextStyle(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.5.sp,
            color = Primary
        ),
            modifier = Modifier.clickable {
                navController.navigate(Screen.LoginScreen.route)
            }
        )
    }
}
