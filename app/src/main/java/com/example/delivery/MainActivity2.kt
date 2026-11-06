package com.example.delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.ui.theme.DeliveryTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF7F5F0)
                ) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen(
    onEditClick: () -> Unit = {},
    onLogoutClick: () -> Unit = {},
    onNavHome: () -> Unit = {},
    onNavProfile: () -> Unit = {},
    onNavSettings: () -> Unit = {}
) {
    val primaryGreen = Color(0xFF13522C)
    val accentBurgundy = Color(0xFF7A1C30)
    val textGray = Color(0xFF64748B)
    val cardBg = Color.White
    val badgeGreenBg = Color(0xFFE2F0E8)
    val badgeRedBg = Color(0xFFF8D7DA)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F5F0))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            // Top Green Header with curved bottom
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        color = primaryGreen,
                        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp, vertical = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Mi perfil",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "UPT",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 1.5.sp
                    )
                }
            }

            // Overlapping Avatar & User Details Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Avatar overlapping header
                Box(
                    modifier = Modifier
                        .offset(y = (-44).dp)
                        .size(88.dp)
                        .clip(CircleShape)
                        .background(accentBurgundy),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NA",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height((-28).dp))

                Text(
                    text = "Nombre Apellido Apellido",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryGreen,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Universidad Politécnica de Tecámac",
                    fontSize = 13.sp,
                    color = textGray,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Badges Row
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = badgeGreenBg
                    ) {
                        Text(
                            text = "Estudiante",
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = primaryGreen
                        )
                    }

                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = badgeRedBg
                    ) {
                        Text(
                            text = "• Activo",
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = accentBurgundy
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // DATOS PERSONALES Card
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "DATOS PERSONALES",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentBurgundy,
                        letterSpacing = 1.sp,
                        modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
                    )

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        color = cardBg,
                        shadowElevation = 2.dp
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            ProfileInfoRow(
                                iconContent = { IdCardIcon(tint = primaryGreen) },
                                label = "Matrícula o Número de Empleado",
                                value = "1224100123"
                            )
                            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
                            ProfileInfoRow(
                                iconContent = { PersonIcon(tint = primaryGreen) },
                                label = "Nombre completo",
                                value = "Nombre Apellido Apellido"
                            )
                            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
                            ProfileInfoRow(
                                iconContent = { EmailIcon(tint = primaryGreen) },
                                label = "Correo",
                                value = "correo@ejemplo.com"
                            )
                            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
                            ProfileInfoRow(
                                iconContent = { PhoneIcon(tint = primaryGreen) },
                                label = "Teléfono",
                                value = "55 0000 0000"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // DATOS ACADÉMICOS Card
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "DATOS ACADÉMICOS",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = accentBurgundy,
                        letterSpacing = 1.sp,
                        modifier = Modifier.padding(bottom = 8.dp, start = 4.dp)
                    )

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        color = cardBg,
                        shadowElevation = 2.dp
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            ProfileInfoRow(
                                iconContent = { GraduationCapIcon(tint = primaryGreen) },
                                label = "Programa educativo",
                                value = "Ingeniería en [Carrera]"
                            )
                            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
                            ProfileInfoRow(
                                iconContent = { CalendarIcon(tint = primaryGreen) },
                                label = "Cuatrimestre y grupo",
                                value = "[Cuatrimestre] · [Grupo]"
                            )
                            HorizontalDivider(color = Color(0xFFF1F5F9), thickness = 1.dp)
                            ProfileInfoRow(
                                iconContent = { CheckCircleIcon(tint = primaryGreen) },
                                label = "Estatus",
                                value = "Inscrito"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(32.dp))

                // Action Buttons
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Editar datos Button
                    Button(
                        onClick = onEditClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = accentBurgundy
                        )
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            EditPencilIcon(tint = Color.White)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Editar datos",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }
                    }

                    // Cerrar sesión Button
                    OutlinedButton(
                        onClick = onLogoutClick,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.5.dp, accentBurgundy),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = accentBurgundy
                        )
                    ) {
                        Text(
                            text = "Cerrar sesión",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = accentBurgundy
                        )
                    }
                }
            }
        }

        // Bottom Navigation Bar
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            color = Color.White,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(horizontal = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Inicio
                BottomNavTab(
                    icon = { HomeIcon(tint = textGray) },
                    label = "Inicio",
                    isSelected = false,
                    onClick = onNavHome
                )
                // Perfil (Selected)
                BottomNavTab(
                    icon = { ProfileNavIcon(tint = primaryGreen) },
                    label = "Perfil",
                    isSelected = true,
                    selectedColor = primaryGreen,
                    onClick = onNavProfile
                )
                // Ajustes
                BottomNavTab(
                    icon = { SettingsIcon(tint = textGray) },
                    label = "Ajustes",
                    isSelected = false,
                    onClick = onNavSettings
                )
            }
        }
    }
}

@Composable
fun ProfileInfoRow(
    iconContent: @Composable () -> Unit,
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFFE2F0E8)),
            contentAlignment = Alignment.Center
        ) {
            iconContent()
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = label,
                fontSize = 11.sp,
                color = Color(0xFF64748B),
                fontWeight = FontWeight.Medium
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = value,
                fontSize = 14.sp,
                color = Color(0xFF1E293B),
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun BottomNavTab(
    icon: @Composable () -> Unit,
    label: String,
    isSelected: Boolean,
    selectedColor: Color = Color(0xFF13522C),
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        icon()
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) selectedColor else Color(0xFF64748B)
        )
    }
}

