package sys.almas.buttontabsample


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import sys.almas.smartbuttontab.ButtonModel
import sys.almas.smartbuttontab.ButtonTab


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        ButtonTab
                .Builder(findViewById(R.id.container))
                .addTab(ButtonModel("Tab 1", 3))
                .addTab(ButtonModel("Default Tab", 0))
                .addTab(ButtonModel("Tab 2", 2))

                .setSelectedId(0)
                .setListener(object : ButtonTab.ButtonTabListener {
                    override fun onClickButton(button: ButtonModel) {
                    }

                }).build()

        ButtonTab
                .Builder(findViewById(R.id.container2))
                .addTab(ButtonModel("Instagram", 3))
                .addTab(ButtonModel("Twitter", 2))
                .addTab(ButtonModel("Telegram", 1))
                .addTab(ButtonModel("Show All", 0))
                .setSelectedId(0)
                .setListener(object : ButtonTab.ButtonTabListener {
                    override fun onClickButton(button: ButtonModel) {
                    }

                }).build()



    }
}
