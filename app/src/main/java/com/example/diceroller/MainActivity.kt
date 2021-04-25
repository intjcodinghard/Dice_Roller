package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Find the button in the layout
        val rollButton: Button = findViewById(R.id.button)
        /*The findViewById() method finds the Button in the layout.
        R.id.button is the resource ID for the Button, which is a unique identifier for it.
        The code saves a reference to the Button object in a variable called rollButton, not the Button object itself.*/
        //Set a click listener
        rollButton.setOnClickListener { rollDice() }

        //Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        // Find the image view in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)


        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //update the imageview with the correct image resource id
        diceImage.setImageResource(drawableResource)
        //update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}
