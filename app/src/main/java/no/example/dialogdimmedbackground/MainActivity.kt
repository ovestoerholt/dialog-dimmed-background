package no.example.dialogdimmedbackground

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_layout.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            /*
            showGooglePlayAppPage(ba
                context = this,
                appId = BuildConfig.APPLICATION_ID
            )
             */
            showGooglePlayAppPage(
                context = this,
                appId = "mobi.mobiletech.apps.android.netcom"
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    private fun showGooglePlayAppPage(context: Context, appId: String) {
        // create an alert builder
        val builder = AlertDialog.Builder(context)
        // set the custom layout
        val customLayout = View.inflate(context, R.layout.dialog_layout, null)
        customLayout.appPageButton.setOnClickListener {
            // Launch Google Play App
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(
                    "https://play.google.com/store/apps/details?id=$appId")
                setPackage("com.android.vending")
            }
            startActivity(intent)
        }
        builder.setView(customLayout)
        // create and show the alert dialog
        val dialog = builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setCancelable(false)
        dialog.show()
    }





}
