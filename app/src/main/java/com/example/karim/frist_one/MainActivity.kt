package com.example.karim.frist_one

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun ButtonSelect(view:View){
        val butnChose=view as Button
        var cellID=0
        when(butnChose.id){
            R.id.button1 ->cellID=1
            R.id.button2 ->cellID=2
            R.id.button3 ->cellID=3
            R.id.button4 ->cellID=4
            R.id.button5 ->cellID=5
            R.id.button6 ->cellID=6
            R.id.button7 ->cellID=7
            R.id.button8 ->cellID=8
            R.id.button9 ->cellID=9
        }
        Log.d("cellID : ",cellID.toString())
        play(cellID,butnChose)
    }
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var activePlayer=1
    fun play(cellId:Int,buttonChoce:Button){
        if(activePlayer==1){
            buttonChoce.text="X"
            buttonChoce.setBackgroundResource(R.color.colorAccent)
            player1.add(cellId)
            activePlayer=2
            if(isWin(player1)) {
                Toast.makeText(this, "Player one win", Toast.LENGTH_LONG).show()
            }
        }else{
            buttonChoce.text="O"
            buttonChoce.setBackgroundResource(R.color.material_blue_grey_800)
            player2.add(cellId)
            activePlayer=1
            if(isWin(player2))
                Toast.makeText(this,"Player two win",Toast.LENGTH_LONG).show()

        }
        buttonChoce.isEnabled=false
    }
    fun isWin(player:ArrayList<Int>):Boolean{
        if(player.contains(1)&&player.contains(2)&&player.contains(3))
            return true
        else if(player.contains(6)&&player.contains(5)&&player.contains(4))
            return true
        else if(player.contains(9)&&player.contains(8)&&player.contains(7))
            return true
        return false
    }
}
