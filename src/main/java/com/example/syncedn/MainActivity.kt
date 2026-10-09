package com.example.syncedn

import android.content.Intent
import androidx.appcompat.app.AlertDialog

/** Common welcome/login entry. Uses the existing member welcome/login layouts. */
class MainActivity : MemberActivity() {
    override val initialPage: String = "start"

    override fun navigate(next: String) {
        if (next != "home") {
            super.navigate(next)
            return
        }
        // Front-end role selection for testing. Replace with a server-provided role later.
        AlertDialog.Builder(this)
            .setTitle("Choose Demo Dashboard")
            .setItems(arrayOf("Member", "Admin / Leader")) { _, choice ->
                val dashboard = if (choice == 0) MemberActivity::class.java else AdminActivity::class.java
                startActivity(Intent(this, dashboard).putExtra("startPage", "home"))
                finish()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }
}
