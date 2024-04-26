package com.sdtv.lazylist

import android.util.Log
import android.util.PrintStreamPrinter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sdtv.lazylist.MainActivity

//@Preview(showBackground = true)
@Composable
fun LazyRowScreen (){
    val TAG = "LazyRowScreen"
    LazyRow(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(MainActivity.items) {index, item ->
            Log.d(TAG, "items are :" + item)
            Spacer(modifier = Modifier.width(8.dp))
            RowItem(item = item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun RowItem(item: Item) {
    val TAG = "LazyRowScreen"
    Column(modifier = Modifier
        .height(350.dp)
        .width(200.dp)
        .clip(RoundedCornerShape(30.dp)),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(
            text = item.title,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black // or any other color you want
        )
        Spacer(modifier = Modifier.height(8.dp))
        Image(modifier = Modifier
            .fillMaxSize()
            .height(200.dp),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.title,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black // or any other color you want
        )
        Text(
            text = "Hi Manju"
        )
        Log.d(TAG, "item title is :" + item.title)
    }
}