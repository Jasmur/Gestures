# Gestures
Basic template for using gestures through Java. JNI source will be kept in private. Ideal menu is to check if lastTouchCount is 4, (player tapped 4 times in a second), to open/close menu, use held to select highlighted sub menu/mod/etc, moved check for direction gesture, and finally use dir to determine where our next highlight will be.

1. Start a new intent for the activity provided.
2. Use the following static fields to perform your checks:
  * lastTouchCount -> Check for how many taps on screen per that last second. All fingers must be off screen to count as one.
  * held -> Self explainatory.
  * moved -> Self explainatory.
  * dir -> 0 = Left, 1 = Up, 2 = Right, 3 = Down
  * tapped -> Self explainatory.
  
3. Using the previous boolean you used in your check, set back to false after performing action when gesture is made to ensure gesture will not loop. 
