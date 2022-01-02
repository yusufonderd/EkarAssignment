package com.ekar.assignment.uicomponent

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ekar.assignment.R

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */

@Composable
fun ButtonType1(@StringRes textResId: Int, @ColorRes color : Int = R.color.ekar_blue, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        border = BorderStroke(1.dp, colorResource(id = color)),
        shape = RoundedCornerShape(20),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = colorResource(id = color))
    ) {
        Text(text = stringResource(textResId))
    }
}