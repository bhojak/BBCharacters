package com.bhojak.bbcharacters.ui.view

//import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import com.bhojak.bbcharacters.ui.components.theme.AppTheme.breakingBadTheme
import dev.chrisbanes.accompanist.coil.CoilImage
import androidx.compose.foundation.layout.Row
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.layout.ContentScale
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation



/**
 * Character details screen UI
 */
class CharacterDetailsView constructor(private val breakingBadCharacter: BreakingBadCharacter) {

    @Composable
    fun showCharacterDetails() {

        breakingBadTheme() {

            Box(modifier = Modifier.fillMaxSize().padding(8.dp)) {

                Column  {

                    CoilImage(
                        data = breakingBadCharacter.characterImage ?: "",
                        contentDescription = null,
                        modifier = Modifier.size(400.dp,300.dp),
                        loading = {
                            Spacer(
                                modifier = Modifier.size(300.dp,300.dp)
                                    .background(MaterialTheme.colors.background)
                            )
                        }
                    )

                    Row() {
                        Text(
                            text = "Name: ",
                            style = TextStyle(fontWeight = FontWeight.Black),
                            modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                        )
                        Text(
                            text = breakingBadCharacter.name,
                            Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                        )
                    }

                    Row() {
                        Text(
                            text = "Occupation: ",
                            style = TextStyle(fontWeight = FontWeight.Black),
                            modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                        )
                        Text(
                            text = breakingBadCharacter.occupation.joinToString(separator = ", "),
                            modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                        )
                    }

                    breakingBadCharacter.status?.let {
                        Row() {
                            Text(
                                text = "Status: ",
                                style = TextStyle(fontWeight = FontWeight.Black),
                                modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                            )
                            Text(
                                text = it,
                                modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                            )
                        }
                    }

                    breakingBadCharacter.nickname?.let {
                        Row() {
                            Text(
                                text = "Nickname: ",
                                style = TextStyle(fontWeight = FontWeight.Black),
                                modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                            )
                            Text(
                                text = it,
                                modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                            )
                        }
                    }

                    breakingBadCharacter.seasonAppearance?.let {
                        Row() {
                            Text(
                                text = "Season Appearances: ",
                                style = TextStyle(fontWeight = FontWeight.Black),
                                modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                            )
                            Text(
                                text = breakingBadCharacter.seasonAppearance.joinToString(separator = ", "),
                                modifier = Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                            )
                        }
                    }
                }


                // column over
            }
        }
    }



}