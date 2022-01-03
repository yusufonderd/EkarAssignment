package com.ekar.assignment.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ekar.assignment.R
import com.ekar.assignment.ui.Screen
import com.ekar.assignment.ui.theme.padding_16

/**
 * @author yusuf.onder
 * Created on 3.01.2022
 */

@Composable
fun Splash(navController: NavController) {
    val viewModel = hiltViewModel<SplashViewModel>()
    val event by viewModel.navigationEvent.collectAsState(SplashEvent.Initial)

    when (event) {
        is SplashEvent.Initial -> {
            Image(
                painter = painterResource(R.drawable.ekar_logo),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding_16)
            )
        }
        is SplashEvent.NavigateToHome -> {
            navController.navigate(Screen.Map.route)
        }
    }

}
