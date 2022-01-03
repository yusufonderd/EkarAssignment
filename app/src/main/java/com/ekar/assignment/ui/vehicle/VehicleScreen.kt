package com.ekar.assignment.ui.vehicle

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ekar.assignment.R
import com.ekar.assignment.ui.theme.padding_16
import com.ekar.assignment.ui.theme.padding_4
import com.ekar.assignment.ui.theme.padding_8
import com.ekar.assignment.uicomponent.*

/**
 * @author yusuf.onder
 * Created on 3.01.2022
 */

@ExperimentalMaterialApi
@Composable
fun VehicleScreen(navController: NavController) {
    val viewModel = hiltViewModel<VehicleViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    if (uiState.isLoading) {
        LoadingView()
    } else {
        LazyColumn{
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(colorResource(id = R.color.ekar_blue_transparent))
                ) {
                    Column() {
                        Image(
                            painter = painterResource(R.drawable.ekar_car),
                            contentDescription = stringResource(R.string.cd_car_image),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(padding_8),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            ShowcaseLabelType1(
                                label = R.string.base_price,
                                title = uiState.carDetail?.deliveryCharges.orEmpty(),
                                subtitle = stringResource(id = R.string.aed_month)
                            )
                            ShowcaseLabelType1(
                                label = R.string.standard_seating,
                                title = uiState.carDetail?.seat.orEmpty(),
                                subtitle = stringResource(id = R.string.seating)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(padding_8),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            ShowcaseLabelType2(
                                label = R.string.booking_fee,
                                title = uiState.carDetail?.bookingFee.orEmpty(),
                                subtitle = uiState.carDetail?.currency.orEmpty(),
                            )

                            ButtonType1(textResId = R.string.how_contracts_work) {
                                Toast.makeText(
                                    context,
                                    R.string.message_button_actions,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        }

                    }
                }
            }

            if (uiState.carDetail?.year.isNullOrEmpty().not()) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = padding_16),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = uiState.carDetail?.formattedYear.orEmpty(),
                            style = MaterialTheme.typography.h5,
                            modifier = Modifier.padding(vertical = padding_8)
                        )
                    }
                }
            }

            if (uiState.carDetail?.colors.isNullOrEmpty().not()) {
                item {
                    Box(modifier = Modifier.padding(padding_8)) {
                        Dropdown(
                            labelResId = R.string.available_colors,
                            options = uiState.carDetail?.colors.orEmpty()
                        )
                    }

                }
            }
            item {
                Column(
                    modifier = Modifier
                        .padding(padding_16)
                ) {
                    Row {
                        Image(
                            painter = painterResource(R.drawable.ekar_logo),
                            contentDescription = stringResource(R.string.cd_car_image),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(64.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.LightGray, CircleShape)
                        )
                        Column(modifier = Modifier.padding(horizontal = padding_8)) {
                            Row {
                                Text(
                                    text = uiState.carDetail?.make.orEmpty(),
                                    style = MaterialTheme.typography.h5,
                                    modifier = Modifier.padding(end = padding_4)
                                )
                                Text(
                                    text = uiState.carDetail?.model.orEmpty(),
                                    style = MaterialTheme.typography.h5,
                                    color = Color.LightGray
                                )
                            }
                            Text(
                                text = uiState.carDetail?.style.orEmpty(),
                                style = MaterialTheme.typography.h6,
                                color = Color.DarkGray
                            )
                        }
                    }

                    ButtonType2(textResId = R.string.proceed_with_your_selection) {

                    }

                }

            }
        }
    }
}
