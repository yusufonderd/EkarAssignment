package com.ekar.assignment.uicomponent

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ekar.assignment.R

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

@Composable
fun ButtonType2(
    @StringRes textResId: Int,
    @ColorRes color: Int = R.color.ekar_blue,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White, backgroundColor = colorResource(
                id = color
            )
        )
    ) {
        Text(
            text = stringResource(textResId),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
        )
    }
}