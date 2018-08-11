# SmartButtonTab
Hi guys
Smart Botton Tab  Is Library for manage Group Button in Android 
This Example Create With [RxJava](https://github.com/ReactiveX/RxJava) And You Can Remove This

  
<img src="https://github.com/mohtasham1988/SmartButtonTab/blob/master/screenShot/gif1.gif" width="350">




## Add Library
**Step 1**. Add the JitPack repository to your build file

```java

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 ``` 
 
  **Step 2**. Add the dependency
  
```java

dependencies {
	        implementation 'com.github.mohtasham1988:SmartButtonTab:v1.0'
	}
  
 ```
 
 
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
