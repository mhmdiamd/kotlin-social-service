package iam.example.socialservice

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import iam.example.socialservice.ui.screens.auth.ChoseMethodScreen
import iam.example.socialservice.ui.screens.auth.login.ForgetPasswordScreen
import iam.example.socialservice.ui.screens.auth.login.FormNewPassword
import iam.example.socialservice.ui.screens.auth.login.FormRegisterScreen
import iam.example.socialservice.ui.screens.auth.register.InputEmailScreen
import iam.example.socialservice.ui.screens.auth.login.LoginScreen

@Composable
fun MyNavigation(
    modifier: Modifier = Modifier,
) {
    val navigation = rememberNavController()

    NavHost(
        navController = navigation,
        startDestination = Screen.ChoseMethodScreen.route
    ) {
        composable(
            route = Screen.ChoseMethodScreen.route,
        ) {
            ChoseMethodScreen(navController = navigation,)
        }
        composable(
            route = Screen.InputEmailScreen.route,
        ) {
            InputEmailScreen(navController = navigation)
        }

        composable(
            route = Screen.LoginScreen.route,
        ) {
            LoginScreen(navController = navigation)
        }

        composable(
            route = Screen.ForgetPasswordScreen.route,
        ) {
            ForgetPasswordScreen(navController = navigation)
        }
        composable(
            route = Screen.LoginScreen.route,
        ) {
            LoginScreen(navController = navigation)
        }

        composable(
            route = Screen.FormInputNewPasswordScreen.route,
        ) {
            FormNewPassword(navController = navigation)
        }

        composable(
            route = Screen.FormRegisterScreen.route,
        ) {
            FormRegisterScreen(navController = navigation)
        }
    }
}