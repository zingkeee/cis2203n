Mock Midterm Calculator

Codera, Neil Ryan B.
24105222
CIS 2203N - Mobile Development

This is my submission for the mock midterm. It's a working calculator app built in Android Studio using Java. I designed it to look exactly like the iPhone calculator.

CODE CHOICES:

*I used a `GridLayout` (4 columns, 5 rows) for the buttons. It was the easiest way to make everything line up perfectly without making the XML code super messy with nested layouts.
*Instead of writing the color and size code for every single button in `activity_main.xml`, I made styles in `themes.xml`. This saved a lot of time and made sure all the buttons stayed perfectly round and uniform.
*I kept the Java code simple. It just saves the first number into a variable, waits for the operator (+, -, *, /), and then uses a `switch` statement to do the math when you press equals.
*To stop the app from crashing when dividing by zero, I added a quick `if` statement. If it sees you trying to divide by 0, it stops the math and just prints "Error" on the screen.
*My student ID ends in 222. So, I added an "ID" button that takes whatever number is currently on the screen and multiplies it by 2.22.
*The backspace button uses `substring` to just chop off the last character of the text. If there's only one number left, it just resets the screen back to "0".
*I added a `ScrollView` right above the main display. Every time a calculation finishes, the Java code pieces the equation together into a string and appends it to that view so you can scroll up and see your past math.
*I used `onSaveInstanceState` to bundle up the current numbers, the operator, and the history log text. This way, if you turn your phone sideways, your math doesn't just disappear and reset to zero.
*To fix the UI getting cut off in landscape mode, I used a Landscape Resource Qualifier (`layout-land`). I created a separate XML file for when the phone is sideways and wrapped the `GridLayout` in another `ScrollView` so the user can easily swipe to see the bottom buttons.