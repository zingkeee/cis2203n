
The original code initialized `TextView counterDisplay = null;` and then tried to call `.setText("0")` on it. This caused a **NullPointerException** because the app was trying to perform an action on an object that didn't exist in memory yet.

I fixed the crash by properly initializing the `TextView` using `findViewById(R.id.tvCounter)`, which links the Java variable to the actual UI element in the layout.

I implemented `onSaveInstanceState` and `onRestoreInstanceState` to ensure the counter value is preserved in a **Bundle** when the activity is destroyed and recreated during screen rotation.