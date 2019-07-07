// for api level 28
fun getScreenShotFromView(view: View, activity: Activity, callback: (Bitmap) -> Unit) {
    activity.window?.let { window ->
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val locationOfViewInWindow = IntArray(2)
        view.getLocationInWindow(locationOfViewInWindow)
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                PixelCopy.request(
                    window,
                    Rect(
                        locationOfViewInWindow[0],
                        locationOfViewInWindow[1],
                        locationOfViewInWindow[0] + view.width,
                        locationOfViewInWindow[1] + view.height
                    ), bitmap, { copyResult ->
                        if (copyResult == PixelCopy.SUCCESS) {
                            callback(bitmap) }
                        else {

                        }
                        // possible to handle other result codes ...
                    },
                    Handler()
                )
            }
        } catch (e: IllegalArgumentException) {
            // PixelCopy may throw IllegalArgumentException, make sure to handle it
            e.printStackTrace()
        }
    }
}

//deprecated version
/*  Method which will return Bitmap after taking screenshot. We have to pass the view which we want to take screenshot.  */
fun getScreenShot(view: View): Bitmap {
    val screenView = view.rootView
    screenView.isDrawingCacheEnabled = true
    val bitmap = Bitmap.createBitmap(screenView.drawingCache)
    screenView.isDrawingCacheEnabled = false
    return bitmap
}