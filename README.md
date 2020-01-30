## Project assignment (MTTPP) 2019/2020


This assignment was made with IntelliJ IDEA and Katalon Recorder, and Maven was used for reporting

If you want to make your own reports, you have to download Maven "apache-maven-x.x.x-bin.zip" from [this link](https://maven.apache.org/download.cgi).

Then you need to extract it to any location so you can add it to your environment PATH variable like in these pictures.

![Envrionment PATH variable](/images/screen1.png)

![Envrionment PATH variable](/images/screen2.png)

### `Testing`

So in this project, the testing was done on my personal website that can be found [HERE](https://jpapez-myplan.web.app/).

These tests were ran in Firefox and Chrome so you need geckodriver.exe and chromedriver.exe respectively to run
these tests. To download geckodriver go to [this website](https://github.com/mozilla/geckodriver/releases) and download
latest release, and to download chromedriver go to [this website](https://chromedriver.chromium.org/) and download the
version that best fit your version of Chrome. (You need to have Firefox and Chrome installed to run these tests).
If you want to add your own driver, just download another driver for other browsers, add them to driver directory and
change these two lines ![Drivers](/images/screen6.png) to match your driver info.


After that, just extract it to your "C:\drivers" folder like so:

![Drivers](/images/screen5.png)


The tests i ran here were: 
* Login without signing up first

* Sign Up

* Sign up, log out and then signing in again

* Signing up and creating project

* Testing of notification system for creating project

In order to run already created test, you can just select one of the tests in drop down menu and click on green play button.
![Test](/images/screen3.png)

Or you can just right click on any java class in src/test/java path and click on "Run SomethingTest"
![Test](/images/screen4.png)