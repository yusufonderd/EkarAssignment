package com.ekar.assignment.uicomponent

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ekar.assignment.ui.theme.padding_4

/**
 * @author yusuf.onder
 * Created on 2.01.2022
 */
@Composable
fun ShowcaseLabelType1(@StringRes label: Int, title: String, subtitle: String) {
    Column (){
        Text(
            text = stringResource(id = label),
            style = MaterialTheme.typography.subtitle1,
        )
        Row() {
            Text(
                text = title,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.align(Alignment.Bottom).padding(end = padding_4)
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.align(Alignment.Bottom)
            )
        }
    }
}
