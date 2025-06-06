package com.example.studytrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.studytrack.presentation.dashboard.DashBoardScreen
import com.example.studytrack.presentation.theme.StudyTrackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyTrackTheme {
                DashBoardScreen()
            }
        }
    }
}