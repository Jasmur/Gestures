package jasmur.gestures;

import android.app.Activity;
import android.view.MotionEvent;

public class Gestures extends Activity {
    private int startX;
    private int startY;
    private int endX;
    private int endY;
    private int xDif;
    private int yDif;
    private int startTick;
    private int endTick;
    private int touchCount;
    private boolean moved;
    public static int lastTouchCount;
    public static int dir; /*0 = Left, 1 = Up, 2 = Right, 3 = Down*/
    public static boolean held;
    public static boolean tapped;

    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tickPerSecond();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        finish();
    }

    private void tickPerSecond() {
        startTick ++;
        if (touchCount != 0) lastTouchCount = touchCount;
        touchCount = 0;
        Thread th = new Thread() {
            @Override
            public void run(){
                try {
                    Thread.sleep(1000);
                    tickPerSecond();
                } catch (Exception e) {
                    //TODO
                }
            }
        };
        th.start();
    }

    private boolean cleanUp(boolean value) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                startX = x;
                startY = y;

                startTick = endTick;
                break;
            case MotionEvent.ACTION_UP:
                endX = x;
                endY = y;

                calculateDir();
                gesturingOut();

                endTick = startTick;
        }
        return true;
    }

    private void gesturingOut() {
        int width = getWindowManager().getDefaultDisplay().getWidth();
        int height = getWindowManager().getDefaultDisplay().getHeight();

        moved = (xDif > width / 10 || yDif > height / 10);
        held = startTick >= endTick + 2;
        tapped = (!moved && !held);
        touchCount ++;
    }

    private void calculateDir() {
        xDif = Math.abs(startX - endX);
        yDif = Math.abs(startY - endY);

        if (startX > endX) dir = 0;
        else dir = 2;
        if (startY > endY) dir = 1;
        else dir = 3;
    }
}
