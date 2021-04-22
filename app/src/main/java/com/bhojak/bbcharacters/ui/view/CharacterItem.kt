package com.bhojak.bbcharacters.ui.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.defaultMinSizeConstraints
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import dev.chrisbanes.accompanist.coil.CoilImage

class CharacterItem constructor(
    private val breakingBadCharacter: BreakingBadCharacter,
    private val onClick: () -> Unit
) {

    @Composable
    fun showCharacterItemView() {
            Surface(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(8.dp), elevation = 2.dp
            ) {
                Column(Modifier.clickable(onClick = onClick)) {


                    CoilImage(
                        data = breakingBadCharacter.characterImage ?: "",
                        fadeIn = true,
                        contentDescription = null,
                        modifier = Modifier.size(100.dp,100.dp),
                        contentScale = ContentScale.Crop,
                        loading = {
                            Spacer(
                                modifier = Modifier.fillMaxSize()
                                    .background(MaterialTheme.colors.background)
                            )
                        }
                    )

                    Text(
                        text = breakingBadCharacter.name,
                        Modifier.absolutePadding(4.dp, 8.dp, 4.dp, 8.dp)
                    )
                }
            }
    }
}