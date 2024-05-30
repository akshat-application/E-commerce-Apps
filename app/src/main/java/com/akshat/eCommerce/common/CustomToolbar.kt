package com.akshat.eCommerce.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun CustomTopAppBar(
    title: String,
    navigationIcon: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Filled.Menu,
            contentDescription = "Back button",
            tint = Color.White
        )
    },
    onNavigationClicked: () -> Unit,
    actionIcon: @Composable (() -> Unit)? = null,
    onActionClicked: (() -> Unit) = {},
) {
    TopAppBar(
        title = {
            searchBox()
//            Text(
//                text = title,
//                maxLines = 1,
//                color = Color.White,
//                style = MaterialTheme.typography.headlineMedium,
//                modifier = Modifier.fillMaxWidth(),
//                textAlign = TextAlign.Center
//            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    onNavigationClicked.invoke()
                }
            ) {
                navigationIcon.invoke()
            }
        },
        actions = {
            actionIcon?.let {
                IconButton(
                    onClick = {
                        onActionClicked.invoke()
                    }
                ) {
                    it.invoke()
                }
            } ?: run {
                IconButton(
                    modifier = Modifier.alpha(0f),
                    onClick = {
                        onActionClicked.invoke()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Block,
                        contentDescription = "button",
                        tint = Color.White,
                    )
                }
            }
        },
        backgroundColor = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun searchBox() {
    var searchData by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .shadow(4.dp, MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.medium)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(8.dp))
            BasicTextField(
                value = searchData,
                onValueChange = { searchData = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {

                    }
                ),
                textStyle = MaterialTheme.typography.bodySmall
            )
        }
    }
}