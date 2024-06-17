package iam.example.socialservice

sealed class Screen(val route : String){
    object ChoseMethodScreen : Screen("chose_method_screen")
    object InputEmailScreen : Screen("input_email_screen")
    object InputOtpScreen : Screen("input_otp_screen")
    object FormRegisterScreen : Screen("form_register_screen")
    object LoginScreen : Screen("login_screen")
    object ForgetPasswordScreen : Screen("forget_password_screen")
    object InputOtpForgetPasswordScreen : Screen("input_otp_forget_password_screen")
    object FormInputNewPasswordScreen : Screen("form_input_new_password_screen")
}