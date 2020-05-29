package com.xzy.uibestpractice

import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private var msgListView: ListView? = null
    private var inputText: EditText? = null
    private var send: Button? = null
    private var adapter: MsgAdapter? = null
    private val msgList: MutableList<Msg> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_main)
        initMsgs()
        adapter = MsgAdapter(this@MainActivity, R.layout.msg_item, msgList)
        inputText = findViewById<View>(R.id.input_text) as EditText
        send = findViewById<View>(R.id.send) as Button
        msgListView = findViewById<View>(R.id.msg_list_view) as ListView
        msgListView?.adapter = adapter
        send?.setOnClickListener {
            val content = inputText?.text.toString()
            if ("" != content) {
                val msg = Msg(content, Msg.TYPE_SENT)
                msgList.add(msg)
                adapter?.notifyDataSetChanged()
                msgListView?.setSelection(msgList.size)
                inputText?.setText("")
            }
        }
    }

    private fun initMsgs() {
        val msg1 = Msg("Hello guy.", Msg.Companion.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("Hello. Who is that?", Msg.Companion.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("This is Tom. Nice talking to you. ", Msg.Companion.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}