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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.delivery.ui.theme.DeliveryTheme

class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF7F5F0)
                ) {
                    FoodCatalogScreen()
                }
            }
        }
    }
}

@Composable
fun FoodCatalogScreen(
    modifier: Modifier = Modifier
) {
    val primaryBrown = Color(0xFF5A1810)
    val bgCream = Color(0xFFF7F5F0)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(bgCream)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 80.dp)
        ) {
            FoodTopBar()

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = stringResource(R.string.welcome_pedro),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = primaryBrown,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            FoodBannerCard(modifier = Modifier.padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            FoodFilterSection(modifier = Modifier.padding(horizontal = 16.dp))

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                FoodItemCard(
                    title = stringResource(R.string.tacos_dorados_title),
                    description = stringResource(R.string.tacos_dorados_desc),
                    cardColor = primaryBrown
                )
                FoodItemCard(
                    title = stringResource(R.string.sandwich_jamon_title),
                    description = stringResource(R.string.sandwich_jamon_desc),
                    cardColor = primaryBrown
                )
                FoodItemCard(
                    title = stringResource(R.string.pastes_title),
                    description = stringResource(R.string.pastes_desc),
                    cardColor = primaryBrown
                )
            }
        }

        FoodBottomBar(
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun FoodTopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier.size(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(20.dp, 12.dp)) {
                val strokeWidth = 3.dp.toPx()
                drawLine(
                    color = Color(0xFF5A1810),
                    start = Offset(0f, 0f),
                    end = androidx.compose.ui.geometry.Offset(size.width, 0f),
                    strokeWidth = strokeWidth
                )
                drawLine(
                    color = Color(0xFF5A1810),
                    start = androidx.compose.ui.geometry.Offset(0f, size.height),
                    end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                    strokeWidth = strokeWidth
                )
            }
        }

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text(
                    text = stringResource(R.string.search_hint),
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            },
            leadingIcon = {
                Box(
                    modifier = Modifier.size(18.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCircle(
                            color = Color.Gray,
                            radius = size.minDimension / 2.5f,
                            style = Stroke(width = 2.dp.toPx())
                        )
                        drawLine(
                            color = Color.Gray,
                            start = androidx.compose.ui.geometry.Offset(size.width * 0.7f, size.height * 0.7f),
                            end = androidx.compose.ui.geometry.Offset(size.width, size.height),
                            strokeWidth = 2.dp.toPx()
                        )
                    }
                }
            },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xFFC7B299),
                unfocusedBorderColor = Color(0xFFC7B299),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            ),
            modifier = Modifier
                .weight(1f)
                .height(48.dp),
            singleLine = true
        )
    }
}

@Composable
fun FoodBannerCard(
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(140.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFC7B299)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF3EFEA))
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFDCC7B2)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Banner Image",
                    color = Color(0xFF2196F3),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun FoodFilterSection(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.Transparent),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier.size(22.dp)) {
                val stroke = 2.dp.toPx()
                val color = Color(0xFF7A1C30)
                drawLine(color, androidx.compose.ui.geometry.Offset(0f, 2.dp.toPx()), androidx.compose.ui.geometry.Offset(size.width, 2.dp.toPx()), stroke)
                drawLine(color, androidx.compose.ui.geometry.Offset(size.width * 0.25f, 8.dp.toPx()), androidx.compose.ui.geometry.Offset(size.width * 0.75f, 8.dp.toPx()), stroke)
                drawLine(color, androidx.compose.ui.geometry.Offset(size.width * 0.4f, 14.dp.toPx()), androidx.compose.ui.geometry.Offset(size.width * 0.6f, 14.dp.toPx()), stroke)
            }
        }

        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF7A1C30)),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFF9F6F0)),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
            modifier = Modifier.height(36.dp)
        ) {
            Text(
                text = stringResource(R.string.filter_ordenar),
                color = Color(0xFF7A1C30),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
        }

        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF7A1C30)),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFF9F6F0)),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
            modifier = Modifier.height(36.dp)
        ) {
            Text(
                text = stringResource(R.string.filter_promociones),
                color = Color(0xFF7A1C30),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
        }

        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            border = BorderStroke(1.dp, Color(0xFF7A1C30)),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(0xFFF9F6F0)),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
            modifier = Modifier.height(36.dp)
        ) {
            Text(
                text = stringResource(R.string.filter_rango_precio),
                color = Color(0xFF7A1C30),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
fun FoodItemCard(
    title: String,
    description: String,
    cardColor: Color,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFC7B299)),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFFE5D5C5)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Image",
                    color = cardColor,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = cardColor
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = description,
                    fontSize = 13.sp,
                    color = Color.DarkGray,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun FoodBottomBar(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = Color(0xFFF7F5F0),
        tonalElevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(4) { index ->
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color(0xFF7A1C30).copy(alpha = if (index == 0) 1f else 0.4f), shape = CircleShape)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FoodCatalogScreenPreview() {
    DeliveryTheme {
        FoodCatalogScreen()
    }
}
