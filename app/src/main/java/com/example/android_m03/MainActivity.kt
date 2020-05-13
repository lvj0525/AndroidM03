package com.example.android_m03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()

        banner.setOnClickListener{
            val intent = Intent(this, ResultActivity::class.java)
            startActivityForResult(intent, 999)
        }
    }

    private fun initFragment() {
        val chatsFragment = ChatsFragment()
        val contactsFragment = ContactsFragment()
        val discoverFragment = DiscoverFragment()
        val meFragment = MeFragment()
        val replaceFragment = ReplaceFragment()

        chats.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (!chatsFragment.isAdded) {
                transaction.add(R.id.fragmentContainer, chatsFragment)
            }
            transaction.show(chatsFragment)
            transaction.commit()
        }

        contacts.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (!contactsFragment.isAdded) {
                transaction.add(R.id.fragmentContainer, contactsFragment)
            }
            transaction.show(contactsFragment)
            transaction.commit()
        }

        discover.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (!discoverFragment.isAdded) {
                transaction.add(R.id.fragmentContainer, discoverFragment)
            }
            transaction.show(discoverFragment)
            transaction.commit()
        }

        me.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (!meFragment.isAdded) {
                transaction.add(R.id.fragmentContainer, meFragment)
            }
            transaction.show(meFragment)
            transaction.commit()
        }

        replaceBtn.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            if (!replaceFragment.isAdded) {
                transaction.replace(R.id.fragmentContainer, replaceFragment)
            }
            transaction.show(replaceFragment)
            transaction.commit()
        }

        removeAllFragmentBtn.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction
                .remove(chatsFragment)
                .remove(contactsFragment)
                .remove(discoverFragment)
                .remove(meFragment)
                .remove(replaceFragment)
                .commit()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 999 && resultCode == 9999) {
            Toast.makeText(this, data?.getStringExtra("message"), Toast.LENGTH_SHORT).show()
        }
    }
}
