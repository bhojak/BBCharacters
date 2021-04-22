package com.bhojak.bbcharacters.ui.screen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.activity.compose.setContent
import com.bhojak.bbcharacters.data.entity.BreakingBadCharacter
import com.bhojak.bbcharacters.ui.view.CharacterDetailsView


class CharacterDetails : AppCompatActivity() {

    companion object {

        const val EXTRA_CHARACTER_DETAILS = "character details extra"

        private lateinit var breakingBadCharacter: BreakingBadCharacter

        fun createCharacterIntent(
            context: Context,
            breakingBadCharacter: BreakingBadCharacter
        ): Intent {
            val intent = Intent(context, CharacterDetails::class.java)
            intent.putExtra(EXTRA_CHARACTER_DETAILS, breakingBadCharacter)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        breakingBadCharacter =
            intent.getSerializableExtra(EXTRA_CHARACTER_DETAILS) as BreakingBadCharacter
        setContent {
            showDetailsView()
        }
    }

    @Composable
    fun showDetailsView() {
        CharacterDetailsView(breakingBadCharacter).showCharacterDetails()
    }
}