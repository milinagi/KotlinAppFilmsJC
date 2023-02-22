package com.example.kotlinappfilmsjc

//import android.icu.text.CaseMap.Title
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.cursosandroidant.filmsjcref.dataAccess.FakeDatabase
import com.example.kotlinappfilmsjc.ui.theme.KotlinAppFilmsJCTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAppFilmsJCTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    ListBasic(FakeDatabase.getAllFilms())
//                    ListAdvance(FakeDatabase.getAllFilms())
//                }
                Scaffold(
                    bottomBar = { BottomAppBarList() },
                    content = {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(bottom = it.calculateBottomPadding())) {
                                ListAdvance(FakeDatabase.getAllFilms())
                        }
                    })
            }
        }
    }
}

@Composable
fun BottomAppBarList() {
    BottomAppBar {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menú")
            }
        }

//        Spacer(modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "Cart")
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Options")
        }
    }
}

@Composable
fun ListAdvance(films: List<Film>) {
    val context = LocalContext.current
    LazyColumn {
        items(films.size) {
//            ItemListBasic(title = films[it].name)
//            ItemListClick(title = films[it].name, modifier = Modifier.clickable {
//                Toast.makeText(context, films[it].name, Toast.LENGTH_SHORT).show()
//            })
//            Divider()
            val film = films[it]
            ItemListAdvance(film = film, modifier = Modifier.clickable { Toast.makeText(context,
                films[it].name,
                Toast.LENGTH_SHORT).show()
            } )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class, ExperimentalGlideComposeApi::class)
@Composable
fun ItemListAdvance(film: Film, modifier: Modifier) {
    Column(modifier = modifier) {
        ListItem(
            text = { Text(text = film.name, style = MaterialTheme.typography.h6) },
            secondaryText = { Text(text = film.description,
                style = MaterialTheme.typography.subtitle1,
                maxLines = 3, overflow = TextOverflow.Ellipsis) },
            singleLineSecondaryText = false,
            icon = {
//                Icon(imageVector = Icons.Filled.Star, contentDescription = "Cover film")
                GlideImage(model = film.photoUrl, contentDescription = "Cover Film",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.list_item_img_size))
//                        .clip(CircleShape)
                        .border(
                            BorderStroke(
                                width = dimensionResource(id = R.dimen.list_item_img_stroke),
                                color = Color.Black
                            )
                        ))
            },
            trailing = {
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .padding(top = dimensionResource(id = R.dimen.common_padding_default)),
                    contentAlignment = Alignment.Center) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = null,
                        tint = colorResource(id = R.color.list_item_trailing), modifier = Modifier.size(
                            dimensionResource(id = R.dimen.list_item_trailing_size)))
                    Text(text = "${film.score}", fontSize = 10.sp)
                }
            }
        )
        Divider()
    }
}

@Composable
fun ItemListClick(title: String, modifier: Modifier) {
    Text(text = title, modifier = modifier
        .fillMaxSize()
        .padding(dimensionResource(id = R.dimen.common_padding_default)),
        style = MaterialTheme.typography.h6)

}

@Composable
fun ListBasic(films: List<Film>) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        films.forEach { ItemListBasic(it.name) }
    }
}

@Composable
fun ItemListBasic(title: String) {
    Text(text = title, modifier = Modifier
        .fillMaxSize()
        .padding(dimensionResource(id = R.dimen.common_padding_default)),
        style = MaterialTheme.typography.h6)

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KotlinAppFilmsJCTheme {
        ListBasic(FakeDatabase.getAllFilms())
    }
}