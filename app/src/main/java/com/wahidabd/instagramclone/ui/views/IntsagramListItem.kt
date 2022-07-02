package com.wahidabd.instagramclone.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.wahidabd.instagramclone.R
import com.wahidabd.instagramclone.data.Story

@Composable
fun InstagramListItem(post: Story){
    Column {
        ProfileInfoSection(post)
        InstagramImage(image = post.storyImage)
        InstagramIconSection()
        InstagramLikeSection(post)
        Text(
            text = "View all ${post.commentsCount} comments",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
            color = Color.Gray
        )
        Text(
            text = "${post.time} ago",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp, top = 2.dp, bottom = 8.dp),
            color = Color.Gray
        )
    }
}

@Composable
fun ProfileInfoSection(post: Story){
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = rememberAsyncImagePainter(post.authorImage), modifier = Modifier
            .size(32.dp)
            .clip(CircleShape), contentScale = ContentScale.Crop, contentDescription = null)
        Text(
            text = post.author,
            style = typography.body1,
            modifier = Modifier
                .padding(8.dp)
                .weight(1f),
            textAlign = TextAlign.Left
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = null
        )
    }
}

@Composable
fun InstagramImage(image: String){
    if (image != ""){
        Image(
            painter = rememberAsyncImagePainter(image),
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun InstagramIconSection() {
    Row {
        var fav by remember{ mutableStateOf(false)}
        IconToggleButton(
            checked = fav,
            onCheckedChange = {fav = it}
        ) {
            val icon = if (fav) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_favorite_24),
                    tint = Color.Red,
                    contentDescription = null
                )
            }else{
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_favorite_border_24),
                    tint = MaterialTheme.colors.onBackground,
                    contentDescription = null
                )
            }
        }
        IconToggleButton(
            checked = false,
            onCheckedChange = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_mode_comment_24),
                tint = MaterialTheme.colors.onSurface,
                contentDescription = null
            )
        }
        IconToggleButton(
            checked = false,
            onCheckedChange = {}
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_outline_send_24),
                tint = MaterialTheme.colors.onSurface,
                contentDescription = null
            )    
        }
    }
}

@Composable
fun InstagramLikeSection(post: Story){
    Row(
        modifier = Modifier
            .padding(start = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(post.authorImage),
            modifier = Modifier
                .size(20.dp)
                .clip(CircleShape),
            contentDescription = "Author Image",
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Liked by ${post.author} and ${post.likesCount} others",
            style = typography.caption,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InstagramListItemPreview(){
    InstagramHome()
}