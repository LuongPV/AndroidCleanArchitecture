package com.pv.cleanarchitecture.presentation.utils

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AlertDialog

object DialogUtil {

    fun showInformationDialog(context: Context, message: String): Dialog {
        val dialog = AlertDialog.Builder(context).setMessage(message).create()
        dialog.show()
        return dialog
    }

    fun showConfirmationDialog(context: Context, message: String, positiveButtonListener: () -> Unit): Dialog {
        val dialog = AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton("OK") { _, _ ->
                positiveButtonListener.invoke()
            }
            .create()
        dialog.show()
        return dialog
    }

}