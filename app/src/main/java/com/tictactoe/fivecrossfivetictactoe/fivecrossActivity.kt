package com.tictactoe.fivecrossfivetictactoe

import android.content.DialogInterface
import android.graphics.Color
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.ImageButton
import android.os.Message
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fivecross.*
import java.lang.Exception


class fivecrossActivity : AppCompatActivity() {

    enum class PLAYINGPLAYER{          // playing 2 player
        FIRST_PLAYER,
        SECOND_PLAYER
    }

    enum class WINNER_OF_GAME {          // winning 1,2 aur draw
        PLAYER_ONE,
        PLAYER_TWO,
        NO_ONE
    }

    // Instant variable
    // assign the value of varaible as null
    var playingPlayer: PLAYINGPLAYER? = null
    var winnerofGame: WINNER_OF_GAME? = null

    var player1Options: ArrayList<Int> = ArrayList()                          // creating two array list uses below
    var player2Options: ArrayList<Int> = ArrayList()
    var allDisabledImages: ArrayList<ImageButton?> = ArrayList()             // ? for optional

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fivecross)

        val player = MediaPlayer.create(this, R.raw.lit)
        player.isLooping = true
        player.start()

        playingPlayer = PLAYINGPLAYER.FIRST_PLAYER
    }

    fun  imagrButtonTapped(view: View){

        val selectedImageButton: ImageButton = view as ImageButton
        // becouse we know user tap button and imagebutton uses
        var randomNumber = (Math.random()*9+1).toInt()

        //    when (selectedImageButton.id){
// forv show commment
        //     R.id.imgButton1 -> Toast.makeText(this@TicTacToeActivity, "Image Button 1 selected",Toast.LENGTH_SHORT).show()
        // for color change
        //       R.id.imgButton1 -> tableLayout.setBackgroundColor(Color.GREEN)

        // for change color with differnt button
        when (randomNumber){
            1  -> tableLayout.setBackgroundColor(Color.RED)
            2  -> tableLayout.setBackgroundColor(Color.BLUE)
            3  -> tableLayout.setBackgroundColor(Color.GREEN)
            4  -> tableLayout.setBackgroundColor(Color.YELLOW)
            5  -> tableLayout.setBackgroundColor(Color.BLACK)
            6  -> tableLayout.setBackgroundColor(Color.WHITE)
            7  -> tableLayout.setBackgroundColor(Color.GRAY)
            8  -> tableLayout.setBackgroundColor(Color.MAGENTA)
            9  -> tableLayout.setBackgroundColor(Color.TRANSPARENT)
            10 -> tableLayout.setBackgroundColor(Color.LTGRAY)
            11 -> tableLayout.setBackgroundColor(Color.DKGRAY)
            12 -> tableLayout.setBackgroundColor(Color.CYAN)
            13 -> tableLayout.setBackgroundColor(Color.RED)
            14 -> tableLayout.setBackgroundColor(Color.BLUE)
            15 -> tableLayout.setBackgroundColor(Color.BLACK)
            16 -> tableLayout.setBackgroundColor(Color.GREEN)
            17 -> tableLayout.setBackgroundColor(Color.YELLOW)
            18 -> tableLayout.setBackgroundColor(Color.BLACK)
            19 -> tableLayout.setBackgroundColor(Color.WHITE)
            20 -> tableLayout.setBackgroundColor(Color.GRAY)
            21 -> tableLayout.setBackgroundColor(Color.MAGENTA)
            22 -> tableLayout.setBackgroundColor(Color.TRANSPARENT)
            23 -> tableLayout.setBackgroundColor(Color.LTGRAY)
            24 -> tableLayout.setBackgroundColor(Color.DKGRAY)
            25 -> tableLayout.setBackgroundColor(Color.CYAN)
        }
        // to assing value after clicking button
        var optionNumber = 0
        when(selectedImageButton.id){
            R.id.imgButton1  -> optionNumber=1
            R.id.imgButton2  -> optionNumber=2
            R.id.imgButton3  -> optionNumber=3
            R.id.imgButton4  -> optionNumber=4
            R.id.imgButton5  -> optionNumber=5
            R.id.imgButton6  -> optionNumber=6
            R.id.imgButton7  -> optionNumber=7
            R.id.imgButton8  -> optionNumber=8
            R.id.imgButton9  -> optionNumber=9
            R.id.imgButton10 -> optionNumber=10
            R.id.imgButton11 -> optionNumber=11
            R.id.imgButton12 -> optionNumber=12
            R.id.imgButton13 -> optionNumber=13
            R.id.imgButton14 -> optionNumber=14
            R.id.imgButton15 -> optionNumber=15
            R.id.imgButton16 -> optionNumber=16
            R.id.imgButton17 -> optionNumber=17
            R.id.imgButton18 -> optionNumber=18
            R.id.imgButton19 -> optionNumber=19
            R.id.imgButton20 -> optionNumber=20
            R.id.imgButton21 -> optionNumber=21
            R.id.imgButton22 -> optionNumber=22
            R.id.imgButton23 -> optionNumber=23
            R.id.imgButton24 -> optionNumber=24
            R.id.imgButton25 -> optionNumber=25
        }
        // to use input button no and image of button
        action(optionNumber, selectedImageButton)

    }
    // function for action function
    private  fun action(optionNumber: Int, selectedImageButton: ImageButton){
        if(playingPlayer == PLAYINGPLAYER.FIRST_PLAYER){        // instant variable = enum

            selectedImageButton.setImageResource(R.drawable.tic)       // change image on clicking button
            player1Options.add(optionNumber)                          // adding position of x in an array
            selectedImageButton.isEnabled = false                    // it fix the final image of button after that can not change the image o button on clicking
            allDisabledImages.add(selectedImageButton)              // this is another array for that condition when match draw no one wins
            playingPlayer = PLAYINGPLAYER.SECOND_PLAYER            // this for second move done by the compputer after complete first player move
            // for move first player to another

        } else if (playingPlayer == (PLAYINGPLAYER.SECOND_PLAYER)){       // main function done by second player
            selectedImageButton.setImageResource(R.drawable.tac)         //  same as above but done for second
            player2Options.add(optionNumber)                            //  player
            selectedImageButton.isEnabled = false
            allDisabledImages.add(selectedImageButton)
            playingPlayer = PLAYINGPLAYER.FIRST_PLAYER               // moves to first player again



            // for play by computer


//            var notSelectedImageNumber = ArrayList<Int>()
//            for (imageNumber in 1..9){
//                if(!(player1Options.contains(imageNumber))){
//                    if (!player2Options.contains(imageNumber)){
//                        // notSelectedImageNumbers is created in order to hold
//                        // the image number of the image buttons that are not selectted
//                        notSelectedImageNumber.add(imageNumber)
//                    }
//                }
//            }
//            try{
//            // to pass value by randon on remaining images
//                var randomNumber = ((Math.random()*notSelectedImageNumber.size)).toInt()
//                var imageNumber = notSelectedImageNumber[randomNumber]
//            when(imageNumber){
//                1-> selectedImageButton = imgButton1
//            }
//            } catch (e:Exception){
//                e.printStackTrace()
//            }

        }
        specifyTheWinnerOfGame()
    }
    // this function specify the winner
    private fun specifyTheWinnerOfGame() {

        // if 1,,3 all for x then true
        // do all the possible cases for that
        // like 123,456,789,147,258,369,357,159 all this  for 3X3
        // for 5X5 are 12345,678910,1112131415,1617181920,2122232425,16111621,27121722,38131823,49141924,510152025,17131924,59131721

        //1
        if (player1Options.contains(1)&&player1Options.contains(2)&&player1Options.contains(3)&&player1Options.contains(4)&&player1Options.contains(5)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(1)&&player2Options.contains(2)&&player2Options.contains(3)&&player2Options.contains(4)&&player2Options.contains(5)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }
        // this is combination of two player
        // other conditions for this pair

        //2
        else if (player1Options.contains(6)&&player1Options.contains(7)&&player1Options.contains(8)&&player1Options.contains(9)&&player1Options.contains(10)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(6)&&player2Options.contains(7)&&player2Options.contains(8)&&player2Options.contains(9)&&player2Options.contains(10)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //3
        else if (player1Options.contains(11)&&player1Options.contains(12)&&player1Options.contains(13)&&player1Options.contains(14)&&player1Options.contains(15)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(11)&&player2Options.contains(12)&&player2Options.contains(13)&&player2Options.contains(14)&&player2Options.contains(15)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //4
        else if (player1Options.contains(16)&&player1Options.contains(17)&&player1Options.contains(18)&&player1Options.contains(19)&&player1Options.contains(20)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(16)&&player2Options.contains(17)&&player2Options.contains(18)&&player2Options.contains(19)&&player2Options.contains(20)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //5
        else if (player1Options.contains(21)&&player1Options.contains(22)&&player1Options.contains(23)&&player1Options.contains(24)&&player1Options.contains(25)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(21)&&player2Options.contains(22)&&player2Options.contains(23)&&player2Options.contains(24)&&player2Options.contains(25)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //6
        else if (player1Options.contains(1)&&player1Options.contains(6)&&player1Options.contains(11)&&player1Options.contains(16)&&player1Options.contains(21)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(1)&&player2Options.contains(6)&&player2Options.contains(11)&&player2Options.contains(16)&&player2Options.contains(21)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //7
        else if (player1Options.contains(2)&&player1Options.contains(7)&&player1Options.contains(12)&&player1Options.contains(17)&&player1Options.contains(22)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(2)&&player2Options.contains(7)&&player2Options.contains(12)&&player2Options.contains(17)&&player2Options.contains(22)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //8
        else if (player1Options.contains(3)&&player1Options.contains(8)&&player1Options.contains(13)&&player1Options.contains(18)&&player1Options.contains(23)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(3)&&player2Options.contains(8)&&player2Options.contains(13)&&player2Options.contains(18)&&player2Options.contains(23)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //9
        else if (player1Options.contains(4)&&player1Options.contains(9)&&player1Options.contains(14)&&player1Options.contains(19)&&player1Options.contains(24)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(4)&&player2Options.contains(9)&&player2Options.contains(14)&&player2Options.contains(19)&&player2Options.contains(24)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //10
        else if (player1Options.contains(5)&&player1Options.contains(10)&&player1Options.contains(15)&&player1Options.contains(20)&&player1Options.contains(25)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(5)&&player2Options.contains(10)&&player2Options.contains(15)&&player2Options.contains(20)&&player2Options.contains(25)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //11
        else if (player1Options.contains(1)&&player1Options.contains(7)&&player1Options.contains(13)&&player1Options.contains(19)&&player1Options.contains(25)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(1)&&player2Options.contains(7)&&player2Options.contains(13)&&player2Options.contains(19)&&player2Options.contains(25)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        //12
        else if (player1Options.contains(5)&&player1Options.contains(9)&&player1Options.contains(13)&&player1Options.contains(17)&&player1Options.contains(21)){
            winnerofGame = WINNER_OF_GAME.PLAYER_ONE
        }
        // for second player
        else if (player2Options.contains(5)&&player2Options.contains(9)&&player2Options.contains(13)&&player2Options.contains(17)&&player2Options.contains(21)){
            winnerofGame = WINNER_OF_GAME.PLAYER_TWO
        }

        if(winnerofGame == WINNER_OF_GAME.PLAYER_ONE){
// put button on alert message is button positive
            // and ok is the text on button
            // false is for reset condition
            // not allow user to remove/cancled alert message
            createAlert("Player one Wins","Congratulations to player 1", AlertDialog.BUTTON_POSITIVE,"ok", false)
            return
        }
        else if(winnerofGame == WINNER_OF_GAME.PLAYER_TWO){
// for player two
            createAlert("Player one Wins","Congratulations to player 2", AlertDialog.BUTTON_POSITIVE,"ok", false)
            return
        }

        checkDrawState()

    }

    private fun createAlert(title: String, message:  String, whichButton: Int, buttonText: String, cancelable: Boolean) {

        val  alertDialog: AlertDialog = AlertDialog.Builder(this@fivecrossActivity).create()
        // create alert dialog
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)

        // all this for text of button
        alertDialog.setButton(whichButton,buttonText, {
                dialog: DialogInterface?, which: Int ->

            resetGame()

        })                                           // this is the condition on clicking on alert the game reset
        alertDialog.setCancelable(cancelable)       // for cancle
        alertDialog.show()                         // for visiblity of alert
    }

    private fun resetGame() {

        // clear all the data of array one,two and their images
        // and no one is winner of game
        player1Options.clear()
        player2Options.clear()
        allDisabledImages.clear()
        winnerofGame = WINNER_OF_GAME.NO_ONE

        //restore orignal image of all button
        imgButton1.setImageResource(R.drawable.toe)
        imgButton2.setImageResource(R.drawable.toe)
        imgButton3.setImageResource(R.drawable.toe)
        imgButton4.setImageResource(R.drawable.toe)
        imgButton5.setImageResource(R.drawable.toe)
        imgButton6.setImageResource(R.drawable.toe)
        imgButton7.setImageResource(R.drawable.toe)
        imgButton8.setImageResource(R.drawable.toe)
        imgButton9.setImageResource(R.drawable.toe)
        imgButton10.setImageResource(R.drawable.toe)
        imgButton11.setImageResource(R.drawable.toe)
        imgButton12.setImageResource(R.drawable.toe)
        imgButton13.setImageResource(R.drawable.toe)
        imgButton14.setImageResource(R.drawable.toe)
        imgButton15.setImageResource(R.drawable.toe)
        imgButton16.setImageResource(R.drawable.toe)
        imgButton17.setImageResource(R.drawable.toe)
        imgButton18.setImageResource(R.drawable.toe)
        imgButton19.setImageResource(R.drawable.toe)
        imgButton20.setImageResource(R.drawable.toe)
        imgButton21.setImageResource(R.drawable.toe)
        imgButton22.setImageResource(R.drawable.toe)
        imgButton23.setImageResource(R.drawable.toe)
        imgButton24.setImageResource(R.drawable.toe)
        imgButton25.setImageResource(R.drawable.toe)

        // allow to image button to change the image
        // allow to intract the button
        imgButton1.isEnabled = true
        imgButton2.isEnabled = true
        imgButton3.isEnabled = true
        imgButton4.isEnabled = true
        imgButton5.isEnabled = true
        imgButton6.isEnabled = true
        imgButton7.isEnabled = true
        imgButton8.isEnabled = true
        imgButton9.isEnabled = true
        imgButton10.isEnabled = true
        imgButton11.isEnabled = true
        imgButton12.isEnabled = true
        imgButton13.isEnabled = true
        imgButton14.isEnabled = true
        imgButton15.isEnabled = true
        imgButton16.isEnabled = true
        imgButton17.isEnabled = true
        imgButton18.isEnabled = true
        imgButton19.isEnabled = true
        imgButton20.isEnabled = true
        imgButton21.isEnabled = true
        imgButton22.isEnabled = true
        imgButton23.isEnabled = true
        imgButton24.isEnabled = true
        imgButton25.isEnabled = true

    }

    private fun checkDrawState() {

        if(allDisabledImages.size == 25 && winnerofGame != WINNER_OF_GAME.PLAYER_ONE && winnerofGame != WINNER_OF_GAME.PLAYER_TWO)

            createAlert("Draw!!!","No on Won The Game", AlertDialog.BUTTON_POSITIVE,"OK",false)
        // reset for all images fill but no one win0
    }

}
