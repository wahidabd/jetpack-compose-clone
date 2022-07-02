package com.wahidabd.instagramclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.wahidabd.instagramclone.ui.theme.InstagramCloneTheme
import com.wahidabd.instagramclone.ui.views.InstagramHome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstagramCloneTheme {
                Surface(color = MaterialTheme.colors.background) {
                    InstagramHome()
                }
            }
        }
    }
}

