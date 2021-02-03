package slidewindow;

public class TestMSW {
    public static void main(String[] args){
        MedianSlideWindow_480 medianSlideWindow=new MedianSlideWindow_480();
        medianSlideWindow.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
