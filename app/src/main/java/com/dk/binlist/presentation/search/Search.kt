package com.dk.binlist.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.dk.binlist.R
import com.dk.binlist.utils.Consts
import com.dk.binlist.utils.MaskVisualTransformation

@Composable
fun Search(
    modifier: Modifier = Modifier,
    onSearchClick: (String) -> Unit
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    val mask = MaskVisualTransformation(Consts.BIN_MASK)
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalAlignment = Alignment.End,
    ) {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth(),
            textStyle = LocalTextStyle.current.copy(textAlign = TextAlign.Center),
            value = text,
            onValueChange = {
                if (it.length <= 8) {
                    text = it
                }
            },
            singleLine = true,
            label = {
                Text(text = stringResource(R.string.search_text_label))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(onClick = { text = "" }) {
                        Icon(
                            imageVector = Icons.Default.Clear, contentDescription = stringResource(
                                R.string.clear
                            )
                        )
                    }
                }
            },
            visualTransformation = mask
        )
        Button(
            shape = RectangleShape,
            onClick = {
                onSearchClick(text)
            }) {
            Text(text = stringResource(R.string.lookup))
        }
    }
}
