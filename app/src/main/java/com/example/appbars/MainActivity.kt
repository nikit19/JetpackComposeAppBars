package com.example.appbars

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.ambient
import androidx.compose.unaryPlus
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppBars()
            }
        }
    }
}

@Composable
fun AppBars() {
    val context = +ambient(ContextAmbient)

    Column() {
        TopAppBar(
                navigationIcon = {
                    AppBarIcon(
                            +imageResource(R.drawable.baseline_menu_white_18dp)
                    ) { Toast.makeText(context, "Menu", Toast.LENGTH_LONG).show() }
                },
                title = { Text(text = "Jetpack Compose") }, actionData = listOf(
                +imageResource(R.drawable.baseline_search_white_18dp)
        )
        )
        { actionImage ->
            AppBarIcon(actionImage) { Toast.makeText(context, "Search", Toast.LENGTH_LONG).show() }
        }

        Container(alignment = Alignment.BottomCenter, expanded = true) {
            BottomAppBar(
                    navigationIcon = {
                        AppBarIcon(
                                +imageResource(R.drawable.baseline_home_white_18dp)
                        ) { Toast.makeText(context, "Home", Toast.LENGTH_LONG).show() }
                    }
                    ,
                    fabConfiguration = BottomAppBar.FabConfiguration(cutoutShape = CircleShape) {
                        FloatingActionButton(
                                color = (+MaterialTheme.colors()).secondary,
                                icon = +imageResource(R.drawable.baseline_check_white_18dp),
                                onClick = { Toast.makeText(context, "Fab", Toast.LENGTH_LONG).show() })
                    },
                    actionData = listOf(
                            +imageResource(R.drawable.baseline_person_white_18dp)
                    )
            ) { actionImage ->
                AppBarIcon(actionImage) {
                    Toast.makeText(context, "Profile", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MaterialTheme {
        AppBars()
    }
}