// Custom Canvas Icons (Strictly avoiding androidx.compose.material.icons)

@Composable
fun IdCardIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawRect(color = tint, size = size, style = Stroke(width = 2.dp.toPx()))
        drawRect(color = tint, topLeft = Offset(4f, 4f), size = Size(6f, 10f))
        drawLine(color = tint, start = Offset(13f, 6f), end = Offset(17f, 6f), strokeWidth = 2f)
        drawLine(color = tint, start = Offset(13f, 10f), end = Offset(17f, 10f), strokeWidth = 2f)
    }
}

@Composable
fun PersonIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawCircle(color = tint, radius = 4.dp.toPx(), center = Offset(10.dp.toPx(), 6.dp.toPx()))
        drawArc(
            color = tint,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(4.dp.toPx(), 11.dp.toPx()),
            size = Size(12.dp.toPx(), 7.dp.toPx()),
            style = Stroke(width = 2.dp.toPx())
        )
    }
}

@Composable
fun EmailIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawRect(color = tint, topLeft = Offset(2f, 4f), size = Size(16f, 12f), style = Stroke(width = 2.dp.toPx()))
        drawLine(color = tint, start = Offset(2f, 4f), end = Offset(10f, 11f), strokeWidth = 2f)
        drawLine(color = tint, start = Offset(18f, 4f), end = Offset(10f, 11f), strokeWidth = 2f)
    }
}

@Composable
fun PhoneIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawCircle(color = tint, radius = 2.dp.toPx(), center = Offset(10.dp.toPx(), 10.dp.toPx()), style = Stroke(width = 2.dp.toPx()))
        drawArc(
            color = tint,
            startAngle = 45f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(3f, 3f),
            size = Size(14f, 14f),
            style = Stroke(width = 2.dp.toPx())
        )
    }
}

@Composable
fun GraduationCapIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        val path = Path().apply {
            moveTo(10f, 3f)
            lineTo(18f, 7f)
            lineTo(10f, 11f)
            lineTo(2f, 7f)
            close()
        }
        drawPath(path = path, color = tint)
        drawRect(color = tint, topLeft = Offset(7f, 12f), size = Size(6f, 4f))
    }
}

@Composable
fun CalendarIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawRect(color = tint, topLeft = Offset(2f, 4f), size = Size(16f, 14f), style = Stroke(width = 2.dp.toPx()))
        drawLine(color = tint, start = Offset(2f, 8f), end = Offset(18f, 8f), strokeWidth = 2f)
        drawLine(color = tint, start = Offset(6f, 2f), end = Offset(6f, 5f), strokeWidth = 2f)
        drawLine(color = tint, start = Offset(14f, 2f), end = Offset(14f, 5f), strokeWidth = 2f)
    }
}

@Composable
fun CheckCircleIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawCircle(color = tint, radius = 8.dp.toPx(), center = Offset(10.dp.toPx(), 10.dp.toPx()), style = Stroke(width = 2.dp.toPx()))
        val path = Path().apply {
            moveTo(6f, 10f)
            lineTo(9f, 13f)
            lineTo(14f, 7f)
        }
        drawPath(path = path, color = tint, style = Stroke(width = 2.dp.toPx()))
    }
}

@Composable
fun EditPencilIcon(tint: Color) {
    Canvas(modifier = Modifier.size(20.dp)) {
        drawLine(color = tint, start = Offset(4f, 16f), end = Offset(8f, 16f), strokeWidth = 2.dp.toPx())
        drawLine(color = tint, start = Offset(6f, 14f), end = Offset(15f, 5f), strokeWidth = 2.dp.toPx())
        drawLine(color = tint, start = Offset(13f, 3f), end = Offset(17f, 7f), strokeWidth = 2.dp.toPx())
    }
}

@Composable
fun HomeIcon(tint: Color) {
    Canvas(modifier = Modifier.size(22.dp)) {
        val path = Path().apply {
            moveTo(11f, 2f)
            lineTo(2f, 10f)
            lineTo(5f, 10f)
            lineTo(5f, 19f)
            lineTo(17f, 19f)
            lineTo(17f, 10f)
            lineTo(20f, 10f)
            close()
        }
        drawPath(path = path, color = tint, style = Stroke(width = 2.dp.toPx()))
    }
}

@Composable
fun ProfileNavIcon(tint: Color) {
    Canvas(modifier = Modifier.size(22.dp)) {
        drawCircle(color = tint, radius = 4.dp.toPx(), center = Offset(11f, 7f))
        drawArc(
            color = tint,
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            topLeft = Offset(4f, 12f),
            size = Size(14f, 8f),
            style = Stroke(width = 2.dp.toPx())
        )
    }
}

@Composable
fun SettingsIcon(tint: Color) {
    Canvas(modifier = Modifier.size(22.dp)) {
        drawCircle(color = tint, radius = 5.dp.toPx(), center = Offset(11f, 11f), style = Stroke(width = 2.dp.toPx()))
        drawCircle(color = tint, radius = 2.dp.toPx(), center = Offset(11f, 11f))
    }
}

@Preview(showBackground = true, widthDp = 393, heightDp = 851)
@Composable
fun ProfileScreenPreview() {
    DeliveryTheme {
        ProfileScreen()
    }
}
