package com.gun.pcs.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.gun.pcs.R
import com.gun.pcs.ui.component.TopBarDetail
import com.gun.pcs.viewmodel.UserViewModel


@Composable
fun UserDetailScreen(viewModel: UserViewModel, onBackClick: () -> Unit) {
    val selectedUser by viewModel.selectedUser.collectAsState()
    Scaffold(
        topBar = {
            TopBarDetail(
                onBackClick = onBackClick,
            )
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            selectedUser?.let { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(user.avatar)
                                .crossfade(true)
                                .build(),
                            contentDescription = "User Avatar Detail",
                            modifier = Modifier
                                .size(120.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                            placeholder = painterResource(id = R.drawable.ic_people),
                            error = painterResource(id = R.drawable.ic_error)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = user.name,
                            textAlign = TextAlign.Start,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Address: ${user.address_no} ${user.street}, ${user.city}, ${user.country}",
                                textAlign = TextAlign.Start
                            )
                        }
                    }
                }
            }
        }
    }
}


