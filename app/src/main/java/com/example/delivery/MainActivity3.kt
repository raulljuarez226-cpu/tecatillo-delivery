package com.example.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.ui.theme.DeliveryTheme

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF7F5F0)
                ) {
                    EditDataScreen(
                        onBackClick = { finish() },
                        onCancelClick = { finish() },
                        onSaveClick = { _, _, _, _, _, _ -> }
                    )
                }
            }
        }
    }
}

@Composable
fun EditDataScreen(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    onCancelClick: () -> Unit = {},
    onSaveClick: (String, String, String, String, String, String) -> Unit = { _, _, _, _, _, _ -> }
) {
    var nombre by remember { mutableStateOf("Nombre") }
    var apellidos by remember { mutableStateOf("Apellido Apellido") }
    var correo by remember { mutableStateOf("correo@ejemplo.com") }
    var telefono by remember { mutableStateOf("55 0000 0000") }

    var currentPassword by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var currentPasswordVisible by remember { mutableStateOf(false) }
    var newPasswordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    val primaryGreen = Color(0xFF13522C)
    val accentBurgundy = Color(0xFF7A1C30)
    val graySubtitle = Color(0xFF64748B)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF7F5F0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .background(primaryGreen)
            ) {
                Canvas(
                    modifier = Modifier
                        .size(160.dp)
                        .align(Alignment.TopEnd)
                        .offset(x = 40.dp, y = (-40).dp)
                ) {
                    drawCircle(
                        color = Color.White.copy(alpha = 0.1f),
                        radius = size.minDimension / 1.2f,
                        style = Stroke(width = 24.dp.toPx())
                    )
                    drawCircle(
                        color = Color.White.copy(alpha = 0.08f),
                        radius = size.minDimension / 1.5f,
                        style = Stroke(width = 16.dp.toPx())
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_arrow_back),
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(id = R.string.edit_data_title),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Box(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape)
                            .background(accentBurgundy),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "NA",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(30.dp)
                            .clip(CircleShape)
                            .background(primaryGreen),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_camera),
                            contentDescription = stringResource(id = R.string.change_photo),
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(id = R.string.change_photo),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = accentBurgundy
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.personal_data),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentBurgundy,
                            letterSpacing = 1.sp
                        )

                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                text = stringResource(id = R.string.employee_id_label),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF334155),
                                modifier = Modifier.padding(bottom = 6.dp, start = 4.dp)
                            )
                            OutlinedTextField(
                                value = stringResource(id = R.string.employee_id_value),
                                onValueChange = {},
                                enabled = false,
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    disabledContainerColor = Color(0xFFF2EFE9),
                                    disabledBorderColor = Color(0xFFE2E8F0),
                                    disabledTextColor = Color(0xFF334155),
                                    disabledLeadingIconColor = Color(0xFF64748B),
                                    disabledTrailingIconColor = Color(0xFF64748B)
                                ),
                                leadingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_id_card),
                                        contentDescription = null,
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                trailingIcon = {
                                    Icon(
                                        painter = painterResource(id = R.drawable.ic_lock),
                                        contentDescription = null,
                                        modifier = Modifier.size(18.dp)
                                    )
                                },
                                singleLine = true
                            )
                            Text(
                                text = stringResource(id = R.string.cannot_be_modified),
                                fontSize = 12.sp,
                                color = graySubtitle,
                                modifier = Modifier.padding(top = 4.dp, start = 4.dp)
                            )
                        }

                        CustomEditTextField(
                            label = stringResource(id = R.string.names_label),
                            value = nombre,
                            onValueChange = { nombre = it },
                            iconRes = R.drawable.ic_person
                        )

                        CustomEditTextField(
                            label = stringResource(id = R.string.surnames_label),
                            value = apellidos,
                            onValueChange = { apellidos = it },
                            iconRes = R.drawable.ic_person
                        )

                        CustomEditTextField(
                            label = stringResource(id = R.string.email_label),
                            value = correo,
                            onValueChange = { correo = it },
                            iconRes = R.drawable.ic_email,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                        )

                        CustomEditTextField(
                            label = stringResource(id = R.string.phone_label),
                            value = telefono,
                            onValueChange = { telefono = it },
                            iconRes = R.drawable.ic_phone,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        )
                    }
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.change_password_section),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = accentBurgundy,
                            letterSpacing = 1.sp
                        )

                        CustomPasswordTextField(
                            label = stringResource(id = R.string.current_password_label),
                            value = currentPassword,
                            onValueChange = { currentPassword = it },
                            placeholder = stringResource(id = R.string.current_password_placeholder),
                            passwordVisible = currentPasswordVisible,
                            onVisibilityChange = { currentPasswordVisible = !currentPasswordVisible }
                        )

                        CustomPasswordTextField(
                            label = stringResource(id = R.string.new_password_label),
                            value = newPassword,
                            onValueChange = { newPassword = it },
                            placeholder = stringResource(id = R.string.new_password_placeholder),
                            passwordVisible = newPasswordVisible,
                            onVisibilityChange = { newPasswordVisible = !newPasswordVisible }
                        )

                        CustomPasswordTextField(
                            label = stringResource(id = R.string.confirm_password_label),
                            value = confirmPassword,
                            onValueChange = { confirmPassword = it },
                            placeholder = stringResource(id = R.string.confirm_password_placeholder),
                            passwordVisible = confirmPasswordVisible,
                            onVisibilityChange = { confirmPasswordVisible = !confirmPasswordVisible }
                        )

                        Text(
                            text = stringResource(id = R.string.leave_blank_password),
                            fontSize = 12.sp,
                            color = graySubtitle,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OutlinedButton(
                        onClick = onCancelClick,
                        modifier = Modifier
                            .weight(1f)
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.5.dp, accentBurgundy),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = accentBurgundy
                        )
                    ) {
                        Text(
                            text = stringResource(id = R.string.cancel),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Button(
                        onClick = { onSaveClick(nombre, apellidos, correo, telefono, currentPassword, newPassword) },
                        modifier = Modifier
                            .weight(1f)
                            .height(52.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = accentBurgundy
                        ),
                        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
                    ) {
                        Text(
                            text = stringResource(id = R.string.save_changes),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun CustomEditTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    iconRes: Int,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF334155),
            modifier = Modifier.padding(bottom = 6.dp, start = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color(0xFF13522C),
                unfocusedBorderColor = Color(0xFFE2E8F0),
                focusedTextColor = Color(0xFF0F172A),
                unfocusedTextColor = Color(0xFF0F172A)
            ),
            singleLine = true,
            keyboardOptions = keyboardOptions,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = null,
                    tint = Color(0xFF13522C),
                    modifier = Modifier.size(20.dp)
                )
            }
        )
    }
}

@Composable
fun CustomPasswordTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    passwordVisible: Boolean,
    onVisibilityChange: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF334155),
            modifier = Modifier.padding(bottom = 6.dp, start = 4.dp)
        )
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFF94A3B8),
                    fontSize = 14.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedBorderColor = Color(0xFF13522C),
                unfocusedBorderColor = Color(0xFFE2E8F0),
                focusedTextColor = Color(0xFF0F172A),
                unfocusedTextColor = Color(0xFF0F172A)
            ),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = null,
                    tint = Color(0xFF13522C),
                    modifier = Modifier.size(20.dp)
                )
            },
            trailingIcon = {
                val iconRes = if (passwordVisible) R.drawable.ic_visibility else R.drawable.ic_visibility_off
                IconButton(onClick = onVisibilityChange) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Toggle password visibility",
                        tint = Color(0xFF64748B),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true, widthDp = 393, heightDp = 851)
@Composable
fun EditDataScreenPreview() {
    DeliveryTheme {
        EditDataScreen()
    }
}
