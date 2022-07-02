package com.wahidabd.whatsappclone.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wahidabd.whatsappclone.R
import com.wahidabd.whatsappclone.model.SampleData
import com.wahidabd.whatsappclone.ui.theme.liteGrayColor
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
@Composable
fun WhatsAppStatus() {
    val date = SimpleDateFormat("hh:mm a")
    val strDate: String = date.format(Date())

    val listOfStatusData = listOf(
        SampleData("Status 1", "Make It Easy Sample 1", "Sample Url", strDate),
        SampleData("Status 2", "Make It Easy Sample 2", "Sample Url", strDate),
        SampleData("Status 3", "Make It Easy Sample 3", "Sample Url", strDate),
        SampleData("Status 4", "Make It Easy Sample 4", "Sample Url", strDate),
        SampleData("Status 5", "Make It Easy Sample 5", "Sample Url", strDate)
    )

    val listOfViewedData = listOf(
        SampleData("Viewed 1", "Make It Easy Sample 1", "Sample Url", strDate),
        SampleData("Viewed 2", "Make It Easy Sample 2", "Sample Url", strDate),
        SampleData("Viewed 3", "Make It Easy Sample 3", "Sample Url", strDate),
        SampleData("Viewed 4", "Make It Easy Sample 4", "Sample Url", strDate),
        SampleData("Viewed 5", "Make It Easy Sample 5", "Sample Url", strDate)
    )

    LazyColumn(
        modifier = Modifier.background(Color.White)
    ){
        item {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier
                    .fillMaxSize()
                    .padding(5.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_baseline_run_circle_24),
                        contentDescription = "My Status",
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                            .padding(5.dp)
                    )

                    Column(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "My Status",
                            fontSize = 16.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            text = "Tab to add status update",
                            fontSize = 14.sp,
                            color = Color.Gray,
                            fontWeight = FontWeight.Normal
                        )
                        Spacer(modifier = Modifier.padding(5.dp))
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(liteGrayColor)
                ) {
                    Text(
                        text = "Recent updates",
                        modifier = Modifier.padding(15.dp, 5.dp, 10.dp, 5.dp),
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
        }
        items(listOfStatusData.size) {index ->
            SampleStatusListItems(data = listOfViewedData[index])
        }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(liteGrayColor)
            ) {
                Text(
                    text = "View updates",
                    modifier = Modifier.padding(15.dp, 5.dp, 10.dp, 5.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
            }
        }
        items(listOfStatusData.size) {index ->
            SampleStatusListItems(listOfStatusData[index])
        }
    }
}

@Composable
fun SampleStatusListItems(data: SampleData){
    Column {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_run_circle_24),
                contentDescription = "Image content",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)
                    .padding(5.dp)
            )
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = data.name,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    text = "Today, ${data.createdAt}",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WhatsAppStatusPreview() {
    WhatsAppStatus()
}