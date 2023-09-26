package com.example.interfacedatabase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfacedatabase.db.DBHandler
import com.example.interfacedatabase.ui.theme.InterfaceDatabaseTheme
import com.example.interfacedatabase.ui.theme.PurpleGrey40



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InterfaceDatabaseTheme {
                App()
            }
        }
    }
}
    @Preview(showBackground = true, widthDp =  350, heightDp = 800)
    @Composable
    fun App(){
        InterfaceDatabaseTheme {
            // A surface container using the 'background' color from the theme
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                Column {
                    SimpleTopAppBar()
                }
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    //CardSample()
                    CamposTexto(LocalContext.current)
                    //FloatingActionButtonSample()
                }
                Column (
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ){
                    FloatingActionButtonSample()
                }

            }

        }
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SimpleTopAppBar() {
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "GFG",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 100.dp)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {


                }
            }

        )
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PinnedTopAppBar() {
        val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "TopAppBar",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        // RowScope here, so these icons will be placed horizontally
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val list = (0..75).map { it.toString() }
                    items(count = list.size) {
                        Text(
                            text = list[it],
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun EnterAlwaysTopAppBar() {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            "TopAppBar",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior
                )
            },
            content = { innerPadding ->
                LazyColumn(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val list = (0..75).map { it.toString() }
                    items(count = list.size) {
                        Text(
                            text = list[it],
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp)
                        )
                    }
                }
            }
        )
    }

    //Card
    @Composable
    fun CardSample() {
        Card(Modifier.size(width = 180.dp, height = 100.dp)) {
            Box(Modifier.fillMaxSize()) {
                Text("Bom dia!!", Modifier.align(Alignment.Center))
            }

        }
    }

    //Button 2
    @Composable
    fun FloatingActionButtonSample() {
        FloatingActionButton(
            onClick = { /* do something */ },
        ) {
            Icon(Icons.Filled.Settings, "Localized description")
        }
    }

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun CamposTexto(
    context: Context
) {

    val courseName = remember { mutableStateOf(TextFieldValue()) }
    val courseDuration = remember { mutableStateOf(TextFieldValue()) }
    val courseTracks = remember { mutableStateOf(TextFieldValue()) }
    val courseDescription = remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "SQlite Database in Android",
            color = PurpleGrey40,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = courseName.value,
            onValueChange = { courseName.value = it },
            label = { Text("Enter your course name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = courseDuration.value,
            onValueChange = { courseDuration.value = it },
            label = { Text("Enter your course duration") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = courseTracks.value,
            onValueChange = { courseTracks.value = it },
            label = { Text("Enter your course tracks") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = courseDescription.value,
            onValueChange = { courseDescription.value = it },
            label = { Text("Enter your course description") },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(15.dp))


        var dbHandler: DBHandler = DBHandler(context)

        Button(
            onClick = {
                dbHandler.addNewCourse(
                    courseName.value.text,
                    courseDuration.value.text,
                    courseDescription.value.text,
                    courseTracks.value.text
                )
                Toast.makeText(context, "Course Added to Database", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .padding(end = 8.dp)
        ) {
            Text(text = "Add Course to Database")
        }
        //botão para read
        Button(onClick = {
            val i = Intent(context, ViewCourses::class.java)
            context.startActivity(i)
        }) {
            // on below line adding a text for our button.
            Text(text = "Read Courses to Database", color = Color.White)
        }
    }

}
