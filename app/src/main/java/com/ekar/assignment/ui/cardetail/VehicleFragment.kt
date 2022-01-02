package com.ekar.assignment.ui.cardetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ekar.assignment.R
import com.ekar.assignment.ui.theme.padding_16
import com.ekar.assignment.ui.theme.padding_4
import com.ekar.assignment.ui.theme.padding_8
import com.ekar.assignment.uicomponent.ButtonType1
import com.ekar.assignment.uicomponent.ButtonType2
import com.ekar.assignment.uicomponent.Dropdown
import com.ekar.assignment.uicomponent.ShowcaseLabelType1
import com.ekar.assignment.uicomponent.ShowcaseLabelType2
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import timber.log.Timber

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@AndroidEntryPoint
class VehicleFragment : Fragment() {
    private val viewModel: CarDetailViewModel by viewModels()

    @ExperimentalMaterialApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MainContent()
            }
        }
    }

    @ExperimentalMaterialApi
    @Composable
    fun MainContent() {
        val uiState by viewModel.uiState.collectAsState()

        if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.size(10.dp, 20.dp))
        } else {
            LazyColumn(
            ) {

                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(colorResource(id = R.color.ekar_blue_transparent))
                    ) {
                        Column() {
                            Image(
                                painter = painterResource(R.drawable.ekar_car),
                                contentDescription = getString(R.string.cd_car_image),
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
                                contentDescription = getString(R.string.cd_car_image),
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


    companion object {
        const val TAG = "CarDetailBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        viewModel.getCarDetail()
    }

    private fun observe() {
        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collectLatest { uiState ->
                Timber.d("uiState => ${uiState.carDetail}")
            }
        }
    }


}