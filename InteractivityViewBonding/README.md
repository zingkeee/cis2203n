To process the string input and validate the password requirement without using `findViewById`, I used ViewBinding to access the UI elements directly. 

Here are the specific Java String methods I used for the validation logic:
* `getText().toString().trim()`: Used to extract the raw text from the user's input and remove any accidental blank spaces at the beginning or end.
* `substring()`: Used to dynamically isolate the final two characters of the inputted Student ID by calculating `idInput.length() - 2`.
* `equals()`: Used to strictly compare the concatenated target password (wall color + extracted digits) against the user's actual password input.