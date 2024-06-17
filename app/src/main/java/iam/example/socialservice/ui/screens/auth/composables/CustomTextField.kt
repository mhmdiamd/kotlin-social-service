package iam.example.socialservice.ui.screens.auth.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import iam.example.socialservice.ui.theme.GraySecondary
import iam.example.socialservice.ui.theme.IconTextField


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    icon: Painter,
    value : String,
    placeholder: String? = "",
    type : String = "text",
    handleChangeValue: (value : String) -> Unit
) {
    OutlinedTextField(
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        modifier = modifier
            .background(GraySecondary)
            .clip(RoundedCornerShape(8.dp)),
        leadingIcon = {
            Icon(
                painter = icon,
                contentDescription = "$placeholder logo",
                tint = IconTextField
            )
        },
        value = value,
        placeholder = {
            Text(text = placeholder!!, color = IconTextField)
        },
        onValueChange = {
            handleChangeValue(it)
        },
    )
}
