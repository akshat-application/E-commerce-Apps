package com.akshat.eCommerce.common

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Block
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
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
            Text(
                text = title,
                maxLines = 1,
                color = Color.White,
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
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