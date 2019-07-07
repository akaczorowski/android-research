/*  Store taken screenshot into above created path  */
fun storeScreenShot(bm: Bitmap?, fileName: String, context: Context?): File {
    val dir = File(context?.filesDir?.absolutePath)
    if (!dir.exists())
        dir.mkdirs()
    val file = File(context?.filesDir?.absolutePath, fileName)
    Timber.d("Create Directory Created : $file")

    try {
        val fOut = FileOutputStream(file)
        bm?.compress(Bitmap.CompressFormat.JPEG, 10, fOut)
        fOut.flush()
        fOut.close()
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return file
}