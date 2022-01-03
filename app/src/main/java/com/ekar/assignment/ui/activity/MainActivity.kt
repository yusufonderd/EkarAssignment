package com.ekar.assignment.ui.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization.Companion.Characters
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ekar.assignment.ui.Screen
import com.ekar.assignment.ui.map.MapScreen
import com.ekar.assignment.ui.splash.Splash
import com.ekar.assignment.ui.theme.EkarAssignmentTheme
import com.ekar.assignment.ui.vehicle.VehicleScreen
import dagger.hilt.android.AndroidEntryPoint
import com.ekar.assignment.R

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EkarAssignmentTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(text = stringResource(id = R.string.app_name))
                            })
                        }
                    ) {
                        NavHost(navController, startDestination = Screen.Splash.route) {
                            composable(Screen.Splash.route) { Splash(navController) }
                            composable(Screen.Map.route) { MapScreen(navController) }
                            composable(Screen.Vehicle.route) { VehicleScreen(navController) }
                        }
                    }
                }
            }
        }
    }

}