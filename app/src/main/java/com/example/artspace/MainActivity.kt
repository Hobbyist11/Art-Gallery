package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}
@Composable
fun ArtSpace(){

    var currentScreen by remember { mutableStateOf(1) }
    when(currentScreen){
        1-> {
            ArtSpaceTextAndImage(
                ArtworkTitleResourceId = R.string.artwork_name1,
                ArtworkArtistResourceId = R.string.artwork_artist1,
                drawableResourceId =R.drawable.img_20201028_172211,
                contentDescriptionResourceId =R.string.art1_desc ,
                onNextButtonClick = {currentScreen ++},
                onPrevButtonClick = {""}
            )
        }
        2-> {
            ArtSpaceTextAndImage(
                ArtworkTitleResourceId = R.string.artwork_name2,
                ArtworkArtistResourceId = R.string.artwork_artist2,
                drawableResourceId = R.drawable.picaudio_1,
                contentDescriptionResourceId = R.string.art2_desc,
                onNextButtonClick = {currentScreen++},
                onPrevButtonClick = {currentScreen--}
            )
        }
        3-> {
            ArtSpaceTextAndImage(
                ArtworkTitleResourceId = R.string.artwork_name3,
                ArtworkArtistResourceId = R.string.artwork_artist3,
                drawableResourceId = R.drawable.img1,
                contentDescriptionResourceId = R.string.art3_desc,
                onNextButtonClick = {""},
                onPrevButtonClick = {currentScreen--}
            )
        }
    }



}

@Composable
fun ArtSpaceTextAndImage(
    ArtworkTitleResourceId:Int,
    ArtworkArtistResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onNextButtonClick: () -> Unit,
    onPrevButtonClick:  () -> Unit,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Card(
            modifier = Modifier
                .padding(18.dp)
                .fillMaxWidth()
                .size(450.dp),
            elevation = CardDefaults.cardElevation(20.dp),
            shape = CardDefaults.elevatedShape,

        ) {
            Image(
                painter = painterResource(id = drawableResourceId),
                contentDescription = stringResource(id = contentDescriptionResourceId),
                modifier = Modifier
                    .padding(30.dp,top = 40.dp,end = 30.dp)
                    .size(350.dp)
                    .wrapContentSize()
            )
        }

        Spacer(modifier = Modifier.height(90.dp))

        Card(
            shape = RectangleShape,
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .fillMaxWidth()


        ){
            Text(
                text = stringResource(id = ArtworkTitleResourceId),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.W400,
            modifier = Modifier.padding(top = 30.dp, start = 10.dp)
            )
            Text(
                text = stringResource(id = ArtworkArtistResourceId),
                fontSize = 15.sp,
                fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.padding(top = 5.dp, bottom = 20.dp, start = 10.dp)
            )
        }
        Spacer(modifier = Modifier.height(40.dp))

        Row(verticalAlignment = Alignment.Bottom) {
            // Previous button
            Button(onClick = onPrevButtonClick,
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
            ) {
                // Inner content including text label
                Text("Previous")

            }
            Spacer(modifier = Modifier.width(50.dp))
            // Next button
            Button(onClick = onNextButtonClick,
            contentPadding = PaddingValues(
                start = 20.dp,
                top = 12.dp,
                end = 20.dp,
                bottom = 12.dp
            )
            ) {
                // Inner content of button
                Text("Next")
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpace()
    }
}