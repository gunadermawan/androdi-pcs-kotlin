package com.gun.pcs.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gun.pcs.R
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(onNavigateToNextScreen: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_pcs),
            contentDescription = "App Logo",
            modifier = Modifier.size(120.dp)
        )
    }
    LaunchedEffect(Unit) {
        delay(2000)
        onNavigateToNextScreen()
    }
}
