# SmartButtonTab
Hi guys
Smart Botton Tab  Is Library for manage Group Button in Android

# Gif
  
<img src="https://github.com/mohtasham1988/SmartButtonTab/blob/master/screenShot/gif1.gif" width="350">




## How to use
Simple Java Code

```java

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

```
