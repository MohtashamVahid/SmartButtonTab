package mohtasham.android.smartbutton

import android.content.Context
import android.os.Build
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import sys.almas.smartbutton.R

import java.util.*

class ButtonTab(view: ViewGroup, list: List<ButtonModel>, listener: ButtonTabListener, id: Int) {
    private var container: LinearLayout? = LinearLayout(view.context)
    private var mContext: Context? = view.context
    private var selectId: Int? = id
    private val unSelectBg = mContext!!.resources.getDrawable(R.drawable.shape_button_unselect)
    private val selectBg = mContext!!.resources.getDrawable(R.drawable.shape_button_select)
    private val textSelect = mContext!!.resources.getColor(R.color.md_blue_500)
    private val textUnSelect = mContext!!.resources.getColor(R.color.md_white_1000)


    init {
        container!!.orientation = LinearLayout.HORIZONTAL
        container!!.gravity = Gravity.CENTER

        val height = mContext!!.resources.getDimension(R.dimen.button_height)
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, height.toInt())
        lp.setMargins(4, 4, 4, 4)

        var despos = Observable.fromIterable(list).observeOn(AndroidSchedulers.mainThread()).subscribe({
            val buttonModel = it
            val button = Button(mContext)
            button.textSize = 12f
            button.text = buttonModel.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                button.background = unSelectBg
            }else{
                button.setBackgroundDrawable(unSelectBg)

            }
            button.layoutParams = lp
            button.tag = buttonModel
            button.setOnClickListener {
                selectId = buttonModel.id
                listener.onClickButton(buttonModel)
                refreshSelect()
            }

            container!!.addView(button)

        }, {}, {
            if (selectId == -1) selectId = list[0].id

            refreshSelect()
            view.addView(container)
        })


    }

    /**
     * **********************
     */
    private fun refreshSelect() {
        var dispos = Observable.range(0, container!!.childCount).observeOn(AndroidSchedulers.mainThread()).subscribe({
                    selectButton(it)
                })
    }

    /**
     * *********************************
     */
    private fun selectButton(it: Int) {

        val obj: Button = container!!.getChildAt(it) as Button
        val item: ButtonModel = obj.tag as ButtonModel

        if (item.id == selectId) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                obj.background = selectBg
            } else {
                obj.setBackgroundDrawable(selectBg)

            }
            obj.setTextColor(textSelect)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                obj.background = unSelectBg
            } else {
                obj.setBackgroundDrawable(unSelectBg)

            }
            obj.setTextColor(textUnSelect)

        }
    }

    /**
     * *********************************
     */
    class Builder(view: ViewGroup) {


        var list: MutableList<ButtonModel>? = ArrayList()
        var listener: ButtonTabListener? = null
        var view: ViewGroup? = null
        var selectId: Int? = -1

        init {
            this.view = view
        }

        fun setListTab(list: MutableList<ButtonModel>): Builder {
            this.list = list
            return this
        }

        fun addTab(button: ButtonModel): Builder {
            list!!.add(button)
            return this
        }

        fun setListener(listener: ButtonTabListener): Builder {
            this.listener = listener
            return this
        }

        fun setSelectedId(id: Int): Builder {
            this.selectId = id
            return this
        }

        fun build(): ButtonTab {

            return ButtonTab(view!!, list!!, listener!!, selectId!!)
        }

    }


    interface ButtonTabListener {
        fun onClickButton(button: ButtonModel)
    }
}