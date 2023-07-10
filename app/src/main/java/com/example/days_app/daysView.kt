package com.example.days_app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.days_app.datasource.datasource
import com.example.days_app.model.DayTask


@Composable
fun CardView(task: DayTask) {
    var visabilty by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .wrapContentSize(align = Alignment.TopCenter)
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp))
            .padding(start = 16.dp, top = 10.dp, end = 16.dp, bottom = 16.dp)
    ) {
        Column {
            Text(
                text = task.day,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                text = stringResource(task.title),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(task.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(250.dp)
                    .clickable {
                        visabilty = !visabilty
                    },
                contentScale = ContentScale.Crop
            )
            AnimatedVisibility(visible = visabilty) {
                Box(
                    modifier = Modifier.padding(top = 10.dp)
                ) {
                    Text(
                        text = stringResource(task.desc),
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
    }
}

@Composable
fun ListOfTask() {
    LazyColumn() {
        items(datasource().reloadData()) {
            CardView(it)
        }
    }
}

@Composable
fun ShowApp() {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {
        Text(
            text = "30 Days of Wellness",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp)
        )
        ListOfTask()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ShowView() {
    ShowApp()
}