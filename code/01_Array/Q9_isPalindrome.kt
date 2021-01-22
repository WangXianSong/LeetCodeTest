package ArrayTest


fun main() {
    val bool = isPalindrome(12231)
    println(bool)
}


fun isPalindrome(x: Int): Boolean {

    if (x <= 0) {
        return false
    }
    val str = x.toString()
    val arrStr = x.toString().toCharArray()

    var mLeftIndex = 0
    var mRightIndex = str.length - 1

    while ((mLeftIndex != mRightIndex) && (mLeftIndex < mRightIndex)) {
        if (arrStr.get(mLeftIndex) != arrStr.get(mRightIndex)) {
            return false
        }
        mLeftIndex++
        mRightIndex--
    }
    return true

}