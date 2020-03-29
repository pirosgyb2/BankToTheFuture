package com.bme.aut.banktothefuture.box

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import com.bme.aut.banktothefuture.R

class MessageFragment : DialogFragment() {

    private var onMessageFragmentAnswer: OnMessageFragmentAnswer? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (context is OnMessageFragmentAnswer) {
            onMessageFragmentAnswer = context
        } else {
            throw RuntimeException(
                    "This Activity is not implementing the " +
                            "OnMessageFragmentAnswer interface")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val message = arguments?.getString(BoxActivity.KEY_MSG)

        val alertDialogBuilder = AlertDialog.Builder(requireContext())

        val inflater = LayoutInflater.from(getContext())
        val dialogLayout = inflater.inflate(R.layout.layout_dialog, null)
        alertDialogBuilder.setView(dialogLayout)

        alertDialogBuilder.setMessage(message)

        alertDialogBuilder.setNegativeButton("Szuper!", DialogInterface.OnClickListener { dialogInterface, i ->
            dialogInterface.dismiss()
            onMessageFragmentAnswer!!.onSelected()
        })


        return alertDialogBuilder.create()
    }
}