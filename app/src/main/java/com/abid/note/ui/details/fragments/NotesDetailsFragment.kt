package com.abid.note.ui.details.fragments


import android.content.Context
import android.content.Intent
import android.graphics.ColorFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.abid.note.R
import com.ebolo.krichtexteditor.fragments.KRichEditorFragment
import com.ebolo.krichtexteditor.fragments.Options
import com.ebolo.krichtexteditor.ui.widgets.EditorButton
import com.esafirm.imagepicker.features.ImagePicker
import kotlinx.android.synthetic.main.fragment_notes_details.*

class NotesDetailsFragment : Fragment() {

    private var isExists: Boolean = false
    private lateinit var editorFragment: KRichEditorFragment


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notes_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editorFragment = KRichEditorFragment.getInstance(
            Options()
                .placeHolder("Write something cool...")
                .onImageButtonClicked(Runnable { ImagePicker.create(this@NotesDetailsFragment).start() })
                // Un-comment this line and comment out the layout below to
                // disable the toolbar
                // .showToolbar(false)
                .onInitialized(Runnable {
                    // Simulate loading saved contents action
                })
        )

        fragmentManager?.beginTransaction()?.replace(
            R.id.container, editorFragment
        )?.commit()


        addTagFeature()
        addAlarmFeature()

    }

    private fun addAlarmFeature() {
    }

    private fun addTagFeature() {
        ivTag.setOnClickListener({
            toggleColor(it as ImageView?)
        })
    }


    private fun toggleColor(it: ImageView?) {
        if (!isExists) {
            it?.setColorFilter(
                ContextCompat.getColor(activity as Context, R.color.green),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            isExists = true
        } else {
            it?.setColorFilter(
                ContextCompat.getColor(activity as Context, R.color.black),
                android.graphics.PorterDuff.Mode.SRC_IN
            )
            isExists = false
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            val image = ImagePicker.getFirstImageOrNull(data)
            if (image != null) {
                // The second param (true/false) would not reflect BASE64 mode or not
                // Normal URL mode would pass the URL
                //*editorFragment.editor.command(IMAGE, false, "https://" + "beebom-redkapmedia.netdna-ssl.com/wp-content/uploads/2016/01/" +

                // For BASE64, image file path would be passed instead
                editorFragment.editor.command(EditorButton.IMAGE, true, image.path)
            }
        }
    }

}
