package com.example.studytrack.presentation.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studytrack.R
import com.example.studytrack.domain.model.Subject
import com.example.studytrack.presentation.components.CountCard
import com.example.studytrack.presentation.components.SubjectCard

@Composable
fun DashBoardScreen() {
    val subjects = listOf(
        Subject("Math", 10f, Subject.subjectCardColors[0]),
        Subject("English", 10f, Subject.subjectCardColors[1]),
        Subject("Science", 10f, Subject.subjectCardColors[2]),
        Subject("History", 10f, Subject.subjectCardColors[3]),
    )
    Scaffold(topBar = {
        DashBoardScreenTopBar()
    }) { paddingValues ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            item {
                CountCardsSection(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), subjectCount = 10, studiedHours = "10", goalHours = "10")
            }

            item {
                SubjectCardsSection(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), subjectList = subjects)
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashBoardScreenTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                "StudyTrack",
                style = MaterialTheme.typography.headlineMedium
            )
        }
    )
}

@Composable
private fun CountCardsSection(
    modifier: Modifier,
    subjectCount: Int,
    studiedHours: String,
    goalHours: String
) {
    Row(modifier = modifier) {
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Subject Count",
            count = "$subjectCount"
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Studied Hours",
            count = studiedHours
        )
        Spacer(modifier = Modifier.width(10.dp))
        CountCard(
            modifier = Modifier.weight(1f),
            headingText = "Goal Study Hours",
            count = goalHours
        )
    }
}

@Preview
@Composable
private fun CountCardsSectionPreview() {
    CountCardsSection(modifier = Modifier, subjectCount = 10, studiedHours = "10", goalHours = "10")
}

@Composable
fun SubjectCardsSection(modifier: Modifier = Modifier,
                        subjectList: List<Subject>,
                        emptyListText : String = "You don't have any subjects. \n Click the + button to add a subject.") {
    Column(modifier = modifier) {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = "SUBJECTS",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 12.dp))
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add"
                )
            }
        }
        if (subjectList.isEmpty()) {
            Image(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally),
                painter = painterResource(R.drawable.img_books),
                contentDescription = emptyListText
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = emptyListText,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
        ) {
            items(subjectList.size) { index ->
                SubjectCard(
                    modifier = Modifier.padding(12.dp),
                    subjectName = subjectList[index].name,
                    gradientColors = subjectList[index].colors,
                    onClick = {}
                )
            }}
    }
}