# PySuggestion
A Python code suggestion plugin for PyCharm

## Setup IntelliJ plugin project
Please follow this comperhensive [tutorial](http://bjorn.tipling.com/how-to-make-an-intellij-idea-plugin-in-30-minutes) from @bjorntipling

## Use this repo
0. Do a shallow git clone of the IntelliJ IDEA Community Edition source code
``
git clone --depth 1 https://github.com/JetBrains/intellij-community.git
``
1. Clone this repo
2. Install JDK 8 update 121
3. Install IntelliJ Community Edition
4. Start IntelliJ, open project, point to the folder of this repo
5. Go to File > Project Structure > SDKs
6. locate the Community Edition that you installed. 
You are not to give it the path to the source you downloaded, this step requires the path to the Community Edition of IntelliJ that you installed in the step 0.
7. click on the sourcepath tab.
Here you’ll add the path to the shallow git clone for the IntelliJ Community edition source you checked out. Click the plus button. Find the path in the dialog that appears. Click OK, then you should see a bunch of classes were added. Click apply and ok.
8. Build and Run
