package com.sdtv.lazylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sdtv.lazylist.MainActivity

//@Preview(showBackground = true)
@Composable
fun LazyGridScreen (){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp),
        columns = GridCells.Fixed(2)
    ) {
        itemsIndexed(MainActivity.items) {index, item ->
            Spacer(modifier = Modifier.width(8.dp))
            GridItem(item = item)
            Spacer(modifier = Modifier.width(8.dp))
        }
    }
}

@Composable
fun GridItem(item: Item) {
    Column(modifier = Modifier
        .height(250.dp)
        .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text(text = item.title, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))
        Image(modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(300.dp)
            .width(200.dp)
            .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.image),
            contentDescription = item.title,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontWeight = FontWeight.SemiBold)
    }
}