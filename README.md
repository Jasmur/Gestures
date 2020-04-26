# Gestures
Basic template for using gestures. Ideal menu is to check if lastTickCount is 4, (player tapped 4 times in a second), to open/close menu, use held to select highlighted sub menu/mod/etc, moved check for direction gesture, and finally use dir to determine where our next highlight will be.

Start a new intent for the activity provided.
Use the following static fields to perform your checks:
  * lastTickCount -> Check for how many taps on screen per that last second. All fingers must be off screen to count as one.
  * held -> Self explainatory.
  * moved -> Self explainatory.
  * dir -> 0 = Left, 1 = Up, 2 = Right, 3 = Down
  * tapped -> Self explainatory.
